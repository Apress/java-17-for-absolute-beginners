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
package com.apress.bgn.nine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by iuliana.cosmina on 09/07/2021
 */
public class NewApiProcessCreationDemo {
    private static final Logger log = LoggerFactory.getLogger(NewApiProcessCreationDemo.class);

    public static void main(String... args) throws IOException, InterruptedException, ExecutionException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("/bin/sh", "-c", "echo Java home: $JAVA_HOME");
        processBuilder.inheritIO();

        Process process = processBuilder.start();
        CompletableFuture<Process> future = process.onExit();
        int result = future.get().exitValue();
        log.info("Process result: " + result);

        CompletableFuture<ProcessHandle> futureHandle = process.toHandle().onExit();
        ProcessHandle processHandle = futureHandle.get();
        log.info("Process ID: {}", processHandle.pid());
        ProcessHandle.Info info = processHandle.info();
        info.arguments().ifPresent(s -> Arrays.stream(s).forEach(a -> log.info("   {}", a)));
        info.command().ifPresent(c -> log.info("\t Command: {}", c));
    }
}
