package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Product_Category")
@Data //using lombok
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory extends BaseEntity<Long> {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCategory")
    private List<Product> created;
}
