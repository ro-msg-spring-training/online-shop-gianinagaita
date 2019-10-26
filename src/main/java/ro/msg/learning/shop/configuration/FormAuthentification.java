package ro.msg.learning.shop.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
//@ConditionalOnBean
//@ConditionalOnClass
@ConditionalOnProperty(value = "securitytype", havingValue = "Form")
public class FormAuthentification extends BaseSecurityConfig {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        super.configure(httpSecurity);
        httpSecurity.formLogin()
                .failureUrl("/login-error.html");
    }


}