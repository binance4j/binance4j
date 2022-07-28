package com.binance4j.savings.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.ProductType;

/** {@link SavingsClient#redeemFlexible} params. */
public class RedemptionParams implements Params {
	/** The product id. */
	@Mandatory
	String productId;
	/** The amount. */
	@Mandatory
	String amount;
	/** The product type. */
	@Mandatory
	ProductType type;

	/**
	 * @param productId The product id.
	 * @param amount    The amount.
	 * @param type      The product type.
	 */
	public RedemptionParams(String productId, String amount, ProductType type) {
		this.productId = productId;
		this.amount = amount;
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