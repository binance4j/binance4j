package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;
import com.binance4j.wallet.dto.WithdrawStatus;

/** The parameters to fetch the user withdraw history */
public class WithdrawHistoryParams extends Params {
	/** The starting timestamp of the results */
	private Long startTime;
	/** The ending timestamp of the results */
	private Long endTime;

	/** The coin we want the history. */
	private String coin;
	/** The withdraw order id to fetch. */
	private String withdrawOrderId;
	/** The status to look for. */
	private Integer status;
	/** The offset. */
	private Integer offset;

	/** Default:1000, Max:1000 */
	private Integer limit = 1000;

	/**
	 
	 */
	public WithdrawHistoryParams() {
		super(1);
	}

	/**
	 * @param coin The coin we need deposit history.
	 */
	public WithdrawHistoryParams(String coin) {
		this();
		this.coin = coin;
	}

	/**
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw, 1:success).
	 */
	public WithdrawHistoryParams(int status) {
		this();
		this.status = status;
	}

	/**
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw, 1:success).
	 */
	public WithdrawHistoryParams(WithdrawStatus status) {
		this();
		this.status = status.getValue();
	}

	/**
	 * @param coin   The coin we need deposit history.
	 * @param status The coin status (EMAIL_SENT(0), CANCELLED(1), AWAITING_APPROVAL(2), REJECTED(3), PROCESSING(4),.
	 *                   FAILURE(5), COMPLETED(6);
	 */
	public WithdrawHistoryParams(String coin, int status) {
		this(coin);
		this.status = status;
	}

	/**
	 * @param coin   The coin we need deposit history.
	 * @param status The coin status.
	 */
	public WithdrawHistoryParams(String coin, WithdrawStatus status) {
		this(coin, status.getValue());
	}

	/**
	 * @param status The withdraw status.
	 */
	public void setStatus(WithdrawStatus status) {
		this.status = status.getValue();
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
	 * @return the withdrawOrderId
	 */
	public String getWithdrawOrderId() {
		return withdrawOrderId;
	}

	/**
	 * @param withdrawOrderId the withdrawOrderId to set
	 */
	public void setWithdrawOrderId(String withdrawOrderId) {
		this.withdrawOrderId = withdrawOrderId;
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
