package com.binance4j.margin.dto;

import java.util.Optional;

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
 * @see InterestType
 */
public record InterestRecord(Optional<String> isolatedSymbol, String asset, Optional<String> rawAsset, String interest, long interestAccuredTime,
		String interestRate, String principal,
		/**
		 * The interest type.
		 * 
		 * @see InterestType
		 */
		String type) {
}