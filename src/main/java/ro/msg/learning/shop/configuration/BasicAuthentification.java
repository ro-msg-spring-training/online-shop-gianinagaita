package ro.msg.learning.shop.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@RequiredArgsConstructor
@Configuration
@ConditionalOnProperty(value = "securitytype", havingValue = "Basic")
public class BasicAuthentification extends BaseSecurityConfig {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        super.configure(httpSecurity);
        httpSecurity.httpBasic();
    }

    //provide a password encoder Base64

}