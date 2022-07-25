package com.binance4j.spot.param;

import com.binance4j.core.param.Params;

/** Request to retrieve all OCO based on provided optional parameters */
public class AllOCOInfoParams extends Params {
	/** The starting timestamp of the results */
	private Long startTime;
	/** The ending timestamp of the results */
	private Long endTime;

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

	/** @return the startTime */
	public Long getStartTime() {
		return startTime;
	}

	/** @param startTime the startTime to set */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/** @return the endTime */
	public Long getEndTime() {
		return endTime;
	}

	/** @param endTime the endTime to set */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}
