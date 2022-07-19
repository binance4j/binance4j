package com.binance4j.wallet.param;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The parameters to get a list of asset dividends */
@Data
@EqualsAndHashCode(callSuper = true)
public class AssetDividendRecordParams extends IntervalParams {
	/** The asset abbreviation. */
	private String asset;
	/** The result limit. Default 20, max 500 */
	private Integer limit = 20;

	/** Default constructor. */
	public AssetDividendRecordParams() {
		super(10);
	}

	/**
	 * with asset
	 *
	 * @param asset The asset we want the records.
	 */
	public AssetDividendRecordParams(String asset) {
		this();
		this.asset = asset;
	}

	/**
	 * with asset and limit
	 *
	 * @param asset The asset we want the records.
	 * @param limit The result limit.
	 */
	public AssetDividendRecordParams(String asset, Integer limit) {
		this(asset);
		this.limit = limit;
	}
}
