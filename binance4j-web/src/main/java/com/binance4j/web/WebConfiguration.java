package com.binance4j.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.binance4j.connectors.Connectors;
import com.binance4j.web.filter.InMemoryUserJwtRequestFilter;
import com.binance4j.web.interceptor.AuthenticationInterceptor;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableWebSecurity
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	@Autowired
	InMemoryUserJwtRequestFilter jwtRequestFilter;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getAuthenticationInterceptor());
	}

	@Bean
	public Connectors getConnectors() {
		return new Connectors("", "");
	}

	@Bean
	AuthenticationInterceptor getAuthenticationInterceptor() {
		return new AuthenticationInterceptor();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		security.authorizeRequests().antMatchers("/api/**").authenticated();
		security.httpBasic().disable().cors().and().csrf().disable();

		security.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		security.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return security.build();
	}

	/**
	 * Le protocole d'encryptage des mots de passe de l'application
	 *
	 * @return l'instance de cryptage de l'application
	 */
	@Bean
	public static BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public Docket getSwaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build();
	}
}
