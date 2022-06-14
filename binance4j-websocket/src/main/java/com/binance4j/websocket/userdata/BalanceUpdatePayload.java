package com.binance4j.websocket.userdata;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Account update event which will reflect the balance changes of the account.
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdatePayload
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceUpdatePayload {
	/**
	 * The event type
	 */
	@JsonProperty("e")
	private String eventType;
	/**
	 * The timestamp
	 */
	@JsonProperty("E")
	private Long eventTime;
	/**
	 * The asset
	 */
	@JsonProperty("a")
	private String asset;
	/**
	 * ???
	 */
	@JsonProperty("d")
	private String balanceDelta;
	/**
	 * ???
	 */
	@JsonProperty("T")
	private Long clearTime;
}