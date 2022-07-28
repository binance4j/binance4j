package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/** {@link StakingClient} params. */
public class PositionParams implements Params {
	/** The product type. */
	@Mandatory
	ProductType product;
	/** The product id. */
	String productId;
	/** The product name. */
	String asset;
	/** The desired page. Start from 1. Default:1 */
	Long current;
	/** The result size. Default:10, Max:100 */
	Long size;

	/**
	 * @param product The product type.
	 */
	public PositionParams(ProductType product) {
		this.product = product;
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
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
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
