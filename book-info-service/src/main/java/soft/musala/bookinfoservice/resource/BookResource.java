package soft.musala.bookinfoservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import soft.musala.bookinfoservice.model.Book;


@RestController
@RequestMapping("/books")
public class BookResource {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/health")
    public String healthCheck () {
        return "Book service is up and running!";
    }

    @RequestMapping("/{bookId}")
    public Book getBookInfo(@PathVariable("bookId") String bookId) {
        System.out.println("BookId : " + bookId);
        Book book = restTemplate.getForObject("https://gutendex.com/books/" + bookId, Book.class);
        return book;
    }

}
