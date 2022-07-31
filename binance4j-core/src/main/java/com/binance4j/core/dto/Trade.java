package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An executed trade
 * 
 * @param id              Trade id.
 * @param price           Price.
 * @param quantity        Quantity.
 * @param quoteQuantity   Quote quantity for the trade (price * qty).
 * @param commission      Commission.
 * @param commissionAsset Asset on which commission is taken.
 * @param time            Trade execution time.
 * @param symbol          The symbol of the trade.
 * @param orderId         The order id.
 * @param isBuyer         Is buyer trade.
 * @param isMaker         Is maker trade.
 * @param isBestMatch     Is best match?
 */
public record Trade(long id, String price, @JsonProperty("qty") String quantity, @JsonProperty("quoteQty") String quoteQuantity, String commission,
		String commissionAsset, long time, String symbol, String orderId, boolean isBuyer, boolean isMaker, boolean isBestMatch) {
}