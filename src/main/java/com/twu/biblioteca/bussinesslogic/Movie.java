package com.twu.biblioteca.bussinesslogic;

import java.util.Objects;

public class Movie {

    private final String name;
    private final String director;
    private final int releaseYear;

    public Movie(String name, String director, int releaseYear) {
        this.name = name;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public String getDirectorName() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return releaseYear == movie.releaseYear &&
                Objects.equals(name, movie.name) &&
                Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, director, releaseYear);
    }
}
