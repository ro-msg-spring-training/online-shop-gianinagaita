package ro.msg.learning.shop.model;

import lombok.*;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Ordeer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordeer extends BaseEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "ShippedFrom")
    private Location ShippedFrom;
    @ManyToOne
    @JoinColumn(name = "Customer")
    private Customer customer;
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "ordeer")
    Set<OrderDetail> orderDetails;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "Country", column = @Column(name = "Address_Country")),
            @AttributeOverride( name = "City", column = @Column(name = "Address_City")),
            @AttributeOverride( name = "County", column = @Column(name = "Address_County")),
            @AttributeOverride( name = "StreetAddress", column = @Column(name = "Address_StreetAddress"))

    })
    private Address address;


}
