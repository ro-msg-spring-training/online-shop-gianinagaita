package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class StockKey implements Serializable {
    @Column(name = "Product_id")
    Long productId;
    @Column(name = "Location_id")
    Long locationId;
}
