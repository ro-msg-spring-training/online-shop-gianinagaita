package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Data
@Setter
@Getter
public class ResponseProximityStrategy {
    Location location;
    Long productId;
    Integer quantity;

    public ResponseProximityStrategy(Location location, Long productId, Integer quantity) {
        this.location = location;
        this.productId = productId;
        this.quantity = quantity;
    }


}
