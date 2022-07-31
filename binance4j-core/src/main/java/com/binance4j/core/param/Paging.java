package com.binance4j.core.param;

/**
 * Paging search params.
 * 
 * @param page  The results page.
 * @param limit The number of rows.
 */
public record Paging(Integer page, Integer limit) implements Params {
	/**
	 * Creates an instance of {@link Paging}.
	 * 
	 * @param page The results page.
	 */
	public Paging(Integer page) {
		this(page, null);
	}
}