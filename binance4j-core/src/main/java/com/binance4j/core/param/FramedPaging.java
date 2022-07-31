package com.binance4j.core.param;

/**
 * Framed paging search.
 * 
 * @param startTime Start time in ms.
 * @param endTime   End time in ms.
 * @param page      The result page.
 * @param limit     The results in the page.
 */
public record FramedPaging(Long startTime, Long endTime, Integer page, Integer limit) implements Params {

	/**
	 * Creates an instance of {@link FramedPaging}
	 * 
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 */
	public FramedPaging(Long startTime, Long endTime) {
		this(startTime, endTime, null, null);
	}

	/**
	 * Creates an instance of {@link FramedPaging}
	 * 
	 * @param page The result page.
	 */
	public FramedPaging(Integer page) {
		this(null, null, page, null);
	}

	/**
	 * Creates an instance of {@link FramedPaging}
	 * 
	 * @param page  The result page.
	 * @param limit The results in the page.
	 */
	public FramedPaging(Integer page, Integer limit) {
		this(null, null, page, limit);
	}
}