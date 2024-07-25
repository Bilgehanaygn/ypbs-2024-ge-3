package yte.ypbs.ypbs_2024_ge3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import yte.ypbs.ypbs_2024_ge3.login.configuration.AuthProperties;

@SpringBootApplication
@EnableConfigurationProperties(AuthProperties.class)
public class Ypbs2024Ge3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ypbs2024Ge3Application.class, args);
	}

}
