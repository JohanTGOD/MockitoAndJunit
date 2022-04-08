package com.johan.tesistingwithjava.movies.model;

public class Movie {

    private Integer id;
    private String name;
    private int minutes;
    private Genre genre;


    public Movie(String name, int minutes, Genre genre) {
        this(null, name, minutes, genre);
    }

    public Movie(Integer id, String name, int minutes, Genre genre) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (minutes != movie.minutes) return false;
        if (id != null ? !id.equals(movie.id) : movie.id != null) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        return genre == movie.genre;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + minutes;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}



