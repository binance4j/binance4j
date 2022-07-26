package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.ProductType;

/** The {@link SavingsClient#getLeftDailyRedemptionQuota} params. */
public class RedemptionQuotaParams extends Params {
	/** The product id. */
	String productId;
	/** The product type. */
	ProductType type;

	/**
	 * @param productId The product id.
	 * @param type      The product type.
	 */
	public RedemptionQuotaParams(String productId, ProductType type) {
		super(1);
		this.productId = productId;
		this.type = type;
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
	 * @return the type
	 */
	public ProductType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ProductType type) {
		this.type = type;
	}
}