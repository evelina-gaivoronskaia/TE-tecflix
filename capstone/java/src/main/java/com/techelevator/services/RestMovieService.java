package com.techelevator.services;

import com.techelevator.controller.MovieController;
import com.techelevator.model.Movie;
import com.techelevator.model.MovieGeneral;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
                if (movieId != actualId) {
                    String sql = "INSERT INTO movie (movie_id, release_date, title, summary, movie_img) VALUES(?,?,?,?,?)";
                    jdbcTemplate.update(sql, movies[i].getMovieId(), movies[i].getReleaseDate(), movies[i].getTitle(), movies[i].getSummary(), movies[i].getMovieImg());
                }
            }
            catch  (EmptyResultDataAccessException e){
                String sql = "INSERT INTO movie (movie_id, release_date, title, summary, movie_img) VALUES(?,?,?,?,?)";
                jdbcTemplate.update(sql, movies[i].getMovieId(), movies[i].getReleaseDate(), movies[i].getTitle(),
                        movies[i].getSummary(), movies[i].getMovieImg());

            }

        }
        return Arrays.asList(movies);
    }

    @Override
    public ArrayList<Movie> getFavoriteMovies(String username) {
        ArrayList<Movie> favoriteMovies = new ArrayList<>();
        try {
            String accountIdSql = "SELECT account_id FROM account " +
                    "JOIN users ON account.user_id = users.user_id " +
                    "WHERE username = ?";
            Integer accountId = jdbcTemplate.queryForObject(accountIdSql, Integer.class, username);

            String sql = "SELECT movie_id FROM favorites WHERE account_id = ?";
            List<Integer> movieIDsList;
            movieIDsList = jdbcTemplate.queryForList(sql, Integer.class, accountId);
            for (int i = 0; i < movieIDsList.size(); i++) {
                int movieId = movieIDsList.get(i);
                String favoriteSQL = "SELECT movie.movie_id, release_date, title, summary, movie_img, favorite FROM movie JOIN favorites ON movie.movie_id = favorites.movie_id WHERE movie.movie_id = ? AND account_id = ?";
                SqlRowSet results = jdbcTemplate.queryForRowSet(favoriteSQL, movieId, accountId);
                while(results.next()){
                    favoriteMovies.add(mapRowToMovie(results));
                }
            }
        }
        catch(EmptyResultDataAccessException e) {
            System.out.println("No favorite movies found!");
        }
        return favoriteMovies;
    }

    private Movie mapRowToMovie(SqlRowSet rowSet) {
        Movie movie = new Movie();
        movie.setMovieId(rowSet.getInt("movie_id"));
        // movie.setGenre(rowSet.getInt("genre"));
        movie.setReleaseDate(rowSet.getString("release_date"));
        movie.setTitle(rowSet.getString("title"));
        movie.setSummary(rowSet.getString("summary"));
        movie.setMovieImg(rowSet.getString("movie_img"));
        movie.setFavorite(rowSet.getBoolean("favorite"));
        return movie;
    }


}
