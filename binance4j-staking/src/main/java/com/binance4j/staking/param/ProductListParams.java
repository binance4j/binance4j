package com.binance4j.staking.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * {@link StakingClient#getProducts} params.
 * 
 * @param product Product type.
 * @param asset   Product name.
 */
@Param
public record ProductListParams(String product, String asset) implements Params {
	/**
	 * Creates an instance of {@link ProductListParams}.
	 * 
	 * @param product Product type.
	 * @param asset   Product name.
	 */
	public ProductListParams(ProductType product, String asset) {
		this(product.toString(), asset);
	}

	/**
	 * Creates an instance of {@link ProductListParams}.
	 * 
	 * @param product Product type.
	 */
	public ProductListParams(ProductType product) {
		this(product.toString(), null);
	}
}