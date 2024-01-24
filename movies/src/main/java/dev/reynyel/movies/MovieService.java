package dev.reynyel.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//The service class
//Uses the MovieRepository class, and talks to the database
//get the list of the movies and returns to the API layer
@Service
public class MovieService {
    @Autowired //Instantiate the class for us
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }
}
