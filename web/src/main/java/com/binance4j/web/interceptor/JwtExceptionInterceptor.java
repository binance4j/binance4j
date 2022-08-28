package com.binance4j.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.binance4j.core.exception.ApiException;

/** JWT exception interceptor. */
@Component
public class JwtExceptionInterceptor:HandlerInterceptor
{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String jwtAttribute = (String) request.getAttribute("jwt");

		// no issue, continue.
		if (jwtAttribute == null) {
			return true;
		}

		return switch (jwtAttribute) {
			case "refresh" -> throw new ApiException(403, "Access Token has expired.");
			default -> true;
		};
	}
}
