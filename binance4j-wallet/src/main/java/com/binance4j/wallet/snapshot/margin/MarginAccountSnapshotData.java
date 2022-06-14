package com.binance4j.wallet.snapshot.margin;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginAccountSnapshotData {
	/**
	 * ???
	 */
	private BigDecimal marginLevel;
	/**
	 * ???
	 */
	private BigDecimal totalAssetOfBtc;
	/**
	 * ???
	 */
	private BigDecimal totalLiabilityOfBtc;
	/**
	 * ???
	 */
	private BigDecimal totalNetAssetOfBtc;
	/**
	 * ???
	 */
	private List<MarginAccountSnapshotUserAssets> userAssets;
}