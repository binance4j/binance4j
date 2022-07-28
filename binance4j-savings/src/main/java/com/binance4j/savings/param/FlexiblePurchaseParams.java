package com.binance4j.savings.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/** The {@link SavingsClient#purchaseFlexible} params. */
public class FlexiblePurchaseParams extends Params {
	/** The product id. */
	@Mandatory
	String productId;
	/** The amount. */
	@Mandatory
	String amount;

	/**
	 * @param productId The product id.
	 * @param amount    The amount.
	 */
	public FlexiblePurchaseParams(String productId, String amount) {
		this.productId = productId;
		this.amount = amount;
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
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
}