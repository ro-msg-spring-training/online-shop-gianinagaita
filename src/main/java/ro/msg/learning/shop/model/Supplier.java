package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Supplier")
@Data //using lombok
@NoArgsConstructor
@AllArgsConstructor

public class Supplier extends BaseEntity<Long> {
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Set<Product> products;
}
