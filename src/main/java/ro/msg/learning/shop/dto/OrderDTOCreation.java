package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.base.BaseEntity;
import ro.msg.learning.shop.model.Address;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
//using lombok
@Data
public class OrderDTOCreation extends BaseEntity<Long> {
    List<ProductQuantity> productQunatityList;
    private Date createdAt;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "Country", column = @Column(name = "Address_Country")),
            @AttributeOverride(name = "City", column = @Column(name = "Address_City")),
            @AttributeOverride(name = "County", column = @Column(name = "Address_County")),
            @AttributeOverride(name = "StreetAddress", column = @Column(name = "Address_StreetAddress"))

    })
    private Address address;
    private Long customerId;

}
