package ro.msg.learning.shop.convert;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ReveneuDTO;
import ro.msg.learning.shop.model.Revenue;

@Component
public class ReveneuConverter {
    public static ReveneuDTO convertEntityToDto(Revenue revenue) {
        return new ReveneuDTO(revenue);
    }
}
