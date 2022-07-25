package com.binance4j.wallet.param;

import java.math.BigDecimal;

import com.binance4j.core.param.Params;
import com.binance4j.wallet.dto.WalletTransferType;

/** The parameters to operate an asset transfer between two accounts */
public class WalletTransferParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();
	/** The asset. */
	private String asset;
	/** The transfer type. */
	private WalletTransferType type;
	/** The volume. */
	private BigDecimal amount;
	/** must be sent when type are ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN */
	private String fromSymbol;
	/** must be sent when type are ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN */
	private String toSymbol;

	/**
	 * @param type   The transfer type.
	 * @param asset  The asset to transfer.
	 * @param amount The volume to transfer.
	 */
	public WalletTransferParams(BigDecimal amount, String asset, WalletTransferType type) {
		super(1);
		this.type = type;
		this.asset = asset;
		this.amount = amount;
	}

	/**
	 * @return the asset
	 */
	public String getAsset() {
		return asset;
	}

	/**
	 * @param asset the asset to set
	 */
	public void setAsset(String asset) {
		this.asset = asset;
	}

	/**
	 * @return the type
	 */
	public WalletTransferType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(WalletTransferType type) {
		this.type = type;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the fromSymbol
	 */
	public String getFromSymbol() {
		return fromSymbol;
	}

	/**
	 * @param fromSymbol the fromSymbol to set
	 */
	public void setFromSymbol(String fromSymbol) {
		this.fromSymbol = fromSymbol;
	}

	/**
	 * @return the toSymbol
	 */
	public String getToSymbol() {
		return toSymbol;
	}

	/**
	 * @param toSymbol the toSymbol to set
	 */
	public void setToSymbol(String toSymbol) {
		this.toSymbol = toSymbol;
	}

	/** @return the timestamp */
	public long getTimestamp() {
		return timestamp;
	}

	/** @param timestamp the timestamp to set */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}