package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.criterion.Order;
import ro.msg.learning.shop.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Customer")
@Data
public class Customer extends BaseEntity<Long> {
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "emailaddress")
    private String emailAddress;
    @OneToMany(mappedBy = "customer")
    private Set<Ordeer> created;
}
