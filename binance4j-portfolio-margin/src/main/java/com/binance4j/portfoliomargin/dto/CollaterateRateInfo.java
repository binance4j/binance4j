package com.binance4j.portfoliomargin.dto;

/**
 * Collaterate rate info.
 * 
 * @param asset          The asset.
 * @param collateralRate The collateral rate.
 */
public record CollaterateRateInfo(String asset, String collateralRate) {
}