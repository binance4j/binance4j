package com.binance4j.margin.param;

import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.TransferType;

/** The {@link MarginClient#transfer} params. */
public class TransferParams extends Params {

	/** The asset being transferred, e.g., BTC. */
	String asset;
	/** The amount to be transferred. */
	String amount;
	/**
	 * The transfer type
	 * <p>
	 * 1: transfer from main account to cross margin account
	 * <p>
	 * 2: transfer from cross margin account to main account
	 */
	int type;

	/**
	 * @param asset  The asset to transfer.
	 * @param amount The amout to transfer.
	 * @param type   The transfer type. 1: transfer from main account to cross margin account, 2: transfer from cross
	 *                   margin. account to main account
	 */
	public TransferParams(String asset, String amount, int type) {
		super(600);
		rateLimitType = RateLimitType.UID;
		this.asset = asset;
		this.amount = amount;
		this.type = type;
	}

	/**
	 * @param asset  The asset to transfer.
	 * @param amount The amout to transfer.
	 * @param type   The transfer type.
	 */
	public TransferParams(String asset, String amount, TransferType type) {
		this(asset, amount, type.getValue());
	}

	/** @return the asset */
	public String getAsset() {
		return asset;
	}

	/** @param asset the asset to set */
	public void setAsset(String asset) {
		this.asset = asset;
	}

	/** @return the amount */
	public String getAmount() {
		return amount;
	}

	/** @param amount the amount to set */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/** @return the type */
	public int getType() {
		return type;
	}

	/** @param type the type to set */
	public void setType(int type) {
		this.type = type;
	}

}