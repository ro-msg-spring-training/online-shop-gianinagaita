package ro.msg.learning.shop.model;

import lombok.Data;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Reveneu")
@Data //using lombok
public class Revenue extends BaseEntity<Long> {
    @Column(name = "tdate")
    private LocalDate date;
    @Column(name = "sum")
    private BigDecimal sum;
    @ManyToOne
    @JoinColumn(name = "Location")
    private Location location;
}
