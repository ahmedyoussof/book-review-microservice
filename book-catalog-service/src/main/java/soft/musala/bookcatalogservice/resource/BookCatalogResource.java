package soft.musala.bookcatalogservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import soft.musala.bookcatalogservice.model.Book;
import soft.musala.bookcatalogservice.model.CatalogItem;
import soft.musala.bookcatalogservice.model.Rating;
import soft.musala.bookcatalogservice.model.UserRating;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClient;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        System.out.println("UserId: " + userId);


        UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);
        return ratings.getUserRatings().stream().map(rating -> {
                    Book book = restTemplate.getForObject("http://localhost:8082/books/" + rating.getBookId(), Book.class);
                    /* Book book =  webClient.build()
                            .get()
                            .uri("http://localhost:8082/books/" + rating.getBookId())
                            .retrieve()
                            .bodyToMono(Book.class)
                            .block(); */
                    return new CatalogItem(book.getName(), "oop a&d", rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
