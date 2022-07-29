package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.Featured;
import com.binance4j.savings.dto.FlexibleProductStatus;

/**
 * {@link SavingsClient#getFlexibleProducts} params.
 * 
 * @param status   The product status.
 * @param featured Featured.
 */
public record FlexibleProductsParams(FlexibleProductStatus status, Featured featured) implements Params {
	/**
	 * Creates an instance of {@link FlexibleProductsParams}.
	 */
	public FlexibleProductsParams() {
		this(null, null);
	}

	/**
	 * Creates an instance of {@link FlexibleProductsParams}.
	 * 
	 * @param status The product status.
	 */
	public FlexibleProductsParams(FlexibleProductStatus status) {
		this(status, null);
	}

	/**
	 * Creates an instance of {@link FlexibleProductsParams}.
	 * 
	 * @param featured Featured.
	 */
	public FlexibleProductsParams(Featured featured) {
		this(null, featured);
	}
}