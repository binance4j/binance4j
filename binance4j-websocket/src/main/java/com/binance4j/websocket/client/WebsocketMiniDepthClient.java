package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.DepthLevel;
import com.binance4j.websocket.payload.DepthUpdateSpeed;
import com.binance4j.websocket.payload.MiniDepthPayload;

/**
 * Websocket client handling top bids and asks events on one or many symbols
 * ²
 */
public class WebsocketMiniDepthClient extends WebsocketClient<MiniDepthPayload> {
    /**
     * Default constructor
     * 
     * @param symbols The symbols we want the data
     * @param level   ???
     * @param speed   the update speed
     */
    public WebsocketMiniDepthClient(String symbols, DepthLevel level, DepthUpdateSpeed speed) {
        super(symbols, String.format("depth%s@%s", level.getLevel(), speed.getSpeed()), MiniDepthPayload.class);
    }

    /**
     * Constructor with iterable of symbols
     * 
     * @param symbols The trading pair iterable
     * @param level   ???
     * @param speed   the update speed
     */
    public WebsocketMiniDepthClient(Iterable<? extends CharSequence> symbols, DepthLevel level,
            DepthUpdateSpeed speed) {
        this(String.join(",", symbols), level, speed);
    }
}
