package com.binance4j.market.trade;

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
	 * The agg trade pair
	 */
	private String symbol;
	/**
	 * id to get aggregate trades from (inclusive).
	 */
	private Long fromId;
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
	 * @param symbol The agg trade pair
	 */
	public AggTradeRequest(String symbol) {
		super(1);
		this.symbol = symbol;
	}

	/**
	 * Constructor with limit
	 *
	 * @param symbol The agg trade pair
	 * @param limit  The result size. Default 500; max 1000.
	 */
	public AggTradeRequest(String symbol, Integer limit) {
		this(symbol);
		this.limit = limit;
	}

	/**
	 * Constructor with fromId
	 *
	 * @param symbol The agg trade pair
	 * @param fromId The id to get aggregate trades from (inclusive).
	 */
	public AggTradeRequest(String symbol, Long fromId) {
		this(symbol);
		this.fromId = fromId;
	}

	/**
	 * Constructor with fromId and limit
	 *
	 * @param symbol The agg trade pair
	 * @param fromId The id to get aggregate trades from (inclusive).
	 * @param limit  The result size. Default 500; max 1000.
	 */
	public AggTradeRequest(String symbol, Long fromId, Integer limit) {
		this(symbol, limit);
		this.fromId = fromId;
	}

	/**
	 * Constructor with fromId
	 *
	 * @param symbol The agg trade pair
	 * @param fromId The id to get aggregate trades from (inclusive).
	 */
	public AggTradeRequest(String symbol, String fromId) {
		this(symbol, Long.getLong(fromId));
	}

	/**
	 * Constructor with fromId and limit
	 *
	 * @param symbol The agg trade pair
	 * @param fromId The id to get aggregate trades from (inclusive).
	 * @param limit  The result size. Default 500; max 1000.
	 */
	public AggTradeRequest(String symbol, String fromId, Integer limit) {
		this(symbol, limit);
		this.fromId = Long.getLong(fromId);
	}

	/**
	 * Constructor with start and end time (time interval must be lower to one hour)
	 *
	 * @param symbol    The agg trade pair
	 * @param startTime Timestamp in ms to get aggregate trades from (inclusive).
	 * @param endTime   Timestamp in ms to get aggregate trades until (inclusive).
	 */
	public AggTradeRequest(String symbol, Long startTime, Long endTime) {
		this(symbol);
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
