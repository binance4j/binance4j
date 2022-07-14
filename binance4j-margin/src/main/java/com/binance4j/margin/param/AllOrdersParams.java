package com.binance4j.margin.param;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AllOrdersParams extends IntervalParams {
	private String symbol;
	private Boolean isIsolated;
	private Long orderId;
	private Long limit;

	public AllOrdersParams(String symbol) {
		super(200);
		this.symbol = symbol;
	}
}
