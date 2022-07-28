package com.binance4j.savings.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.LendingType;

/**
 * The {@link SavingsClient#getInterests}, {@link SavingsClient#getPurchases},{@link SavingsClient#getRedemptions}
 * params.
 */
public class LendingParams extends Params {
	/** Lending type. */
	@Mandatory
	LendingType lendingType;
	/** Asset name. */
	String asset;
	/** Start time in ms. */
	Long startTime;
	/** End time in ms. */
	Long endTime;
	/** Current page. */
	Long current;
	/** Page size. */
	Long size;

	/**
	 * @param lendingType Lending type.
	 */
	public LendingParams(LendingType lendingType) {
		this.lendingType = lendingType;
	}

	/**
	 * @return the lendingType
	 */
	public LendingType getLendingType() {
		return lendingType;
	}

	/**
	 * @param lendingType the lendingType to set
	 */
	public void setLendingType(LendingType lendingType) {
		this.lendingType = lendingType;
	}

	/**
	 * @return the asset
	 */
	public String getAsset() {
		return asset;
	}

	/**
	 * @param asset the asset to set
	 */
	public void setAsset(String asset) {
		this.asset = asset;
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

	/**
	 * @return the current
	 */
	public Long getCurrent() {
		return current;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(Long current) {
		this.current = current;
	}

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}

}
