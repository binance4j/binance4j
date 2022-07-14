package com.binance4j.market.price;

import com.binance4j.core.param.Params;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The parameters to get the average price of a trading pair */
@Data
@EqualsAndHashCode(callSuper = true)
public class AveragePriceParams extends Params {
	/** The trading pair we want the price. */
	private String symbol;

	/**
	 * Default constructor
	 *
	 * @param symbol The trading pair we want the price
	 */
	public AveragePriceParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}
}
