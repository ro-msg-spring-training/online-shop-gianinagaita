package ro.msg.learning.shop.dto;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.model.Ordeer;

@Component
public class OrderConvert {

    public static OrderDTO convertEntityToDto(Ordeer ordeer) {
        return new OrderDTO(ordeer);
    }
}
