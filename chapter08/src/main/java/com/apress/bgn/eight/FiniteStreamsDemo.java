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

import com.apress.bgn.eight.util.AudioType;
import com.apress.bgn.eight.util.Song;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by iuliana.cosmina on 19/05/2021
 */
public class FiniteStreamsDemo {
    public static void main(String... args) {
        Stream<Integer> built = Stream.<Integer>builder()
                .add(50).add(10).add(250)
                .build();

        Stream<String> lyrics = Stream.<String>builder()
                .add("In a world where people never meet,")
                .add("They fall in love looking at some screen")
                .add("And love can only be one-sided")
                .add("Bitter, burning unrequited.")
                .build();

        Stream<Song> songs = Stream.<Song>builder()
                .add (new Song("John Mayer", "New Light", 206, AudioType.FLAC))
                .add (new Song("Ben Barnes", "You find me", 420, AudioType.FLAC))
                .build();

        Stream data = Stream.builder()
                .add("Vultures")
                .add(3)
                .add(List.of("aa"))
                .build();

        Stream<Integer> generated = Stream.generate(
                () -> {
                    Random rand = new Random();
                    return rand.nextInt(300) + 1;
                }
        ).limit(15);

        Stream<Integer> iterated1 = Stream.iterate(0, i -> i < 50 , i -> i + 5);

        Stream<Integer> iterated2 = Stream.iterate(0, i -> i + 5).limit(15);

        System.out.println("Print elements of stream generated with 'takeWhile(s -> s % 3 == 0)' from ordered stream ");
        Stream<Integer> orderedStream = List.of( 3, 6, 9, 11, 12, 13, 15).stream();
        Stream<Integer> result = orderedStream.takeWhile(s -> s % 3 == 0);
        result.forEach(s -> System.out.print(s + " "));

        System.out.println("\nPrint elements of stream generated with 'takeWhile(s -> s % 3 == 0)' from unordered stream");
        //while (true) {
            Stream<Integer> unorderedStream = Set.of(3, 6, 9, 2, 4, 8, 12, 36, 18, 42, 11, 13).stream();
            result = unorderedStream
                    //.parallel()
                    .takeWhile(s -> s % 3 == 0);
            result.forEach(s -> System.out.print(s + " "));
        //}

        System.out.println("\nPrint elements of stream generated with 'dropWhile(s -> s % 3 == 0)' from ordered stream ");
        List.of( 3, 6, 9, 11, 12, 13, 15).stream()
            .dropWhile(s -> s % 3 == 0 ).forEach(s -> System.out.print(s + " "));

        System.out.println("\nPrint elements of stream generated with 'dropWhile(s -> s % 3 == 0)' from unordered stream ");
        Set.of(3, 6, 9, 2, 4, 8, 12, 36, 18, 42, 11, 13).stream()
                .parallel()
                .dropWhile(s -> s % 3 == 0 ).forEach(s -> System.out.print(s + " "));
    }
}
