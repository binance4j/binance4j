package com.binance4j.margin.param;

import java.math.BigDecimal;

import com.binance4j.core.dto.WeightType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#borrow} params. */
public class BorrowParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();
	/** Asset to borrow. */
	private String asset;
	/** Isolated symbol. */
	private String symbol;
	/** For isolated margin or not, "TRUE", "FALSE"，default "FALSE". */
	private Boolean isIsolated;
	/** Amount to borrow. */
	private BigDecimal amount;

	/**
	 * @param asset  Asset to borrow.
	 * @param amount Amount to borrow.
	 */
	public BorrowParams(String asset, BigDecimal amount) {
		super(300);
		weightType = WeightType.UID;
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
	public BigDecimal getAmount() {
		return amount;
	}

	/** @param amount the amount to set */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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