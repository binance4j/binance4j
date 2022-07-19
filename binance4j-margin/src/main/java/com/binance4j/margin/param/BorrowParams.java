package com.binance4j.margin.param;

import java.math.BigDecimal;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.client.MarginClient;

import lombok.AccessLevel;
import lombok.Setter;

/** The {@link MarginClient#borrow} params. */
public class BorrowParams extends FramedParams {
	/** Asset to borrow. */
	private String asset;
	/** Isolated symbol. */
	private String symbol;
	/** For isolated margin or not, "TRUE", "FALSE"，default "FALSE". */
	@Setter(value = AccessLevel.NONE)
	private Boolean isIsolated;
	/** Amount to borrow. */
	private BigDecimal amount;

	/**
	 * @param asset  Asset to borrow.
	 * @param amount Amount to borrow.
	 */
	public BorrowParams(String asset, BigDecimal amount) {
		super(300);
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

	/** @return the asset */.
	public String getAsset() {
		return asset;
	}

	/** @param asset the asset to set */.
	public void setAsset(String asset) {
		this.asset = asset;
	}

	/** @return the symbol */.
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */.
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/** @return the isIsolated */.
	public Boolean isIsolated() {
		return isIsolated;
	}

	/** @return the amount */.
	public BigDecimal getAmount() {
		return amount;
	}

	/** @param amount the amount to set */.
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}