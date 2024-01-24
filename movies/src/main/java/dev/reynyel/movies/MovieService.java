package dev.reynyel.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    //Optional lets java know that it may return null if movie does not exist
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
