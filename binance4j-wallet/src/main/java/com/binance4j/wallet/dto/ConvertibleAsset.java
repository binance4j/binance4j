package com.binance4j.wallet.dto;

/**
 * Asset that can be converted into BNB.
 * 
 * @param asset            The asset name.
 * @param assetFullName    The asset full name.
 * @param amountFree       The free balance.
 * @param toBTC            The BTC valuation.
 * @param toBNB            The BNB valuation.
 * @param toBNBOffExchange The BNB valuation commissions fees deducted.
 * @param exchange         Commission fees.
 */
public record ConvertibleAsset(
		/** The asset name. */
		String asset,
		/** The asset full name. */
		String assetFullName,
		/** The free balance. */
		String amountFree,
		/** The BTC valuation. */
		String toBTC,
		/** The BNB valuation. */
		String toBNB,
		/** The BNB valuation commissions fees deducted. */
		String toBNBOffExchange,
		/** Commission fees. */
		String exchange) {
}
