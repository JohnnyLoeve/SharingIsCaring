package com.example.SharingIsCaring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests().requestMatchers("/HomePage").anonymous()
                        .requestMatchers("/Account", "/HomePage","/", "/CreateAMeal", "/CreateUser", "/ContactForm", "/LoginPage", "/MealOptions", "/media/**", "/scripts/**", "/styles/**").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated()

                .and()

                .formLogin()
                .loginPage("/LoginPage").defaultSuccessUrl("/HomePage", true)
                .permitAll();

                return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("Lisa").password("123").roles("ADMIN").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("Sion").password("123").roles("ADMIN").build());
        return manager;
    }
}
