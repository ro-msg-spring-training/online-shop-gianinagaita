package ro.msg.learning.shop.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exceptions.RecordNotFoundException;
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MyUserDetailService implements UserDetailsService {
    private CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findCustomerByuserName(s);
        if (customer.isPresent()) {
            Customer customer1 = customer.get();
            customer1.setPassword(passwordEncoder.encode(customer1.getPassword()));
            String str = customer1.getPassword();
            System.out.println(str);
            //customerRepository.save(customer1);
            return new User(customer1.getUserName(), customer1.getPassword(), getAuthorities(true));
        } else {
            throw new RecordNotFoundException("Username with this '" + s + "' does no exist");
        }
    }

    private List<GrantedAuthority> getAuthorities(boolean isAdmin) {

        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>(2);
        authorityList.add(new SimpleGrantedAuthority("USER_ROLE"));
        if (isAdmin) {
            authorityList.add(new SimpleGrantedAuthority("ADMIN_ROLE"));
        }
        return authorityList;
    }
}

