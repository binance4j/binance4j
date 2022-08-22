package com.binance4j.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.binance4j.connectors.Connectors;

/** Authentication interceptor */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

	@Autowired
	Connectors connectors;

	// Destroying API keys after response.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		connectors.rest().updateKeys(null, null);
	}
}
