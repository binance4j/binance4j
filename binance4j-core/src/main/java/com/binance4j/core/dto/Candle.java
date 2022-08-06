package com.binance4j.core.dto;

import java.util.List;

import com.binance4j.core.serialization.CandleDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An ohlc candle for a symbol.
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
@ApiModel("An ohlc candle for a symbol.")
public record Candle(@ApiModelProperty("The candlestick open timestamp in milliseconds.") long openTime, @ApiModelProperty("The Open value.") String open,
		@ApiModelProperty("The High value.") String high, @ApiModelProperty("The Low value.") String low, @ApiModelProperty("The Close value.") String close,
		@ApiModelProperty("The traded volume in the interval.") String volume,
		@ApiModelProperty("The candlestick close timestamp in milliseconds.") long closeTime,
		@ApiModelProperty("The quote asset traded volume.") String quoteAssetVolume, @ApiModelProperty("The number of trades.") long numberOfTrades,
		@ApiModelProperty("Taker buy base asset volume.") String takerBuyBaseAssetVolume,
		@ApiModelProperty("Taker buy quote asset volume.") String takerBuyQuoteAssetVolume) {
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
