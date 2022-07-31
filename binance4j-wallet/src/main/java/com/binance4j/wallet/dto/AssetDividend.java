package com.binance4j.wallet.dto;

/**
 * An asset divident.
 * 
 * @param amount  The divident amount.
 * @param enInfo  Info about the asset.
 * @param asset   The asset abbreviation.
 * @param id      The id.
 * @param divTime Dividend time in ms.
 * @param tranId  The transaction id.
 */
public record AssetDividend(String amount, String enInfo, String asset, long id, long divTime, long tranId) {
}