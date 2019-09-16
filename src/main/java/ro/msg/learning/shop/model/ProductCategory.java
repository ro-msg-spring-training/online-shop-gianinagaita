package ro.msg.learning.shop.model;

import lombok.*;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

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
//    @OneToMany(mappedBy = "productcategory")
//    private Set<Product> created;
}
