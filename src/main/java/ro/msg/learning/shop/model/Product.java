package ro.msg.learning.shop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode//using lombok
public class Product extends BaseEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "imageUrl")
    private String imageUrl;
//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "Stock",
//            joinColumns = @JoinColumn(name = "Product", referencedColumnName = "id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "Location", referencedColumnName = "id", nullable = false)
//    )
    @OneToMany(mappedBy = "product")
    Set<Stock> stocks;
    @OneToMany(mappedBy = "product")
    Set<OrderDetail> orderDetails;
    @ManyToOne
    @JoinColumn(name = "Category")
    private ProductCategory productcategory;
    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "OrderDetail",
//            joinColumns = @JoinColumn(name = "Product", referencedColumnName = "id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "Ordeer", referencedColumnName = "id", nullable = false)
//    )

    @ManyToOne
    @JoinColumn(name = "Supplier")
    private Supplier supplier;

}
