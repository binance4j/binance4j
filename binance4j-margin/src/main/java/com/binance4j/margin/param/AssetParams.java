package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The {@link MarginClient#getAsset} params. */
@Data
@EqualsAndHashCode(callSuper = true)
public class AssetParams extends Params {
	private String asset;

	public AssetParams(String asset) {
		super(10);
		this.asset = asset;
	}
}