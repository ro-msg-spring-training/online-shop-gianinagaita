package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Supplier")
@Data //using lombok
public class Supplier extends BaseEntity<Long> {
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "supplier")
    private Set<Product> products;
}
