package pt.iscte.hospital.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pt.iscte.hospital.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (userService.validateUser(username, password)) {   // TODO userservice

            // use the credentials
            // and authenticate against the third-party system

            // TODO lista de roles
            List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

            roles.add(new SimpleGrantedAuthority("ROLE_PATIENT"));

            return new UsernamePasswordAuthenticationToken(
                    username, password, roles);//SimpleGrantedAuthority "ROLE_"
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
