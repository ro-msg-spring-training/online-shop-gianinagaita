package ro.msg.learning.shop.convert;

import ro.msg.learning.shop.dto.ReveneuDTO;
import ro.msg.learning.shop.model.Revenue;

public class ReveneuConverter {
    public static ReveneuDTO convertEntityToDto(Revenue revenue) { return  new ReveneuDTO(revenue);
    }
}
