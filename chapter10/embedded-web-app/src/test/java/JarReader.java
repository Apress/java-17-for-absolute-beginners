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

import com.apress.bgn.ten.WebDemo;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by iuliana.cosmina on 04/07/2021
 */
public class JarReader {

    @Test
    void testReadingFromJar() throws Exception {
        File jar = new File("/Users/iulianacosmina/apress/workspace/java-17-for-absolute-beginners/chapter10/embedded-web-app/target/embedded-web-app-2.0-SNAPSHOT-jar-with-dependencies.jar");

        JarInputStream jis = new JarInputStream(new FileInputStream(jar));
        JarEntry  jarEntry = jis.getNextJarEntry();
        File destDir = new File (WebDemo.STATIC_DIR);
        while(jarEntry!= null) {
            if(jarEntry.getName().endsWith("index.html")) {
                jis.readAllBytes();

               /* File destFile = new File(destDir, jarEntry.getName());
                // fix for Windows-created archives
                File parent = destFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }
                // write file content
                FileOutputStream fos = new FileOutputStream(destFile);
                int len;
                byte[] buffer = new byte[1024];
                while ((len = jis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();*/
            }

            jarEntry = jis.getNextJarEntry();
        }
        jis.closeEntry();
       jis.close();
    }

}
