package com.binance4j.wallet.assetdetail;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The parameters to get details about a supported asset */
@Data
@EqualsAndHashCode(callSuper = true)
public class AssetDetailParams extends FramedParams {
	/** The asset abbreviation. */
	private String asset;

	/** Default constructor. */
	public AssetDetailParams() {
		super(1);
	}

	/**
	 *
	 * 
	 * @param asset the asset we want the details
	 */
	public AssetDetailParams(String asset) {
		this();
		this.asset = asset;
	}
}
