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

/**
 * Created by iuliana.cosmina on 17/04/2021
 */
public class NumericDemo {
    private byte b;
    private short s;
    private int i;
    private long l;
    private float f;
    private double d;

    public static void main(String... args) {
        NumericDemo nd = new NumericDemo();

        nd.b = 0b1100;
        System.out.println("Byte binary value: " + nd.b);

        nd.i = 42 ; // decimal case

        nd.i = 045 ; // octal case - base 8
        System.out.println("Int octal value: " + nd.i);

        nd.i = 0xcafe ; // hexadecimal case - base 16
        System.out.println("Int hexadecimal value: " + nd.i);

        nd.i = 0b10101010101010101010101010101011;
        System.out.println("Int binary value: " + nd.i);

        //Java 7 syntax
        nd.i = 0b1010_1010_1010_1010_1010_1010_1010_1011;
        System.out.println("Int binary value: " + nd.i);

        nd.l = 1000_000l; // equivalent to 1000_000L
        System.out.println("Long value: " + nd.l);

        nd.f = 5;
        System.out.println("Integer value assigned to a float variable: " + nd.f);

        nd.f = 2.5f; // equivalent to nd.f = 2.5F;
        System.out.println("Decimal value assigned to a float variable: " + nd.f);

        nd.d = 2.5d; // equivalent to nd.d = 2.5D;
        System.out.println("Decimal value assigned to a double variable: " + nd.f);
    }
}
