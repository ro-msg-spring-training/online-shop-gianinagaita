package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Ordeer;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Ordeer, Long> {
    // Optional<Ordeer> findOrderByIdAndLocationIdIn(Long id, List<Long> locationId);
    @Query("SELECT o.ShippedFrom FROM Ordeer o where o.ShippedFrom= :ShippedFrom")
    List<Ordeer> findOrderByShippedFrom(Location ShippedFrom);
}
