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
package com.apress.bgn.eleven.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by iuliana.cosmina on 11/07/2021
 */
public class ChannelDemo {
    private static final Logger log = LoggerFactory.getLogger(ChannelDemo.class);

    public static void main(String... args) {
        var sb = new StringBuilder();
        final String inDir = "chapter11/read-write-file/src/main/resources/input/";
        try (FileInputStream is = new FileInputStream(new File(inDir + "data.txt"));
             FileChannel inChannel = is.getChannel()) {

            long fileSize = inChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int)fileSize);
            inChannel.read(buffer);
            buffer.flip();
            while(buffer.hasRemaining()){
                sb.append((char) buffer.get());
            }
        }  catch (IOException e) {
            log.error("File could not be read! ", e);
        }
        log.info("Read with FileChannel [1]--> {}", sb.toString());
        log.info("------------------------------------------");

        sb = new StringBuilder();
        try (RandomAccessFile file = new RandomAccessFile(inDir + "data.txt", "r");
                FileChannel inChannel = file.getChannel()) {

            long fileSize = inChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int)fileSize);
            inChannel.read(buffer);
            buffer.flip();
            while(buffer.hasRemaining()){
                sb.append((char) buffer.get());
            }
        }  catch (IOException e) {
            log.error("File could not be read! ", e);
        }
        log.info("Read with FileChannel [2] --> {}", sb.toString());

        sb = new StringBuilder();
        try (RandomAccessFile file = new RandomAccessFile(inDir + "data.txt", "r");
             FileChannel inChannel = file.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(48);
            while(inChannel.read(buffer) > 0) {
                buffer.flip();
                for (int i = 0; i < buffer.limit(); i++) {
                    sb.append((char) buffer.get());
                }
                buffer.clear();
            }
        }  catch (IOException e) {
            log.error("File could not be read! ", e);
        }
        log.info("Read with FileChannel [3] --> {}", sb.toString());
    }
}
