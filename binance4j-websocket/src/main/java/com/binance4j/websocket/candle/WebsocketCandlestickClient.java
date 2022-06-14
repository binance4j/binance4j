package com.binance4j.websocket.candle;

import java.time.Duration;

import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.service.DurationService;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Websocket client handling Kline events on one or many symbols
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WebsocketCandlestickClient extends BaseWebsocketClient<CandlePayload> {

	Duration noResponseMarginError = Duration.ofSeconds(10);

	/**
	 * Constructor
	 *
	 * @param symbols  The symbols we want the klines
	 * @param interval The candlestick interval
	 * @param callback The events handler
	 */
	public WebsocketCandlestickClient(String symbols, CandlestickInterval interval,
	                                  WebsocketCallback<CandlePayload> callback) {
		super(symbols, String.format("kline_%s", interval.getValue()), CandlePayload.class, callback);
		// We define the read timeout the same as the interval + a margin
		getConfiguration().setNoResponseTimeout(
				DurationService.convert(interval).plus(getConfiguration().getNoResponseTimeoutMarginError()));
	}

	/**
	 * Constructor
	 *
	 * @param symbols  The trading pair iterable
	 * @param interval The candlestick interval
	 * @param callback The events handler
	 */
	public WebsocketCandlestickClient(Iterable<? extends CharSequence> symbols, CandlestickInterval interval,
	                                  WebsocketCallback<CandlePayload> callback) {
		this(String.join(",", symbols), interval, callback);
	}
}
