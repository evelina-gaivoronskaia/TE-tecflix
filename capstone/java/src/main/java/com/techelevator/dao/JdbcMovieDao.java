package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDAO {
    private JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> getList() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()) {
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
                "(release_year, " +
                "director, title, summary, movie_img) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
        Integer newMovie = jdbcTemplate.queryForObject(sql, Integer.class,
                movieToSave.getReleaseDate(), movieToSave.getTitle(),
                movieToSave.getSummary(), movieToSave.getMovieImg());
        return getMovieByID(newMovie);
    }

    @Override
    public Movie updateMovie(Movie movieToUpdate, int movieId, String username) {
        // finds whos account this is
        String accountIdSql = "SELECT account_id FROM account " +
                "JOIN users ON account.user_id = users.user_id " +
                "WHERE username = ?";
        Integer accountId = jdbcTemplate.queryForObject(accountIdSql, Integer.class, username);

            //updates the movie IF MOVIE TIED TO ACCOUNT

            Integer result = getFavorite(movieId, accountId);


                if(result == null){
                    String insert = "INSERT INTO favorites (account_id, movie_id, favorite) VALUES (?,?,?)";
                    jdbcTemplate.update(insert, accountId, movieId, movieToUpdate.getFavorite());
                }

                String sql2 = "UPDATE favorites SET favorite = ? " +
                        "WHERE movie_id = ? AND account_id = ?;";

                jdbcTemplate.update(sql2, movieToUpdate.getFavorite(), movieToUpdate.getMovieId(), accountId);


        return getMovieByID(movieId);

    }

    private Integer getFavorite(int movieId, int accountId){
        Integer result;

        try{
            String movieSql = "SELECT favorite_id FROM favorites WHERE movie_id = ? AND account_id = ?;";
             result = jdbcTemplate.queryForObject(movieSql, Integer.class, movieId, accountId);
        } catch(EmptyResultDataAccessException e){
            return null;
        }

      return result;
    }
//    @Overide
//    public void setFavorite(int movieId ,String username){
//        String accountIdSql = "SELECT account_id FROM account " +
//                "JOIN users ON account.user_id = users.user_id " +
//                "WHERE username = ?";
//        Integer accountId = jdbcTemplate.queryForObject(accountIdSql, Integer.class, username);
//
//
//        String sql="INSERT INTO favorites(account_id,movie_id,favorite)" +
//                "VALUES (?,?,?)";
//
//    }


    @Override
    public boolean deleteMovie(int movieId) {
        String sql = "DELETE FROM movie WHERE movie_id = ?;";
        boolean isDeleted = false;
        try {
            jdbcTemplate.update(sql, movieId);
            isDeleted = true;
        } catch (Exception e) {
            // System.err.println("Unable to Delete");
        }
        return false;
    }

    private Movie mapRowToMovie(SqlRowSet rowSet) {
        Movie movie = new Movie();

        movie.setMovieId(rowSet.getInt("movie_id"));
        // movie.setGenre(rowSet.getInt("genre"));
        movie.setReleaseDate(rowSet.getString("release_date"));
        movie.setTitle(rowSet.getString("title"));
        movie.setSummary(rowSet.getString("summary"));
        movie.setMovieImg(rowSet.getString("movie_img"));
        return movie;
    }
}
