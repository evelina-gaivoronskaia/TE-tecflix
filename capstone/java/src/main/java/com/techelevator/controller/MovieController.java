package com.techelevator.controller;


import com.techelevator.dao.MovieDAO;
import com.techelevator.model.Movie;
import com.techelevator.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@PreAuthorize("isAuthenticated()")
public class MovieController {

    @Autowired
    private MovieDAO movieDao;
    @Autowired
    MovieService movieService;


    @GetMapping(path = "/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    
}
