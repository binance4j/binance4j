package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.SideEffectType;
import com.fasterxml.jackson.annotation.JsonProperty;

/** {@link MarginClient#newOrder} params. */
@Param(weight = 6, isOrder = true)
public class NewOrderParams implements Params {
	/** The default order time in force. */
	TimeInForce timeInForce = TimeInForce.GTC;
	/** The order symbol */
	String symbol;
	/** The order type */
	OrderType type;
	/** The order side */
	OrderSide side;
	/** The order quantity */
	String quantity;
	/** The order price */
	String price;
	/** The stop price */
	String stopPrice;
	/** The order response type Default: RESULT. */
	NewOrderResponseType newOrderRespType;
	/** The quote order quantity */
	@JsonProperty("quoteOrderQty")
	String quoteOrderQuantity;
	/** The iceberg quantity */
	@JsonProperty("icebergQty")
	String icebergQuantity;
	/** The order unique id. Else is produced automatically. */
	String newClientOrderId;
	/** Set The margin order side-effect. NO_SIDE_EFFECT, MARGIN_BUY, AUTO_REPAY; default: NO_SIDE_EFFECT. */
	SideEffectType sideEffectType;

	/**
	 * Produces an order without a price
	 *
	 * @param symbol      Asset pair on which to place the order.
	 * @param type        Order type.
	 * @param side        order direction.
	 * @param quantity    Quantity of the order.
	 * @param timeInForce Lifetime of the order.
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
	 * @param symbol      Asset pair on which to place the order.
	 * @param type        Order type.
	 * @param side        Direction of the order.
	 * @param quantity    Quantity of the order.
	 * @param price       Order price.
	 * @param timeInForce Lifetime of the order.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, String quantity, String price, TimeInForce timeInForce) {
		this(symbol, type, side, quantity, timeInForce);
		this.price = price;
	}

	/**
	 * Produces an order without price with time in force GTC by default
	 *
	 * @param symbol   Asset pair on which to place the order.
	 * @param type     Order type.
	 * @param side     Direction of the order.
	 * @param quantity Quantity of the order.
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
	 * @param symbol   Asset pair on which to place the order.
	 * @param type     Order type.
	 * @param side     Direction of the order.
	 * @param quantity Quantity of the order.
	 * @param price    Order price.
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
	 * Produces a buy market order
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Quantity.
	 * @param timeInForce TimeInforce.
	 * @return The generated {@link NewOrderParams}.
	 */
	public static NewOrderParams buy(String symbol, String quantity, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, quantity, timeInForce);
	}

	/**
	 * Produces a buy market order
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @return The generated {@link NewOrderParams}.
	 */
	public static NewOrderParams buy(String symbol, String quantity) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, quantity);
	}

	/**
	 * Produces a sell market order
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Quantity.
	 * @param timeInForce TimeInforce.
	 * @return The generated {@link NewOrderParams}.
	 */
	public static NewOrderParams sell(String symbol, String quantity, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, quantity, timeInForce);
	}

	/**
	 * Produces a sell market order
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @return The generated {@link NewOrderParams}.
	 */
	public static NewOrderParams sell(String symbol, String quantity) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, quantity, TimeInForce.GTC);
	}

	/**
	 * Produces a buy limit order
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Quantity.
	 * @param price       Price.
	 * @param timeInForce TimeInforce.
	 * @return The generated {@link NewOrderParams}.
	 */
	public static NewOrderParams buy(String symbol, String quantity, String price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.BUY, quantity, price, timeInForce);
	}

	/**
	 * Produces a buy limit order
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @param price    Price.
	 * @return The generated {@link NewOrderParams}.
	 */
	public static NewOrderParams buy(String symbol, String quantity, String price) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.BUY, quantity, price, TimeInForce.GTC);
	}

	/**
	 * Produces a sell limit order
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Quantity.
	 * @param price       Price.
	 * @param timeInForce TimeInforce.
	 * @return The generated {@link NewOrderParams}.
	 */
	public static NewOrderParams sell(String symbol, String quantity, String price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.SELL, quantity, price, timeInForce);
	}

	/**
	 * Produces a sell limit order
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @param price    Price.
	 * @return The generated {@link NewOrderParams}.
	 */
	public static NewOrderParams sell(String symbol, String quantity, String price) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.SELL, quantity, price, TimeInForce.GTC);
	}

	/**
	 * Produces a MARKET order with quote quantity
	 *
	 * @param symbol      Asset pair.
	 * @param quantity    Quantity.
	 * @param timeInForce Lifetime of the order.
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
	 * @param symbol   Asset pair.
	 * @param quantity Quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellQuote(String symbol, String quantity) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, null, TimeInForce.GTC);
		order.setQuoteOrderQuantity(quantity);
		return order;
	}

	/** @return The sideEffectType */
	public SideEffectType getSideEffectType() {
		return sideEffectType;
	}

	/** @param sideEffectType SideEffectType to set */
	public void setSideEffectType(SideEffectType sideEffectType) {
		this.sideEffectType = sideEffectType;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol Symbol to set
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
	 * @param side Side to set
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
	 * @param quantity Quantity to set
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
	 * @param price Price to set
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
	 * @param stopPrice StopPrice to set
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
	 * @param newOrderRespType NewOrderRespType to set
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
	 * @param type Type to set
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
	 * @param timeInForce TimeInForce to set
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
	 * @param quoteOrderQuantity QuoteOrderQuantity to set
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
	 * @param icebergQuantity IcebergQuantity to set
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
	 * @param newClientOrderId NewClientOrderId to set
	 */
	public void setNewClientOrderId(String newClientOrderId) {
		this.newClientOrderId = newClientOrderId;
	}
}