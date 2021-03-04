package pt.iscte.hospital.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomAuthenticationProvider authProvider;


    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // authentication manager (see below)
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // http builder configurations for authorize requests and form login (see below)
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/patient/**").hasRole("PATIENT")
                .antMatchers("/employee/**").hasRole("EMPLOYEE")
                .antMatchers("/receptionist/**").hasRole("RECEPTIONIST")
                .antMatchers("/doctor/**").hasRole("DOCTOR")
                .antMatchers("/unitresponsible/**").hasRole("UNIT_RESPONSIBLE")
                .antMatchers("/user**", "/main", "/userToMain").hasAnyRole("PATIENT", "EMPLOYEE", "RECEPTIONIST", "DOCTOR", "UNIT_RESPONSIBLE")
                .antMatchers("/public/**").permitAll()
                .antMatchers("/*.css", "/fonts/**", "/imagens/**", "*.html" , "*.ico").permitAll()
                .antMatchers("/uploaded_images/**").hasAnyRole("PATIENT", "EMPLOYEE", "RECEPTIONIST", "DOCTOR", "UNIT_RESPONSIBLE")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/public/login")
                .loginProcessingUrl("/public/login")
                .defaultSuccessUrl("/main", true)
                .failureUrl("/login.html?error=true")
                .failureHandler(new AuthenticationEntryPointFailureHandler(new BasicAuthenticationEntryPoint()))
                .and()
                .logout()
                .logoutUrl("/home")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
        // ...
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}