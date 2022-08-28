package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [SpotClient.newOrder] params.
 */
@Param(weight = 1, isOrder = true, type = RateLimitType.UID_AND_IP)
public class NewOrderParams:Params
{
	/** The order symbol */
	String symbol;
	/** The order side */
	OrderSide side;
	/** The order type */
	OrderType type;
	/** The order quantity */
	String quantity;
	/** The order price */
	String price;
	/** The stop price */
	String stopPrice;
	/** The order response type Default: RESULT. */
	NewOrderResponseType newOrderRespType;
	/** The order lifetime */
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
	public NewOrderParams(String symbol, OrderType type, OrderSide side, String quantity, String price,
			TimeInForce timeInForce) {
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

	// MARKET

	/**
	 * Produces a MARKET buy order
	 *
	 * @param symbol   Asset pair.
	 * @param quantity Quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams buy(String symbol, String quantity) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, quantity);
	}

	/**
	 * Produces a MARKET order
	 *
	 * @param symbol   Asset pair.
	 * @param quantity Quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams sell(String symbol, String quantity) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, quantity);
	}

	// MARKET QUOTE

	/**
	 * Produces a MARKET buy order with quote quantity and default timeInForce
	 *
	 * @param symbol   Asset pair.
	 * @param quantity Quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyQuote(String symbol, String quantity) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, null);
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
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, null);
		order.setQuoteOrderQuantity(quantity);
		return order;
	}

	// LIMIT

	/**
	 * Produces a LIMIT buy order
	 *
	 * @param symbol      Asset pair.
	 * @param quantity    Quantity.
	 * @param price       Purchase price.
	 * @param timeInForce Lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams buy(String symbol, String quantity, String price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.BUY, quantity, price, timeInForce);
	}

	/**
	 * Produces a LIMIT buy order
	 *
	 * @param symbol   Asset pair.
	 * @param quantity Quantity.
	 * @param price    Purchase price.
	 * @return The order to execute.
	 */
	public static NewOrderParams buy(String symbol, String quantity, String price) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.BUY, quantity, price, TimeInForce.GTC);
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol      Asset pair.
	 * @param quantity    Quantity.
	 * @param price       Selling price.
	 * @param timeInForce Lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams sell(String symbol, String quantity, String price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.SELL, quantity, price, timeInForce);
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol   Asset pair.
	 * @param quantity Quantity.
	 * @param price    Purchase prices.
	 * @return The order to execute.
	 */
	public static NewOrderParams sell(String symbol, String quantity, String price) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.SELL, quantity, price, TimeInForce.GTC);
	}

	/**
	 * Produces a MARKET buy order with quote quantity
	 *
	 * @param symbol      Asset pair.
	 * @param quantity    Quantity.
	 * @param timeInForce Lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams buy(String symbol, String quantity, TimeInForce timeInForce) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, null, timeInForce);
		order.setQuoteOrderQuantity(quantity);
		return order;
	}

	// STOP LOSS

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol    Asset pair.
	 * @param quantity  Quantity.
	 * @param stopPrice Stop price
	 * @return The order to execute.
	 */
	public static NewOrderParams sellStopLoss(String symbol, String quantity, String stopPrice) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.STOP_LOSS, OrderSide.SELL, quantity,
				TimeInForce.GTC);
		order.setStopPrice(stopPrice);
		return order;
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol      Asset pair.
	 * @param quantity    Quantity.
	 * @param stopPrice   Stop price
	 * @param timeInForce time in force
	 * @return The order to execute.
	 */
	public static NewOrderParams sellStopLoss(String symbol, String quantity, String stopPrice,
			TimeInForce timeInForce) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.STOP_LOSS, OrderSide.SELL, quantity, timeInForce);
		order.setStopPrice(stopPrice);
		return order;
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol    Asset pair.
	 * @param quantity  Quantity.
	 * @param stopPrice Stop price
	 * @return The order to execute.
	 */
	public static NewOrderParams buyStopLoss(String symbol, String quantity, String stopPrice) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.STOP_LOSS, OrderSide.BUY, quantity,
				TimeInForce.GTC);
		order.setStopPrice(stopPrice);
		return order;
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol      Asset pair.
	 * @param quantity    Quantity.
	 * @param stopPrice   Stop price
	 * @param timeInForce time in force
	 * @return The order to execute.
	 */
	public static NewOrderParams buyStopLoss(String symbol, String quantity, String stopPrice,
			TimeInForce timeInForce) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.STOP_LOSS, OrderSide.BUY, quantity, timeInForce);
		order.setStopPrice(stopPrice);
		return order;
	}

	/**
	 * @return the stopLimitPrice
	 */
	public String getStopLimitPrice() {
		return stopLimitPrice;
	}

	/**
	 * @param stopLimitPrice StopLimitPrice to set
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

	@Override
	public String toString() {
		return "NewOrderParams [icebergQuantity=" + icebergQuantity + ", newClientOrderId=" + newClientOrderId
				+ ", newOrderRespType=" + newOrderRespType + ", price=" + price + ", quantity=" + quantity
				+ ", quoteOrderQuantity=" + quoteOrderQuantity + ", side=" + side + ", stopLimitPrice=" + stopLimitPrice
				+ ", stopPrice=" + stopPrice + ", symbol=" + symbol + ", timeInForce=" + timeInForce + ", type=" + type
				+ "]";
	}

}