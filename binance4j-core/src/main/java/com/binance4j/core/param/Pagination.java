package com.binance4j.core.param;

/**
 * Pagination search params.
 * 
 * @param page The results page.
 * @param rows The number of rows.
 */
public record Pagination(Integer page, Integer rows) implements Params {
	/** Creates an instance of {@link Pagination} */
	public Pagination() {
		this(null, null);
	}
}