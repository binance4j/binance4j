package com.binance4j.spot.param;

import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.param.Params;

/** Base order class. */
public abstract class BaseOrder implements Params {
	/** Order symbol. */
	protected String symbol;
	/** Order side. */
	protected OrderSide side;
	/** Order type. */
	protected OrderType type;
	/** A unique id among open orders. Automatically generated if not sent. */
	protected String newClientOrderId;
	/** Strategy id. */
	protected Integer strategyId;
	/** Strategy type. */
	protected Integer strategyType;
	/** Desired response type. */
	protected NewOrderResponseType NewOrderResponseType;

	/**
	 * @param symbol Order symbol.
	 * @param side   Order side.
	 * @param type   Order type.
	 */
	protected BaseOrder(String symbol, OrderSide side, OrderType type) {
		this.symbol = symbol;
		this.side = side;
		this.type = type;
	}

	/**
	 * @return the symbol
	 */
	public String symbol() {
		return symbol;
	}

	/**
	 * @return the side
	 */
	public OrderSide side() {
		return side;
	}

	/**
	 * @return the type
	 */
	public OrderType type() {
		return type;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public BaseOrder symbol(String symbol) {
		this.symbol = symbol;
		return this;
	}

	/**
	 * @param side the side to set
	 */
	public BaseOrder side(OrderSide side) {
		this.side = side;
		return this;
	}

	/**
	 * @param type the type to set
	 */
	public BaseOrder type(OrderType type) {
		this.type = type;
		return this;
	}

	/**
	 * @return the newClientOrderId
	 */
	public String newClientOrderId() {
		return newClientOrderId;
	}

	/**
	 * @param newClientOrderId the newClientOrderId to set
	 */
	public BaseOrder newClientOrderId(String newClientOrderId) {
		this.newClientOrderId = newClientOrderId;
		return this;
	}

	@Override
	public String toString() {
		return "BaseOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + "]";
	}
}