package com.binance4j.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.binance4j.connectors.Connectors;

public abstract class BaseController {
	@Autowired
	Connectors connectors;
}
