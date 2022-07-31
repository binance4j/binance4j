package com.binance4j.core.param;

/**
 * Time interval seach.
 * 
 * @param startTime Start time in ms.
 * @param endTime   End time in ms.
 * @param limit     Results limit.
 */
public record TimeFrame(Long startTime, Long endTime, Integer limit) implements Params {

	/**
	 * Creates an instance of {@link TimeFrame}.
	 * 
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 */
	public TimeFrame(Long startTime, Long endTime) {
		this(startTime, endTime, null);
	}

	/**
	 * Creates an instance of {@link TimeFrame}.
	 * 
	 * @param limit The results limit.
	 */
	public TimeFrame(Integer limit) {
		this(null, null, limit);
	}
}