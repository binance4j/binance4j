package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.Featured;
import com.binance4j.savings.dto.FlexibleProductStatus;

/**
 * [SavingsClient.getFlexibleProducts] params.
 * 
 * @param status   Product status.
 * @param featured Featured.
 */
@Param
data class FlexibleProductsParams(
String status, String featured):Params
{

	/**
	 * Creates an instance of {@link FlexibleProductsParams}.
	 */
	public FlexibleProductsParams() {
		this((String) null, (String) null);
	}

	/**
	 * Creates an instance of {@link FlexibleProductsParams}.
	 * 
	 * @param status   Product status.
	 * @param featured Featured.
	 */
	public FlexibleProductsParams(FlexibleProductStatus status, Featured featured) {
		this(status == null ? null : status.toString(), featured == null ? null : featured.toString());
	}

	/**
	 * Creates an instance of {@link FlexibleProductsParams}.
	 * 
	 * @param status Product status.
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