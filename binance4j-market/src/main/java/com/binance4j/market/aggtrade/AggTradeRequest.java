package com.binance4j.market.aggtrade;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to get compressed, aggregate trades. Trades that fill at the
 * time, from the same order, with the same price will have the quantity
 * aggregated.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AggTradeRequest extends Request {
    /**
     * The agg trade trading pair
     */
    private String symbol;
    /**
     * id to get aggregate trades from (inclusive).
     */
    private String fromId;
    /**
     * Default 500; max 1000.
     */
    private Integer limit;
    /**
     * Timestamp in ms to get aggregate trades from (inclusive).
     */
    private Long startTime;
    /**
     * Timestamp in ms to get aggregate trades until (inclusive).
     */
    private Long endTime;

    /**
     * Default constructor
     * 
     * @param symbol The agg trade trading pair
     */
    public AggTradeRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }

    /**
     * Constructor with limit
     * 
     * @param symbol The agg trade trading pair
     * @param limit  The result size
     */
    public AggTradeRequest(String symbol, Integer limit) {
        this(symbol);
        this.limit = limit;
    }

    /**
     * Constructor with fromId
     * 
     * @param symbol The agg trade trading pair
     * @param fromId The id to get aggregate trades from (inclusive).
     */
    public AggTradeRequest(String symbol, String fromId) {
        this(symbol);
        this.fromId = fromId;
    }

    /**
     * Constructor with fromId and limit
     * 
     * @param symbol The agg trade trading pair
     * @param fromId The id to get aggregate trades from (inclusive).
     * @param limit  The result size
     */
    public AggTradeRequest(String symbol, String fromId, Integer limit) {
        this(symbol, limit);
        this.fromId = fromId;
    }

    /**
     * Constructor with start and end time
     * 
     * @param symbol    The agg trade trading pair
     * @param startTime Timestamp in ms to get aggregate trades from (inclusive).
     * @param endTime   Timestamp in ms to get aggregate trades until (inclusive).
     */
    public AggTradeRequest(String symbol, Long startTime, Long endTime) {
        this(symbol);
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
