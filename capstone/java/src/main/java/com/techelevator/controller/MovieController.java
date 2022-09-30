package com.techelevator.controller;


import com.techelevator.dao.MovieDAO;
import com.techelevator.model.Movie;
import com.techelevator.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class MovieController {

    @Autowired
    private MovieDAO movieDao;
    @Autowired
    MovieService movieService;
    public MovieController(MovieDAO movieDAO){this.movieDao =movieDAO;}

//    public MovieController(MovieDAO movieDAO, MovieService movieService){
//        this.movieDao = movieDAO;
//        this.movieService = movieService;
//    }


    @GetMapping(path = "/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping(path="/movies/{id}", method= RequestMethod.GET)
    public Movie get(@PathVariable("id") int movieId) {return movieDao.getMovieByID(movieId);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateThisMovie(@PathVariable int movieId, @RequestBody Movie updatedMovie){
        updatedMovie.setMovieId(movieId);
        if(movieDao.updateMovie(updatedMovie, movieId) != null){
            return updatedMovie;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found to update.");
        }
    }

}
