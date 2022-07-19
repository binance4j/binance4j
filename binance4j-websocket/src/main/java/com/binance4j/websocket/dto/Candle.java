package com.binance4j.websocket.dto;

import java.math.BigDecimal;

import com.binance4j.websocket.serialization.CandlestickEventDeserializer;
import com.binance4j.websocket.serialization.CandlestickEventSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/** Kline/candle for a symbol. */
@JsonFormat(shape = Shape.OBJECT)
@JsonDeserialize(using = CandlestickEventDeserializer.class)
@JsonSerialize(using = CandlestickEventSerializer.class)
public record Candle(
		/** The candlestick open timestamp in milliseconds */
		Long openTime,
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
		Long closeTime,
		/** The quote asset traded volume */
		BigDecimal quoteAssetVolume,
		/** The number of trades */
		Long numberOfTrades,
		/** Taker buy base asset volume */
		BigDecimal takerBuyBaseAssetVolume,
		/** Taker buy quote asset volume */
		BigDecimal takerBuyQuoteAssetVolume,
		/** The event type. */
		String eventType,
		/** The timestamp in ms. */
		Long eventTime,
		/** The trading pair. */
		String symbol,
		/** The interval id. */
		String intervalId,
		/** The first trade id. */
		Long firstTradeId,
		/** The last trade id. */
		Long lastTradeId,
		/** is it the last bar of the interval? */
		Boolean isBarFinal) {
}