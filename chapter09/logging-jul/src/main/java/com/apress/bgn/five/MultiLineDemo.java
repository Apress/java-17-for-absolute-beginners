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
package com.apress.bgn.five;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by iuliana.cosmina on 18/04/2021
 */
public class MultiLineDemo {

    public static void main(String... args) {
        String newLineCh = System.getProperty("line.separator");

        // method 1: simple concatenation using the '+' operator
        String multilineStr = "line one of the text block" +
                newLineCh +
                "line two of the text block" +
                newLineCh +
                "last line of the text block" ;

        // or method 2 using `String#concat(..)` method
        multilineStr = "line one of the text block"
                .concat(newLineCh)
                .concat("line two of the text block")
                .concat(newLineCh)
                .concat("last line of the text block") ;

        // or method 3 using `String.join` utility method
        multilineStr = String.join("line one of the text block" ,
                newLineCh ,
                "line two of the text block" ,
                newLineCh ,
                "last line of the text block");

        // or method 4 using a StringBuffer instance
        multilineStr = new StringBuffer("line one of the text block")
                .append(newLineCh)
                .append("line two of the text block")
                .append(newLineCh)
                .append("last line of the text block").toString();

        // or method 5 using a StringBuilder instance
        multilineStr = new StringBuilder("line one of the text block")
                .append(newLineCh)
                .append("line two of the text block")
                .append(newLineCh)
                .append("last line of the text block").toString();

        // or method 5 using a StringWriter instance
        StringWriter stringWriter = new StringWriter();
        stringWriter .write("line one of the text block");
        stringWriter.write(newLineCh);
        stringWriter.write("line two of the text block");
        stringWriter.write(newLineCh);
        stringWriter.write("last line of the text block");
        multilineStr = stringWriter.toString();

        // or method 6 using a  and PrintWriter instance
        stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter .println("line one of the text block");
        printWriter.println("line two of the text block");
        printWriter.println("last line of the text block");
        multilineStr = stringWriter.toString();

        // or method 7: starting with Java 15, text-blocks
        multilineStr = """  
                line one of the text block
                line two of the text block
                last line of the text block""";

        System.out.print(multilineStr);

        System.out.println("-------------");


        multilineStr = """  
                line one of the text block
                line two of the text block
                last line of the text block
                """;

        System.out.print(multilineStr);
    }
}
