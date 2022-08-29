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
import com.apress.bgn.eight.util.StreamMediaLoader;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MediaStreamTester {
    public static Consumer<Song> myConsumer = song -> {
        song.setSinger(song.getSinger().toUpperCase());
        System.out.println(song);
    };


    public static void main(String... args) {
        Stream<Song> songs = StreamMediaLoader.loadSongs();
        songs.forEach(song -> System.out.println(song));

        songs = StreamMediaLoader.loadSongs();
        songs.forEach(song -> myConsumer.accept(song));

        songs = StreamMediaLoader.loadSongs();
        songs.forEachOrdered(song -> myConsumer.accept(song));

        System.out.println(" Collecting Stream elements into an array");
        songs = StreamMediaLoader.loadSongs();
        Song[] sarray = songs.filter(s -> s.getAudioType() == AudioType.MP3).toArray(Song[]::new);
        Arrays.stream(sarray).forEach(System.out::println);


        System.out.println("----- Testing sum() -----");
        songs = StreamMediaLoader.loadSongs();
        Integer totalDuration0 = songs
                .mapToInt(Song::getDuration)
                .sum();
        System.out.println("Total duration: " + totalDuration0);

        System.out.println("----- Testing reduce(..) -----");
        songs = StreamMediaLoader.loadSongs();
        Integer totalDuration1 = songs
                .mapToInt(Song::getDuration)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Total duration: " + totalDuration1);


        System.out.println("----- Testing findAny() -----");
        songs = StreamMediaLoader.loadSongs();
        Optional<Song> optSong = songs.parallel().findAny();
        optSong.ifPresent(System.out::println);

        System.out.println("----- Testing anyMatch(..) -----");
        songs = StreamMediaLoader.loadSongs();
        boolean b0 = songs.anyMatch(s -> s.getTitle().contains("Paper"));
        System.out.println("Are there songs with title containing ’Paper’? " + b0);

        System.out.println("----- Testing skip(..) + anyMatch(..) -----");
        songs = StreamMediaLoader.loadSongs();
        boolean b1 = songs.parallel()
                .skip(6)
                .anyMatch(s -> s.getTitle().contains("Paper"));
        System.out.println("Are there songs with title containing `Paper`? " + b1);


        System.out.println("----- Testing allMatch(..) -----");
        songs = StreamMediaLoader.loadSongs();
        boolean b2 = songs.allMatch(s -> s.getDuration() > 300); // <1>
        System.out.println("Are all songs longer than 5 minutes? " + b2);

        System.out.println("----- Testing noneMatch(..) -----");
        songs = StreamMediaLoader.loadSongs();
        boolean b3 = songs.noneMatch(s -> s.getDuration() > 300); // <1>
        System.out.println("Are all songs shorter than 5 minutes? " + b3);


    }
}