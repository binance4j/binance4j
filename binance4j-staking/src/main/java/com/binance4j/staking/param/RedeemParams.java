package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/** The {@link StakingClient} params. */
public class RedeemParams extends Params {
	/** The product type. */
	@Mandatory
	ProductType product;
	/** The product id. */
	@Mandatory
	String productId;
	/** The position id. Mandatory if product is {@code STAKING} or {@code L_DEFI}. */
	String positionId;
	/** The amount to purchase. Mandatory if product is {@code F_DEFI}. */
	String amount;

	/**
	 * @param product   The product type.
	 * @param productId The product id.
	 */
	public RedeemParams(ProductType product, String productId) {
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
	 * @return the positionId
	 */
	public String getPositionId() {
		return positionId;
	}

	/**
	 * @param positionId the positionId to set
	 */
	public void setPositionId(String positionId) {
		this.positionId = positionId;
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
