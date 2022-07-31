package com.binance4j.margin.dto;

/**
 * Asset balance of an {@link Account}.
 * 
 * @param asset    The asset name.
 * @param borrowed The borrowed quantity.
 * @param free     The free quantity.
 * @param interest The borrow interest.
 * @param locked   The locked quantity.
 * @param netAsset The net asset.
 */
public record AssetBalance(String asset, String borrowed, String free, String interest, String locked, String netAsset) {
}