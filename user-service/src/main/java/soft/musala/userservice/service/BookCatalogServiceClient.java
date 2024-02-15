package soft.musala.userservice.service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import soft.musala.userservice.model.CatalogItem;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "book-catalog-service")
public interface BookCatalogServiceClient {
    @GetMapping("/catalog/{userId}")
    @Retry(name="book-catalog-service")
    @CircuitBreaker(name="book-catalog-service", fallbackMethod="getCatalogsFallback")
    public List<CatalogItem> getBookCatalogs(@PathVariable String userId);

    default List<CatalogItem> getCatalogsFallback(String userId, Throwable exception) {
        System.out.println("Param = " + userId);
        System.out.println("Exception took place: " + exception.getMessage());
        return new ArrayList<>();
    }
}
