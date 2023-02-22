package com.example.SharingIsCaring;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserRepo userRepo;


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

//        @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> userRepo.getNewUserByUsername(username)
//                .map(user -> User.builder()
//                        .username(user.getUsername())
//                        .password(user.getPassword())
//                        .roles(user.getRole())
//                        .build())
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/HomePage", "/LoginPage", "/CreateUser", "/MealOptions", "/media/**", "/scripts/**", "/styles/**", "/h2", "/h2-console", "/h2/**").permitAll()

                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/LoginPage").defaultSuccessUrl("/HomePage", true)
                .permitAll()
                .and()
                .headers()
                .frameOptions().sameOrigin() // allow H2 console to be embedded in an iframe
                .httpStrictTransportSecurity().disable(); // disable HSTS to allow access over plain HTTP

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("Lisa").password("123").roles("USER", "ADMIN").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("Sion").password("123").roles("USER", "ADMIN").build());
        return manager;
    }
}
