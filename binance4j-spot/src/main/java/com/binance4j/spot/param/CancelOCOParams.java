package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#cancelOCO} params.
 * 
 * @param symbol            Symbol to cancel the order.
 * @param orderListId       Either {@code orderListId} or {@code listClientOrderId} must be provided.
 * @param listClientOrderId Either {@code orderListId} or {@code listClientOrderId} must be provided.
 * @param newClientOrderId  Used to uniquely identify this cancel. Automatically generated by default
 */
@Param
public record CancelOCOParams(String symbol, Long orderListId, String listClientOrderId, String newClientOrderId) implements Params {
	/**
	 * Creates an instance of {@link CancelOCOParams}.
	 * 
	 * @param symbol Symbol to cancel the order.
	 */
	public CancelOCOParams(String symbol) {
		this(symbol, null, null, null);
	}

	/**
	 * Creates an instance of {@link CancelOCOParams}.
	 * 
	 * @param symbol            Symbol to cancel the order.
	 * @param listClientOrderId Either {@code orderListId} or {@code listClientOrderId} must be provided.
	 * @param newClientOrderId  Used to uniquely identify this cancel. Automatically generated by default
	 */
	public CancelOCOParams(String symbol, String listClientOrderId, String newClientOrderId) {
		this(symbol, null, listClientOrderId, newClientOrderId);
	}

	/**
	 * Creates an instance of {@link CancelOCOParams}.
	 * 
	 * @param symbol            Symbol to cancel the order.
	 * @param listClientOrderId Either {@code orderListId} or {@code listClientOrderId} must be provided.
	 */
	public CancelOCOParams(String symbol, String listClientOrderId) {
		this(symbol, null, listClientOrderId, null);
	}

	/**
	 * Creates an instance of {@link CancelOCOParams}.
	 * 
	 * @param symbol      Symbol to cancel the order.
	 * @param orderListId Order list id.
	 */
	public CancelOCOParams(String symbol, Long orderListId) {
		this(symbol, orderListId, null, null);
	}

	/**
	 * Creates an instance of {@link CancelOCOParams}.
	 * 
	 * @param symbol           Symbol to cancel the order.
	 * @param orderListId      Order list id.
	 * @param newClientOrderId Used to uniquely identify this cancel. Automatically generated by default
	 */
	public CancelOCOParams(String symbol, Long orderListId, String newClientOrderId) {
		this(symbol, orderListId, null, newClientOrderId);
	}
}