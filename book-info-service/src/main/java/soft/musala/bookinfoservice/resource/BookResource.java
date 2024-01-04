package soft.musala.bookinfoservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soft.musala.bookinfoservice.model.Book;


@RestController
@RequestMapping("/books")
public class BookResource {

    @RequestMapping("/{bookId}")
    public Book getBookInfo(@PathVariable("bookId") String bookId) {
        System.out.println("BookId : " + bookId);
        return new Book("123", "Head First Object Oriented Analysis and Design");
    }

}
