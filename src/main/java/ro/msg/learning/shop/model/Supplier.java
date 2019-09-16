package ro.msg.learning.shop.model;

import lombok.*;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Supplier")
@Data //using lombok
@NoArgsConstructor
@AllArgsConstructor

public class Supplier extends BaseEntity<Long> {
    @Column(name = "name")
    private String name;
//    @OneToMany(mappedBy = "supplier")
//    private Set<Product> products;
}
