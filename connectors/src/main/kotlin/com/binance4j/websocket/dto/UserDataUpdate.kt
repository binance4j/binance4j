/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.websocket.dto

import com.binance4j.websocket.serialization.UserDataUpdateEventDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

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
@JsonDeserialize(using = UserDataUpdateEventDeserializer::class)
@ApiModel("User data update event")
data class UserDataUpdate(
	@ApiModelProperty("Event type.")
	
	var eventType: UserDataUpdateType? = null
	@ApiModelProperty("Timestamp.")
val eventTime: Long,

@ApiModelProperty("Account update.")

var outboundAccountPositionUpdateEvent: AccountUpdate? = null

@ApiModelProperty("Balance update.")

var balanceUpdateEvent: BalanceUpdate? = null

@ApiModelProperty("Order trade update.")

var orderTradeUpdateEvent: OrderTradeUpdate? = null
)