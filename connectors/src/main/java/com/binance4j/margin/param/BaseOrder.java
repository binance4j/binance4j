package com.binance4j.margin.param;

import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.dto.SideEffectType;

/** Base order class. */
public abstract class BaseOrder:Params
{
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
	/** For isolated margin or not, */
	protected Boolean isIsolated;
	/**
	 * Set The margin order side-effect. default: NO_SIDE_EFFECT.
	 */
	protected SideEffectType sideEffectType;

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

	/**
	 * @return the isIsolated
	 */
	public Boolean getIsIsolated() {
		return isIsolated;
	}

	/**
	 * @param isIsolated the isIsolated to set
	 */
	public void setIsIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}

	/**
	 * @return the sideEffectType
	 */
	public SideEffectType getSideEffectType() {
		return sideEffectType;
	}

	/**
	 * @param sideEffectType the sideEffectType to set
	 */
	public void setSideEffectType(SideEffectType sideEffectType) {
		this.sideEffectType = sideEffectType;
	}

	@Override
	public String toString() {
		return "BaseOrder [NewOrderResponseType=" + NewOrderResponseType + ", isIsolated=" + isIsolated
				+ ", newClientOrderId=" + newClientOrderId + ", side=" + side + ", sideEffectType=" + sideEffectType
				+ ", strategyId=" + strategyId + ", strategyType=" + strategyType + ", symbol=" + symbol + ", type="
				+ type + "]";
	}
}