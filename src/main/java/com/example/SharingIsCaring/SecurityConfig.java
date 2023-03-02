package com.example.SharingIsCaring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
                //Permits resources
                .requestMatchers("/static/scripts/sicscript.js", "/media/**", "/scripts/**", "/styles/**", "/resources/**", "static/styles/style.css", "static/styles/login.css").permitAll()
                //permits sites for visitors without login
                .requestMatchers("/ContactForm","/HomePage", "/LoginPage", "/CreateUser", "/MealOptions", "/MealDetails/**").permitAll()
                //permits the h2 database
                .requestMatchers("/h2", "/h2-console", "/h2/**").permitAll()
                //the rest is only permitted while logged in as ADMIN
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/LoginPage").defaultSuccessUrl("/HomePage", true)
                .permitAll()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable();


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
