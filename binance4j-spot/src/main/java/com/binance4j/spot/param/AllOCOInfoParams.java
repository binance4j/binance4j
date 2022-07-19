package com.binance4j.spot.param;

import com.binance4j.core.param.IntervalParams;

/** Request to retrieve all OCO based on provided optional parameters */
public class AllOCOInfoParams extends IntervalParams {
	/** The id to search from. */
	private Long fromId;
	/** The result size. Default Value: 500; Max Value: 1000 */
	private Integer limit;

	/** Default constructor. */
	public AllOCOInfoParams() {
		super(10);
	}

	/**
	 * @param fromId The id to search from.
	 */
	public AllOCOInfoParams(Long fromId) {
		this();
		this.fromId = fromId;
	}

	/**
	 * @param limit The result size.
	 */
	public AllOCOInfoParams(Integer limit) {
		this();
		this.limit = limit;
	}

	/**
	 * @param fromId The id to search from.
	 * @param limit  The result size.
	 */
	public AllOCOInfoParams(Long fromId, Integer limit) {
		this();
		this.fromId = fromId;
		this.limit = limit;
	}

	/**
	 * @return the fromId
	 */
	public Long getFromId() {
		return fromId;
	}

	/**
	 * @param fromId the fromId to set
	 */
	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
