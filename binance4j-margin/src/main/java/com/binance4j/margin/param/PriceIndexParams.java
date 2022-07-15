package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The {@link MarginClient#getPriceIndex} params. */
@Data
@EqualsAndHashCode(callSuper = true)
public class PriceIndexParams extends Params {
	private String symbol;

	public PriceIndexParams(String symbol) {
		super(10);
		this.symbol = symbol;
	}
}
