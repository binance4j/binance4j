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

package com.binance4j.connectors.websocket.dto

import com.binance4j.connectors.core.dto.AssetBalance
import com.binance4j.connectors.websocket.serialization.AssetBalanceDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Account update event which will reflect the current position/balances of the
 * account.
 * <p>
 * This event is embedded as part of a user data update event.
 *
 * @property eventType Event type.
 * @property eventTime Timestamp.
 * @property balances  Assets balance.
 * @see UserDataUpdate
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Account update event which will reflect the current position/balances of the account.")
data class AccountUpdate(
	@ApiModelProperty("Event type.")
	@JsonProperty("e")
	var eventType: String,
	@ApiModelProperty("Timestamp.")
	@JsonProperty("E")
	var eventTime: Long,
	@JsonProperty("B")
	@ApiModelProperty("Assets balance.")
	@JsonDeserialize(contentUsing = AssetBalanceDeserializer::class)
	var balances: List<AssetBalance> = emptyList()
)

