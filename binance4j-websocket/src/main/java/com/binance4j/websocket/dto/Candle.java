package com.binance4j.websocket.dto;

import com.binance4j.websocket.serialization.CandlestickEventDeserializer;
import com.binance4j.websocket.serialization.CandlestickEventSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
public record Candle(Long openTime, String open, String high, String low, String close, String volume, Long closeTime, String quoteAssetVolume,
		Long numberOfTrades, String takerBuyBaseAssetVolume, String takerBuyQuoteAssetVolume, String eventType, Long eventTime, String symbol,
		String intervalId, Long firstTradeId, Long lastTradeId, Boolean isBarFinal) {
}