package com.redmath.news.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableMethodSecurity
@Configuration
public class WebSecurityConfiguration {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/api/v1/news", "GET"))
                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/api/v1/news/**"))
                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/actuator"))
                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/actuator/**"));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(Customizer.withDefaults());
        http.authorizeHttpRequests(config -> config.anyRequest().authenticated());
        return http.build();
    }
}
