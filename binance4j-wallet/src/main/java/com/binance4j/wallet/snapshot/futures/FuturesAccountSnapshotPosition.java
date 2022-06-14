package com.binance4j.wallet.snapshot.futures;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesAccountSnapshotPosition {
	/**
	 * The asset pair
	 */
	private String symbol;
	/**
	 * The entry price
	 */
	private BigDecimal entryPrice;
	/**
	 * ???
	 */
	private BigDecimal markPrice;
	/**
	 * The position amount
	 */
	private BigDecimal positionAmt;
	/**
	 * Only show the value at the time of opening the position
	 */
	private BigDecimal unRealizedProfit;
}