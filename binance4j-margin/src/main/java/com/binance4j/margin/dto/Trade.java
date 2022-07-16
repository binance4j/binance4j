package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
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
		BigDecimal commission,
		/** The trade price. */
		BigDecimal price,
		/** The traded quantity. */
		@JsonProperty("qty") BigDecimal quantity,
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