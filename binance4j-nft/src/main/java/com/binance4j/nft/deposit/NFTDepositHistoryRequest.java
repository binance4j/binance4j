package com.binance4j.nft.deposit;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A NFT deposit history request
 * <p>
 * The max interval between startTime and endTime is 90 days.
 * <p>
 * If startTime and endTime are not sent, the recent 7 days' data will be
 * returned.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NFTDepositHistoryRequest extends IntervalRequest {
    /** The result size. Default 50, Max 50. */
    private Integer limit = 50;
    /** The result page. Default 1. */
    private Integer page = 1;

    /**
     * Constructor
     */
    public NFTDepositHistoryRequest() {
        super(3000);
    }

    /**
     * Constructor
     * 
     * @param limit The result size. Default 50, Max 50.
     * @param page  The result page. Default 1.
     */
    public NFTDepositHistoryRequest(int limit, int page) {
        this();
        this.limit = limit;
        this.page = page;
    }

    /**
     * Constructor
     * 
     * @param limit     The result size. Default 50, Max 50.
     * @param page      The result page. Default 1.
     * @param startTime The result start time in ms
     * @param endTime   The result end time in ms
     */
    public NFTDepositHistoryRequest(int limit, int page, long startTime, long endTime) {
        this(limit, page);
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
