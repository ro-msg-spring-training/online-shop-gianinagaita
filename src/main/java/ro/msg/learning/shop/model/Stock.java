package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Stock")
@Getter
@Setter
public class Stock {
    @EmbeddedId
    StockKey stockId;
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false,
            updatable = false)
    Product product;
    @ManyToOne
    @JoinColumn(name = "location_id", insertable = false,
            updatable = false)
    Location location;
    @Column(name = "quantity")
    private Integer quantity;


}
