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

import com.apress.bgn.eight.util.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.apress.bgn.eight.util.MediaLoader.loadSongs;

/**
 * Created by iuliana.cosmina on 05/02/2021
 */
public class IntroductoryMain {
    public static void main(String... args) {
        List<Song> songList = loadSongs();
        List<Song> resultedSongs = new ArrayList<>();

        //find all songs with duration of at least 300 seconds
        for (Song song: songList) {
            if (song.getDuration() >= 300) {
                resultedSongs.add(song);
            }
        }

        // save the names in a list and sort them in decreasing order of their duration.
        Collections.sort(resultedSongs, (s1, s2) -> s2.getDuration().compareTo(s1.getDuration()));
        System.out.println(resultedSongs);
        List<String> finalList0 = new ArrayList<>();
        for (Song song: resultedSongs) {
            finalList0.add(song.getTitle());
        }
        System.out.println("Before Java 8: " + finalList0);

        // doing the same using a stream
        List<String> finalList = songList.stream().filter(s -> s.getDuration() >= 300)
                .sorted(Comparator.comparing(Song::getDuration).reversed())
                .map(Song::getTitle)
                .collect(Collectors.toList());
        System.out.println("After Java 8: " + finalList);
    }
}
