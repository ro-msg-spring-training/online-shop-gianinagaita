package ro.msg.learning.shop.convert;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.model.Stock;

@Component
@RequiredArgsConstructor
public class StockConverter {
    public static StockDTO convertEntityStockToDto(Stock stock) {
        return new StockDTO(stock);
    }

    public static Stock convertingStockDtoToEntity(StockDTO stockDTO) {
        return Stock.builder()
                .stockId(stockDTO.getStockId())
                .product(stockDTO.getProduct())
                .location(stockDTO.getLocation())
                .quantity(stockDTO.getQuantity())
                .build();
    }
}
