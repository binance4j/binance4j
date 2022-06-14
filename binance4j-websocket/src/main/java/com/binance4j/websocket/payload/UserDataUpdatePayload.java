package com.binance4j.websocket.payload;

import com.binance4j.websocket.serialization.UserDataUpdateEventDeserializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User data update event which can be of four types:
 * <p>
 * outboundAccountInfo; whenever there is a change in the account (e.g.
 * balance of an asset)
 * <p>
 * {@code outboundAccountPosition}: the change in account balances caused by an
 * event.
 * <p>
 * {@code executionReport}: whenever there is a trade or an order
 * <p>
 * {@code balanceUpdate}: the change in account balance (delta).
 * <p>
 * 
 * Deserialization could fail with UnsupportedEventException in case of
 * unsupported eventType.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = UserDataUpdateEventDeserializer.class)
@AllArgsConstructor
@NoArgsConstructor
public class UserDataUpdatePayload {
	/**
	 * The event type
	 */
	private UserDataUpdatePayloadType eventType;
	/**
	 * The timestamp
	 */
	private Long eventTime;
	/**
	 * The account update
	 */
	private AccountUpdatePayload outboundAccountPositionUpdateEvent;
	/**
	 * The balance update
	 */
	private BalanceUpdatePayload balanceUpdateEvent;
	/**
	 * The order trade update
	 */
	private OrderTradeUpdatePayload orderTradeUpdateEvent;
}