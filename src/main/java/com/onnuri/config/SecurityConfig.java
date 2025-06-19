package com.onnuri.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.onnuri.service.UserService;

@Configuration
public class SecurityConfig {

	@Autowired
	private UserService userService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests()
	                .requestMatchers("/user/login", "/loginProcess", "/user/signUpForm", "/user/signUpProcess"
	                		).permitAll()
	                .anyRequest().authenticated()
	            .and()
	            .formLogin()
	                .loginPage("/user/login")
	                .loginProcessingUrl("/loginProcess")
	                .defaultSuccessUrl("/Main", true)
	                .failureUrl("/user/login?error=true")
	                .permitAll()
	            .and()
	            .logout()
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/user/login")
	                .invalidateHttpSession(true)
	                .permitAll();

	        return http.build();
	    }
}
