package com.binance4j.savings.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/** The {@link SavingsClient#getLeftDailyFlexiblePurchaseQuota} params. */
public class PurchaseQuotaParams implements Params {
	/** The product id. */
	@Mandatory
	String productId;

	/**
	 * Constructor.
	 * 
	 * @param productId The product id.
	 */
	public PurchaseQuotaParams(String productId) {
		this.productId = productId;
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