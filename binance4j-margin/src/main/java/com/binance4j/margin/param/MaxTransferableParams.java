package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MaxTransferableParams extends FramedParams {
	private String asset;
	private String isolatedSymbol;

	public MaxTransferableParams(String asset) {
		super(50);
		this.asset = asset;
	}
}
