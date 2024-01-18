package soft.musala.bookcatalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import soft.musala.bookcatalogservice.model.Book;
import soft.musala.bookcatalogservice.model.CatalogItem;
import soft.musala.bookcatalogservice.model.Rating;

@Service
public class BookInfoService {

    @Autowired
    private RestTemplate restTemplate;

    public CatalogItem getCatalogItem(Rating rating) {
        Book book = restTemplate.getForObject("http://book-info-service/books/" + rating.getBookId(), Book.class);
        return new CatalogItem(book.getTitle(), "test desc", rating.getRating());
    }

}
