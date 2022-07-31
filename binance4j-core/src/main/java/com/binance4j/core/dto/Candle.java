package com.binance4j.core.dto;

import java.util.List;

import com.binance4j.core.serialization.CandleDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
@JsonDeserialize(using = CandleDeserializer.class)
public record Candle(long openTime, String open, String high, String low, String close, String volume, long closeTime, String quoteAssetVolume,
		long numberOfTrades, String takerBuyBaseAssetVolume, String takerBuyQuoteAssetVolume) {
	/**
	 * accepting a list of String acting like a line of data in a csv file
	 * 
	 * @param input The String input.
	 */
	public Candle(List<String> input) {
		this(Long.parseLong(input.get(0)), input.get(1), input.get(2), input.get(3), input.get(4), input.get(5), Long.parseLong(input.get(6)), input.get(7),
				Long.parseLong(input.get(8)), input.get(9), input.get(10));
	}
}
