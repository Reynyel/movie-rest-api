package dev.reynyel.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    //form a dynamic query and do the job inside the database without using the repository
    @Autowired
    private MongoTemplate mongoTemplate;


    //First look for movie with the given imdbId
    //Second create a review and link it with the found movie
    public Review createReview(String reviewBody, String imdbId){
        //insert into database
        Review review = reviewRepository.insert(new Review(reviewBody));

        //using template to update the movie class
        //matching to check which movie is being updated
        //apply to apply the update
        //the review created will be pushed inside the review ids array
        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
