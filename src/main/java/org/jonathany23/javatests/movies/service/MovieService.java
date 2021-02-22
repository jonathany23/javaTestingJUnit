package org.jonathany23.javatests.movies.service;

import org.jonathany23.javatests.movies.data.MovieRepository;
import org.jonathany23.javatests.movies.model.Genre;
import org.jonathany23.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMovieByGenre(Genre genre) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByLength(int duration) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= duration).collect(Collectors.toList());
    }
}
