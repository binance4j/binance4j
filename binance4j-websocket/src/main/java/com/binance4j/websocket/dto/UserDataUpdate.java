package com.binance4j.websocket.dto;

import com.binance4j.websocket.serialization.UserDataUpdateEventDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * User data update event:
 * <ul>
 * <li>{@code outboundAccountPosition}: the change in account balances caused by an event.</li>
 * <li>{@code executionReport}: whenever there is a trade or an order.</li>
 * <li>{@code balanceUpdate}: the change in account balance (delta).</li>
 * </ul>
 * 
 * @param eventType                          The event type.
 * @param eventTime                          The timestamp.
 * @param outboundAccountPositionUpdateEvent The account update.
 * @param balanceUpdateEvent                 The balance update.
 * @param orderTradeUpdateEvent              The order trade update.
 */
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