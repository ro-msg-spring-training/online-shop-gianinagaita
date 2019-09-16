package ro.msg.learning.shop.model;

import lombok.*;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "Product")
 @NoArgsConstructor //using lombok
public class Product extends BaseEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "image_Url")
    private String imageUrl;
    @OneToMany(mappedBy = "product")
    Set<Stock> stocks;
    @OneToMany(mappedBy = "product")
    Set<OrderDetail> orderDetails;
    @ManyToOne
    @JoinColumn(name = "Category_id")
    private ProductCategory productCategory;
    @ManyToOne
    @JoinColumn(name = "Supplier")
    private Supplier supplier;

}
