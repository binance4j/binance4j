package com.binance4j.core.order;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Trade order information.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class OrderInfo extends MiniOrderInfo {
	/**
	 * The order side
	 */
	private OrderSide side;
	/**
	 * Price.
	 */
	private BigDecimal price;
	/**
	 * Original quantity.
	 */
	private BigDecimal origQty;
	/**
	 * Original quantity.
	 */
	private BigDecimal executedQty;
	/**
	 * Used to calculate the average price
	 */
	private BigDecimal cummulativeQuoteQty;
	/**
	 * Order status.
	 */
	private OrderStatus status;
	/**
	 * Time in force to indicate how Long will the order remain active.
	 */
	private TimeInForce timeInForce;
	/**
	 * Type of order.
	 */
	private OrderType type;
	/**
	 * Used with stop orders.
	 */
	private BigDecimal stopPrice;
	/**
	 * Used with iceberg orders.
	 */
	private BigDecimal icebergQty;
	/**
	 * Order timestamp
	 */
	private Long time;

	/**
	 * Update timestamp.
	 */
	private Long updateTime;
	/**
	 * ???
	 */
	private Boolean isWorking;
	/**
	 * Original quote order quantity.
	 */
	private BigDecimal origQuoteOrderQty;
	/**
	 * is isolated margin
	 */
	private Boolean isIsolated;
}
