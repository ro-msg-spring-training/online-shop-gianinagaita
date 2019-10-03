package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Ordeer;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Ordeer, Long> {
    // Optional<Ordeer> findOrderByIdAndLocationIdIn(Long id, List<Long> locationId);
    Optional<Ordeer> findOrderByShippedFrom(Location ShippedFrom);
}
