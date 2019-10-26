package ro.msg.learning.shop.dto;

import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Revenue;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReveneuDTO {
    private Long id;
    private Location location;
    private LocalDate date;
    private BigDecimal sum;

    public ReveneuDTO(Revenue revenue) {
        this.id = revenue.getId();
        this.date = revenue.getDate();
        this.location = revenue.getLocation();
        this.sum = revenue.getSum();
    }
}
