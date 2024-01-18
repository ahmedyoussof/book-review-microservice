package soft.musala.bookcatalogservice.resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import soft.musala.bookcatalogservice.model.CatalogItem;
import soft.musala.bookcatalogservice.model.UserRating;
import soft.musala.bookcatalogservice.service.BookInfoService;
import soft.musala.bookcatalogservice.service.UserRatingService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private UserRatingService userRatingService;

    @RequestMapping("/health")
    public String healthCheck () {
        return "Catalog service is up and running!";
    }

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating ratings = userRatingService.getUserRating(userId);
        return ratings.getUserRatings().stream()
                .map(rating -> bookInfoService.getCatalogItem(rating))
                .collect(Collectors.toList());
    }

 }
