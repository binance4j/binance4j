package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.DepositStatus;

/**
 * {@link WalletClient#getDepositHistory} params.
 * 
 * @param coin   Deposited coin.
 * @param status Deposit status. 0:pending, 1:success,6: credited but cannot withdraw.
 */
@Param
public record DepositHistoryParams(String coin, String status) implements Params {
	/**
	 * Creates an instance of {@link DepositHistoryParams}.
	 * 
	 * @param coin   Deposited coin.
	 * @param status Deposit status. 0:pending, 1:success,6: credited but cannot withdraw.
	 */
	public DepositHistoryParams(DepositStatus status, String coin) {
		this(coin, status.toString());
	}

	/**
	 * Creates an instance of {@link DepositHistoryParams}.
	 */
	public DepositHistoryParams() {
		this("", null);
	}

	/**
	 * Creates an instance of {@link DepositHistoryParams}.
	 * 
	 * @param coin Deposited coin.
	 */
	public DepositHistoryParams(String coin) {
		this(coin, null);
	}

	/**
	 * Creates an instance of {@link DepositHistoryParams}.
	 * 
	 * @param status Deposit status. 0:pending, 1:success,6: credited but cannot withdraw.
	 */
	public DepositHistoryParams(DepositStatus status) {
		this("", status.toString());
	}
}