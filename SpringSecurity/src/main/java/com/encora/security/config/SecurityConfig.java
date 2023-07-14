package com.encora.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

		UserDetails adminUser = User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("ADMIN").build();
		UserDetails applicationUser = User.withUsername("msd").password(passwordEncoder.encode("1234")).roles("APPUSER").build();
		UserDetails guestUser = User.withUsername("cr7").password(passwordEncoder.encode("1234")).roles("GUEST").build();
		UserDetails superUser = User.withUsername("dipesh").password(passwordEncoder.encode("abcd")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(adminUser, applicationUser, guestUser,superUser);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeHttpRequests().requestMatchers("/api/v1/welcome").permitAll().and()
				.authorizeHttpRequests().requestMatchers("/api/v1/**").authenticated().and().formLogin().and().build();
	}

}
