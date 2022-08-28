package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Top bids and asks.
 * 
 * @property lastUpdateId Last update id.
 * @property bids         Bids.
 * @property asks         Asks.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Top bids and asks.")
data class MiniDepth(
@ApiModelProperty("Last update id.")
@JsonProperty("lastUpdateId") var lastUpdateId:Long?=null,
@ApiModelProperty("Bids.") List<OrderBookEntry> bids,
@ApiModelProperty("Asks.")
List<OrderBookEntry> asks)
{
}
