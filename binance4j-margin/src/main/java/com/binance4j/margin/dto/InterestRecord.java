package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Interest record in a {@link InterestHistory}
 * 
 * @param isolatedSymbol      The isolated symbol. Will not be returned for crossed margin.
 * @param asset               The related asset.
 * @param rawAsset            The related raw asset. Will not be returned for isolated margin.
 * @param interest            The interest.
 * @param interestAccuredTime Interest accrued (?) time.
 * @param interestRate        The interest rate.
 * @param principal           The borrowed quantity (?).
 * @param type                The interest type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record InterestRecord(
		/** The isolated symbol. Will not be returned for crossed margin */
		Optional<String> isolatedSymbol,
		/** The related asset. */
		String asset,
		/** The related raw asset. Will not be returned for isolated margin. */
		Optional<String> rawAsset,
		/** The interest. */
		BigDecimal interest,
		/** Interest accrued (?) time. */
		long interestAccuredTime,
		/** The interest rate. */
		BigDecimal interestRate,
		/** The borrowed quantity (?). */
		BigDecimal principal,
		/** The interest type. */
		InterestType type) {
}