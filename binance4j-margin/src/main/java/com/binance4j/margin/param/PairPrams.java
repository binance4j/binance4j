package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PairPrams extends FramedParams {
	private String symbol;

	public PairPrams(String symbol) {
		super(10);
		this.symbol = symbol;
	}
}