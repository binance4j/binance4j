package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * {@link StakingClient#getPosition} params.
 * 
 * @param product   Product type.
 * @param productId Product id.
 * @param asset     Product name.
 */
public record PositionParams(@Mandatory ProductType product, String productId, String asset) implements Params {

	/**
	 * Creates an instance of {@code PositionParams}.
	 * 
	 * @param product Product type.
	 */
	public PositionParams(ProductType product) {
		this(product, null, null);
	}

	/**
	 * Creates an instance of {@code PositionParams}.
	 * 
	 * @param product   Product type.
	 * @param productId Product id.
	 */
	public PositionParams(ProductType product, String productId) {
		this(product, productId, null);
	}

	/**
	 * Creates an instance of {@code PositionParams}.
	 * 
	 * @param product Product type.
	 * @param asset   Product name.
	 */
	public PositionParams(String asset, ProductType product) {
		this(product, null, asset);
	}

}