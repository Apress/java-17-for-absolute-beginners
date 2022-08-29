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

/**
 * Created by iuliana.cosmina on 09/05/2021
 */
public class AnotherSwitchExpressionDemo {
    public static void main(String... args) {
        //Read a
        int a = Integer.parseInt(args[0]);

        System.out.println( switch (a) {
            case 1, 2, 12 -> {
                System.out.println("One of 1,2,12 is tested.");
                yield "Winter";
            }
            case 3,4,5 -> {
                System.out.println("One of 3,4,5 is tested.");
                yield "Spring";
            }
            case 6,7,8 -> {
                System.out.println("One of 6,7,8 is tested.");
                yield "Summer";
            }
            case 9,10,11 -> {
                System.out.println("One of 9,10,11 is tested.");
                yield "Autumn";
            }
            default ->
                throw new IllegalStateException("Unexpected value");
        });
    }
}
