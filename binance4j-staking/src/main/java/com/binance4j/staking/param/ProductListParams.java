package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * {@link StakingClient#getProducts} params.
 * 
 * @param product The product type.
 * @param asset   The product name.
 */
public record ProductListParams(@Mandatory ProductType product, String asset) implements Params {
	/**
	 * Creates an instance of {@code ProductListParams}.
	 * 
	 * @param product The product type.
	 */
	public ProductListParams(ProductType product) {
		this(product, null);
	}
}