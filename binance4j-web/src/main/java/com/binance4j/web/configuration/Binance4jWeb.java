package com.binance4j.web.configuration;

import org.springframework.beans.factory.annotation.Value;
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
import com.binance4j.web.dto.AdminDetails;
import com.binance4j.web.filter.JwtAuthenticationFilter;
import com.binance4j.web.filter.KeysAuthenticationFilter;
import com.binance4j.web.interceptor.JwtExceptionInterceptor;
import com.binance4j.web.interceptor.ResetBinanceKeysInterceptor;
import com.binance4j.web.service.AdminDetailsService;
import com.binance4j.web.service.AuthenticationService;
import com.binance4j.web.service.BaseUserDetailsService;
import com.binance4j.web.service.DummyUserDetailsService;
import com.binance4j.web.service.JwtService;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/** Binance4j proxy configuration. */
@EnableWebSecurity
@Configuration
public class Binance4jWeb implements WebMvcConfigurer {
	/** Connector controllers base URI. */
	public final static String CONNECTORS_BASE_URI = "/api/v1/connectors/";
	/** Admin username. */
	@Value("${binance4j.admin.username}")
	String adminUsername;
	/** Admin password. */
	@Value("${binance4j.admin.password}")
	String adminPassword;
	/** Admin key. */
	@Value("${binance4j.admin.key}")
	String adminKey;
	/** Admin secret. */
	@Value("${binance4j.admin.secret}")
	String adminSecret;
	/** Registered user authentication service. */
	BaseUserDetailsService userDetailsService;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getAuthenticationInterceptor());
		registry.addInterceptor(getJwtInterceptor());
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		// routes restriction
		security.authorizeRequests().antMatchers(CONNECTORS_BASE_URI + "**").authenticated();
		security.httpBasic().disable().cors().and().csrf().disable();

		// enable stateless server
		security.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// authentication filters

		security
				.addFilterBefore(getAdminAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(getUserAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(getKeysAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		// build
		return security.build();
	}

	@Bean
	public JwtAuthenticationFilter getAdminAuthenticationFilter() {
		return new JwtAuthenticationFilter(getAdminDetailsService(),
				getJwtService(), getConnectors());
	}

	@Bean
	public JwtAuthenticationFilter getUserAuthenticationFilter() {
		return new JwtAuthenticationFilter(new DummyUserDetailsService(), getJwtService(), getConnectors());
	}

	/**
	 * @return Registered user authentication service.
	 */
	@Bean
	public BaseUserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	/**
	 * @param userDetailsService the userDetailsService to set
	 */
	public void setUserDetailsService(BaseUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
		getUserAuthenticationFilter().setUserDetailsService(userDetailsService);
	}

	@Bean
	public JwtService getJwtService() {
		return new JwtService();
	}

	@Bean
	public AuthenticationService getAuthenticationService() {
		return new AuthenticationService(getConnectors());
	}

	@Bean
	public AdminDetails getAdminDetails() {
		return new AdminDetails(adminUsername, adminPassword, adminKey, adminSecret);
	}

	@Bean
	public AdminDetailsService getAdminDetailsService() {
		return new AdminDetailsService(getAdminDetails());
	}

	@Bean
	public KeysAuthenticationFilter getKeysAuthenticationFilter() {
		return new KeysAuthenticationFilter(getAuthenticationService());
	}

	@Bean
	public Connectors getConnectors() {
		return new Connectors(null, null);
	}

	@Bean
	public ResetBinanceKeysInterceptor getAuthenticationInterceptor() {
		return new ResetBinanceKeysInterceptor(getConnectors());
	}

	@Bean
	public JwtExceptionInterceptor getJwtInterceptor() {
		return new JwtExceptionInterceptor();
	}

	@Bean
	public Docket getSwaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build();
	}
}
