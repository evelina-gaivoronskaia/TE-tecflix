package com.techelevator.controller;


import com.techelevator.dao.MovieDAO;
import com.techelevator.model.Movie;
import com.techelevator.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping(path = "/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping(path="/movies/{id}", method= RequestMethod.GET)
    public Movie get(@PathVariable("id") int movieId) {return movieDao.getMovieByID(movieId);
    }


}
