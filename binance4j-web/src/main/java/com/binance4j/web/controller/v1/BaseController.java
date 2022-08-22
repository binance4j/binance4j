package com.binance4j.web.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import com.binance4j.connectors.Connectors;

@PreAuthorize("isAuthenticated()")
public abstract class BaseController {
	final static protected String ALGO_DESCRIPTION = "The algorithm.";
	final static protected String COIN_DESCRIPTION = "The coin.";
	final static protected String ASSET_DESCRIPTION = "The asset.";
	final static protected String CONFIG_ID_DESCRIPTION = "The config id.";
	final static protected String SYMBOL_DESCRIPTION = "The traiding pair.";
	final static protected String SYMBOLS_DESCRIPTION = "The traiding pairs.";
	final static protected String SIDE_DESCRIPTION = "The order side.";
	final static protected String QUANTITY_DESCRIPTION = "The quantity.";
	final static protected String PRICE_DESCRIPTION = "The order price.";
	final static protected String TIF_DESCRIPTION = "The order Time in Force.";
	final static protected String ICEBERG_DESCRIPTION = "The order iceberg quantity.";
	final static protected String DELTA_DESCRIPTION = "The order trailing delta.";
	final static protected String STOP_PRICE_DESCRIPTION = "The order stop price.";
	final static protected String START_TIME_DESCRIPTION = "Start time in ms.";
	final static protected String END_TIME_DESCRIPTION = "End time in ms.";
	final static protected String TOKEN_DESCRIPTION = "The token name.";
	final static protected String PAGE_DESCRIPTION = "The result page.";
	final static protected String LIMIT_DESCRIPTION = "The result limit.";
	final static protected String USERNAME_DESCRIPTION = "The username.";
	final static protected String WORKER_DESCRIPTION = "The worker name.";

	final static protected String DEFAULT_TIF = "GTC";

	@Autowired
	Connectors connectors;
}
