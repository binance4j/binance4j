package com.binance4j.websocket.userdata;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Order or trade report update event.
 * <p>
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdatePayload
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTradeUpdatePayload {
	/**
	 * The event type
	 */
	@JsonProperty("e")
	private String eventType;
	/**
	 * The timestamp
	 */
	@JsonProperty("E")
	private Long eventTime;
	/**
	 * The trading pair
	 */
	@JsonProperty("s")
	private String symbol;
	/**
	 * Client order id
	 */
	@JsonProperty("c")
	private String newClientOrderId;
	/**
	 * Buy/Sell order side.
	 */
	@JsonProperty("S")
	private OrderSide side;
	/**
	 * Type of order.
	 */
	@JsonProperty("o")
	private OrderType type;
	/**
	 * Time in force to indicate how Long will the order remain active.
	 */
	@JsonProperty("f")
	private TimeInForce timeInForce;
	/**
	 * Original quantity in the order.
	 */
	@JsonProperty("q")
	private BigDecimal originalQuantity;
	/**
	 * Price.
	 */
	@JsonProperty("p")
	private BigDecimal price;
	/**
	 * Type of execution.
	 */
	@JsonProperty("x")
	private ExecutionType executionType;
	/**
	 * Status of the order.
	 */
	@JsonProperty("X")
	private OrderStatus orderStatus;
	/**
	 * Reason why the order was rejected.
	 */
	@JsonProperty("r")
	private OrderRejectReason orderRejectReason;
	/**
	 * Order id.
	 */
	@JsonProperty("i")
	private Long orderId;
	/**
	 * Quantity of the last filled trade.
	 */
	@JsonProperty("l")
	private BigDecimal quantityLastFilledTrade;
	/**
	 * Accumulated quantity of filled trades on this order.
	 */
	@JsonProperty("z")
	private BigDecimal accumulatedQuantity;
	/**
	 * Price of last filled trade.
	 */
	@JsonProperty("L")
	private BigDecimal priceOfLastFilledTrade;
	/**
	 * Commission.
	 */
	@JsonProperty("n")
	private BigDecimal commission;
	/**
	 * Asset on which commission is taken
	 */
	@JsonProperty("N")
	private String commissionAsset;
	/**
	 * Order/trade time.
	 */
	@JsonProperty("T")
	private Long orderTradeTime;
	/**
	 * Trade id.
	 */
	@JsonProperty("t")
	private Long tradeId;
	/**
	 * Order creation time.
	 */
	@JsonProperty("O")
	private Long orderCreationTime;
	/**
	 * Cumulative quote asset transacted quantity.
	 */
	@JsonProperty("Z")
	private BigDecimal cumulativeQuoteQty;
	/**
	 * Last quote asset transacted quantity (i.e. lastPrice * lastQty).
	 */
	@JsonProperty("Y")
	private BigDecimal lastQuoteQty;
	/**
	 * Quote Order Qty.
	 */
	@JsonProperty("Q")
	private BigDecimal quoteOrderQty;
}