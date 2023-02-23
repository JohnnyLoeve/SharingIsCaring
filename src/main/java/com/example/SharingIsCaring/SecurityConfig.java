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
                .requestMatchers("/static/media/sicscript.js", "/HomePage", "/LoginPage", "/CreateUser", "/MealOptions", "/media/**", "/scripts/**", "/styles/**", "/h2", "/h2-console", "/h2/**").permitAll()
                .requestMatchers("/resources/**").permitAll()
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
