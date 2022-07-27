package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.ProductType;

/** The {@link SavingsClient#redeemFlexible} params. */
public class RedemptionParams extends Params {
	/** The product id. */
	String productId;
	/** The amount. */
	String amount;
	/** The product type. */
	ProductType type;

	/**
	 * @param productId The product id.
	 * @param amount    The amount.
	 * @param type      The product type.
	 */
	public RedemptionParams(String productId, String amount, ProductType type) {
		super(1);
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