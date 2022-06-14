package com.binance4j.websocket.candle;

import com.binance4j.core.market.Candle;
import com.binance4j.websocket.serialization.CandlestickEventDeserializer;
import com.binance4j.websocket.serialization.CandlestickEventSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Kline/Candlestick bar for a symbol.
 */
@Data
@JsonFormat(shape = Shape.OBJECT)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonDeserialize(using = CandlestickEventDeserializer.class)
@JsonSerialize(using = CandlestickEventSerializer.class)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CandlePayload extends Candle {
	/**
	 * The event type
	 */
	private String eventType;
	/**
	 * The timestamp in ms
	 */
	private Long eventTime;
	/**
	 * The trading pair
	 */
	private String symbol;
	/**
	 * The interval id
	 */
	private String intervalId;
	/**
	 * The first trade id
	 */
	private Long firstTradeId;
	/**
	 * The last trade id
	 */
	private Long lastTradeId;
	/**
	 * is it the last bar of the interval?
	 */
	private Boolean isBarFinal;
}