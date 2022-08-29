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
import com.apress.bgn.eight.util.MediaLoader;
import com.apress.bgn.eight.util.Song;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

/**
 * Created by iuliana.cosmina on 20/05/2021
 */
public class OptionalDemo {

    public static void main(String... args) {
        Optional<Song> empty = Optional.empty();

        Optional<Long> value = Optional.of(5L);

        /*Song song0 = null;
        Optional<Song> nullable = Optional.of(song0);*/

        List<Song> songs = MediaLoader.loadSongs();
        Optional<Song> opt0 = songs.stream()
                .filter(s -> "B.B. King".equals(s.getSinger()))
                .findFirst();
        opt0.ifPresent(r -> System.out.println(r.getTitle())); // <1>

        // Java 8
        Optional<Song> opt1 = songs.stream()
                .filter(s -> "B.B. King".equals(s.getSinger()))
                .findFirst();
        if(opt1.isEmpty()) {
            System.out.println("Not found!");
        }

        // Java 9
        System.out.println("Testing ifPresentOrElse(..)");
        Optional<Song> opt2 = songs.stream()
                .filter(ss -> "B.B. King".equals(ss.getSinger())).findFirst();
        opt2.ifPresentOrElse(
                r -> System.out.println(r.getTitle()),
                () -> System.out.println("Not found!")) ;

        System.out.println("Testing get()");
        Optional<Song> opt3 = songs.stream()
                .filter(ss -> "Rob Thomas".equals(ss.getSinger()))
                .findFirst();
        System.out.println("Found Song " + opt3.get());

        System.out.println("Testing orElse(..)");
        Optional<Song> opt4 = songs.stream()
                .filter(ss -> "B.B. King".equals(ss.getSinger()))
                .findFirst();
        opt4.ifPresent(r -> System.out.println(r.getTitle()));

        Song defaultSong = new Song();
        defaultSong.setTitle("Untitled");
        Song s = opt4.orElse(defaultSong);
        System.out.println("Found: " + s.getTitle());


        Song fromSupplier = opt4.orElseGet(() -> new Song("None", "Untitled", 0, null));
        System.out.println("Found: " + fromSupplier.getTitle());

        System.out.println("Testing isMoreThan3MinsAndLessThenTen(..)");
        Song song0 = new Song("Ben Barnes", "You find me", 420, AudioType.FLAC);
        if(isMoreThan3MinsAndLessThenTen(song0)) {
            System.out.println("This song is just right!");
        }

        System.out.println("Testing orElseThrow(..)");
        Optional<Song> opt5 = songs.stream()
                .filter(st -> "B.B. King".equals(st.getSinger()))
                .findFirst();
        Song song1 = opt5.orElseThrow(IllegalArgumentException::new);
    }

    public static boolean isMoreThan3MinsAndLessThenTen(Song song) {
        return Optional.ofNullable(song).map(SongTransformer::processDuration)
                .filter(d -> d >= 3)
                .filter(d -> d <= 10)
                .isPresent();
    }

}
