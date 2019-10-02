package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ro.msg.learning.shop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(@Param("id") Long id);
}
