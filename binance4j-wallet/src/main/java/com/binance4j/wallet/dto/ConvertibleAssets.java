package com.binance4j.wallet.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Assets that can be converted into BNB */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ConvertibleAssets(List<ConvertibleAsset> details,
		/** The BTC valuation. */
		BigDecimal totalTransferBtc,
		/** The BNB valuation. */
		BigDecimal totalTransferBNB,
		/** The commission fee. */
		BigDecimal dribbletPercentage) {
}
