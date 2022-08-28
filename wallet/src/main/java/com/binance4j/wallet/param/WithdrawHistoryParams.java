package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.WithdrawStatus;

/**
 * {@link WalletClient#getWithdrawHistory} params.
 * 
 * @param coin            Coin we want the history.
 * @param withdrawOrderId Withdraw order id to fetch.
 * @param status          Status to look for.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#withdraw-history-supporting-network-user_data">Binance
 *      doc</a>
 */
@Param
public record WithdrawHistoryParams(String coin, String withdrawOrderId, String status) implements Params {
	/**
	 * Creates an instance of {@link WithdrawHistoryParams}.
	 * 
	 * @param coin            Coin we want the history.
	 * @param withdrawOrderId Withdraw order id to fetch.
	 * @param status          Status to look for.
	 */
	public WithdrawHistoryParams(String coin, String withdrawOrderId, WithdrawStatus status) {
		this(coin, withdrawOrderId, status == null ? null : status.toString());
	}

	/**
	 * Creates an instance of {@link WithdrawHistoryParams}.
	 * 
	 * @param withdrawOrderId Withdraw order id to fetch.
	 */
	public WithdrawHistoryParams(String withdrawOrderId) {
		this(null, withdrawOrderId, "");
	}

	/**
	 * Creates an instance of {@link WithdrawHistoryParams}.
	 * 
	 * @param coin   Coin we want the history.
	 * @param status Status to look for.
	 */
	public WithdrawHistoryParams(String coin, WithdrawStatus status) {
		this(coin, null, status == null ? null : status.toString());
	}

	/**
	 * Creates an instance of {@link WithdrawHistoryParams}.
	 * 
	 * @param status Status to look for.
	 */
	public WithdrawHistoryParams(WithdrawStatus status) {
		this(null, null, status == null ? null : status.toString());
	}
}