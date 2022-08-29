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

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

/**
 * Created by iuliana.cosmina on 24/10/2021
 */
public class RandomNumberGeneratorsDemo {

    public static void main(String... args) {
        // use in apps with no concurrent threads - Random objects are shared
        Random rand = new Random();
        System.out.println("Random integer value from 0 to" + (Integer.MAX_VALUE-1) + " : "+ rand.nextInt(Integer.MAX_VALUE));

        // Introduced in Java 1.7 - local to the current thread
        System.out.println("java.util.concurrent.ThreadLocalRandom:" + ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));

        // Introduced in Java 17 this interface is designed to provide a common protocol for objects that generate random
        // or (more typically) pseudorandom sequences of numbers (or Boolean values).
        System.out.println("java.util.random.RandomGenerator:" + RandomGenerator.getDefault().nextInt(Integer.MAX_VALUE));
    }
}
