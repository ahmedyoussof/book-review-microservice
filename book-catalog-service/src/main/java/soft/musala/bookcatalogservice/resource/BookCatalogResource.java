package soft.musala.bookcatalogservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import soft.musala.bookcatalogservice.model.Book;
import soft.musala.bookcatalogservice.model.CatalogItem;
import soft.musala.bookcatalogservice.model.Rating;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        System.out.println("UserId: " + userId);


        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );
        return ratings.stream().map(rating -> {
                    Book book = restTemplate.getForObject("http://localhost:8082/books/" + rating.getBookId(), Book.class);
                    return new CatalogItem(book.getName(), "oop a&d", rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
