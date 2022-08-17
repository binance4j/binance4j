package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getInterestHistory},{@link MarginClient#getTransferHistory},{@link MarginClient#getLoanRecord},{@link MarginClient#getRepayRecord}
 * params.
 * 
 * @param asset          Related asset.
 * @param isolatedSymbol Isolated symbol.
 * @param txId           Transaction id in POST /sapi/v1/margin/repay.
 * @param archived       Set to true for archived data from 6 months ago.
 */
@Param
public record TransactionHistoryParams(String asset, String isolatedSymbol, Long txId, Boolean archived)
		implements Params {
	/**
	 * Creates an instance of {@link TransactionHistoryParams}.
	 * 
	 * @param asset          Related asset.
	 * @param isolatedSymbol Isolated symbol.
	 * @param txId           Transaction id in POST /sapi/v1/margin/repay.
	 * @param archived       Set to true for archived data from 6 months ago.
	 */
	public TransactionHistoryParams(String asset, String isolatedSymbol, Long txId, Boolean archived) {
		this.asset = asset;
		this.isolatedSymbol = isolatedSymbol;
		this.txId = txId;
		this.archived = archived;
	}

	/**
	 * Creates an instance of {@link TransactionHistoryParams}.
	 * 
	 * @param asset Related asset.
	 */
	public TransactionHistoryParams(String asset) {
		this(asset, null, null, null);
	}

	/**
	 * Creates an instance of {@link TransactionHistoryParams}.
	 * 
	 * @param asset          Related asset.
	 * @param isolatedSymbol Isolated symbol.
	 */
	public TransactionHistoryParams(String asset, String isolatedSymbol) {
		this(asset, isolatedSymbol, null, null);
	}

	/**
	 * Creates an instance of {@link TransactionHistoryParams}.
	 * 
	 * @param asset          Related asset.
	 * @param isolatedSymbol Isolated symbol.
	 * @param archived       Set to true for archived data from 6 months ago.
	 */
	public TransactionHistoryParams(String asset, String isolatedSymbol, Boolean archived) {
		this(asset, isolatedSymbol, null, archived);
	}

	/**
	 * Creates an instance of {@link TransactionHistoryParams}.
	 * 
	 * @param asset          Related asset.
	 * @param isolatedSymbol Isolated symbol.
	 * @param txId           Transaction id in POST /sapi/v1/margin/repay.
	 */
	public TransactionHistoryParams(String asset, String isolatedSymbol, Long txId) {
		this(asset, isolatedSymbol, txId, null);
	}

	/**
	 * Creates an instance of {@link TransactionHistoryParams}.
	 * 
	 * @param asset Related asset.
	 * @param txId  Transaction id in POST /sapi/v1/margin/repay.
	 */
	public TransactionHistoryParams(String asset, Long txId) {
		this(asset, null, txId, null);
	}

	/**
	 * Creates an instance of {@link TransactionHistoryParams}.
	 * 
	 * @param asset    Related asset.
	 * @param txId     Transaction id in POST /sapi/v1/margin/repay.
	 * @param archived Set to true for archived data from 6 months ago.
	 */
	public TransactionHistoryParams(String asset, Long txId, Boolean archived) {
		this(asset, null, txId, archived);
	}
}