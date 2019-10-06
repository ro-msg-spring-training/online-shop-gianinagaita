package ro.msg.learning.shop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.msg.learning.shop.services.MyUserDetailService;

public abstract class BaseSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    PasswordEncoder passwordEncoder;
    @Autowired
    MyUserDetailService userDetailService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                .disable().authorizeRequests().anyRequest().authenticated();
        httpSecurity.headers().frameOptions().disable(); //for showing me the console after the login in
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailService;
    }

}
