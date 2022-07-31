package com.binance4j.spot.dto;

/**
 * The partial trade of an order.
 * 
 * @param price           The price.
 * @param quantity        The quantity.
 * @param commission      The commission.
 * @param commissionAsset The commission asset.
 * @param tradeId         The trade id.
 */
public record OrderTrade(String price, String quantity, String commission, String commissionAsset, long tradeId) {
}
