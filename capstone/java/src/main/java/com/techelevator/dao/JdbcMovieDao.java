package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDAO{
    private JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> getList() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            movies.add(mapRowToMovie(result));
        }
        return movies;
    }

    @Override
    public Movie getMovieByID(int movieId) {
        Movie movie = null;
        String sql = "SELECT * " +
                     "FROM movie " +
                     "WHERE movie_id =?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, movieId);
        while (result.next()) {
            movie = mapRowToMovie(result);
        }
        return movie;
    }

    @Override
    public Movie createMovie(Movie movieToSave) {
        String sql = "INSERT INTO movie " +
                    "(genre, release_year, " +
                    "director, title, summary, movie_img) " +
                    "VALUES (?, ?, ?, ?, ?, ?);";
        Integer newMovie = jdbcTemplate.queryForObject(sql, Integer.class, movieToSave.getGenre(),
                movieToSave.getReleaseDate(), movieToSave.getTitle(),
                movieToSave.getSummary(), movieToSave.getMovieImg());
        return getMovieByID(newMovie);
    }

    @Override
    public Movie updateMovie(Movie movieToUpdate, int movieId) {
        String sql = "UPDATE movie SET genre = ?, release_year = ?, director = ?, " +
                     "title = ?, summary = ?, movie_img = ? " +
                     "WHERE movie_id = ?;";
        jdbcTemplate.update(sql, movieToUpdate.getGenre(), movieToUpdate.getReleaseDate(),
                movieToUpdate.getTitle(), movieToUpdate.getSummary(),
                movieToUpdate.getMovieImg());
        return getMovieByID(movieId);
    }

    @Override
    public boolean deleteMovie(int movieId) {
        String sql = "DELETE FROM movie WHERE movie_id = ?;";
        boolean isDeleted = false;
        try {
            jdbcTemplate.update(sql, movieId);
            isDeleted = true;
        }catch (Exception e) {
            //System.err.println("Unable to Delete");
        }
        return false;
    }

    private Movie mapRowToMovie(SqlRowSet rowSet) {
        Movie movie = new Movie();

        movie.setMovieId(rowSet.getInt("movie_id"));
        //movie.setGenre(rowSet.getInt("genre"));
        movie.setReleaseDate(rowSet.getString("release_date"));
        //movie.setDirector(rowSet.getString("director"));
        movie.setTitle(rowSet.getString("title"));
        movie.setSummary(rowSet.getString("summary"));
        movie.setMovieImg(rowSet.getString("movieImg"));
        return movie;
    }
}
