package com.binance4j.core.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The representation of an aggregated trade.
 * 
 * @param tradeId      The trade id.
 * @param firstTradeId The first trade id.
 * @param lastTradeId  The last trade id.
 * @param time         The timestamp.
 * @param price        The price.
 * @param quantity     The quantity.
 * @param isBuyerMaker Was it a buyer maker.
 * @param isBestMatch  Was it the best price match?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AggTrade(
		/** The trade id */
		long a,
		/** The price */
		BigDecimal p,
		/** The quantity */
		BigDecimal q,
		/** The first trade id */
		long f,
		/** The last trade id */
		long l,
		/** The timestamp */
		long T,
		/** Was it a buyer maker */
		boolean m,
		/** Was it the best price match? */
		boolean M) {

	/**
	 * @param input The CSV line.
	 */
	public AggTrade(List<String> input) {
		this(Long.parseLong(input.get(0)), new BigDecimal(input.get(1)), new BigDecimal(input.get(2)), Long.parseLong(input.get(3)),
				Long.parseLong(input.get(4)), Long.parseLong(input.get(5)), Boolean.parseBoolean(input.get(6)), Boolean.parseBoolean(input.get(7)));
	}

	/**
	 * @return the tradeId
	 */
	public long tradeId() {
		return a;
	}

	/**
	 * @return the price
	 */
	public BigDecimal price() {
		return p;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal quantity() {
		return q;
	}

	/**
	 * @return the firstTradeId
	 */
	public long firstTradeId() {
		return f;
	}

	/**
	 * @return the lastTradeId
	 */
	public long lastTradeId() {
		return l;
	}

	/**
	 * @return the time
	 */
	public long time() {
		return T;
	}

	/**
	 * @return the isBuyerMaker
	 */
	public boolean isBuyerMaker() {
		return m;
	}

	/**
	 * @return the isBestMatch
	 */
	public boolean isBestMatch() {
		return M;
	}

}