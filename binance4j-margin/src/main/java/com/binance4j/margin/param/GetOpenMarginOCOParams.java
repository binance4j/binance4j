package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetOpenMarginOCOParams extends FramedParams {
	private Boolean isIsolated;
	/** mandatory for isolated margin, not supported for cross margin */
	private String symbol;

	public GetOpenMarginOCOParams() {
		super(10);
	}
}
