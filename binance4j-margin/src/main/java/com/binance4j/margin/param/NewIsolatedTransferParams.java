package com.binance4j.margin.param;

import java.math.BigDecimal;

import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedTransferAccount;

/** The {@link MarginClient#newIsolatedTransfer} params. */
public class NewIsolatedTransferParams extends Params {

	/** The asset to transfer */
	private String asset;
	/** The symbol to transfer from */
	private String symbol;
	/** The transfer origin. */
	private IsolatedTransferAccount transFrom;
	/** The transfer destination. */
	private IsolatedTransferAccount transTo;
	/** THe amount to transfer */
	private BigDecimal amount;

	/**
	 * @param asset     The asset to transfer.
	 * @param symbol    The symbol to transfer from.
	 * @param transFrom The transfer origin.
	 * @param transTo   The transfer destination.
	 * @param amount    THe amount to transfer.
	 */
	public NewIsolatedTransferParams(String asset, String symbol, IsolatedTransferAccount transFrom, IsolatedTransferAccount transTo, BigDecimal amount) {
		super(600);
		rateLimitType = RateLimitType.UID;
		this.asset = asset;
		this.symbol = symbol;
		this.transFrom = transFrom;
		this.transTo = transTo;
		this.amount = amount;
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

	/** @return the transFrom */
	public IsolatedTransferAccount getTransFrom() {
		return transFrom;
	}

	/** @param transFrom the transFrom to set */
	public void setTransFrom(IsolatedTransferAccount transFrom) {
		this.transFrom = transFrom;
	}

	/** @return the transTo */
	public IsolatedTransferAccount getTransTo() {
		return transTo;
	}

	/** @param transTo the transTo to set */
	public void setTransTo(IsolatedTransferAccount transTo) {
		this.transTo = transTo;
	}

	/** @return the amount */
	public BigDecimal getAmount() {
		return amount;
	}

	/** @param amount the amount to set */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
