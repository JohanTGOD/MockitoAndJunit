package com.johan.tesistingwithjava.movies.service;

import com.johan.tesistingwithjava.movies.data.MovieRepository;
import com.johan.tesistingwithjava.movies.model.Genre;
import com.johan.tesistingwithjava.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
       return movieRepository.findAll().stream()
               .filter(x-> x.getGenre() == genre).collect(Collectors.toList());
    }
}
