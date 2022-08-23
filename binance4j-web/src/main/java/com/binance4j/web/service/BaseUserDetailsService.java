package com.binance4j.web.service;

import org.springframework.stereotype.Service;

/**
 * Service to authenticate the admin user registered in application.properties.
 */
@Service
public interface BaseUserDetailsService extends Binance4jUserDetailsService {
}
