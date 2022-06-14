package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.BookTickerPayload;

/** Websocket client handling book ticker events on all symbols */
public class WebsocketAllBookTickersClient extends WebsocketClient<BookTickerPayload> {
    /**
     * Default constructor
     */
    public WebsocketAllBookTickersClient() {
        super(null, "!bookTicker", BookTickerPayload.class);
    }
}
