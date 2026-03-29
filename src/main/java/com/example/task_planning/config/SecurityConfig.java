package com.example.task_planning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // ✅ Disable CSRF (important for Postman)
            .csrf(csrf -> csrf.disable())

            // ✅ Disable default login form (important)
            .formLogin(form -> form.disable())

            // ✅ Disable HTTP Basic (optional but cleaner)
            .httpBasic(Customizer.withDefaults())

            // ✅ Authorization rules
            .authorizeHttpRequests(auth -> auth
                // Allow ALL auth endpoints
                .requestMatchers("/api/auth/**").permitAll()

                // Allow POST login/register explicitly (extra safety)
                .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()

                // Your public APIs
                .requestMatchers("/api/users/**").permitAll()
                .requestMatchers("/api/teams/**").permitAll()
                .requestMatchers("/api/tasks/**").permitAll()
                .requestMatchers("/api/subtasks/**").permitAll()

                // Everything else secured
                .anyRequest().authenticated()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}