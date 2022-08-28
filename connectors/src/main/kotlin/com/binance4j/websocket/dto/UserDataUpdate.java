package com.binance4j.websocket.dto;

import com.binance4j.websocket.serialization.UserDataUpdateEventDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * User data update event:
 * <ul>
 * <li>{@code outboundAccountPosition}: the change in account balances caused by
 * an event.</li>
 * <li>{@code executionReport}: whenever there is a trade or an order.</li>
 * <li>{@code balanceUpdate}: the change in account balance (delta).</li>
 * </ul>
 * 
 * @property eventType                          Event type.
 * @property eventTime                          Timestamp.
 * @property outboundAccountPositionUpdateEvent Account update.
 * @property balanceUpdateEvent                 Balance update.
 * @property orderTradeUpdateEvent              Order trade update.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = UserDataUpdateEventDeserializer.class)
@ApiModel("User data update event")
data class UserDataUpdate(
@ApiModelProperty("Event type.")
@JsonProperty("eventType") var eventType:UserDataUpdateType?=null,
@ApiModelProperty("Timestamp.")
@JsonProperty("eventTime") var eventTime:Long?=null,
@ApiModelProperty("Account update.")
@JsonProperty("outboundAccountPositionUpdateEvent") var outboundAccountPositionUpdateEvent:AccountUpdate?=null,
@ApiModelProperty("Balance update.")
@JsonProperty("balanceUpdateEvent") var balanceUpdateEvent:BalanceUpdate?=null,
@ApiModelProperty("Order trade update.")
@JsonProperty("orderTradeUpdateEvent") var orderTradeUpdateEvent:OrderTradeUpdate?=null)
{
}