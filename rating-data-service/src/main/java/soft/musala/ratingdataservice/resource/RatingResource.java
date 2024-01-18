package soft.musala.ratingdataservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soft.musala.ratingdataservice.model.Rating;
import soft.musala.ratingdataservice.model.UserRating;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

    @RequestMapping("/health")
    public String healthCheck () {
        return "Rating service is up and running!";
    }

    @RequestMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId) {
        return new Rating(bookId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {

        List<Rating> ratings = Arrays.asList(
                new Rating("123", 4),
                new Rating("4567", 3)
        );

        return new UserRating(ratings);
    }
}
