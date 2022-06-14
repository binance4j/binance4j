package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.DepthPayload;
import com.binance4j.websocket.payload.DepthUpdateSpeed;

/** Websocket client handling depth events on one or many symbols */
public class WebsocketDepthClient extends WebsocketClient<DepthPayload> {
    /**
     * Default constructor
     * 
     * @param symbols The symbols we want the data
     * @param speed   the update speed
     */
    public WebsocketDepthClient(String symbols, DepthUpdateSpeed speed) {
        super(symbols, String.format("depth@%s", speed.getSpeed()), DepthPayload.class);
    }

    /**
     * Constructor with iterable of symbols
     * 
     * @param symbols The trading pair iterable
     * @param speed   the update speed
     */
    public WebsocketDepthClient(Iterable<? extends CharSequence> symbols, DepthUpdateSpeed speed) {
        this(String.join(",", symbols), speed);
    }
}
