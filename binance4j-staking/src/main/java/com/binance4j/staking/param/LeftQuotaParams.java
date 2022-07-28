package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/** {@link StakingClient} params. */
public class LeftQuotaParams implements Params {
	/** The product type. */
	@Mandatory
	ProductType product;
	/** The product id. */
	@Mandatory
	String productId;

	/**
	 * @param product   The product type.
	 * @param productId The product id.
	 */
	public LeftQuotaParams(ProductType product, String productId) {
		this.product = product;
		this.productId = productId;
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

}
