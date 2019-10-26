package ro.msg.learning.shop.model;

import lombok.*;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    List<Stock> stocks;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    List<OrderDetail> orderDetails;
    @ManyToOne
    @JoinColumn(name = "Category_id") //exactly the name from db
    private ProductCategory productCategory;
    @ManyToOne
    @JoinColumn(name = "Supplier")
    private Supplier supplier;

}
