package com.binance4j.staking.param;

import java.math.BigDecimal;

import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/** The {@link StakingClient} params. */
public class RedeemParams extends Params {
	/** The product type. */
	ProductType product;
	/** The position id. Mandatory if product is {@code STAKING} or {@code L_DEFI}. */
	String positionId;
	/** The product id. */
	String productId;
	/** The amount to purchase. Mandatory if product is {@code F_DEFI}. */
	BigDecimal amount;

	/**
	 * @param product   The product type.
	 * @param productId The product id.
	 */
	public RedeemParams(ProductType product, String productId) {
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
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
