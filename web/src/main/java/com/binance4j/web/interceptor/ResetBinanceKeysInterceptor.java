package com.binance4j.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.binance4j.connectors.Connectors;

/** Resets keys after response is sent for privacy. */
@Component
public class ResetBinanceKeysInterceptor:HandlerInterceptor
{
	/** Binance4j connectors. */
	Connectors connectors;

	/**
	 * Creates instances.
	 * 
	 * @param connectors Binance4j connectors.
	 */
	public ResetBinanceKeysInterceptor(Connectors connectors) {
		this.connectors = connectors;
	}

	// Destroying API keys after response.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		connectors.rest().updateKeys(null, null);
	}
}
