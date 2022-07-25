package com.binance4j.fiat.param;

import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.fiat.client.FiatClient;
import com.binance4j.fiat.dto.PaymentType;

/**
 * {@link FiatClient#getPayments} params.
 */
public class PaymentParams extends Params {

	/** Transaction type */
	PaymentType transactionType;
	/** Begin time in ms */
	Long beginTime;
	/** End time in ms */
	Long endTime;
	/** Page. Default 1. */
	Integer page;
	/** Rows. Default 100, max 500. */
	Integer rows;

	/**
	 * @param transactionType The transaction type.
	 */
	public PaymentParams(PaymentType transactionType) {
		super(90000);
		rateLimitType = RateLimitType.UID;
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionType
	 */
	public PaymentType getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(PaymentType transactionType) {
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