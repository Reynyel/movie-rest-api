package dev.reynyel.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Serves as data access layer for the API
//Actually talks to the database and getting the data back
@Repository
public interface MovieRepository extends MongoRepository <Movie, ObjectId>{
    //get movie by imdbId
    Optional<Movie> findMovieByImdbId(String imdbId);

}
