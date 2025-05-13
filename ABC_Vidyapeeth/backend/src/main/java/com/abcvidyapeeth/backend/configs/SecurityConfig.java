package com.abcvidyapeeth.backend.configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired UserDetailsService userDetailsService;
		
	@Autowired JwtFilter jwtFilter;	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.cors(Customizer.withDefaults()) // Apply CORS configuration
	        .csrf(customizer -> customizer.disable())
	        .httpBasic(Customizer.withDefaults())
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/user/registerUser", "/user/login", "/util/announcements", "/registration/saveNewAdmissionReg").permitAll() // Corrected paths
	            .anyRequest().authenticated())
	        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	    return http.build();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(List.of("http://localhost:3000")); // Allow React frontend
	    configuration.setAllowedMethods(List.of("GET", "POST"));
	    configuration.setAllowedHeaders(List.of("*")); // Allow all headers
	    configuration.setAllowCredentials(true); // Allow cookies or credentials

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
}
