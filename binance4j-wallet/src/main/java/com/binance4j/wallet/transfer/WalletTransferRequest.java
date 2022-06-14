package com.binance4j.wallet.transfer;

import com.binance4j.core.request.FramedRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * A request to operate an asset transfer between two accounts
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WalletTransferRequest extends FramedRequest {
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
	public WalletTransferRequest(BigDecimal amount, String asset, WalletTransferType type) {
		super(1);
		this.type = type;
		this.asset = asset;
		this.amount = amount;
	}
}