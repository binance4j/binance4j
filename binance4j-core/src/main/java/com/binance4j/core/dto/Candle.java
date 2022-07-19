package com.binance4j.core.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The representation of a candle for a symbol.
 * 
 * @param openTime                 The candlestick open timestamp in milliseconds.
 * @param open                     The Open value.
 * @param high                     The High value.
 * @param low                      The Low value.
 * @param close                    The Close value.
 * @param volume                   The traded volume in the interval.
 * @param closeTime                The candlestick close timestamp in milliseconds.
 * @param quoteAssetVolume         The quote asset traded volume.
 * @param numberOfTrades           The number of trades.
 * @param takerBuyBaseAssetVolume  Taker buy base asset volume.
 * @param takerBuyQuoteAssetVolume Taker buy quote asset volume.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Candle(
		/** The candlestick open timestamp in milliseconds */
		long openTime,
		/** The Open value */
		BigDecimal open,
		/** The High value */
		BigDecimal high,
		/** The Low value */
		BigDecimal low,
		/** The Close value */
		BigDecimal close,
		/** The traded volume in the interval */
		BigDecimal volume,
		/** The candlestick close timestamp in milliseconds */
		long closeTime,
		/** The quote asset traded volume */
		BigDecimal quoteAssetVolume,
		/** The number of trades */
		long numberOfTrades,
		/** Taker buy base asset volume */
		BigDecimal takerBuyBaseAssetVolume,
		/** Taker buy quote asset volume */
		BigDecimal takerBuyQuoteAssetVolume) {

	/**
	 * accepting a list of String acting like a line of data in a csv file
	 * 
	 * @param input The String input.
	 */
	public Candle(List<String> input) {
		this(Long.parseLong(input.get(0)), new BigDecimal(input.get(1)), new BigDecimal(input.get(2)), new BigDecimal(input.get(3)),
				new BigDecimal(input.get(4)), new BigDecimal(input.get(5)), Long.parseLong(input.get(6)), new BigDecimal(input.get(7)),
				Long.parseLong(input.get(8)), new BigDecimal(input.get(9)), new BigDecimal(input.get(10)));
	}
}
