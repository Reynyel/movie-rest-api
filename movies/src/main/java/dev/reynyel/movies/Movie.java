package dev.reynyel.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data //this will take care of getters and setters and two string lists
@AllArgsConstructor //takes all private field as argument
@NoArgsConstructor //takes no parameters
public class Movie {
    @Id
    private Object id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrop;

    @DocumentReference //This will store only the ids of the reviews, and reviews will be in separate collection
    private List<Review> reviewIds;
}
