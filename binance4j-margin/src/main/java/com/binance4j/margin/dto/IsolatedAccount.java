package com.binance4j.margin.dto;

import java.util.List;

/**
 * Isolated margin account info
 * 
 * @param assets              The owned assets.
 * @param totalAssetOfBtc     Total asset of Bitcoin.
 * @param totalLiabilityOfBtc Total liability of Bitcoin.
 * @param totalNetAssetOfBtc  Total net asset of Bitcoin.
 */
public record IsolatedAccount(List<IsolatedPair> assets, String totalAssetOfBtc, String totalLiabilityOfBtc, String totalNetAssetOfBtc) {
}