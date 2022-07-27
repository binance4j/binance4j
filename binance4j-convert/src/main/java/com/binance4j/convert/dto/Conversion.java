package com.binance4j.convert.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A conversion of an asset into another.
 * 
 * @param quoteId      Quote Id
 * @param orderId      Order Id
 * @param orderStatus  Order Status
 * @param fromAsset    From Asset
 * @param fromAmount   From Amount
 * @param toAsset      To Asset
 * @param toAmount     To Amount
 * @param ratio        Ratio
 * @param inverseRatio Inverse Ratio
 * @param createTime   Create Time
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Conversion(
		/** Quote Id */
		String quoteId,
		/** Order Id */
		long orderId,
		/** Order Status */
		String orderStatus,
		/** From Asset */
		String fromAsset,
		/** From Amount */
		String fromAmount,
		/** To Asset */
		String toAsset,
		/** To Amount */
		String toAmount,
		/** Ratio */
		String ratio,
		/** Inverse Ratio */
		String inverseRatio,
		/** Create Time */
		long createTime) {
}
