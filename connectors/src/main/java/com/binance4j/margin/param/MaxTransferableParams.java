package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getMaxTransferable] params.
 * 
 * @param asset          Asset.
 * @param isolatedSymbol Isolated symbol.
 */
data class MaxTransferableParams(
asset : String, String isolatedSymbol):Params
{

	/**
	 * Creates an instance of {@link MaxTransferableParams}.
	 * 
	 * @param asset Asset.
	 */
	public MaxTransferableParams(String asset) {
		this(asset, null);
	}
}