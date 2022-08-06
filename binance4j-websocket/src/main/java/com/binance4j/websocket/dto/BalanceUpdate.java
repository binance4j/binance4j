package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

/**
 * Account update event which will reflect the balance changes of the account. This event is embedded as part of a user
 * data update event.
 *
 * @param eventType    The event type.
 * @param eventTime    The timestamp.
 * @param asset        The asset.
 * @param balanceDelta The balance delta.
 * @param clearTime    Clear time in ms.
 * @see UserDataUpdate
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("")
public record BalanceUpdate(@JsonProperty("e") String eventType, @JsonProperty("E") Long eventTime, @JsonProperty("a") String asset,
		@JsonProperty("d") String balanceDelta, @JsonProperty("T") Long clearTime) {
}