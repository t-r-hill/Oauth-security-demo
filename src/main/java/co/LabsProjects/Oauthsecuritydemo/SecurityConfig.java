package co.LabsProjects.Oauthsecuritydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/protected").authenticated()
                .anyRequest().permitAll()
                .and()
                .oauth2Login(login -> login.loginPage("/login").defaultSuccessUrl("/"))
                .sessionManagement(session -> session.maximumSessions((1))
                );

        return http.build();
    }
}
