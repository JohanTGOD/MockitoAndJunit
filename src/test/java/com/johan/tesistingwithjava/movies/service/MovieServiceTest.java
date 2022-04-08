package com.johan.tesistingwithjava.movies.service;

import com.johan.tesistingwithjava.movies.data.MovieRepository;
import com.johan.tesistingwithjava.movies.model.Genre;
import com.johan.tesistingwithjava.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class MovieServiceTest {

    private MovieRepository movieRepository;
    MovieService movieService;

    @Before
    public void setUp() throws Exception {
        movieRepository= Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void returnMoviesByGenre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        List<Integer> moviesFilteredById = movies.stream().map(x -> x.getId()).collect(Collectors.toList());
        Assert.assertThat("", moviesFilteredById, CoreMatchers.is(asList(3,6)));
    }

    @Test
    public void returnMoviesByDuration() {

    }
}