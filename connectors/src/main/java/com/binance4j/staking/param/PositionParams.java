package com.binance4j.staking.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * [StakingClient.getPosition] params.
 * 
 * @param product   Product type.
 * @param productId Product id.
 * @param asset     Product name.
 */
@Param
data class PositionParams(
String product, String productId,
String asset):Params
{

	/**
	 * Creates an instance of {@link PositionParams}.
	 * 
	 * @param product   Product type.
	 * @param productId Product id.
	 * @param asset     Product name.
	 */
	public PositionParams(ProductType product, String productId, String asset) {
		this(product.toString(), productId, asset);
	}

	/**
	 * Creates an instance of {@link PositionParams}.
	 * 
	 * @param product Product type.
	 */
	public PositionParams(ProductType product) {
		this(product.toString(), null, null);
	}

	/**
	 * Creates an instance of {@link PositionParams}.
	 * 
	 * @param product   Product type.
	 * @param productId Product id.
	 */
	public PositionParams(ProductType product, String productId) {
		this(product.toString(), productId, null);
	}

	/**
	 * Creates an instance of {@link PositionParams}.
	 * 
	 * @param product Product type.
	 * @param asset   Product name.
	 */
	public PositionParams(String asset, ProductType product) {
		this(product.toString(), null, asset);
	}
}