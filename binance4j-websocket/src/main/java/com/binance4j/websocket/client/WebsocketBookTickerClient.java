package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.BookTickerPayload;

/** Websocket client handling book ticker events on one or many symbols */
public class WebsocketBookTickerClient extends WebsocketClient<BookTickerPayload> {
    /**
     * Constructor with symbols separated by a coma
     * 
     * @param symbols trading pair separated by a coma
     */
    public WebsocketBookTickerClient(String symbols) {
        super(symbols, "bookTicker", BookTickerPayload.class);
    }

    /**
     * Constructor with iterable of symbols
     * 
     * @param symbols The trading pair iterable
     */
    public WebsocketBookTickerClient(Iterable<? extends CharSequence> symbols) {
        this(String.join(",", symbols));
    }
}