package com.johan.tesistingwithjava.movies.data;

import com.johan.tesistingwithjava.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);

    Collection<Movie> findAll();

    void saveOrUpdate(Movie movie);

}
