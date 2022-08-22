package com.binance4j.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.binance4j.core.exception.ApiException;

/** JWT issues interceptor. */
@Component
public class JwtInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String jwtAttribute = (String) request.getAttribute("jwt");

		return switch (jwtAttribute) {
			case "refresh" -> throw new ApiException(403, "Access Token has expired.");
			default -> true;
		};
	}
}
