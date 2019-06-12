package hello.repository;

import hello.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByPriceGreaterThanEqual(float price);
    List<Product> findByNameStartingWithAndPriceLessThan(String name,float price);
}
