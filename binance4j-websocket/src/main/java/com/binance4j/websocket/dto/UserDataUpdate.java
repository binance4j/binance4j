package com.binance4j.websocket.dto;

import com.binance4j.websocket.serialization.UserDataUpdateEventDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = UserDataUpdateEventDeserializer.class)
public record UserDataUpdate(UserDataUpdateType eventType, Long eventTime, AccountUpdate outboundAccountPositionUpdateEvent, BalanceUpdate balanceUpdateEvent,
		OrderTradeUpdate orderTradeUpdateEvent) {
}