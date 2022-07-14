package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IsolatedAccountParams extends FramedParams {
	/** Max 5 symbols can be sent; separated by "," */
	private String symbols;

	public IsolatedAccountParams() {
		super(10);
	}
}