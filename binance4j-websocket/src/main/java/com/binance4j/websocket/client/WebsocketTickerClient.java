package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.TickerPayload;

/**
 * Handles 24hr rolling window ticker statistics for a single symbol. These are
 * NOT the
 * statistics of the UTC day, but a 24hr rolling window for the previous 24hrs.
 */
public class WebsocketTickerClient extends WebsocketClient<TickerPayload> {
    /**
     * Default constructor
     * 
     * @param symbols The symbols we want the data
     */
    public WebsocketTickerClient(String symbols) {
        super(symbols, "ticker", TickerPayload.class);
    }

    /**
     * Constructor with iterable of symbols
     * 
     * @param symbols The trading pair iterable
     */
    public WebsocketTickerClient(Iterable<? extends CharSequence> symbols) {
        this(String.join(",", symbols));
    }
}
