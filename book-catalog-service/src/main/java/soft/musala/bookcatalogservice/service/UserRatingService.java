package soft.musala.bookcatalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import soft.musala.bookcatalogservice.model.UserRating;


@Service
public class UserRatingService {

    @Autowired
    private RestTemplate restTemplate;

    public UserRating getUserRating(String userId) {
        return restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, UserRating.class);
    }

}
