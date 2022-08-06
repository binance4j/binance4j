package com.binance4j.websocket.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A wrapper for the listen key.
 * 
 * @param listenKey The key used to open a user data stream.
 */

@ApiModel("")
public record ListenKey(@ApiModelProperty("") String listenKey) {
}