package yte.ypbs.ypbs_2024_ge3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    public SecurityConfiguration(AuthenticationManagerBuilder authManagerBuilder,
                                 CustomUserDetailService customerUserDetailService) throws Exception {
        authManagerBuilder
                .userDetailsService(customerUserDetailService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }
}
