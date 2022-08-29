package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A wrapper for the server time.
 * 
 * @property serverTime Server time in ms.
 */
@ApiModel("A wrapper for the server time.")
data class ServerTimeResponse(@ApiModelProperty("The server time in ms.")  val serverTime : Long)
{
}