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
package com.apress.bgn.seven.switchst;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by iuliana.cosmina on 22/08/2021
 */
public class PatternMatchingDemo {

    public static void main(String... args) {
        List<Object> contents = List.of( "String value",
                42, 42_000L, 4.2f, 4.2314d,
                BigInteger.ONE);

        contents.stream().map(PatternMatchingDemo::oldStyleFormat)
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    private static String oldStyleFormat(Object item) {
        String strVal = "unknown";
        if(item instanceof String str) {
            strVal = String.format("String %s", str);
        } else if (item instanceof Integer i){
            strVal = String.format("int %d", i);
        } else if (item instanceof Long l){
            strVal = String.format("long %d", l);
        } else if (item instanceof Float f){
            strVal = String.format("float %.2f", f);
        } else if (item instanceof Double d){
            strVal = String.format("double %.4f", d);
        } else if (item instanceof BigInteger b){
            strVal = "BigInteger " + b.toString();
        }
        return strVal;
    }

    /*
    Pattern Matching for switch (Preview)
    https://openjdk.java.net/jeps/406
    private static String newStyleFormat(Object item) {
        return switch (item) {
            case String str -> String.format("String %s", str);
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Float f  -> String.format("float %.2f", f);
            case Double d  -> String.format("double %f", d);
            case BigInteger b  -> "BigInteger " + b.toString();
            default        -> item.toString();
        };
    }*/
}
