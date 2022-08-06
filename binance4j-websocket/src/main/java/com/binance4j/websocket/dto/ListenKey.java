package com.binance4j.websocket.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A wrapper for the listen key.
 * 
 * @param listenKey Key used to open a user data stream.
 */

@ApiModel("A wrapper for the listen key.")
public record ListenKey(@ApiModelProperty("Key used to open a user data stream.") String listenKey) {
}