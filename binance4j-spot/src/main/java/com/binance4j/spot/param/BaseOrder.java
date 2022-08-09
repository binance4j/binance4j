package com.binance4j.spot.param;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.param.Params;

/** Base order class. */
public abstract class BaseOrder implements Params {
	/** Order symbol. */
	protected final String symbol;
	/** Order side. */
	protected final OrderSide side;
	/** Order type. */
	protected final OrderType type;

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
	 * @return the side
	 */
	public OrderSide getSide() {
		return side;
	}

	/**
	 * @return the type
	 */
	public OrderType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "BaseOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + "]";
	}
}