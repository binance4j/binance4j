package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.client.MarginClient;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The {@link MarginClient#getCrossMarginPair} params. */
@Data
@EqualsAndHashCode(callSuper = true)
public class PairParams extends FramedParams {
	private String symbol;

	public PairParams(String symbol) {
		super(10);
		this.symbol = symbol;
	}
}