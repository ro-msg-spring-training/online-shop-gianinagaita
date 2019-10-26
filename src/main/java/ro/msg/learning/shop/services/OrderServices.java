package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.OrderDTOCreation;
import ro.msg.learning.shop.model.Ordeer;
import ro.msg.learning.shop.strategy.Strategy;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServices {
    private final Strategy strategy;


    //need to modify after persisting in database the orderentity into orderto
    public List<Ordeer> createOrder(OrderDTOCreation orderDTOCreation) {
        return
                strategy.createOrder(orderDTOCreation);
    }
}
