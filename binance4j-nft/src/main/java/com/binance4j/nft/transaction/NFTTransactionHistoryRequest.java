package com.binance4j.nft.transaction;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A NFT transaction history request
 * <p>
 * The max interval between startTime and endTime is 90 days.
 * <p>
 * If startTime and endTime are not sent, the recent 7 days' data will be
 * returned.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NFTTransactionHistoryRequest extends IntervalRequest {
    /** The order type. */
    private Integer orderType;
    /** The result size. Default 50, Max 50. */
    private Integer limit = 50;
    /** The result page. Default 1. */
    private Integer page = 1;

    /**
     * Constructor
     * 
     * @param orderType The order type
     */
    public NFTTransactionHistoryRequest(NFTOrderType orderType) {
        super(3000);
        this.orderType = orderType.getValue();
    }

    /**
     * Constructor
     * 
     * @param orderType The order type
     */
    public NFTTransactionHistoryRequest(int orderType) {
        super(3000);
        this.orderType = orderType;
    }

    /**
     * Constructor
     * 
     * @param orderType The order type.
     * @param limit     The result size. Default 50, Max 50.
     * @param page      The result page. Default 1.
     */
    public NFTTransactionHistoryRequest(NFTOrderType orderType, int limit, int page) {
        this(orderType);
        this.limit = limit;
        this.page = page;
    }

    /**
     * Constructor
     * 
     * @param orderType The order type.
     * @param limit     The result size. Default 50, Max 50.
     * @param page      The result page. Default 1.
     * @param startTime The result start time in ms
     * @param endTime   The result end time in ms
     */
    public NFTTransactionHistoryRequest(NFTOrderType orderType, int limit, int page, long startTime, long endTime) {
        this(orderType, limit, page);
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
