package com.strongkittens.nirstorage.config;

import com.strongkittens.nirstorage.config.BCrypt.BCryptPasswordEncoder;
import com.strongkittens.nirstorage.auth.filter.SessionExistFilter;
import com.strongkittens.nirstorage.auth.services.RedisSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final RedisSessionService redisSessionService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SessionExistFilter sessionExistFilter() {
        return new SessionExistFilter(redisSessionService);
    }

    @Bean
    public FilterRegistrationBean<SessionExistFilter> sessionExistFilterRegistration() {
        FilterRegistrationBean<SessionExistFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(sessionExistFilter());
        // описано в фильтрах

        registrationBean.addUrlPatterns("/auth/logout", "/student/*", "/teacher/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }


}