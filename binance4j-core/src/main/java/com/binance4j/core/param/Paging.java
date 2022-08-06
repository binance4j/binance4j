package com.binance4j.core.param;

/**
 * Paging search params.
 * 
 * @param page  Results page.
 * @param limit Number of rows.
 */
public record Paging(Integer page, Integer limit) implements Params {
	/**
	 * Creates an instance of {@link Paging}.
	 * 
	 * @param page  Results page.
	 * @param limit Number of rows.
	 */
	public Paging(Integer page, Integer limit) {
		this.page = page;
		this.limit = limit;
	}

	/**
	 * Creates an instance of {@link Paging}.
	 * 
	 * @param page Results page.
	 */
	public Paging(Integer page) {
		this(page, null);
	}
}