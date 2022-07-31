package com.binance4j.websocket.client;

import java.time.Duration;

import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.Candle;
import com.binance4j.websocket.service.DurationService;

/** Websocket client handling Kline events on one or many symbols */
public class WebsocketCandlestickClient extends BaseWebsocketClient<Candle> {
	Duration noResponseMarginError = Duration.ofSeconds(10);

	/**
	 * @param symbols  The symbols we want the klines.
	 * @param interval The candlestick interval.
	 * @param callback The events handler.
	 */
	public WebsocketCandlestickClient(String symbols, CandlestickInterval interval, WebsocketCallback<Candle> callback) {
		super(symbols, String.format("kline_%s", interval.toString()), Candle.class, callback);
		// We define the read timeout the same as the interval + a margin
		getConfiguration().setNoResponseTimeout(DurationService.convert(interval).plus(getConfiguration().getNoResponseTimeoutMarginError()));
	}

	/**
	 * @param symbols  The trading pair iterable.
	 * @param interval The candlestick interval.
	 * @param callback The events handler.
	 */
	public WebsocketCandlestickClient(Iterable<? extends CharSequence> symbols, CandlestickInterval interval, WebsocketCallback<Candle> callback) {
		this(String.join(",", symbols), interval, callback);
	}

	/**
	 * @return the noResponseMarginError
	 */
	public Duration getNoResponseMarginError() {
		return noResponseMarginError;
	}

	/**
	 * @param noResponseMarginError the noResponseMarginError to set
	 */
	public void setNoResponseMarginError(Duration noResponseMarginError) {
		this.noResponseMarginError = noResponseMarginError;
	}
}