package com.binance4j.core.param;

/** A Request with a result interval */
public abstract class IntervalParams extends FramedParams {
	/** The starting timestamp of the results */
	protected Long startTime;
	/** The ending timestamp of the results */
	protected Long endTime;

	protected IntervalParams() {
		super();
	}

	/**
	 * @param weight The Request weight
	 */
	protected IntervalParams(int weight) {
		super(weight);
	}

	/**
	 * 
	 * 
	 * @param weight         The Request weight
	 * @param isOrderRequest Is the request a trading order
	 */
	protected IntervalParams(int weight, Boolean isOrderRequest) {
		super(weight, isOrderRequest);
	}

	/**
	 * @return the startTime
	 */
	public Long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Long getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}