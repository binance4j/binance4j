package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IsolatedMarginFeeParams extends FramedParams {
	private final String symbol;
	private Integer vipLevel;

	public IsolatedMarginFeeParams() {
		super(10);
		symbol = null;
	}

	public IsolatedMarginFeeParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}
}
