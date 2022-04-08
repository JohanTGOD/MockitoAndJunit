package com.johan.tesistingwithjava.movies.data;

import com.johan.tesistingwithjava.movies.model.Genre;
import com.johan.tesistingwithjava.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryJDBCTest {

    @Test
    public void loadAllMovies() throws SQLException {
        DriverManagerDataSource data = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(data);

        ScriptUtils.executeSqlScript(data.getConnection(), new ClassPathResource("script.sql"));
        MovieRepositoryJDBC movieRepositoryJDBC = new MovieRepositoryJDBC(jdbcTemplate);
        Collection<Movie> movies = movieRepositoryJDBC.findAll();
        assertThat( movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )) );

    }
}