package com.binance4j.wallet.param;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesAccountSnapshotPosition {
	/** The asset pair. */
	private String symbol;
	/** The entry price. */
	private BigDecimal entryPrice;
	/** Mark price. */
	private BigDecimal markPrice;
	/** The position amount. */
	@JsonProperty("positionAmt")
	private BigDecimal positionAmount;
	/** Only show the value at the time of opening the position. */
	private BigDecimal unRealizedProfit;
}