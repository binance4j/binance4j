package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedTransferAccount;

/**
 * {@link MarginClient#getIsolatedTransferHistory} params.
 * 
 * @param symbol    Symbol.
 * @param asset     Asset.
 * @param transFrom Transfer origin.
 * @param transTo   Transfer destination.
 * @param archived  Set to true for archived data from 6 months ago.
 */
@Param
public record IsolatedTransferHistoryParams(@Mandatory String symbol, String asset, IsolatedTransferAccount transFrom, IsolatedTransferAccount transTo,
		Boolean archived) implements Params {

	/**
	 * Creates an instance of {@link IsolatedTransferHistoryParams}.
	 * 
	 * @param symbol    Symbol.
	 * @param asset     Asset.
	 * @param transFrom Transfer origin.
	 * @param transTo   Transfer destination.
	 * @param archived  Set to true for archived data from 6 months ago.
	 */
	public IsolatedTransferHistoryParams(String symbol) {
		this(symbol, null, null, null, null);
	}

	/**
	 * Creates an instance of {@link IsolatedTransferHistoryParams}.
	 * 
	 * @param symbol Symbol.
	 * @param asset  Asset.
	 */
	public IsolatedTransferHistoryParams(String symbol, String asset) {
		this(symbol, asset, null, null, null);
	}

	/**
	 * Creates an instance of {@link IsolatedTransferHistoryParams}.
	 * 
	 * @param symbol    Symbol.
	 * @param asset     Asset.
	 * @param transFrom Transfer origin.
	 * @param transTo   Transfer destination.
	 */
	public IsolatedTransferHistoryParams(String symbol, String asset, IsolatedTransferAccount transFrom, IsolatedTransferAccount transTo) {
		this(symbol, asset, transFrom, transTo, null);
	}

	/**
	 * Creates an instance of {@link IsolatedTransferHistoryParams}.
	 * 
	 * @param symbol    Symbol.
	 * @param transFrom Transfer origin.
	 * @param transTo   Transfer destination.
	 * @param archived  Set to true for archived data from 6 months ago.
	 */
	public IsolatedTransferHistoryParams(String symbol, IsolatedTransferAccount transFrom, IsolatedTransferAccount transTo, Boolean archived) {
		this(symbol, null, transFrom, transTo, archived);
	}

	/**
	 * Creates an instance of {@link IsolatedTransferHistoryParams}.
	 * 
	 * @param symbol    Symbol.
	 * @param transFrom Transfer origin.
	 * @param transTo   Transfer destination.
	 */
	public IsolatedTransferHistoryParams(String symbol, IsolatedTransferAccount transFrom, IsolatedTransferAccount transTo) {
		this(symbol, null, transFrom, transTo, null);
	}
}
