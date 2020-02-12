package com.twu.biblioteca.bussinesslogic;

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
}
