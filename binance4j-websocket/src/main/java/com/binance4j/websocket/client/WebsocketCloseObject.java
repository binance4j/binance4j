package com.binance4j.websocket.client;

import lombok.AllArgsConstructor;
import lombok.Data;

/** Contains the code and the reason of the websocket closing */
@Data
@AllArgsConstructor
public class WebsocketCloseObject {
    /**
     * The closing code
     */
    private int code;
    /**
     * The closing reason
     */
    private String reason;
}