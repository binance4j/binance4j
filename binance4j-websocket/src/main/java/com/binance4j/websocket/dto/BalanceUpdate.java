package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account update event which will reflect the balance changes of the account. This event is embedded as part of a user
 * data update event.
 *
 * @param eventType    Event type.
 * @param eventTime    Timestamp.
 * @param asset        Asset.
 * @param balanceDelta Balance delta.
 * @param clearTime    Clear time in ms.
 * @see UserDataUpdate
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Account update event which will reflect the balance changes of the account. This event is embedded as part of a user data update event.")
public record BalanceUpdate(@ApiModelProperty("Event type.") @JsonProperty("e") String eventType,
		@ApiModelProperty("Timestamp.") @JsonProperty("E") Long eventTime, @ApiModelProperty("Asset.") @JsonProperty("a") String asset,
		@ApiModelProperty("Balance delta.") @JsonProperty("d") String balanceDelta, @ApiModelProperty("Clear time in ms.") @JsonProperty("T") Long clearTime) {
}