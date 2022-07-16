package com.binance4j.margin.param;

import java.math.BigDecimal;

import com.binance4j.core.client.RestClientConfiguration;
import com.binance4j.core.dto.BaseOrder;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.SideEffectType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#newOrder} params. */
public class NewOrderParams extends BaseOrder {
	/** Set The margin order side-effect. NO_SIDE_EFFECT, MARGIN_BUY, AUTO_REPAY; default: NO_SIDE_EFFECT. */
	private SideEffectType sideEffectType;

	/**
	 * Produces an order
	 * 
	 * @param symbol      The symbol
	 * @param type        The order type
	 * @param side        The order side
	 * @param quantity    The quantity
	 * @param timeInForce The timeInforce
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity, TimeInForce timeInForce) {
		super(6, symbol, type, side, quantity, timeInForce);
	}

	/**
	 * Produces an order
	 * 
	 * @param symbol   The symbol
	 * @param type     The order type
	 * @param side     The order side
	 * @param quantity The quantity
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity) {
		super(6, symbol, type, side, quantity);
	}

	/**
	 * Produces an order
	 * 
	 * @param symbol      The symbol
	 * @param type        The order type
	 * @param side        The order side
	 * @param quantity    The quantity
	 * @param price       The price
	 * @param timeInForce The timeInforce
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity, BigDecimal price, TimeInForce timeInForce) {
		super(6, symbol, type, side, quantity, price, timeInForce);
	}

	/**
	 * Produces an order
	 * 
	 * @param symbol   The symbol
	 * @param type     The order type
	 * @param side     The order side
	 * @param quantity The quantity
	 * @param price    The price
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity, BigDecimal price) {
		super(6, symbol, type, side, quantity, price);
	}

	/**
	 * Produces a buy market order
	 * 
	 * @param symbol      The symbol
	 * @param quantity    The quantity
	 * @param timeInForce The timeInforce
	 * @return The generated {@link NewOrderParams}
	 */
	public static NewOrderParams buyMarket(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, quantity, timeInForce);
	}

	/**
	 * Produces a buy market order
	 * 
	 * @param symbol   The symbol
	 * @param quantity The quantity
	 * @return The generated {@link NewOrderParams}
	 */
	public static NewOrderParams buyMarket(String symbol, BigDecimal quantity) {
		return buyMarket(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces a sell market order
	 * 
	 * @param symbol      The symbol
	 * @param quantity    The quantity
	 * @param timeInForce The timeInforce
	 * @return The generated {@link NewOrderParams}
	 */
	public static NewOrderParams sellMarket(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, quantity, timeInForce);
	}

	/**
	 * Produces a sell market order
	 * 
	 * @param symbol   The symbol
	 * @param quantity The quantity
	 * @return The generated {@link NewOrderParams}
	 */
	public static NewOrderParams sellMarket(String symbol, BigDecimal quantity) {
		return buyMarket(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces a buy limit order
	 * 
	 * @param symbol      The symbol
	 * @param quantity    The quantity
	 * @param price       The price
	 * @param timeInForce The timeInforce
	 * @return The generated {@link NewOrderParams}
	 */
	public static NewOrderParams buyLimit(String symbol, BigDecimal quantity, BigDecimal price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.BUY, quantity, price, timeInForce);
	}

	/**
	 * Produces a buy limit order
	 * 
	 * @param symbol   The symbol
	 * @param quantity The quantity
	 * @param price    The price
	 * @return The generated {@link NewOrderParams}
	 */
	public static NewOrderParams buyLimit(String symbol, BigDecimal quantity, BigDecimal price) {
		return buyLimit(symbol, quantity, price, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces a sell limit order
	 * 
	 * @param symbol      The symbol
	 * @param quantity    The quantity
	 * @param price       The price
	 * @param timeInForce The timeInforce
	 * @return The generated {@link NewOrderParams}
	 */
	public static NewOrderParams sellLimit(String symbol, BigDecimal quantity, BigDecimal price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.SELL, quantity, price, timeInForce);
	}

	/**
	 * Produces a sell limit order
	 * 
	 * @param symbol   The symbol
	 * @param quantity The quantity
	 * @param price    The price
	 * @return The generated {@link NewOrderParams}
	 */
	public static NewOrderParams sellLimit(String symbol, BigDecimal quantity, BigDecimal price) {
		return sellLimit(symbol, quantity, price, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * @return The sideEffectType
	 */
	public SideEffectType getSideEffectType() {
		return sideEffectType;
	}

	/**
	 * @param sideEffectType The sideEffectType to set
	 */
	public void setSideEffectType(SideEffectType sideEffectType) {
		this.sideEffectType = sideEffectType;
	}
}