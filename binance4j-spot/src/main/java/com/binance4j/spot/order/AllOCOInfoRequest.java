package com.binance4j.spot.order;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** Request to retrieve all OCO based on provided optional parameters */
@Data
@EqualsAndHashCode(callSuper = true)
public class AllOCOInfoRequest extends IntervalRequest {
    /**
     * The id to search from
     */
    private Long fromId;
    /**
     * The result size. Default Value: 500; Max Value: 1000
     */
    private Integer limit;

    /** Default constructor */
    public AllOCOInfoRequest() {
        super(10);
    }

    /**
     * Constructor
     * 
     * @param fromId The id to search from
     */
    public AllOCOInfoRequest(Long fromId) {
        this();
        this.fromId = fromId;
    }

    /**
     * Constructor
     * 
     * @param limit The result size
     */
    public AllOCOInfoRequest(Integer limit) {
        this();
        this.limit = limit;
    }

    /**
     * Constructor
     * 
     * @param fromId The id to search from
     * @param limit  The result size
     */
    public AllOCOInfoRequest(Long fromId, Integer limit) {
        this();
        this.fromId = fromId;
        this.limit = limit;
    }
}
