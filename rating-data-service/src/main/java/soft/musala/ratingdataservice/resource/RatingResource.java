package soft.musala.ratingdataservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soft.musala.ratingdataservice.model.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId) {
        return new Rating(bookId, 4);
    }
}
