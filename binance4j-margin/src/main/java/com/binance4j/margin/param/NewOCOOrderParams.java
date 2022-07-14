package com.binance4j.margin.param;

import java.math.BigDecimal;

import com.binance4j.core.order.OCOOrderParams;
import com.binance4j.core.order.OrderSide;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NewOCOOrderParams extends OCOOrderParams {
	private Boolean isIsolated;

	/**
	 * @param symbol
	 * @param side
	 * @param quantity
	 * @param price
	 * @param stopPrice
	 */
	public NewOCOOrderParams(String symbol, OrderSide side, BigDecimal quantity, BigDecimal price, BigDecimal stopPrice) {
		super(symbol, side, quantity, price, stopPrice);
	}
}
