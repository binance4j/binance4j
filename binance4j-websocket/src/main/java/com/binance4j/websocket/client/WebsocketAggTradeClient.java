package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.AggTradePayload;

/** Websocket client handling Aggregate trade events on a symbol or symbols */
public class WebsocketAggTradeClient extends WebsocketClient<AggTradePayload> {
    /**
     * Constructor with symbols separated by a coma
     * 
     * @param symbols trading pair separated by a coma
     */
    public WebsocketAggTradeClient(String symbols) {
        super(symbols, "aggTrade", AggTradePayload.class);
    }

    /**
     * Constructor with iterable of symbols
     * 
     * @param symbols The trading pair iterable
     */
    public WebsocketAggTradeClient(Iterable<? extends CharSequence> symbols) {
        this(String.join(",", symbols));
    }
}