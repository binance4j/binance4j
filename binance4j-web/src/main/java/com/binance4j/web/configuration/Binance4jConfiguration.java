package com.binance4j.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.binance4j.connectors.Connectors;
import com.binance4j.web.filter.AdminAuthenticationFilter;
import com.binance4j.web.filter.KeysAuthenticationFilter;
import com.binance4j.web.interceptor.AuthenticationInterceptor;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableWebSecurity
@Configuration
public class Binance4jConfiguration implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getAuthenticationInterceptor());
	}

	@Bean
	public AdminAuthenticationFilter getAdminAuthenticationFilter() {
		return new AdminAuthenticationFilter();
	}

	@Bean
	public KeysAuthenticationFilter getKeysAuthenticationFilter() {
		return new KeysAuthenticationFilter();
	}

	@Bean
	public Connectors getConnectors() {
		return new Connectors(null, null);
	}

	@Bean
	public AuthenticationInterceptor getAuthenticationInterceptor() {
		return new AuthenticationInterceptor();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		security.authorizeRequests().antMatchers("/api/v1/**").authenticated();
		security.httpBasic().disable().cors().and().csrf().disable();
		security.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		security.addFilterBefore(getAdminAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(getKeysAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		return security.build();
	}

	@Bean
	public Docket getSwaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build();
	}
}
