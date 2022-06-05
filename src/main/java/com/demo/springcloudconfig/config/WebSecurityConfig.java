package com.demo.springcloudconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Created by linhtn on 6/4/2022.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    @Order(0)
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .requestMatchers((matchers) -> matchers.antMatchers("/decrypt"))
                .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll())
                .requestCache().disable()
                .securityContext().disable()
                .sessionManagement().disable();

        return http.build();
    }
}
