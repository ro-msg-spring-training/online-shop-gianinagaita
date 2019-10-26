package ro.msg.learning.shop.convert;

import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.model.Ordeer;

public class OrderConverter {


    public static OrderDTO convertEntityToDto(Ordeer ordeer) {
        return new OrderDTO(ordeer);
    }

    public static Ordeer convertDtoToEntity(OrderDTO orderDTO) {
        return Ordeer.builder()
                .ShippedFrom(orderDTO.getShippedFrom())
                .customer(orderDTO.getCustomer())
                .createdAt(orderDTO.getCreatedAt())
                .address(orderDTO.getAddress())
                .build();
    }
}
