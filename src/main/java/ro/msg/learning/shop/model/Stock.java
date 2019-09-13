package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "Stock")
@Data
public class Stock {
    @EmbeddedId
    StockKey id;
    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    Product product;
    @ManyToOne
    @MapsId("location_id")
    @JoinColumn(name = "location_id")
    Location location;
    //@Column(name = "quantity")
    private Integer quantity;


}
