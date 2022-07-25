package com.binance4j.staking.param;

import java.math.BigDecimal;

import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/** The {@link StakingClient} params. */
public class PurchaseParams extends Params {
	/** The product type. */
	ProductType product;
	/** The product id. */
	String productId;
	/** The amount to purchase. */
	BigDecimal amount;
	/** Renew purchase? Active if product is {@code STAKING} or {@code L_DEFI}. */
	Boolean renewable;

	/**
	 * @param product   The product type.
	 * @param productId The product id.
	 * @param amount    The amount to purchase.
	 */
	public PurchaseParams(ProductType product, String productId, BigDecimal amount) {
		super(1);
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
	public PurchaseParams(ProductType product, String productId, BigDecimal amount, Boolean renewable) {
		super(1);
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
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
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