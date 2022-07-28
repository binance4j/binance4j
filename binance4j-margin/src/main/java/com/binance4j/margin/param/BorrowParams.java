package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#borrow} params. */
public class BorrowParams extends Params {

	/** Asset to borrow. */
	@Mandatory
	String asset;
	/** Amount to borrow. */
	@Mandatory
	String amount;
	/** Isolated symbol. */
	String symbol;
	/** For isolated margin or not, "TRUE", "FALSE"，default "FALSE". */
	Boolean isIsolated;

	/**
	 * @param asset  Asset to borrow.
	 * @param amount Amount to borrow.
	 */
	public BorrowParams(String asset, String amount) {
		super(300);
		rateLimitType = RateLimitType.UID;
		this.asset = asset;
		this.amount = amount;
	}

	/**
	 * Isolated margin loan
	 * 
	 * @param symbol isolated symbol.
	 */
	public void isIsolated(String symbol) {
		this.isIsolated = true;
		this.symbol = symbol;
	}

	/** Crossed margin loan. */
	public void isNotIsolated() {
		this.isIsolated = false;
		this.symbol = null;
	}

	/** @return the asset */
	public String getAsset() {
		return asset;
	}

	/** @param asset the asset to set */
	public void setAsset(String asset) {
		this.asset = asset;
	}

	/** @return the symbol */
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/** @return the isIsolated */
	public Boolean isIsolated() {
		return isIsolated;
	}

	/** @return the amount */
	public String getAmount() {
		return amount;
	}

	/** @param amount the amount to set */
	public void setAmount(String amount) {
		this.amount = amount;
	}

}