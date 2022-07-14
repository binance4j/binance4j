package com.binance4j.margin.param;

import com.binance4j.core.param.Params;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AssetParams extends Params {
	private String asset;

	public AssetParams(String asset) {
		super(10);
		this.asset = asset;
	}
}