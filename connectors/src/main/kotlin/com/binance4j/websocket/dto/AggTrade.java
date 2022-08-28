package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An aggregated trade event for a symbol.
 * 
 * @property aggregatedTradeId     Agg trade id.
 * @property price                 Price.
 * @property quantity              Volume.
 * @property firstBreakdownTradeId First trade id.
 * @property lastBreakdownTradeId  Last trade id.
 * @property tradeTime             Timestamp.
 * @property isBuyerMaker          Was the buyer the maker?
 * @property eventType             Event type.
 * @property eventTime             Timestamp.
 * @property symbol                Trading pair.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("An aggregated trade event for a symbol.")
data class AggTrade(@ApiModelProperty("Agg trade id.") @JsonProperty("a") Long aggregatedTradeId,
		@ApiModelProperty("Price.") @JsonProperty("p") String price,
		@ApiModelProperty("Volume.") @JsonProperty("q") String quantity,
		@ApiModelProperty("First trade id.") @JsonProperty("f") Long firstBreakdownTradeId,
		@ApiModelProperty("Last trade id.") @JsonProperty("l") Long lastBreakdownTradeId,
		@ApiModelProperty("Timestamp.") @JsonProperty("T") Long tradeTime,
		@ApiModelProperty("Was the buyer the maker?") @JsonProperty("m") Boolean isBuyerMaker,
		@ApiModelProperty("Event type.") @JsonProperty("e") String eventType,
		@ApiModelProperty("Timestamp.") @JsonProperty("E") Long eventTime,
		@ApiModelProperty("Trading pair.") @JsonProperty("s") String symbol) {
}