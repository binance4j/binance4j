package com.binance4j.core.dto;

import java.util.List;

/**
 * The representation of an aggregated trade.
 * 
 * @param a The trade id
 * @param p The price
 * @param q The quantity
 * @param f The first trade id
 * @param l The last trade id
 * @param T The timestamp
 * @param m Was it a buyer maker
 * @param M Was it the best price match?
 */
public record AggTrade(
		/** The trade id */
		long a,
		/** The price */
		String p,
		/** The quantity */
		String q,
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
		this(Long.parseLong(input.get(0)), input.get(1), input.get(2), Long.parseLong(input.get(3)), Long.parseLong(input.get(4)), Long.parseLong(input.get(5)),
				Boolean.parseBoolean(input.get(6)), Boolean.parseBoolean(input.get(7)));
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
	public String price() {
		return p;
	}

	/**
	 * @return the quantity
	 */
	public String quantity() {
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