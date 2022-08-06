package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A wrapper for the server time
 * 
 * @param serverTime The server time in ms.
 */
@ApiModel("")
public record ServerTimeResponse(@ApiModelProperty("") long serverTime) {
}