package com.binance4j.staking.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * [StakingClient.purchase] params.
 * 
 * @param product   Product type.
 * @param productId Product id.
 * @param amount    Amount to purchase.
 * @param renewable Renew purchase? Active if product is {@code STAKING} or
 *                  {@code L_DEFI}.
 */
@Param
data class PurchaseParams(
String product, String productId,
String amount, Boolean renewable):Params
{

	/**
	 * Creates an instance of {@link PurchaseParams}.
	 * 
	 * @param product   Product type.
	 * @param productId Product id.
	 * @param amount    Amount to purchase.
	 * @param renewable Renew purchase? Active if product is {@code STAKING} or
	 *                  {@code L_DEFI}.
	 */
	public PurchaseParams(ProductType product, String productId, String amount, Boolean renewable) {
		this(product.toString(), productId, amount, renewable);
	}

	/**
	 * Creates an instance of {@link PurchaseParams}.
	 * 
	 * @param product   Product type.
	 * @param productId Product id.
	 * @param amount    Amount to purchase.
	 */
	public PurchaseParams(ProductType product, String productId, String amount) {
		this(product, productId, amount, null);
	}
}