package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * {@link StakingClient#redeem} params.
 * 
 * @param product    Product type.
 * @param productId  Product id.
 * @param positionId Position id. Mandatory if product is {@code STAKING} or {@code L_DEFI}.
 * @param amount     Amount to purchase. Mandatory if product is {@code F_DEFI}.
 */
public record RedeemParams(@Mandatory ProductType product, @Mandatory String productId, String positionId, String amount) implements Params {
	/**
	 * Creates an instance of {@code RedeemParams}.
	 * 
	 * @param product   Product type.
	 * @param productId Product id.
	 */
	public RedeemParams(ProductType product, String productId) {
		this(product, productId, null, null);
	}

	/**
	 * Creates an instance of {@code RedeemParams}.
	 * 
	 * @param product    Product type.
	 * @param productId  Product id.
	 * @param positionId Position id. Mandatory if product is {@code STAKING} or {@code L_DEFI}.
	 */
	public RedeemParams(ProductType product, String productId, String positionId) {
		this(product, productId, positionId, null);
	}

	/**
	 * Creates an instance of {@code RedeemParams}.
	 * 
	 * @param product   Product type.
	 * @param productId Product id.
	 * @param amount    Amount to purchase. Mandatory if product is {@code F_DEFI}.
	 */
	public RedeemParams(String amount, ProductType product, String productId) {
		this(product, productId, null, amount);
	}
}