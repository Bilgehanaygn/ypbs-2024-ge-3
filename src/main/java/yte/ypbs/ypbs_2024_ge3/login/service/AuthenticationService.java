package yte.ypbs.ypbs_2024_ge3.login.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.security.AuthProvider;

@Service
public class AuthenticationService {
    private AuthenticationManager authenticationManager;
    private SecurityContextRepository securityContextRepository;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, SecurityContextRepository securityContextRepository) {
        this.authenticationManager = authenticationManager;
        this.securityContextRepository = securityContextRepository;
    }

    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticatedAuthentication = authenticationManager.authenticate(authenticationToken);

        if (authenticatedAuthentication.isAuthenticated()) {
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticatedAuthentication);
            SecurityContextHolder.setContext(securityContext);
            saveContext();
            return "Auth Successful";
        }
        return "Authentication Failed";
    }

    public void logout() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logoutHandler.logout(attr.getRequest(), attr.getResponse(), authentication);

        HttpServletRequest request = attr.getRequest();
        HttpServletResponse response = attr.getResponse();

        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath(request.getContextPath() + "/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    private void saveContext() {
        if (RequestContextHolder.getRequestAttributes() != null) {
            var requestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            var responseAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            securityContextRepository.saveContext(SecurityContextHolder.getContext(), requestAttributes, responseAttributes);
        }
    }
}
