package com.example.simpleserverforfrontendplaygraound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleServerForFrontEndPlaygraoundApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleServerForFrontEndPlaygraoundApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
//            }
//        };
//    }

}
