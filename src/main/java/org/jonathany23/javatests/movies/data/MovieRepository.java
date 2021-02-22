package org.jonathany23.javatests.movies.data;

import org.jonathany23.javatests.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(Long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);

}
