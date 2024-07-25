package yte.ypbs.ypbs_2024_ge3.login.configuration.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import yte.ypbs.ypbs_2024_ge3.login.configuration.AuthProperties;

import java.io.IOException;

@Component
public class CustomAuthFilter extends GenericFilterBean {
    private AuthProperties authProperties;

    public CustomAuthFilter(AuthProperties authProperties) {
        this.authProperties = authProperties;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String userSecret = httpRequest.getHeader("secret");

        if (userSecret != null && userSecret.equals(authProperties.getSecret())) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            throw new ServletException("Unauthorized");
        }
    }
}
