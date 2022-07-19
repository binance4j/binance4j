package com.binance4j.spot.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The parameters to get the current account information. */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountParams extends FramedParams {
	/** Constructor. */
	public AccountParams() {
		super(10);
	}
}
