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
                .antMatchers("/change_data/**", "/make-appointment", "/historicoPagamentos").hasRole("PATIENT")
                .antMatchers("/patient-inicio").hasRole("PATIENT")
                .antMatchers("/change_data/**").hasRole("PATIENT")
                .antMatchers("/change_data/**").hasRole("PATIENT")
                .antMatchers("/admin/**").hasRole("EMPLOYEE")
                .antMatchers("/admin/**", "/add-speciality", "/add-patient", "/faturaForm", "/historicoPagamentos", "/lista-utentes").hasRole("RECEPTIONIST")
                .antMatchers("/doctor-consultas", "/lista-medicos").hasRole("RECEPTIONIST")
                .antMatchers("/doctor-inicio", "/lista-utentes", "/doctor-consultas", "/info-appointment").hasRole("DOCTOR")
                .antMatchers("/admin/**").hasRole("UNIT_RESPONSIBLE")
                .antMatchers("/user**", "/main", "/userToMain").hasAnyRole("PATIENT", "EMPLOYEE", "RECEPTIONIST", "DOCTOR", "UNIT_RESPONSIBLE")
                .antMatchers("/login*", "/", "/recoverPass", "/recoverToLogin", "/registration").permitAll()
                .antMatchers("/registrationToLogin", "/temp", "/test").permitAll()
                .antMatchers("/*.css", "/fonts/**", "/imagens/**", "*.html" , "*.ico").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/main", true)
                .failureUrl("/login.html?error=true")
                .failureHandler(new AuthenticationEntryPointFailureHandler(new BasicAuthenticationEntryPoint()))
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
        // ...
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
