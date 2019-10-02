package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.base.BaseEntity;
import ro.msg.learning.shop.model.Address;
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Ordeer;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO extends BaseEntity<Long> {
    private Long id;
    private Location ShippedFrom;
    private Customer customer;
    private Date createdAt;
    private Address address;

    public OrderDTO(Ordeer ordeer) {
        this.id = ordeer.getId();
        this.ShippedFrom = ordeer.getShippedFrom();
        this.customer = ordeer.getCustomer();
        this.createdAt = ordeer.getCreatedAt();
        this.address = ordeer.getAddress();
    }

}
