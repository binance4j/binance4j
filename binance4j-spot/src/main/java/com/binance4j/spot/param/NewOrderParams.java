package com.binance4j.spot.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@link SpotClient#newOrder} params.
 */
@Param(weight = 1, isOrder = true)
public class NewOrderParams implements Params {
	/** The order symbol */
	@Mandatory
	String symbol;
	/** The order side */
	@Mandatory
	OrderSide side;
	/** The order quantity */
	@Mandatory
	String quantity;
	/** The order price */
	String price;
	/** The stop price */
	String stopPrice;
	/** The order response type Default: RESULT. */
	NewOrderResponseType newOrderRespType;
	/** The order type */
	OrderType type;
	/** Le order lifetime */
	TimeInForce timeInForce;
	/** The quote order quantity */
	@JsonProperty("quoteOrderQty")
	String quoteOrderQuantity;
	/** The iceberg quantity */
	@JsonProperty("icebergQty")
	String icebergQuantity;
	/** The order unique id. Else is produced automatically. */
	String newClientOrderId;
	/** Stop Limit price. */
	String stopLimitPrice;

	/**
	 * Produces an order without a price
	 *
	 * @param symbol      the asset pair on which to place the order.
	 * @param type        the order type.
	 * @param side        order direction.
	 * @param quantity    the quantity of the order.
	 * @param timeInForce the lifetime of the order.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, String quantity, TimeInForce timeInForce) {
		this.type = type;
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.timeInForce = timeInForce;
	}

	/**
	 * Produces an order with a price
	 *
	 * @param symbol      the asset pair on which to place the order.
	 * @param type        the order type.
	 * @param side        the direction of the order.
	 * @param quantity    the quantity of the order.
	 * @param price       the order price.
	 * @param timeInForce the lifetime of the order.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, String quantity, String price, TimeInForce timeInForce) {
		this.type = type;
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.timeInForce = timeInForce;
		this.price = price;
	}

	/**
	 * Produces an order without price with time in force GTC by default
	 *
	 * @param symbol   the asset pair on which to place the order.
	 * @param type     the order type.
	 * @param side     the direction of the order.
	 * @param quantity the quantity of the order.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, String quantity) {
		this.type = type;
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
	}

	/**
	 * Produces an order with a default price and time in force GTC
	 *
	 * @param symbol   the asset pair on which to place the order.
	 * @param type     the order type.
	 * @param side     the direction of the order.
	 * @param quantity the quantity of the order.
	 * @param price    the order price.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, String quantity, String price) {
		this.type = type;
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.price = price;
	}

	// STATIQUE //

	/**
	 * Produces a MARKET buy order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyMarket(String symbol, String quantity, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, quantity, timeInForce);
	}

	/**
	 * Produces a MARKET buy order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyMarket(String symbol, String quantity) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, quantity);
	}

	/**
	 * Produces a MARKET order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellMarket(String symbol, String quantity, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, quantity, timeInForce);
	}

	/**
	 * Produces a MARKET order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellMarket(String symbol, String quantity) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, quantity);
	}

	/**
	 * Produces a LIMIT buy order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param price       The purchase price.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyLimit(String symbol, String quantity, String price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.BUY, quantity, price, timeInForce);
	}

	/**
	 * Produces a LIMIT buy order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @param price    The purchase price.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyLimit(String symbol, String quantity, String price) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.BUY, quantity, price);
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param price       The selling price.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellLimit(String symbol, String quantity, String price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.SELL, quantity, price, timeInForce);
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @param price    The purchase prices.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellLimit(String symbol, String quantity, String price) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.SELL, quantity, price);
	}

	// QUOTE ORDERS

	/**
	 * Produces a MARKET buy order with quote quantity
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyQuote(String symbol, String quantity, TimeInForce timeInForce) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, null, timeInForce);
		order.setQuoteOrderQuantity(quantity);
		return order;
	}

	/**
	 * Produces a MARKET buy order with quote quantity and default timeInForce
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyQuote(String symbol, String quantity) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, null);
		order.setQuoteOrderQuantity(quantity);
		return order;
	}

	/**
	 * Produces a MARKET order with quote quantity
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellQuote(String symbol, String quantity, TimeInForce timeInForce) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, null, timeInForce);
		order.setQuoteOrderQuantity(quantity);
		return order;
	}

	/**
	 * Produces a MARKET order with quote quantity and default timeInForce
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellQuote(String symbol, String quantity) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, null);
		order.setQuoteOrderQuantity(quantity);
		return order;
	}

	/**
	 * @return the stopLimitPrice
	 */
	public String getStopLimitPrice() {
		return stopLimitPrice;
	}

	/**
	 * @param stopLimitPrice the stopLimitPrice to set
	 */
	public void setStopLimitPrice(String stopLimitPrice) {
		this.stopLimitPrice = stopLimitPrice;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the side
	 */
	public OrderSide getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(OrderSide side) {
		this.side = side;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the stopPrice
	 */
	public String getStopPrice() {
		return stopPrice;
	}

	/**
	 * @param stopPrice the stopPrice to set
	 */
	public void setStopPrice(String stopPrice) {
		this.stopPrice = stopPrice;
	}

	/**
	 * @return the newOrderRespType
	 */
	public NewOrderResponseType getNewOrderRespType() {
		return newOrderRespType;
	}

	/**
	 * @param newOrderRespType the newOrderRespType to set
	 */
	public void setNewOrderRespType(NewOrderResponseType newOrderRespType) {
		this.newOrderRespType = newOrderRespType;
	}

	/**
	 * @return the type
	 */
	public OrderType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(OrderType type) {
		this.type = type;
	}

	/**
	 * @return the timeInForce
	 */
	public TimeInForce getTimeInForce() {
		return timeInForce;
	}

	/**
	 * @param timeInForce the timeInForce to set
	 */
	public void setTimeInForce(TimeInForce timeInForce) {
		this.timeInForce = timeInForce;
	}

	/**
	 * @return the quoteOrderQuantity
	 */
	public String getQuoteOrderQuantity() {
		return quoteOrderQuantity;
	}

	/**
	 * @param quoteOrderQuantity the quoteOrderQuantity to set
	 */
	public void setQuoteOrderQuantity(String quoteOrderQuantity) {
		this.quoteOrderQuantity = quoteOrderQuantity;
	}

	/**
	 * @return the icebergQuantity
	 */
	public String getIcebergQuantity() {
		return icebergQuantity;
	}

	/**
	 * @param icebergQuantity the icebergQuantity to set
	 */
	public void setIcebergQuantity(String icebergQuantity) {
		this.icebergQuantity = icebergQuantity;
	}

	/**
	 * @return the newClientOrderId
	 */
	public String getNewClientOrderId() {
		return newClientOrderId;
	}

	/**
	 * @param newClientOrderId the newClientOrderId to set
	 */
	public void setNewClientOrderId(String newClientOrderId) {
		this.newClientOrderId = newClientOrderId;
	}

}