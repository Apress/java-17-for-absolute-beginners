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
package com.apress.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by iuliana.cosmina on 31/03/2021
 * I will delete this later - used for validating Figure numbers
 */
public class ListingParser {

    public static void main(String... args) throws IOException {
        //FileWriter fileWriter = new FileWriter("/Users/iulianacosmina/apress/book-java-bgn-02/ch04-new.adoc");
        //PrintWriter printWriter = new PrintWriter(fileWriter);

        Files.readAllLines(Paths.get("/Users/iulianacosmina/apress/book-java-bgn-02/ch04.adoc")).forEach(line -> {
            if(line.contains("Listing")) {
                int startIndex = line.indexOf("Listing") + 10;
                int endIndex = startIndex + 2;
                try {
                    String numberStr = line.substring(startIndex, endIndex);
                    if(!Character.isDigit(numberStr.charAt(numberStr.length()-1))) {
                        numberStr = numberStr.substring(0, numberStr.length()-1);
                    }
                    if(!Character.isDigit(numberStr.charAt(0))) {
                        System.out.println(line);
                    }
                   int number = Integer.parseInt(numberStr);
                    if(number<=51 && number>28) {
                        line  = line.replace("Listing 4-" +number , "Listing 4-"+ (number + 2));
                        System.out.println(line);
                    }
                } catch (StringIndexOutOfBoundsException sse) {
                    System.out.println(line);
                }
            }
            //printWriter.println(line);
        });
        //printWriter.close();
    }
}
