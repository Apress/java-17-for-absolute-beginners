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
package com.apress.bgn.eleven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by iuliana.cosmina on 10/07/2021
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
        var file = new File("/Users/iulianacosmina/apress/workspace/java-17-for-absolute-beginners/README.adoc");
        printFileStats(file);
        log.info("------------------------------------------");

        try {
            var localUri = new URI("file:///Users/iulianacosmina/apress/workspace/java-17-for-absolute-beginners/README.adoc");
            var localFile =  new File (localUri);
            printFileStats(localFile);
            log.info("------------------------------------------");
        } catch (URISyntaxException use) {
            log.error("Malformed URI, no file there", use);
        }

        file = new File("/Users/iulianacosmina/.gitconfig");
        printFileStats(file);
        log.info("------------------------------------------");

        var d = new File("/Users/iulianacosmina/apress/workspace/java-17-for-absolute-beginners");
        Arrays.stream(Objects.requireNonNull(d.list())).forEach(ff -> log.info("\t File Name : {}", ff));
        log.info("------------------------------------------");

        Arrays.stream(Objects.requireNonNull(d.listFiles())).forEach(ff -> log.info("\t File : {}", ff.getAbsolutePath()));
        log.info("------------------------------------------");

        Arrays.stream(Objects.requireNonNull(d.listFiles(childFile -> childFile.isDirectory() && childFile.getName().startsWith("chapter")))).forEach(ff -> log.info("Chapter Source : {}", ff.getName()));
        log.info("------------------------------------------");

        Arrays.stream(Objects.requireNonNull(d.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return dir.getName().startsWith("chapter");
                    }
                }))).forEach(ff -> log.info("\t File : {}", ff.getAbsolutePath()));
        log.info("------------------------------------------");

        File created = new File(
                "/Users/iulianacosmina/apress/workspace/java-17-for-absolute-beginners/chapter11/read-write-file/src/main/resources/output/created.txt");
        if (!created.exists()) {
            try {
                created.createNewFile();
            } catch (IOException e) {
                log.error("Could not create file.", e);
            }
        }
        log.info("------------------------------------------");

        try {
            var temp = File.createTempFile("java_bgn_", ".tmp");
            log.info("File created.txt at: {}", temp.getAbsolutePath());
            temp.deleteOnExit();
        } catch (IOException e) {
            log.error("Could not create temporary file.", e);
        }
        log.info("------------------------------------------");

        file = new File(
                "chapter11/read-write-file/src/main/resources/output/created.txt");
        var renamed = new File(
                "chapter11/read-write-file/src/main/resources/output/renamed.txt");
        boolean result = file.renameTo(renamed);
        log.info("Renaming succeeded? : {} ", result);
        log.info("------------------------------------------");
    }

    private static void printFileStats(File f) {
        if (f.exists()) {
            log.info("File Details:");
            log.info("Type : {}", f.isFile() ? "file" : "directory or symlink");
            log.info("Location :{}", f.getAbsolutePath());
            log.info("Parent :{}", f.getParent());
            log.info("Name : {}", f.getName());

            double kilobytes = f.length() / (double)1024;
            log.info("Size : {} ", kilobytes);

            log.info("Is Hidden : {}", f.isHidden());
            log.info("Is Readable? : {}", f.canRead());
            log.info("Is Writable? : {}", f.canWrite());
        }
    }
}
