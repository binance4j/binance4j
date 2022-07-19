package com.binance4j.wallet.param;

import com.binance4j.core.param.FramedParams;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Requests assets that can be converted into BNB */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertibleAssetParams extends FramedParams {
	/** Constructor */
	public ConvertibleAssetParams() {
		super(1);
	}

}
