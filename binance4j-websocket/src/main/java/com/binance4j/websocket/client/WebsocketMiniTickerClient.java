package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.MiniTickerPayload;

/** Websocket client handling mini events on one or many symbols */
public class WebsocketMiniTickerClient extends WebsocketClient<MiniTickerPayload> {
    /**
     * Default constructor
     * 
     * @param symbols The symbols we want the data
     */
    public WebsocketMiniTickerClient(String symbols) {
        super(symbols, "miniTicker", MiniTickerPayload.class);
    }

    /**
     * Constructor with iterable of symbols
     * 
     * @param symbols The trading pair iterable
     */
    public WebsocketMiniTickerClient(Iterable<? extends CharSequence> symbols) {
        this(String.join(",", symbols));
    }
}
