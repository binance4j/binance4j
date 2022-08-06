package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An order book entry consisting of price and quantity.
 * 
 * @param price Price.
 * @param qt    Quantity.
 */
@JsonFormat(shape = Shape.ARRAY)
@JsonPropertyOrder()
@ApiModel("An order book entry consisting of price and quantity.")
public record OrderBookEntry(@ApiModelProperty("The price.") String price, @ApiModelProperty("The quantity.") String qt) {
}