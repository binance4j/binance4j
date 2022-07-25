package com.binance4j.nft.param;

import com.binance4j.core.dto.WeightType;
import com.binance4j.core.param.Params;
import com.binance4j.nft.dto.OrderType;

/**
 * A NFT transaction history request
 * <p>
 * The max interval between startTime and endTime is 90 days.
 * <p>
 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
 */
public class TransactionHistoryParams extends Params {
	/** The starting timestamp of the results */
	private Long startTime;
	/** The ending timestamp of the results */
	private Long endTime;

	/** The order type. */
	private Integer orderType;
	/** The result size. Default 50, Max 50. */
	private Integer limit = 50;
	/** The result page. Default 1. */
	private Integer page = 1;

	private TransactionHistoryParams() {
		super(3000);
		weightType = WeightType.UID;
	}

	/**
	 * @param orderType The order type.
	 */
	public TransactionHistoryParams(OrderType orderType) {
		this();
		this.orderType = orderType.getValue();
	}

	/**
	 * @param orderType The order type.
	 */
	public TransactionHistoryParams(int orderType) {
		this();
		this.orderType = orderType;
	}

	/**
	 * @param orderType The order type.
	 * @param limit     The result size. Default 50, Max 50.
	 * @param page      The result page. Default 1.
	 */
	public TransactionHistoryParams(OrderType orderType, int limit, int page) {
		this(orderType);
		this.limit = limit;
		this.page = page;
	}

	/**
	 * @param orderType The order type.
	 * @param limit     The result size. Default 50, Max 50.
	 * @param page      The result page. Default 1.
	 * @param startTime The result start time in ms.
	 * @param endTime   The result end time in ms.
	 */
	public TransactionHistoryParams(OrderType orderType, int limit, int page, long startTime, long endTime) {
		this(orderType, limit, page);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * @return the orderType.
	 */
	public Integer getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType the orderType to set.
	 */
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	/**
	 * @return the limit.
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set.
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return the page.
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set.
	 */
	public void setPage(Integer page) {
		this.page = page;
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
