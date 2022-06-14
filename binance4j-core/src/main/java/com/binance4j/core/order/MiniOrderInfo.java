package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Trade order information.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniOrderInfo {
	/**
	 * The order symbol
	 */
	private String symbol;

	/**
	 * Order id.
	 */
	private Long orderId;
	/**
	 * Client order id.
	 */
	private String clientOrderId;
}
