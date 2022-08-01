package com.binance4j.staking.param;

import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * {@link StakingClient#getProducts} params.
 * 
 * @param product The product type.
 * @param asset   The product name.
 */
public record ProductListParams(ProductType product, String asset) implements Params {
	/**
	 * Creates an instance of {@link ProductListParams}.
	 * 
	 * @param product The product type.
	 */
	public ProductListParams(ProductType product) {
		this(product, null);
	}
}