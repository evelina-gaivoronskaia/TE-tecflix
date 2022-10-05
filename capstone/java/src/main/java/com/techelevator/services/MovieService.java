package com.techelevator.services;

import com.techelevator.model.Movie;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    ArrayList<Movie> getFavoriteMovies(String username);
}
