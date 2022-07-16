package com.binance4j.core.param;

/** The base of a request with a recvWindow and a timestamp */
public abstract class FramedParams extends Params {
	/** The request timestamp */
	protected long timestamp = System.currentTimeMillis();

	protected FramedParams() {
		super();
	}

	/**
	 * @param weight The Request weight
	 */
	protected FramedParams(int weight) {
		super(weight, false);
	}

	/**
	 * @param weight         The Request weight
	 * @param isOrderRequest Is the request a trading order
	 */
	protected FramedParams(int weight, Boolean isOrderRequest) {
		super(weight, isOrderRequest);
	}

	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}