package com.binance4j.wallet.snapshot.margin;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginAccountSnapshotData {
	/** Margin level. */
	private BigDecimal marginLevel;
	/** Total asset of Bitcoin. */
	private BigDecimal totalAssetOfBtc;
	/** Total liability Of Bitcoin. */
	private BigDecimal totalLiabilityOfBtc;
	/** Total net Asset of Bitcoin. */
	private BigDecimal totalNetAssetOfBtc;
	/** User assets. */
	private List<MarginAccountSnapshotUserAssets> userAssets;
}