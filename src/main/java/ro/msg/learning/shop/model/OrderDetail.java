package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetail")
@Data
public class OrderDetail {
    @EmbeddedId
    OrderDetailKey id;
    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id", insertable = false,
            updatable = false)
    Product product;
    @ManyToOne
    @MapsId("ordeer_id")
    @JoinColumn(name = "ordeer_id", insertable = false,
            updatable = false)
    Ordeer ordeer;
    private Integer quantity;
}
