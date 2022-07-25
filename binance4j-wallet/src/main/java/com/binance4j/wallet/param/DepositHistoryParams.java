package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;
import com.binance4j.wallet.dto.DepositStatus;

/** The parameters to get a coin deposit history */
public class DepositHistoryParams extends Params {
	/** The starting timestamp of the results */
	private Long startTime;
	/** The ending timestamp of the results */
	private Long endTime;

	/** The deposited coin. */
	private String coin;
	/** The deposit status. 0(0:pending,6: credited but cannot withdraw, 1:success) */
	private Integer status;

	/** The history offset. */
	private Integer offset;
	/** The history size. Default:1000, Max:1000 */
	private Integer limit = 1000;

	/** Default constructor. */
	public DepositHistoryParams() {
		super(1);
	}

	/**
	 * @param coin The coin we need deposit history.
	 */
	public DepositHistoryParams(String coin) {
		this();
		this.coin = coin;
	}

	/**
	 * @param status The coin status (0:pending,6: credited but cannot withdraw, 1:success).
	 */
	public DepositHistoryParams(int status) {
		this();
		this.status = status;
	}

	/**
	 * @param status The coin status.
	 */
	public DepositHistoryParams(DepositStatus status) {
		this();
		this.status = status.getValue();
	}

	/**
	 * @param coin   The coin we need deposit history.
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw, 1:success).
	 */
	public DepositHistoryParams(String coin, int status) {
		this(coin);
		this.status = status;
	}

	/**
	 * @param coin   The coin we need deposit history.
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw, 1:success).
	 */
	public DepositHistoryParams(String coin, DepositStatus status) {
		this(coin, status.getValue());
	}

	/**
	 * @param coin   The coin we need deposit history.
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw, 1:success).
	 * @param limit  The history size. Default:1000, Max:1000.
	 */
	public DepositHistoryParams(String coin, DepositStatus status, int limit) {
		this(coin, status.getValue());
		this.limit = limit;
	}

	/**
	 * @param coin   The coin we need deposit history.
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw, 1:success).
	 * @param limit  The history size. Default:1000, Max:1000.
	 */
	public DepositHistoryParams(String coin, int status, int limit) {
		this(coin, status);
		this.limit = limit;
	}

	/**
	 * @param coin   The coin we need deposit history.
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw, 1:success).
	 * @param limit  The history size. Default:1000, Max:1000.
	 * @param offset The history offset.
	 */
	public DepositHistoryParams(String coin, DepositStatus status, int limit, int offset) {
		this(coin, status, limit);
		this.offset = offset;
	}

	/**
	 * @param coin   The coin we need deposit history.
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw, 1:success).
	 * @param limit  The history size. Default:1000, Max:1000.
	 * @param offset The history offset.
	 */
	public DepositHistoryParams(String coin, int status, int limit, int offset) {
		this(coin, status, limit);
		this.offset = offset;
	}

	/**
	 * @return the coin
	 */
	public String getCoin() {
		return coin;
	}

	/**
	 * @param coin the coin to set
	 */
	public void setCoin(String coin) {
		this.coin = coin;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the offset
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * @param offset the offset to set
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/** @return the startTime */
	public Long getStartTime() {
		return startTime;
	}

	/** @param startTime the startTime to set */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/** @return the endTime */
	public Long getEndTime() {
		return endTime;
	}

	/** @param endTime the endTime to set */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}