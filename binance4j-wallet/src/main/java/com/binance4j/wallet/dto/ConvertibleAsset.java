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
public record ConvertibleAsset(String asset, String assetFullName, String amountFree, String toBTC, String toBNB, String toBNBOffExchange, String exchange) {
}
