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
package com.apress.bgn.eight;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Created by iuliana.cosmina on 20/05/2021
 */
public class NumericStreamsDemo {
    public static void main(String... args) {
        IntStream intStream0 = IntStream.builder().add(0).add(1).add(2).add(5).build();
        IntStream intStream1 = IntStream.of(0,1,2,3,4,5);

        IntStream intStream2 = IntStream.range(0, 10);
        IntStream intStream3 = IntStream.rangeClosed(0, 10);

        Random random = new Random();
        IntStream intStream4 = random.ints(5);

        IntStream intStream5 = IntStream.of('a','b','c','d');
        intStream5.forEach(c -> System.out.println((char) c));

        IntStream charStream = "sample".chars();
        charStream.forEach(c -> System.out.println((char) c));

        DoubleStream doubleStream0 = DoubleStream.of(1, 2 , 2.3, 3.4, 4.5, 6);

        DoubleStream doubleStream1 = random.doubles(3);
        
        DoubleStream doubleStream2 = DoubleStream.iterate(2.5, d -> d = d + 0.2).limit(10);
    }
}
