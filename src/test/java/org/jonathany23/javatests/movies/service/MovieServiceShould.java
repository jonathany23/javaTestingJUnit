package org.jonathany23.javatests.movies.service;

import org.hamcrest.CoreMatchers;
import org.jonathany23.javatests.movies.data.MovieRepository;
import org.jonathany23.javatests.movies.model.Genre;
import org.jonathany23.javatests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Nigtht", 152, Genre.ACTION, "director 1"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "director 1"),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY, "director 1"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "director 1"),
                        new Movie(5, "Scream", 111, Genre.HORROR, "director 1"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY, "director 1"),
                        new Movie(7, "Matrix", 136, Genre.ACTION, "director 1"),
                        new Movie(8, "Superman", 130, Genre.ACTION, "director 1")
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMovieByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3,6)));
    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> movies = movieService.findMovieByLength(119);

        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    @Test
    public void return_movies_by_name() {
        Collection<Movie> movies = movieService.findMovieByName("super");

        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(4, 8)));
    }

    @Test
    public void return_movies_by_direcor() {
        Collection<Movie> movies = movieService.findMovieByDirector("director");

        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}