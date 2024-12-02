package com.codimy.socle.common.config;


import java.util.ArrayList;
import java.util.List;

import com.codimy.socle.common.props.SecurityProperties;
import com.codimy.socle.common.props.SwaggerProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
@AllArgsConstructor
public class SecurityConfiguration {

    private final SwaggerProperties swaggerProperties;
    private final SecurityProperties securityProperties;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        auth ->
                                auth.requestMatchers(getAuthorizedUrls()).permitAll().anyRequest().authenticated())
                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }

    private String[] getAuthorizedUrls() {
        List<String> authorizedUrls = new ArrayList<>();
        authorizedUrls.addAll(securityProperties.getAuthorizedUrls());
        authorizedUrls.addAll(swaggerProperties.getUrls());
        return authorizedUrls.toArray(new String[0]);
    }
}