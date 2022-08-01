package com.binance4j.core.dto;

/**
 * An executed trade
 * 
 * @param id              Trade id.
 * @param price           Price.
 * @param qty             Quantity.
 * @param quoteQty        Quote quantity for the trade (price * qty).
 * @param commission      Commission.
 * @param commissionAsset Asset on which commission is taken.
 * @param time            Trade execution time.
 * @param symbol          The symbol of the trade.
 * @param orderId         The order id.
 * @param isBuyer         Is buyer trade.
 * @param isMaker         Is maker trade.
 * @param isBestMatch     Is best match?
 */
public record Trade(long id, String price, String qty, String quoteQty, String commission, String commissionAsset, long time, String symbol, String orderId,
		boolean isBuyer, boolean isMaker, boolean isBestMatch) {
}