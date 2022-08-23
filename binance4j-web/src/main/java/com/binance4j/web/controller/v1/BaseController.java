package com.binance4j.web.controller.v1;

import org.springframework.security.access.prepost.PreAuthorize;

import com.binance4j.connectors.Connectors;

/** Service base controller. */
@PreAuthorize("isAuthenticated()")
public abstract class BaseController {
	/** ALGO_DESCRIPTION */
	final static protected String ALGO_DESCRIPTION = "The algorithm.";
	/** COIN_DESCRIPTION */
	final static protected String COIN_DESCRIPTION = "The coin.";
	/** ASSET_DESCRIPTION */
	final static protected String ASSET_DESCRIPTION = "The asset.";
	/** CONFIG_ID_DESCRIPTION */
	final static protected String CONFIG_ID_DESCRIPTION = "The config id.";
	/** SYMBOL_DESCRIPTION */
	final static protected String SYMBOL_DESCRIPTION = "The traiding pair.";
	/** SYMBOLS_DESCRIPTION */
	final static protected String SYMBOLS_DESCRIPTION = "The traiding pairs.";
	/** SIDE_DESCRIPTION */
	final static protected String SIDE_DESCRIPTION = "The order side.";
	/** QUANTITY_DESCRIPTION */
	final static protected String QUANTITY_DESCRIPTION = "The quantity.";
	/** PRICE_DESCRIPTION */
	final static protected String PRICE_DESCRIPTION = "The order price.";
	/** TIF_DESCRIPTION */
	final static protected String TIF_DESCRIPTION = "The order Time in Force.";
	/** ICEBERG_DESCRIPTION */
	final static protected String ICEBERG_DESCRIPTION = "The order iceberg quantity.";
	/** DELTA_DESCRIPTION */
	final static protected String DELTA_DESCRIPTION = "The order trailing delta.";
	/** STOP_PRICE_DESCRIPTION */
	final static protected String STOP_PRICE_DESCRIPTION = "The order stop price.";
	/** START_TIME_DESCRIPTION */
	final static protected String START_TIME_DESCRIPTION = "Start time in ms.";
	/** END_TIME_DESCRIPTION */
	final static protected String END_TIME_DESCRIPTION = "End time in ms.";
	/** TOKEN_DESCRIPTION */
	final static protected String TOKEN_DESCRIPTION = "The token name.";
	/** PAGE_DESCRIPTION */
	final static protected String PAGE_DESCRIPTION = "The result page.";
	/** LIMIT_DESCRIPTION */
	final static protected String LIMIT_DESCRIPTION = "The result limit.";
	/** USERNAME_DESCRIPTION */
	final static protected String USERNAME_DESCRIPTION = "The username.";
	/** WORKER_DESCRIPTION */
	final static protected String WORKER_DESCRIPTION = "The worker name.";
	/** Default time in force. */
	final static protected String DEFAULT_TIF = "GTC";

	Connectors connectors;

	/**
	 * Creates instance.
	 * 
	 * @param connectors Binance4j connectors.
	 */
	protected BaseController(Connectors connectors) {
		this.connectors = connectors;
	}
}