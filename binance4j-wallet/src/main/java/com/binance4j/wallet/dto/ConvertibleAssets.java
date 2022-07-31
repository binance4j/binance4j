package com.binance4j.wallet.dto;

import java.util.List;

/**
 * Assets that can be converted into BNB.
 * 
 * @param details            Details.
 * @param totalTransferBtc   The BTC valuation.
 * @param totalTransferBNB   The BNB valuation.
 * @param dribbletPercentage The commission fee.
 */
public record ConvertibleAssets(List<ConvertibleAsset> details, String totalTransferBtc, String totalTransferBNB, String dribbletPercentage) {
}
