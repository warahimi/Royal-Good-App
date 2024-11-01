package com.royalgoodsusa.Royal.Goods.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//        //config.addAllowedOrigin("http://localhost:5173"); // Allow your React app’s origin
//        config.addAllowedOriginPattern("*"); // Allows requests from all origins
//        config.addAllowedMethod("*"); // Allow all HTTP methods (GET, POST, etc.)
//        config.addAllowedHeader("*"); // Allow all headers
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config); // Apply this CORS configuration to all endpoints
//
//        return new CorsFilter(source);
//    }
//    @Bean
//    public WebMvcConfigurer configurer(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("*")
//                        .allowedOrigins("http://localhost:3000");
//            }
//        };
//    }
@Bean
public WebMvcConfigurer configurer() {
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/**")
//                    .allowedMethods("GET", "POST", "PUT", "DELETE")
//                    .allowedOrigins("http://localhost:3000")
//                    .allowedHeaders("*");
            registry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedOriginPatterns("*")
                    .allowedHeaders("*");
        }
    };
}
}