package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.TradePayload;

/** Websocket client handling trade events on one or many symbols */
public class WebsocketTradeClient extends WebsocketClient<TradePayload> {
    /**
     * Default constructor
     * 
     * @param symbols The symbols we want the data
     */
    public WebsocketTradeClient(String symbols) {
        super(symbols, "trade", TradePayload.class);
    }

    /**
     * Constructor with iterable of symbols
     * 
     * @param symbols The trading pair iterable
     */
    public WebsocketTradeClient(Iterable<? extends CharSequence> symbols) {
        this(String.join(",", symbols));
    }
}
