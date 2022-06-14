package com.binance4j.nft.asset;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A NFT withdraw withdraw request
 * <p>
 * The max interval between startTime and endTime is 90 days.
 * <p>
 * If startTime and endTime are not sent, the recent 7 days' data will be
 * returned.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NFTAssetRequest extends FramedRequest {
    /** The result size. Default 50, Max 50. */
    private Integer limit = 50;
    /** The result page. Default 1. */
    private Integer page = 1;

    /**
     * Constructor
     */
    public NFTAssetRequest() {
        super(3000);
    }

    /**
     * Constructor
     * 
     * @param limit The result size. Default 50, Max 50.
     * @param page  The result page. Default 1.
     */
    public NFTAssetRequest(int limit, int page) {
        this();
        this.limit = limit;
        this.page = page;
    }
}
