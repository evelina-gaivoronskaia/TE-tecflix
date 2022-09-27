package com.techelevator.services;

import com.techelevator.model.Movie;
import com.techelevator.model.MovieGeneral;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RestMovieService implements MovieService {

    private RestTemplate restTemplate = new RestTemplate();

    private final String API_URL = "https://api.themoviedb.org/3";


    @Override
    public List<Movie> getAllMovies() {

        MovieGeneral mg = restTemplate.getForObject(API_URL, MovieGeneral.class);
        Movie[] movies = mg.getResults();
        return Arrays.asList(movies);
    }
}
