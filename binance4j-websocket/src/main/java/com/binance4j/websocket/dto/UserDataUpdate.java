package com.binance4j.websocket.dto;

import com.binance4j.websocket.serialization.UserDataUpdateEventDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * User data update event which can be of four types:
 * <p>
 * outboundAccountInfo; whenever there is a change in the account (e.g. balance of an asset)
 * <p>
 * {@code outboundAccountPosition}: the change in account balances caused by an event.
 * <p>
 * {@code executionReport}: whenever there is a trade or an order
 * <p>
 * {@code balanceUpdate}: the change in account balance (delta).
 * <p>
 * Deserialization could fail with UnsupportedEventException in case of unsupported eventType.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = UserDataUpdateEventDeserializer.class)
public record UserDataUpdate(
		/** The event type. */
		UserDataUpdateType eventType,
		/** The timestamp. */
		Long eventTime,
		/** The account update. */
		AccountUpdate outboundAccountPositionUpdateEvent,
		/** The balance update. */
		BalanceUpdate balanceUpdateEvent,
		/** The order trade update. */
		OrderTradeUpdate orderTradeUpdateEvent) {
}