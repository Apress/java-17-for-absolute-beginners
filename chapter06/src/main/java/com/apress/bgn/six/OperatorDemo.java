package com.apress.bgn.six;

import com.apress.bgn.four.classes.Gender;
import com.apress.bgn.four.hierarchy.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iuliana.cosmina on 3/6/18
 */
public class OperatorDemo {

    public static void main(String... args) {
        List<Artist> artists = new ArrayList<>();

        Musician john = new Performer("John", 43, 1.91f, Gender.MALE);
        List<String> songs = List.of("Gravity");
        john.setSongs(songs);
        artists.add(john);

        Graphician diana = new Graphician("Diana", 23, 1.62f, Gender.FEMALE, "MacOs");
        artists.add(diana);

        //Musician fake = (Musician) diana;

        for (Artist artist : artists) {
            if (artist instanceof Musician musician) {
                System.out.println("Songs: " + musician.getSongs());
            } else {
                System.out.println("Other Type: " +  artist.getClass());
            }
        }
    }
}
