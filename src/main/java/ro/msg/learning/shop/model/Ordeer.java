package ro.msg.learning.shop.model;

import lombok.*;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Ordeer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ordeer extends BaseEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "Shipped_From")
    private Location ShippedFrom;
    @ManyToOne
    @JoinColumn(name = "Customer")
    private Customer customer;
    @Column(name = "CreatedAt")
    private Date createdAt;
    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordeer")
//    List<OrderDetail> orderDetails;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "Country", column = @Column(name = "Address_Country")),
            @AttributeOverride(name = "City", column = @Column(name = "Address_City")),
            @AttributeOverride(name = "County", column = @Column(name = "Address_County")),
            @AttributeOverride(name = "StreetAddress", column = @Column(name = "Address_StreetAddress"))

    })
    private Address address;


//    public Ordeer(Location location, Customer customerById, LocalDateTime now, Address address) {
//    }
}
