package soft.musala.bookcatalogservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soft.musala.bookcatalogservice.model.CatalogItem;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        System.out.println("UserId: " + userId);
        return Collections.singletonList(
                new CatalogItem("Head First Object Oriented Analysis and Design", "oop a&d", 4)
        );
    }
}
