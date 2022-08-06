package com.binance4j.websocket.dto;

import com.binance4j.core.dto.CandlestickInterval;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Net asset value candle.
 * 
 * @param startTime     Start time.
 * @param endTime       End time.
 * @param name          Name.
 * @param interval      Interval.
 * @param firstUpdate   First update.
 * @param lastUpdate    Last update.
 * @param open          Open.
 * @param close         Close.
 * @param high          High.
 * @param low           Low.
 * @param realLeverage  Real leverage.
 * @param updateNumbers Number of updates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("")
public record BLVTCandle(@JsonProperty("t")long startTime,@ApiModelProperty("")@JsonProperty("T")long endTime,@ApiModelProperty("")
@JsonProperty(@ApiModelProperty("")"s") String name,
@ApiModelProperty("")
@JsonProperty("i")
CandlestickInterval interval,
@ApiModelProperty("")
@JsonProperty("f")
long firstUpdate,
@ApiModelProperty("")
@JsonProperty("L")
long lastUpdate,
@ApiModelProperty("")
@JsonProperty("o")
String open,
@ApiModelProperty("")
@JsonProperty("c")
String close,
@ApiModelProperty("")
@JsonProperty("h")
String high,
@ApiModelProperty("")
@JsonProperty("l")
String low,
@ApiModelProperty("")
@JsonProperty("v")
String realLeverage,
@ApiModelProperty("")
@JsonProperty("n")
long updateNumbers)
{
}
