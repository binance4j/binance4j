package com.binance4j.margin.param;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TradeParams extends IntervalParams {
	private String symbol;
	private Boolean isIsolated;
	private Long fromId;
	private Integer limit;

	public TradeParams() {
		super(10);
	}
}
