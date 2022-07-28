package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getMaxTransferable} params.
 * 
 * @param asset          Asset.
 * @param isolatedSymbol Isolated symbol.
 */
@Param(weight = 50)
public record MaxTransferableParams(@Mandatory String asset, String isolatedSymbol) implements Params {
	/**
	 * Creates an instance of {@link MaxTransferableParams}.
	 * 
	 * @param asset Asset.
	 */
	public MaxTransferableParams(String asset) {
		this(asset, null);
	}
}