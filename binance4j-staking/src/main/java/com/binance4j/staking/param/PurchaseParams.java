package com.binance4j.staking.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * {@link StakingClient#purchase} params.
 * 
 * @param product   The product type.
 * @param productId The product id.
 * @param amount    The amount to purchase.
 * @param renewable Renew purchase? Active if product is {@code STAKING} or {@code L_DEFI}.
 */
@Param
public record PurchaseParams(ProductType product, String productId, String amount, Boolean renewable) implements Params {
	/**
	 * Creates an instance of {@link PurchaseParams}.
	 * 
	 * @param product   The product type.
	 * @param productId The product id.
	 * @param amount    The amount to purchase.
	 */
	public PurchaseParams(ProductType product, String productId, String amount) {
		this(product, productId, amount, null);
	}
}