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
package com.apress.bgn.eleven.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * Created by iuliana.cosmina on 10/07/2021
 */
public class PathDemo {
    private static final Logger log = LoggerFactory.getLogger(PathDemo.class);

    public static void main(String... args) {
        File file = new File(
                "/Users/iulianacosmina/apress/workspace/java-17-for-absolute-beginners/README.adoc");
        //Path path = Paths.get(file.toURI());
        Path path = Path.of(file.toURI());
        log.info(path.toString());
        log.info("------------------------------------------");

        Path composedPath = Paths.get("/Users/iulianacosmina/apress/workspace",
                "java-17-for-absolute-beginners",
                "README.adoc");
        log.info(composedPath.toString());
        log.info("Is the same path? : {} ", path.compareTo(composedPath) ==0 ? "yes" : "no");
        log.info("------------------------------------------");

        printPathDetails(composedPath);
        log.info("------------------------------------------");

        var chapterPath = Paths.get("/Users/iulianacosmina/apress/workspace",
                "java-17-for-absolute-beginners/chapter11");
        Path filePath = chapterPath.resolve(
                "read-write-file/src/main/resources/input/data.txt");
        log.info("Resolved Path :{}", filePath.toAbsolutePath());
        log.info("------------------------------------------");

        var outputPath = FileSystems.getDefault()
                .getPath("/Users/iulianacosmina/apress/workspace/" +
                        "java-17-for-absolute-beginners/chapter11/read-write-file/src/main/resources/output/sample");
        try {
            Path dirPath = Files.createDirectory(outputPath);
            printPathStats(dirPath);
        } catch (FileAlreadyExistsException faee) {
            log.error("Directory already exists.", faee);
        } catch (IOException e) {
            log.error("Could not create directory.", e);
        }
        log.info("------------------------------------------");


        Path copyFilePath = Paths.get(outputPath.toAbsolutePath().toString(), "data.adoc");
        try {
            Files.copy(filePath, copyFilePath);
            log.info("Exists? : {}", Files.exists(copyFilePath)? "yes": "no");
            log.info("File copied to: {}", copyFilePath.toAbsolutePath());
        } catch (FileAlreadyExistsException faee) {
            log.error("File already exists.", faee);
        } catch (IOException e) {
            log.error("Could not copy file.", e);
        }
        Path movedFilePath = Paths.get(outputPath.toAbsolutePath().toString(), "copy-data.adoc");
        try {
            Files.move(copyFilePath, movedFilePath);
            log.info("File moved to: {}", movedFilePath.toAbsolutePath());
            Files.deleteIfExists(copyFilePath);
        } catch (FileAlreadyExistsException faee) {
            log.error("File already exists.", faee);
        }  catch (IOException e) {
            log.error("Could not move file.", e);
        }
    }

    private static void printPathDetails(Path path) {
        log.info("Location :{}", path.toAbsolutePath());
        log.info("Is Absolute? : {}", path.isAbsolute());
        log.info("Parent :{}", path.getParent());
        log.info("Root :{}", path.getRoot());
        log.info("FileName : {}", path.getFileName());
        log.info("FileSystem : {}", path.getFileSystem());
        log.info("IsFileReadOnly : {}", path.getFileSystem().isReadOnly());
    }

    private static void printPathStats(Path path) {
        if (Files.exists(path)) {
            log.info("Path Details:");
            log.info("Type: {}", Files.isDirectory(path) ? "yes" : "no");
            log.info("Type: {}", Files.isRegularFile(path) ? "yes" : "no");
            log.info("Type: {}", Files.isSymbolicLink(path) ? "yes" : "no");
            log.info("Location :{}", path.toAbsolutePath());
            log.info("Parent :{}", path.getParent());
            log.info("Name : {}", path.getFileName());

            try {
                double kilobytes = Files.size(path) / (double)1024;
                log.info("Size : {} ", kilobytes);
                log.info("Is Hidden: {}", Files.isHidden(path) ? "yes" : "no");
            } catch (IOException e) {
                log.error("Could not access file.", e);
            }
            log.info("Is Readable: {}", Files.isReadable(path) ? "yes" : "no");
            log.info("Is Writable: {}", Files.isWritable(path) ? "yes" : "no");

        }
    }
}
