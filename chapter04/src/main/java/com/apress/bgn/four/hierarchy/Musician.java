package com.apress.bgn.four.hierarchy;

import java.util.List;

/**
 * @author iuliana.cosmina
 * @date 11/04/2018
 * @since 1.0
 */
public interface Musician extends Artist {

    List<String> getSongs();

    void setSongs(List<String> songs);

    String getGenre();

    void setGenre(String genre);
}
