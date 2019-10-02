package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.model.Ordeer;

public interface OrderRepository extends JpaRepository<Ordeer, Long> {
    // Optional<Ordeer> findOrderByIdAndLocationIdIn(Long id, List<Long> locationId);
}
