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
 *
 */
public class BitwiseDemo {
    public static void main(String... args) {
        negator();
        System.out.println("-------------------------");
        and();
        System.out.println("-------------------------");
        or();
        System.out.println("-------------------------");
        xor();
        System.out.println("-------------------------");
    }

    public static void negator(){
        System.out.println(" ~ ");
        byte b1 = 10;
        print8Bits(b1);
        byte b2 = (byte) ~b1;
        print8Bits(b2);
    }

    public static void and(){
        System.out.println(" & ");
        byte b1 = 117;
        print8Bits(b1);
        byte b2 = 95;
        print8Bits(b2);
        byte result  = (byte) (b1 & b2);
        print8Bits(result);
    }

    public static void or(){
        System.out.println(" | ");
        byte b1 = 117;
        print8Bits(b1);
        byte b2 = 95;
        print8Bits(b2);
        byte result  = (byte) (b1 | b2);
        print8Bits(result);
    }

    public static void xor(){
        System.out.println(" ^ ");
        byte b1 = 117;
        print8Bits(b1);
        byte b2 = 95;
        print8Bits(b2);
        byte result  = (byte) (b1 ^ b2);
        print8Bits(result);
    }

    public static void print8Bits(byte arg) {
        System.out.println("decimal:" + arg);
        String str = String.format("%8s", Integer.toBinaryString(arg)).replace(' ', '0');
        System.out.println("binary:" + str);
    }

}
