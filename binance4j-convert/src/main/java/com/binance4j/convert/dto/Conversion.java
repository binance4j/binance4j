package com.binance4j.convert.dto;

/**
 * A conversion of an asset into another.
 * 
 * @param quoteId      Quote Id.
 * @param orderId      Order Id.
 * @param orderStatus  Order Status.
 * @param fromAsset    From Asset.
 * @param fromAmount   From Amount.
 * @param toAsset      To Asset.
 * @param toAmount     To Amount.
 * @param ratio        Ratio.
 * @param inverseRatio Inverse Ratio.
 * @param createTime   Create Time in ms.
 */
public record Conversion(String quoteId, long orderId, String orderStatus, String fromAsset, String fromAmount, String toAsset, String toAmount, String ratio,
		String inverseRatio, long createTime) {
}
