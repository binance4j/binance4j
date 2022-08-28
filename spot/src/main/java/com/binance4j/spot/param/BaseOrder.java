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

	/**
	 * @return the strategyId
	 */
	public Integer getStrategyId() {
		return strategyId;
	}

	/**
	 * @param strategyId the strategyId to set
	 */
	public void setStrategyId(Integer strategyId) {
		this.strategyId = strategyId;
	}

	/**
	 * @return the strategyType
	 */
	public Integer getStrategyType() {
		return strategyType;
	}

	/**
	 * @param strategyType the strategyType to set
	 */
	public void setStrategyType(Integer strategyType) {
		this.strategyType = strategyType;
	}

	/**
	 * @return the newOrderResponseType
	 */
	public NewOrderResponseType getNewOrderResponseType() {
		return NewOrderResponseType;
	}

	/**
	 * @param newOrderResponseType the newOrderResponseType to set
	 */
	public void setNewOrderResponseType(NewOrderResponseType newOrderResponseType) {
		NewOrderResponseType = newOrderResponseType;
	}

	@Override
	public String toString() {
		return "BaseOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + "]";
	}
}