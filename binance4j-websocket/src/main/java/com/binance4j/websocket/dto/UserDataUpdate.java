package com.binance4j.websocket.dto;

import com.binance4j.websocket.serialization.UserDataUpdateEventDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * User data update event:
 * <ul>
 * <li>{@code outboundAccountPosition}: the change in account balances caused by an event.</li>
 * <li>{@code executionReport}: whenever there is a trade or an order.</li>
 * <li>{@code balanceUpdate}: the change in account balance (delta).</li>
 * </ul>
 * 
 * @param eventType                          Event type.
 * @param eventTime                          Timestamp.
 * @param outboundAccountPositionUpdateEvent Account update.
 * @param balanceUpdateEvent                 Balance update.
 * @param orderTradeUpdateEvent              Order trade update.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = UserDataUpdateEventDeserializer.class)
@ApiModel("User data update event")
public record UserDataUpdate(@ApiModelProperty("Event type.") UserDataUpdateType eventType, @ApiModelProperty("Timestamp.") Long eventTime,
		@ApiModelProperty("Account update.") AccountUpdate outboundAccountPositionUpdateEvent,
		@ApiModelProperty("Balance update.") BalanceUpdate balanceUpdateEvent,
		@ApiModelProperty("Order trade update.") OrderTradeUpdate orderTradeUpdateEvent) {
}