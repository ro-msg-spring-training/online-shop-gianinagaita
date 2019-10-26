package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.dto.OrderDTOCreation;
import ro.msg.learning.shop.model.Ordeer;

import java.util.List;

public interface Strategy {
    List<Ordeer> createOrder(OrderDTOCreation orderDTOCreation);
}
