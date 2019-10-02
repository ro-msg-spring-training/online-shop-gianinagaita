package ro.msg.learning.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.msg.learning.shop.model.Stock;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findStockByLocationIdAndProductIdIn(Long locationId, Collection<Long> productId);

    //ALSO MAKING WITHOUT QUERIES
    //   Optional<Long> findLocationIdFromStockByProductIdAndQuantityGreaterThanEqual(Long productId, Integer quantity);
//MAKING WITH CREATION METHOD A QUERY TO DataBase
    Optional<Stock> findStockByLocationIdAndProductId(Long locationId, Long productId);
    List<Stock> findStockByProductId(Long productId);
    List<Stock> findStockByLocationId(Long locationId);
    @Query("SELECT s.quantity FROM Stock s where s.stockId.productId= :productId and s.stockId.locationId= :locationId")
    Integer findQuantityByProductIdAndLocationId(@Param("productId") Long productId, @Param("locationId") Long locationId);

}
