package com.johan.tesistingwithjava.movies.data;

import com.johan.tesistingwithjava.movies.model.Genre;
import com.johan.tesistingwithjava.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MovieRepositoryJDBC implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {
        RowMapper<Movie> movieMapper = getMovieRowMapper();
        return jdbcTemplate.query("select * from movies",movieMapper);
    }

    private RowMapper<Movie> getMovieRowMapper() {
        RowMapper<Movie> movieMapper = getRowMapper();
        return movieMapper;
    }

    private static RowMapper<Movie> getRowMapper() {
        return (resultSet, i) -> new Movie(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("minutes"),
                Genre.valueOf(resultSet.getString("genre")));
    }

    @Override
    public void saveOrUpdate(Movie movie) {

    }
}
