package com.eazybytes.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // Lambda DSL
        // https://docs.spring.io/spring-security/reference/migration-7/configuration.html
        // Permit all requests inside the Web Application
        http.authorizeHttpRequests(authorize -> {
            authorize.requestMatchers("/","/home").permitAll();
            authorize.requestMatchers("/holidays/**").permitAll();
            authorize.requestMatchers("/contact").permitAll();
            authorize.requestMatchers("/saveMsg").permitAll();
            authorize.requestMatchers("/courses").permitAll();
            authorize.requestMatchers("/about").permitAll();
            authorize.requestMatchers("/assets/**").permitAll();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
