package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.WalletTransferType;

/**
 * {@link WalletClient#transfer} params.
 * 
 * @param asset      Asset.
 * @param type       Transfer type.
 * @param amount     Volume.
 * @param fromSymbol Mandatory when {@code ISOLATEDMARGIN_MARGIN} and
 *                   {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
 * @param toSymbol   Mandatory when {@code ISOLATEDMARGIN_MARGIN} and
 *                   {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
 */
@Param
public record WalletTransferParams(String asset, WalletTransferType type, String amount, String fromSymbol,
		String toSymbol) implements Params {
	/**
	 * Creates an instance of {@link WalletTransferParams}.
	 * 
	 * @param asset      Asset.
	 * @param type       Transfer type.
	 * @param amount     Volume.
	 * @param fromSymbol Mandatory when {@code ISOLATEDMARGIN_MARGIN} and
	 *                   {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 * @param toSymbol   Mandatory when {@code ISOLATEDMARGIN_MARGIN} and
	 *                   {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 */
	public WalletTransferParams(String asset, WalletTransferType type, String amount, String fromSymbol,
			String toSymbol) {
		this.asset = asset;
		this.type = type;
		this.amount = amount;
		this.fromSymbol = fromSymbol;
		this.toSymbol = toSymbol;
	}

	/**
	 * Creates an instance of {@link WalletTransferParams}.
	 * 
	 * @param asset  Asset.
	 * @param type   Transfer type.
	 * @param amount Volume.
	 */
	public WalletTransferParams(String asset, WalletTransferType type, String amount) {
		this(asset, type, amount, null, null);
	}
}