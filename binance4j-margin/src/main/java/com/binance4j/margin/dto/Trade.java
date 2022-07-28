package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public record Trade(
		/** The trade id. */
		long id,
		/** The related order id. */
		long orderId,
		/** The traded symbol. */
		String symbol,
		/** The commission asset . */
		String commissionAsset,
		/** The commission amount. */
		String commission,
		/** The trade price. */
		String price,
		/** The traded quantity. */
		@JsonProperty("qty") String quantity,
		/** The transaction time. */
		long time,
		/** Is it the best match? */
		boolean isBestMatch,
		/** Is it a buyer trade? */
		boolean isBuyer,
		/** Is it a maker trade? */
		boolean isMaker,
		/** Is it an isolated trade? */
		boolean isIsolated) {
}