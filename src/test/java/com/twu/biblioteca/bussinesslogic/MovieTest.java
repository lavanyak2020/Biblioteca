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
}
