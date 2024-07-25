package yte.ypbs.ypbs_2024_ge3.login.configuration;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix="auth")
public class AuthProperties {

    private String secret;

}
