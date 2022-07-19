package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Account update event which will reflect the balance changes of the account. This event is embedded as part of a user
 * data update event.
 *
 * @see UserDataUpdate
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public record BalanceUpdate(/** The event type. */
@JsonProperty("e") String eventType,
		/** The timestamp. */
		@JsonProperty("E") Long eventTime,
		/** The asset. */
		@JsonProperty("a") String asset,
		/** The balance delta */
		@JsonProperty("d") String balanceDelta,
		/** Clear time in ms */
		@JsonProperty("T") Long clearTime) {
}