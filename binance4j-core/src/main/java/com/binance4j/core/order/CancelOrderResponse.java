package com.binance4j.core.order;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The CancelOrder request result */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelOrderResponse {
	/**
	 * The order status
	 */
	private OrderStatus status;
	/**
	 * The order side
	 */
	private OrderSide side;
	/**
	 * The order type
	 */
	private OrderType type;
	/**
	 * The order timeInForce
	 */
	private TimeInForce timeInForce;
	/**
	 * The order id
	 */
	private Long orderId;
	/**
	 * The order list
	 */
	private Long orderListId;
	/**
	 * The order symbol
	 */
	private String symbol;
	/**
	 * The original client order id
	 */
	private String origClientOrderId;
	/**
	 * The client order id
	 */
	private String clientOrderId;
	/**
	 * The order executed quantity
	 */
	private String executedQty;
	/**
	 * The order price
	 */
	private BigDecimal price;
	/**
	 * The order original quantity
	 */
	private BigDecimal origQty;
	/**
	 * The order cumulative quote quantity
	 */
	private BigDecimal cummulativeQuoteQty;
	/**
	 * Is the order margin isolated
	 */
	private Boolean isIsolated;
}