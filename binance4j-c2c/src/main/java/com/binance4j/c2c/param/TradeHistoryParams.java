package com.binance4j.c2c.param;

import com.binance4j.c2c.client.C2CClient;
import com.binance4j.c2c.dto.TradeType;
import com.binance4j.core.param.Params;

/** The {@link C2CClient#getTrades} params. */
public class TradeHistoryParams extends Params {

	/** Trade type. */
	TradeType tradeType;
	/** Page. Default: 1. */
	Integer page;
	/** Rows. Default 100. Max 100. */
	Integer rows;

	/**
	 * @param tradeType Trade type.
	 */
	public TradeHistoryParams(TradeType tradeType) {
		super(1);
		this.tradeType = tradeType;
	}

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the rows
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	/**
	 * @return the tradeType
	 */
	public TradeType getTradeType() {
		return tradeType;
	}

	/**
	 * @param tradeType the tradeType to set
	 */
	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}
}