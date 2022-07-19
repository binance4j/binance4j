package com.binance4j.wallet.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The parameters to get the funding wallet */
@Data
@EqualsAndHashCode(callSuper = true)
public class FundingAssetParams extends FramedParams {

	/** The asset we want the balance. */
	private String asset;

	/** Get the BTC value of the asset. */
	private Boolean needBtcValuation;

	/**
	 
	 */
	public FundingAssetParams() {
		super(1);
	}

	/**
	 * @param asset The asset we want the balance.
	 */
	public FundingAssetParams(String asset) {
		this();
		this.asset = asset;
	}

	/**
	 * @param asset            The asset we want the balance.
	 * @param needBtcValuation Dlo we want the value of the balance in bitcoin?
	 */
	public FundingAssetParams(String asset, Boolean needBtcValuation) {
		this(asset);
		this.needBtcValuation = needBtcValuation;
	}
}
