package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.WithdrawStatus;

/**
 * {@link WalletClient#getWithdrawHistory} params.
 * 
 * @param coin            The coin we want the history.
 * @param withdrawOrderId The withdraw order id to fetch.
 * @param status          The status to look for.
 * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#withdraw-history-supporting-network-user_data">Binance
 *      doc</a>
 */
@Param
public record WithdrawHistoryParams(String coin, String withdrawOrderId, WithdrawStatus status) implements Params {
	/**
	 * Creates an instance of {@link WithdrawHistoryParams}.
	 */
	public WithdrawHistoryParams() {
		this(null, null, null);
	}

	/**
	 * Creates an instance of {@link WithdrawHistoryParams}.
	 * 
	 * @param withdrawOrderId The withdraw order id to fetch.
	 */
	public WithdrawHistoryParams(String withdrawOrderId) {
		this(null, withdrawOrderId, null);
	}

	/**
	 * Creates an instance of {@link WithdrawHistoryParams}.
	 * 
	 * @param coin   The coin we want the history.
	 * @param status The status to look for.
	 */
	public WithdrawHistoryParams(String coin, WithdrawStatus status) {
		this(coin, null, status);
	}

	/**
	 * Creates an instance of {@link WithdrawHistoryParams}.
	 * 
	 * @param status The status to look for.
	 */
	public WithdrawHistoryParams(WithdrawStatus status) {
		this(null, null, status);
	}
}