package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#repay} params. */
public class RepayParams extends Params {
	/** The asset to repay. */
	@Mandatory
	String asset;
	/** The amount to repay. */
	@Mandatory
	String amount;
	/** The isolated symbol. */
	String symbol;
	/** For isolated margin or not. Default {@code false}. */
	Boolean isIsolated;

	/**
	 * @param asset  The asset to repay.
	 * @param amount The amount to repay.
	 */
	public RepayParams(String asset, String amount) {
		super(300);
		rateLimitType = RateLimitType.UID;
		this.asset = asset;
		this.amount = amount;
	}

	/**
	 * Isolated margin repay
	 * 
	 * @param symbol isolated symbol.
	 */
	public void isIsolated(String symbol) {
		this.isIsolated = true;
		this.symbol = symbol;
	}

	/** Crossed margin repay. */
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
	public Boolean getIsIsolated() {
		return isIsolated;
	}

	/** @param isIsolated the isIsolated to set */
	public void setIsIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
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