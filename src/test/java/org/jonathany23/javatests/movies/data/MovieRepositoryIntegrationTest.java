package org.jonathany23.javatests.movies.data;

import org.hamcrest.CoreMatchers;
import org.jonathany23.javatests.movies.model.Genre;
import org.jonathany23.javatests.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepository;
    private DataSource dataSource;


    @Before
    public void setUp() throws Exception {
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {

        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "director 1"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "director 2"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "director 3")
        )));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);
        assertThat(movie, CoreMatchers.is(new Movie(2, "Memento", 113, Genre.THRILLER, "director 2")));
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER, "director 8");

        movieRepository.saveOrUpdate(movie);
        Movie movieFromDb = movieRepository.findById(4);
        
        assertThat(movieFromDb, CoreMatchers.is(new Movie(4,"Super 8", 112, Genre.THRILLER, "director 4")));

    }

    @After
    public void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}