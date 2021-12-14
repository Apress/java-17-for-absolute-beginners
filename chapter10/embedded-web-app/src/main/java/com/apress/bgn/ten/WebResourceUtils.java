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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.stream.Stream;

/**
 * Created by iuliana.cosmina on 04/07/2021
 */
public class WebResourceUtils {

    public static String readResource(final String resourceName) throws Exception {
        File jarFile = new File(WebDemo.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath().replaceAll("\\\\", "/"));

        if(jarFile.isDirectory()) {
            // When run from IntelliJ IDEA  and the jar does not exist, but all data is in the target directory
            try (Stream<Path> walkStream = Files.walk(jarFile.toPath())) {
                 Optional<String> contents = walkStream.filter(p -> p.toFile().isFile()).filter(f -> f.endsWith(resourceName))
                        .findFirst().map(f -> {
                            try {
                                return new String (Files.readAllBytes(f));
                            } catch (IOException e) {
                                e.printStackTrace();
                                return null;
                            }
                        });
              if (contents.isPresent()) {
                  return contents.get();
              }
            }
        } else {
            // when run from the command line with: java -jar target/embedded-web-app-2.0-SNAPSHOT-jar-with-dependencies.jar
            JarInputStream jis = new JarInputStream(new FileInputStream(jarFile));
            JarEntry jarEntry = jis.getNextJarEntry();
            while (jarEntry != null) {
                if (jarEntry.getName().endsWith(resourceName)) {
                    return new String(jis.readAllBytes());
                }
                jarEntry = jis.getNextJarEntry();
            }
            jis.closeEntry();
            jis.close();
        }
        return null;
    }

}
