package com.techelevator.dao;

import com.techelevator.model.Movie;

import java.util.List;

public interface MovieDAO {

    List<Movie> getList();
    Movie getMovieByID(int movieId);
    Movie createMovie(Movie movieToSave);
    Movie updateMovie(Movie movieToUpdate, int movieId);
    boolean deleteMovie(int movieId);

}
