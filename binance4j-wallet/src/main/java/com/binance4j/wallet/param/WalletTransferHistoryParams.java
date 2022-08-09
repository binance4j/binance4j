package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.WalletTransferType;

/**
 * {@link WalletClient#getTransferHistory} params.
 * 
 * @param type       User universal transfer type.
 * @param fromSymbol Mandatory when {@code ISOLATEDMARGIN_MARGIN} and {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
 * @param toSymbol   Mandatory when {@code MARGIN_ISOLATEDMARGIN} and {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
 */
@Param
public record WalletTransferHistoryParams(WalletTransferType type, String fromSymbol, String toSymbol) implements Params {

	/**
	 * Creates an instance of {@link WalletTransferHistoryParams}.
	 * 
	 * @param type       User universal transfer type.
	 * @param fromSymbol Mandatory when {@code ISOLATEDMARGIN_MARGIN} and {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 * @param toSymbol   Mandatory when {@code MARGIN_ISOLATEDMARGIN} and {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 */
	public WalletTransferHistoryParams(WalletTransferType type, String fromSymbol, String toSymbol) {
		this.type = type;
		this.fromSymbol = fromSymbol;
		this.toSymbol = toSymbol;
	}

	/**
	 * Creates an instance of {@link WalletTransferHistoryParams}.
	 * 
	 * @param type User universal transfer type.
	 */
	public WalletTransferHistoryParams(WalletTransferType type) {
		this(type, null, null);
	}
}