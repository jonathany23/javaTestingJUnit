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

    public Collection<Movie> findMovieByName(String name) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByDirector(String director) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector().toLowerCase().contains(director))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        Collection<Movie> movieCollection = movieRepository.findAll();

        if (template.getId() != null){
            movieCollection = movieCollection.stream()
                    .filter(movie -> movie.getId() == template.getId())
                    .collect(Collectors.toList());
        }
        if (template.getName() != null) {
            movieCollection = movieCollection.stream()
                    .filter(movie -> movie.getName().toLowerCase().contains(template.getName()))
                    .collect(Collectors.toList());
        }
        if (template.getMinutes() != null){
            movieCollection = movieCollection.stream()
                    .filter(movie -> movie.getMinutes() <= template.getMinutes()).collect(Collectors.toList());
        }
        if (template.getGenre() != null){
            movieCollection = movieCollection.stream()
                    .filter(movie -> movie.getGenre() == template.getGenre()).collect(Collectors.toList());
        }
        if (template.getDirector() != null){
            movieCollection = movieCollection.stream()
                    .filter(movie -> movie.getDirector().toLowerCase().contains(template.getDirector()))
                    .collect(Collectors.toList());
        }

        return movieCollection;
    }
}
