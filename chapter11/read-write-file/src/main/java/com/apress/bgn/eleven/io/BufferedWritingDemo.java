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

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Created by iuliana.cosmina on 18/07/2021
 */
public class BufferedWritingDemo {
    private static final Logger log = LoggerFactory.getLogger(BufferedWritingDemo.class);

    public static void main(String... args) {
        var file = new File("chapter11/read-write-file/src/main/resources/output/data.txt");
        var dataList = List.of ("How will I hold my head" ,
                "To keep from going under");

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (String entry : dataList) {
                writer.write(entry);
                writer.newLine();
            }
            log.info("String written using BufferedWriter before Java 1.7");
        } catch (IOException e) {
            log.info("Something went wrong! ", e);
        } finally {
            if(writer!= null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    log.info("Something went wrong! ", e);
                }
            }
        }
        log.info("------------------------------------------");

        try (final BufferedWriter wr = new BufferedWriter(new FileWriter(file))){
            dataList.forEach(entry -> {
                try {
                    wr.write(entry);
                    wr.newLine();
                } catch (IOException e) {
                    log.info("Something went wrong! ", e);
                }
            });
            wr.flush();
            log.info("String written using BufferedWriter after Java 1.7");
        } catch (IOException e) {
            log.info("Something went wrong! ", e);
        }
        log.info("------------------------------------------");

        try (final BufferedWriter wr = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)){
            dataList.forEach(entry -> {
                try {
                    wr.write(entry);
                    wr.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            wr.flush();
            log.info("String written using BufferedWriter after Java 1.8");
        } catch (IOException e) {
            log.info("Something went wrong! ", e);
        }
        log.info("------------------------------------------");

        try (final OutputStreamWriter wr = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)){
            dataList.forEach(entry -> {
                try {
                    wr.write(entry);
                    wr.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            wr.flush();
            log.info("String written using OutputStreamWriter ");
        } catch (IOException e) {
            log.info("Something went wrong! ", e);
        }
        log.info("------------------------------------------");

        try (final BufferedWriter wr = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
            dataList.forEach(entry -> {
                try {
                    wr.write(entry);
                    wr.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            wr.flush();
            log.info("String written using Files.newBufferedWriter with APPEND  option. ");
        } catch (IOException e) {
            log.info("Something went wrong! ", e);
        }
        log.info("------------------------------------------");

        try (final BufferedWriter wr = new BufferedWriter(new FileWriter(file, true))){
            dataList.forEach(entry -> {
                try {
                    wr.write(entry);
                    wr.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            wr.flush();
        } catch (IOException e) {
            log.info("Something went wrong! ", e);
        }
        log.info("------------------------------------------");
    }
}
