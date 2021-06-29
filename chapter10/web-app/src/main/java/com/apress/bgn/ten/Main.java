/*
Freeware License, some rights reserved

Copyright (c) 2021 Iuliana Cosmina

Permission is hereby granted, free of charge, to anyone obtaining a copy 
of this software and associated documentation files (the "Software"), 
to work with the Software within the limits of freeware distribution and fair use. 
This includes the rights to use, copy, and modify the Software for personal use. 
Users are also allowed and encouraged to submit corrections and modifications 
to the Software for the benefit of other users.

It is not allowed to reuse,  modify, or redistribute the Software for 
commercial use in any way, or for a user's educational materials such as books 
or blog articles without prior permission from the copyright holder. 

The above copyright notice and this permission notice need to be included 
in all copies or substantial portions of the software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS OR APRESS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.apress.bgn.ten;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.WebResourceSet;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.JarResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Created by iuliana.cosmina on 27/06/2021
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static final Integer PORT = Optional.ofNullable(System.getenv("PORT")).map(Integer::parseInt).orElse(8080);
    // TODO set these with valid values on your computer
    public static final String TMPDIR = Optional.ofNullable(System.getenv("TMPDIR")).orElse("/tmp/tomcat-tmp");
    public static final String STATICDIR = Optional.ofNullable(System.getenv("STATICDIR")).orElse("/tmp/tomcat-static");

    public static void main(String... args) throws IOException, LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(TMPDIR);
        tomcat.setPort(PORT);

        // create a default Connector if there is none and adds it to the service
        tomcat.getConnector();

        // prevent register jsp servlet
        tomcat.setAddDefaultWebXmlToWebapp(false);

        String contextPath = ""; // root context
        new File(STATICDIR).mkdirs();
        String docBase = new File(STATICDIR).getCanonicalPath();
        Context context = tomcat.addWebapp(contextPath, docBase);
        context.setAddWebinfClassesResources(true); // process /META-INF/resources for static

        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws IOException {
                PrintWriter writer = resp.getWriter();

                writer.println("<html><title>Welcome</title><body style=\"background-color:black\">");
                writer.println("<h1 style=\"color:#ffd200\"> Embedded Tomcat 10.0.7 says hi!</h1>");
                writer.println("</body></html>");
            }
        };
        String servletName = "HomeServlet";
        String urlPattern = "/";
        tomcat.addServlet(contextPath, servletName, servlet);
        context.addServletMappingDecoded(urlPattern, servletName);

        WebResourceRoot webResourceRoot = new StandardRoot(context);

        // add itself jar with static resources (html) and annotated servlets
        String webAppMount = "/WEB-INF/classes";
        WebResourceSet webResourceSet;

        // needed to avoid a concurrent exception in IntelliJ IDEA
        //try {Thread.sleep(2000L); } catch (Exception e) {}

        if (!isJar()) {
            // potential dangerous - if last argument will "/" that means tomcat will serves self jar with .class files
            webResourceSet = new DirResourceSet(webResourceRoot, webAppMount, getResourceFromFs(), "/");
        } else {
            webResourceSet = new JarResourceSet(webResourceRoot, webAppMount, getResourceFromJarFile(), "/");
        }
        webResourceRoot.addJarResources(webResourceSet);
        context.setResources(webResourceRoot);

        // need for proper destroying servlets
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                tomcat.getServer().stop();
            } catch (LifecycleException e) {
                e.printStackTrace();
            }
        }));

        tomcat.start();
        tomcat.getServer().await();
    }

    public static boolean isJar() {
        URL resource = Main.class.getResource("/");
        return resource == null;
    }

    public static String getResourceFromJarFile() {
        File jarFile = new File(System.getProperty("java.class.path"));
        return jarFile.getAbsolutePath();
    }

    public static String getResourceFromFs() {
        URL resource = Main.class.getResource("/");
        return resource.getFile();
    }
}
