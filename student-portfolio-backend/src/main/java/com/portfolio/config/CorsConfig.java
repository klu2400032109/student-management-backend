package com.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // ✅ Allow your deployed frontend
        config.addAllowedOrigin("https://student-management-frontend-orpin.vercel.app");

        // ✅ (Optional) allow local frontend also
        config.addAllowedOrigin("http://localhost:5173");

        // ✅ Allow all headers and methods
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        // ⚠️ Important for your setup
        config.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
