package com.binance4j.core.param;

import com.binance4j.core.client.RestClient;

/**
 * A time interval params for data search. Mostly merged with a {@link Params} in a {@link RestClient} call.
 * 
 * @param startTime Start time in ms.
 * @param endTime   End time in ms.
 * @param limit     Results limit.
 */
public record TimeIntervalParams(Long startTime, Long endTime, Integer limit) implements Params {
	/**
	 * Creates instance of {@link TimeIntervalParams}.
	 * 
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 */
	public TimeIntervalParams(Long startTime, Long endTime) {
		this(startTime, endTime, null);
	}
}