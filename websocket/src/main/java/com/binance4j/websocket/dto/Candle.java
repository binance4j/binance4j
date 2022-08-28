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
 * @param openTime                 Candlestick open timestamp in milliseconds
 * @param open                     Open value
 * @param high                     High value
 * @param low                      Low value
 * @param close                    Close value
 * @param volume                   Traded volume in the interval
 * @param closeTime                Candlestick close timestamp in milliseconds
 * @param quoteAssetVolume         Quote asset traded volume
 * @param numberOfTrades           Number of trades
 * @param takerBuyBaseAssetVolume  Taker buy base asset volume
 * @param takerBuyQuoteAssetVolume Taker buy quote asset volume
 * @param eventType                Event type.
 * @param eventTime                Timestamp in ms.
 * @param symbol                   Trading pair.
 * @param intervalId               Interval id.
 * @param firstTradeId             First trade id.
 * @param lastTradeId              Last trade id.
 * @param isBarFinal               Is it the last bar of the interval?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(shape = Shape.OBJECT)
@JsonDeserialize(using = CandlestickEventDeserializer.class)
@JsonSerialize(using = CandlestickEventSerializer.class)
@ApiModel("Kline/candle for a symbol.")
public record Candle(@ApiModelProperty("Candlestick open timestamp in milliseconds") Long openTime,
		@ApiModelProperty("Open value") String open,
		@ApiModelProperty("High value") String high, @ApiModelProperty("Low value") String low,
		@ApiModelProperty("Close value") String close,
		@ApiModelProperty("Traded volume in the interval") String volume,
		@ApiModelProperty("Candlestick close timestamp in milliseconds") Long closeTime,
		@ApiModelProperty("Quote asset traded volume") String quoteAssetVolume,
		@ApiModelProperty("Number of trades") Long numberOfTrades,
		@ApiModelProperty("Taker buy base asset volume") String takerBuyBaseAssetVolume,
		@ApiModelProperty("Taker buy quote asset volume") String takerBuyQuoteAssetVolume,
		@ApiModelProperty("Event type.") String eventType,
		@ApiModelProperty("Timestamp in ms.") Long eventTime, @ApiModelProperty("Trading pair.") String symbol,
		@ApiModelProperty("Interval id.") String intervalId, @ApiModelProperty("First trade id.") Long firstTradeId,
		@ApiModelProperty("Last trade id.") Long lastTradeId,
		@ApiModelProperty("Is it the last bar of the interval?") Boolean isBarFinal) {
}