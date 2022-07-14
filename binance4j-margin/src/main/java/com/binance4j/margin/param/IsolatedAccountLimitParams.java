package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IsolatedAccountLimitParams extends FramedParams {
	public IsolatedAccountLimitParams() {
		super(1);
	}
}
