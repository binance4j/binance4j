package com.binance4j.fiat.param;

import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.fiat.client.FiatClient;
import com.binance4j.fiat.dto.TransactionType;

/**
 * {@link FiatClient#getTransactions} params.
 */
public class TransactionParams extends Params {

	/** Transaction type */
	private TransactionType transactionType;
	/** Begin time in ms */
	private Long beginTime;
	/** End time in ms */
	private Long endTime;
	/** Page. Default 1. */
	private Integer page;
	/** Rows. Default 100, max 500. */
	private Integer rows;

	/**
	 * @param transactionType The transaction type.
	 */
	public TransactionParams(TransactionType transactionType) {
		super(90000);
		rateLimitType = RateLimitType.UID;
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the beginTime
	 */
	public Long getBeginTime() {
		return beginTime;
	}

	/**
	 * @param beginTime the beginTime to set
	 */
	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @return the endTime
	 */
	public Long getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
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
}