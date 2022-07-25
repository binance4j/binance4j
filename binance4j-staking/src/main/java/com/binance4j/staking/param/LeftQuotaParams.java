package com.binance4j.staking.param;

import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/** The {@link StakingClient} params. */
public class LeftQuotaParams extends Params {
	/** The product type. */
	ProductType product;
	/** The product id. */
	String productId;

	/**
	 * @param product   The product type.
	 * @param productId The product id.
	 */
	public LeftQuotaParams(ProductType product, String productId) {
		super(1);
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
