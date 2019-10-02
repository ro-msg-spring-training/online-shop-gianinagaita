package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.model.StockKey;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockDTO {
    private StockKey stockId;
    private Product product;
    private Location location;
    private Integer quantity;

    public StockDTO(Stock stock) {
        this.stockId = stock.getStockId();
        this.location = stock.getLocation();
        this.quantity = stock.getQuantity();
        //this.product=stock.getProduct();
    }

}
