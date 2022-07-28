package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.dto.TransactionType;
import com.fasterxml.jackson.annotation.JsonProperty;

/** {@link StakingClient} params. */
public class HistoryParams implements Params {
	/** The product type. */
	@Mandatory
	ProductType product;
	/** The transaction type. */
	@Mandatory
	@JsonProperty("txnType")
	TransactionType transactionType;
	/** The product name. */
	String asset;
	/** The starting timestamp of the results */
	Long startTime;
	/** The ending timestamp of the results */
	Long endTime;
	/** The desired page. Start from 1. Default:1 */
	Long current;
	/** The result size. Default:10, Max:100 */
	Long size;

	/**
	 * @param product The product type.
	 * @param txnType The transaction type.
	 */
	public HistoryParams(ProductType product, TransactionType txnType) {

		this.product = product;
		this.transactionType = txnType;
	}

	/**
	 * @return the product
	 */
	public ProductType getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductType product) {
		this.product = product;
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

	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
}