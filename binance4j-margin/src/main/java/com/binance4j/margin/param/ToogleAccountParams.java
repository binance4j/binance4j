package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ToogleAccountParams extends FramedParams {
	private String symbol;

	public ToogleAccountParams(String symbol) {
		super(300);
		this.symbol = symbol;
	}
}
