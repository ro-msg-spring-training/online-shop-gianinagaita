package ro.msg.learning.shop.dto;

import ro.msg.learning.shop.model.Ordeer;

public class OrderConvert {

    public static OrderDTO convertEntityToDto(Ordeer ordeer) {
        return new OrderDTO(ordeer);
    }
}
