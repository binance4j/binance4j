package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public record BalanceUpdate(@JsonProperty("e") String eventType, @JsonProperty("E") Long eventTime, @JsonProperty("a") String asset,
		@JsonProperty("d") String balanceDelta, @JsonProperty("T") Long clearTime) {
}