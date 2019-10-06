package ro.msg.learning.shop.services;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.OrderDTOCreation;
import ro.msg.learning.shop.dto.ProductQuantity;
import ro.msg.learning.shop.exceptions.StockNotFoundException;
import ro.msg.learning.shop.exceptions.StrategyEnableException;
import ro.msg.learning.shop.model.Address;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Ordeer;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.CustomerRepository;
import ro.msg.learning.shop.repository.OrderRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.strategy.Strategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class OrderServices {
    private final Strategy strategy;


    //need to modify after persisting in database the orderentity into orderto
   public List<Ordeer> createOrder(OrderDTOCreation orderDTOCreation){
        return
                strategy.createOrder(orderDTOCreation);
    }
}
