package com.binance4j.wallet.transfer;

import java.math.BigDecimal;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to operate an asset transfer between two accounts
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WalletTransferParams extends FramedParams {
	/**
	 * The asset
	 */
	private String asset;
	/**
	 * The transfer type
	 */
	private WalletTransferType type;
	/**
	 * The volume
	 */
	private BigDecimal amount;
	/**
	 * must be sent when type are ISOLATEDMARGIN_MARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 */
	private String fromSymbol;
	/**
	 * must be sent when type are ISOLATEDMARGIN_MARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 */
	private String toSymbol;

	/**
	 * Constructor
	 *
	 * @param type   The transfer type
	 * @param asset  The asset to transfer
	 * @param amount The volume to transfer
	 */
	public WalletTransferParams(BigDecimal amount, String asset, WalletTransferType type) {
		super(1);
		this.type = type;
		this.asset = asset;
		this.amount = amount;
	}
}