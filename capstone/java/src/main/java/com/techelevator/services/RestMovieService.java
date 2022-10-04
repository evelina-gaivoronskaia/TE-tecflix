package com.techelevator.services;

import com.techelevator.model.Movie;
import com.techelevator.model.MovieGeneral;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RestMovieService implements MovieService {

    private RestTemplate restTemplate = new RestTemplate();

    private final JdbcTemplate jdbcTemplate;

    private final String API_URL = "https://api.themoviedb.org/3/discover/movie?api_key=2d32c6a8acfff838e7086c4671244fb8&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate";

    public RestMovieService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> getAllMovies() { // rename loadAllMovies

        MovieGeneral moviesGeneral = restTemplate.getForObject(API_URL, MovieGeneral.class);
        Movie[] movies = moviesGeneral.getResults();

        for (int i = 0; i < movies.length; i++) {
            try {
                int actualId = movies[i].getMovieId();
                int movieId;
                String errorCheck = "SELECT movie_id FROM movie WHERE title ILIKE ? AND release_date ILIKE ?";
                movieId = jdbcTemplate.queryForObject(errorCheck, int.class, movies[i].getTitle(), movies[i].getReleaseDate());
//                if (movieId != actualId) {
//                    String sql = "INSERT INTO movie (movie_id, release_date, title, summary, movie_img) VALUES(?,?,?,?,?)";
//                    jdbcTemplate.update(sql, movies[i].getMovieId(), movies[i].getReleaseDate(), movies[i].getTitle(), movies[i].getSummary(), movies[i].getMovieImg());
//                }
            }
            catch  (EmptyResultDataAccessException e){
                String sql = "INSERT INTO movie (movie_id, release_date, title, summary, movie_img) VALUES(?,?,?,?,?)";
                jdbcTemplate.update(sql, movies[i].getMovieId(), movies[i].getReleaseDate(), movies[i].getTitle(),
                        movies[i].getSummary(), movies[i].getMovieImg());

            }

        }
        return Arrays.asList(movies);
    }
}
