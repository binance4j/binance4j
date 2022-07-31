package com.binance4j.wallet.dto;

/**
 * A deposit address for a given asset.
 * 
 * @param url     The deposit url.
 * @param address The deposit address.
 * @param tag     The deposit tag.
 * @param coin    The coin abbreviation.
 */
public record DepositAddress(String url, String address, String tag, String coin) {
}