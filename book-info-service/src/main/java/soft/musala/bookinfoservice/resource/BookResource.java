package soft.musala.bookinfoservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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


    @Autowired
    private Environment environment;

    @RequestMapping("/health")
    public String healthCheck () {
        return "Book info service is up and running on port: " + environment.getProperty("local.server.port");
    }

    @RequestMapping("/{bookId}")
    public Book getBookInfo(@PathVariable("bookId") String bookId) {
        System.out.println("BookId : " + bookId);
        Book book = restTemplate.getForObject("https://gutendex.com/books/" + bookId, Book.class);
        return book;
    }

}
