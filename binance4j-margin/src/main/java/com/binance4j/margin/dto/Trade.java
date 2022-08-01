package com.binance4j.margin.dto;

/**
 * A trade being part of a {@link NewOrderRecord}
 * 
 * @param id              The trade id.
 * @param orderId         The related order id.
 * @param symbol          The traded symbol.
 * @param commissionAsset The commission asset .
 * @param commission      The commission amount.
 * @param price           The trade price.
 * @param quantity        The traded quantity.
 * @param time            The transaction time.
 * @param isBestMatch     Is it the best match?
 * @param isBuyer         Is it a buyer trade?
 * @param isMaker         Is it a maker trade?
 * @param isIsolated      Is it an isolated trade?
 */
public record Trade(long id, long orderId, String symbol, String commissionAsset, String commission, String price, String qty, long time, boolean isBestMatch,
		boolean isBuyer, boolean isMaker, boolean isIsolated) {
}