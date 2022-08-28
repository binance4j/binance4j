package com.binance4j.websocket.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A wrapper for the listen key.
 * 
 * @property listenKey Key used to open a user data stream.
 */

@ApiModel("A wrapper for the listen key.")
data class ListenKey(
@ApiModelProperty("Key used to open a user data stream.")
var listenKey:String?=null)
{
}