package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Requests assets that can be converted into BNB */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertibleAssetParams extends Params {

	/** Constructor */
	public ConvertibleAssetParams() {
		super(1);
	}

}
