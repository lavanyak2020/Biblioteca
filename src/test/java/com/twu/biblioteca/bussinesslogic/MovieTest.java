package com.twu.biblioteca.bussinesslogic;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class MovieTest {

    @Test
    public void shouldReturnDetailsOfTheMovie() {
        Movie movie = new Movie("Ala Vaikunta Puramlo", "Trivikram Srinivas", 2020);

        assertThat(movie.getName(), is(equalTo("Ala Vaikunta Puramlo")));
        assertThat(movie.getDirectorName(), is(equalTo("Trivikram Srinivas")));
        assertThat(movie.getReleaseYear(), is(equalTo(2020)));
    }

    @Test
    public void shouldEquateTwoSameMovies() {
        Movie movie1 = new Movie("Ala Vaikunta Puramlo", "Trivikram Srinivas", 2020);
        Movie movie2 = new Movie("Ala Vaikunta Puramlo", "Trivikram Srinivas", 2020);

        assertThat(movie1, is(equalTo(movie2)));
    }
}
