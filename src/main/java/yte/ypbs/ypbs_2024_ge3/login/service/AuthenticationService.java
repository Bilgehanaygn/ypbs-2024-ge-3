package yte.ypbs.ypbs_2024_ge3.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
            return "Authentication Successful";
        }
        return "Authentication Failed";
    }

    public void logout() {
        SecurityContextHolder.clearContext();
        saveContext();
    }

    private void saveContext() {
        if (RequestContextHolder.getRequestAttributes() != null) {
            var requestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            var responseAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            securityContextRepository.saveContext(SecurityContextHolder.getContext(), requestAttributes, responseAttributes);
        }
    }


}
