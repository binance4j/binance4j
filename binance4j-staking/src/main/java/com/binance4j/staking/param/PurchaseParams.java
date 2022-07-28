package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/** The {@link StakingClient} params. */
public class PurchaseParams extends Params {
	/** The product type. */
	@Mandatory
	ProductType product;
	/** The product id. */
	@Mandatory
	String productId;
	/** The amount to purchase. */
	@Mandatory
	String amount;
	/** Renew purchase? Active if product is {@code STAKING} or {@code L_DEFI}. */
	Boolean renewable;

	/**
	 * @param product   The product type.
	 * @param productId The product id.
	 * @param amount    The amount to purchase.
	 */
	public PurchaseParams(ProductType product, String productId, String amount) {
		this.product = product;
		this.productId = productId;
		this.amount = amount;
	}

	/**
	 * @param product   The product type.
	 * @param productId The product id.
	 * @param amount    The amount to purchase.
	 * @param renewable Renew purchase?
	 */
	public PurchaseParams(ProductType product, String productId, String amount, Boolean renewable) {

		this.product = product;
		this.productId = productId;
		this.amount = amount;
		this.renewable = renewable;
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
	 * @return the renewable
	 */
	public Boolean getRenewable() {
		return renewable;
	}

	/**
	 * @param renewable the renewable to set
	 */
	public void setRenewable(Boolean renewable) {
		this.renewable = renewable;
	}
}