package com.binance4j.websocket.dto;

import com.binance4j.core.dto.CandlestickInterval;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Net asset value candle.
 * 
 * @property startTime     Start time.
 * @property endTime       End time.
 * @property name          Name.
 * @property interval      Interval.
 * @property firstUpdate   First update.
 * @property lastUpdate    Last update.
 * @property open          Open.
 * @property close         Close.
 * @property high          High.
 * @property low           Low.
 * @property realLeverage  Real leverage.
 * @property updateNumbers Number of updates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Net asset value candle.")
data class BLVTCandle(@ApiModelProperty("Start time.") @JsonProperty("t") long startTime,
		@ApiModelProperty("End time.") @JsonProperty("T") long endTime,
		@ApiModelProperty("Name.") @JsonProperty("s") String name,
		@ApiModelProperty("Interval.") @JsonProperty("i") CandlestickInterval interval,
		@ApiModelProperty("First update.") @JsonProperty("f") long firstUpdate,
		@ApiModelProperty("Last update.") @JsonProperty("L") long lastUpdate,
		@ApiModelProperty("Open.") @JsonProperty("o") String open,
		@ApiModelProperty("Close.") @JsonProperty("c") String close,
		@ApiModelProperty("High.") @JsonProperty("h") String high,
		@ApiModelProperty("Low.") @JsonProperty("l") String low,
		@ApiModelProperty("Real leverage.") @JsonProperty("v") String realLeverage,
		@ApiModelProperty("Number of updates.") @JsonProperty("n") long updateNumbers) {
}
