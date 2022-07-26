package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.Featured;
import com.binance4j.savings.dto.FlexibleProductStatus;

/** The {@link SavingsClient#getFlexibleProducts} params. */
public class FlexibleProductsParams extends Params {
	FlexibleProductStatus status;
	Featured featured;
	Long current;
	Long size;

	/**
	 * Constructor.
	 */
	public FlexibleProductsParams() {
		super(1);
	}

	/**
	 * @return the status
	 */
	public FlexibleProductStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(FlexibleProductStatus status) {
		this.status = status;
	}

	/**
	 * @return the featured
	 */
	public Featured getFeatured() {
		return featured;
	}

	/**
	 * @param featured the featured to set
	 */
	public void setFeatured(Featured featured) {
		this.featured = featured;
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
