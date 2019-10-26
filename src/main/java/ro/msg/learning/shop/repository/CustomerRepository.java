package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import ro.msg.learning.shop.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerById(Long costumerId);

    Optional<Customer> findCustomerByuserName(@PathVariable("username") String username);
}
