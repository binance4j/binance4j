package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Net asset value event.
 * 
 * @param eventName Event name.
 * @param eventTime Event time.
 * @param name      BLVT name.
 * @param candle    BLVT candle.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Net asset value event.")
public record BLVTCandleEvent(@ApiModelProperty("Event name.") @JsonProperty("e") String eventName,
		@ApiModelProperty("Event time.") @JsonProperty("E") long eventTime, @ApiModelProperty("BLVT name.") @JsonProperty("s") String name,
		@ApiModelProperty("BLVT candle.") @JsonProperty("k") BLVTCandle candle) {
}