package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Location")
@Data //using lombok
public class Location extends BaseEntity<Long> {
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "Country", column = @Column(name = "Address_Country")),
            @AttributeOverride( name = "City", column = @Column(name = "Address_City")),
            @AttributeOverride( name = "County", column = @Column(name = "Address_County")),
            @AttributeOverride( name = "StreetAddress", column = @Column(name = "Address_StreetAddress"))

    })
    private Address address;
    @OneToMany(mappedBy = "location")
    Set<Stock> stocks;
    @OneToMany(mappedBy = "ShippedFrom")
    private Set<Ordeer> created;
}
