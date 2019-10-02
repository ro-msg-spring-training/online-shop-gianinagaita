package ro.msg.learning.shop.convert;

import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.model.Ordeer;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.repository.SupplierRepository;

public class OrderConverter {


    public static OrderDTO convertEntityToDto(Ordeer ordeer) {
        return new OrderDTO(ordeer);
    }

    public Ordeer convertDtoToEntity(OrderDTO orderDTO) {
        return Ordeer.builder()
                .ShippedFrom(orderDTO.getShippedFrom())
                .customer(orderDTO.getCustomer())
                .createdAt(orderDTO.getCreatedAt())
                .address(orderDTO.getAddress())
                .build();
    }
}
