package com.binance4j.wallet.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The parameters to get The api key permissions */
@Data
@EqualsAndHashCode(callSuper = true)
public class ApiPermissionsParams extends FramedParams {
	/** Constructor. */
	public ApiPermissionsParams() {
		super(1);
	}
}
