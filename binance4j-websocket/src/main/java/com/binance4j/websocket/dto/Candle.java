package com.binance4j.websocket.dto;

import com.binance4j.websocket.serialization.CandlestickEventDeserializer;
import com.binance4j.websocket.serialization.CandlestickEventSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Kline/candle for a symbol.
 * 
 * @param openTime                 The candlestick open timestamp in milliseconds
 * @param open                     The Open value
 * @param high                     The High value
 * @param low                      The Low value
 * @param close                    The Close value
 * @param volume                   The traded volume in the interval
 * @param closeTime                The candlestick close timestamp in milliseconds
 * @param quoteAssetVolume         The quote asset traded volume
 * @param numberOfTrades           The number of trades
 * @param takerBuyBaseAssetVolume  Taker buy base asset volume
 * @param takerBuyQuoteAssetVolume Taker buy quote asset volume
 * @param eventType                The event type.
 * @param eventTime                The timestamp in ms.
 * @param symbol                   The trading pair.
 * @param intervalId               The interval id.
 * @param firstTradeId             The first trade id.
 * @param lastTradeId              The last trade id.
 * @param isBarFinal               Is it the last bar of the interval?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(shape = Shape.OBJECT)
@JsonDeserialize(using = CandlestickEventDeserializer.class)
@JsonSerialize(using = CandlestickEventSerializer.class)
@ApiModel("")
public record Candle(@ApiModelProperty("") Long openTime, @ApiModelProperty("") String open, @ApiModelProperty("") String high,
		@ApiModelProperty("") String low, @ApiModelProperty("") String close, @ApiModelProperty("") String volume, @ApiModelProperty("") Long closeTime,
		@ApiModelProperty("") String quoteAssetVolume, @ApiModelProperty("") Long numberOfTrades, @ApiModelProperty("") String takerBuyBaseAssetVolume,
		@ApiModelProperty("") String takerBuyQuoteAssetVolume, @ApiModelProperty("") String eventType, @ApiModelProperty("") Long eventTime,
		@ApiModelProperty("") String symbol, @ApiModelProperty("") String intervalId, @ApiModelProperty("") Long firstTradeId,
		@ApiModelProperty("") Long lastTradeId, @ApiModelProperty("") Boolean isBarFinal) {
}