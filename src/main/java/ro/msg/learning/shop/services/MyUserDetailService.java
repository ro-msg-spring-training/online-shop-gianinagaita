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
    @Autowired
    PasswordEncoder passwordEncoder;
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findCustomerByuserName(s);
        customer.get().setPassword(passwordEncoder.encode(customer.get().getPassword()));
        return customer
                .map(u -> new User(customer.get().getUserName(), customer.get().getPassword(), getAuthorities(true)))
                .orElseThrow(() -> new RecordNotFoundException(
                        "Username with this '" + s + "' does not exist"));

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

