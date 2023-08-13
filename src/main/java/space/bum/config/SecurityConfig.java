package space.bum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;
import space.bum.config.security.filters.CustomAuthFilter;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

	private final CustomAuthFilter customAuthFilter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.addFilterAt(customAuthFilter,
				UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().anyRequest().authenticated() // learn later
				.and()
				.build();
	}
}
