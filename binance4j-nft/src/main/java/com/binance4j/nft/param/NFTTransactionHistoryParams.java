package com.binance4j.nft.param;

import com.binance4j.core.param.IntervalParams;
import com.binance4j.nft.dto.NFTOrderType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A NFT transaction history request
 * <p>
 * The max interval between startTime and endTime is 90 days.
 * <p>
 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NFTTransactionHistoryParams extends IntervalParams {
	/** The order type. */
	private Integer orderType;
	/** The result size. Default 50, Max 50. */
	private Integer limit = 50;
	/** The result page. Default 1. */
	private Integer page = 1;

	/**
	 *
	 * 
	 * @param orderType The order type
	 */
	public NFTTransactionHistoryParams(NFTOrderType orderType) {
		super(3000);
		this.orderType = orderType.getValue();
	}

	/**
	 *
	 * 
	 * @param orderType The order type
	 */
	public NFTTransactionHistoryParams(int orderType) {
		super(3000);
		this.orderType = orderType;
	}

	/**
	 *
	 * 
	 * @param orderType The order type.
	 * @param limit     The result size. Default 50, Max 50.
	 * @param page      The result page. Default 1.
	 */
	public NFTTransactionHistoryParams(NFTOrderType orderType, int limit, int page) {
		this(orderType);
		this.limit = limit;
		this.page = page;
	}

	/**
	 *
	 * 
	 * @param orderType The order type.
	 * @param limit     The result size. Default 50, Max 50.
	 * @param page      The result page. Default 1.
	 * @param startTime The result start time in ms
	 * @param endTime   The result end time in ms
	 */
	public NFTTransactionHistoryParams(NFTOrderType orderType, int limit, int page, long startTime, long endTime) {
		this(orderType, limit, page);
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
