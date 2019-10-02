package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "Location")
@Getter
@Setter//using lombok
@AllArgsConstructor
@NoArgsConstructor
public class Location extends BaseEntity<Long> {
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "Country", column = @Column(name = "Address_Country")),
            @AttributeOverride(name = "City", column = @Column(name = "Address_City")),
            @AttributeOverride(name = "County", column = @Column(name = "Address_County")),
            @AttributeOverride(name = "StreetAddress", column = @Column(name = "Address_StreetAddress"))

    })
    private Address address;
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "location")
//    List<Stock> stocks;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ShippedFrom")
//    private List<Ordeer> created;
}
