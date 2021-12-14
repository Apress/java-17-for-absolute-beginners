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
package com.apress.bgn.six;

/**
 * Created by iuliana.cosmina on 25/04/2021
 */
public class ModulusDemo {
    public static void main(String... args) {
        double d = 5.28d;
        System.out.println("No rounding = " +  (d % 2d));
        System.out.println("Rounded up remainder = " + Math.ceil(d % 2d));
        System.out.println("Rounded (default) remainder = " + Math.round(d % 2d));
        System.out.println("Rounded down remainder = " + Math.floor(d % 2d));

        System.out.println("---------------------------------");

        double d1 = 5.8d;
        System.out.println("No rounding = " +  (d1 % 2d));
        System.out.println("Rounded up remainder = " + Math.ceil(d1 % 2d));
        System.out.println("Rounded (default) remainder = " + Math.round(d1 % 2d));
        System.out.println("Rounded down remainder = " + Math.floor(d1 % 2d));

    }
}
