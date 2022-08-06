package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Defines the allowed maximum position an account can have on the base asset of a symbol.
 * 
 * @param maxPosition The max positions allowed.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("")
public record MaxPositionFilter(@ApiModelProperty("") String maxPosition) {
}