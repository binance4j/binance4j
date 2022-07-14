package com.binance4j.wallet.tradefee;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to get the fees of a trading pair
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TradeFeeParams extends FramedParams {
	/** The trading pair we want the fees. */
	private String symbol;

	public TradeFeeParams() {
		super(1);
	}

	public TradeFeeParams(String symbol) {
		this();
		this.symbol = symbol;
	}
}
