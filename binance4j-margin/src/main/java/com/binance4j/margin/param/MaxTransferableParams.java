package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getMaxTransferable} params. */
public class MaxTransferableParams extends FramedParams {
	/** The asset */
	private String asset;
	/** The isolated symbols */
	private String isolatedSymbol;

	/** @param asset The asset */.
	public MaxTransferableParams(String asset) {
		super(50);
		this.asset = asset;
	}

	/** @return the asset */.
	public String getAsset() {
		return asset;
	}

	/** @param asset the asset to set */.
	public void setAsset(String asset) {
		this.asset = asset;
	}

	/** @return the isolatedSymbol */.
	public String getIsolatedSymbol() {
		return isolatedSymbol;
	}

	/** @param isolatedSymbol the isolatedSymbol to set */.
	public void setIsolatedSymbol(String isolatedSymbol) {
		this.isolatedSymbol = isolatedSymbol;
	}
}