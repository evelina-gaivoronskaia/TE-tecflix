package com.techelevator.services;

import com.techelevator.model.Movie;
import com.techelevator.model.MovieGeneral;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@Component
public class RestMovieService implements MovieService {

    private RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://api.themoviedb.org/3/discover/movie?api_key=2d32c6a8acfff838e7086c4671244fb8&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate";


    @Override
    public List<Movie> getAllMovies() {
       MovieGeneral moviesGeneral = restTemplate.getForObject(API_URL, MovieGeneral.class);
       Movie[] movies = moviesGeneral.getResults();
       return Arrays.asList(movies);

    }
}
