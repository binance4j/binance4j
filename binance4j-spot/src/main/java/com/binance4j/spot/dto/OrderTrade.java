package com.binance4j.spot.dto;

/**
 * The partial trade of an order.
 * 
 * @param price           The price.
 * @param qty             The quantity.
 * @param commission      The commission.
 * @param commissionAsset The commission asset.
 * @param tradeId         The trade id.
 */
public record OrderTrade(String price, String qty, String commission, String commissionAsset, long tradeId) {
}
