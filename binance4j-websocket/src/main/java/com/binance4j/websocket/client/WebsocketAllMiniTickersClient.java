package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.MiniTickerPayload;

/**
 * Websocket client handling mini ticker events on all
 * symbols.
 */
public class WebsocketAllMiniTickersClient extends WebsocketClient<MiniTickerPayload> {
    /**
     * Default constructor
     */
    public WebsocketAllMiniTickersClient() {
        super(null, "!miniTicker", MiniTickerPayload.class);
    }
}
