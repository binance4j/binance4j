package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OpenOrdersParams extends FramedParams {
	private String symbol;
	private Boolean isIsolated;

	public OpenOrdersParams() {
		super(10);
	}
}
