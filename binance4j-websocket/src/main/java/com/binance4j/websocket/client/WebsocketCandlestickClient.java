package com.binance4j.websocket.client;

import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.websocket.payload.CandlestickBarPayload;
import com.binance4j.websocket.service.DurationService;

/** Websocket client handling Kline events on one or many symbols */
public class WebsocketCandlestickClient extends WebsocketClient<CandlestickBarPayload> {

    /**
     * Constructor
     * 
     * @param symbols  The symbols we want the klines
     * @param interval The candlestick interval
     */
    public WebsocketCandlestickClient(String symbols, CandlestickInterval interval) {
        super(symbols, String.format("kline_%s", interval.getValue()), CandlestickBarPayload.class);
        // We define the read timeout the same as the interval
        setNoResponseTimeout(DurationService.convert(interval));
    }

    /**
     * Constructor
     * 
     * @param symbols  The trading pair iterable
     * @param interval The candlestick interval
     */
    public WebsocketCandlestickClient(Iterable<? extends CharSequence> symbols, CandlestickInterval interval) {
        this(String.join(",", symbols), interval);
    }
}
