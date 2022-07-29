package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#getOCO} params.
 * 
 * @param orderListId       Either {@code orderListId} or {@code origClientOrderId} must be provided.
 * @param origClientOrderId Either {@code orderListId} or {@code origClientOrderId} must be provided.
 */
@Param(weight = 2)
public record OCOInfoParams(Long orderListId, String origClientOrderId) implements Params {
	/**
	 * Creates an instance of {@link OCOInfoParams}.
	 * 
	 * @param orderListId Either {@code orderListId} or {@code origClientOrderId} must be provided.
	 */
	public OCOInfoParams(Long orderListId) {
		this(orderListId, null);
	}

	/**
	 * Creates an instance of {@link OCOInfoParams}.
	 * 
	 * @param origClientOrderId Either {@code orderListId} or {@code origClientOrderId} must be provided.
	 */
	public OCOInfoParams(String origClientOrderId) {
		this(null, origClientOrderId);
	}
}
