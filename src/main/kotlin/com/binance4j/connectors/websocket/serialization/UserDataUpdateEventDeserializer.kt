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

package com.binance4j.connectors.websocket.serialization

import com.binance4j.connectors.websocket.dto.*
import com.binance4j.connectors.websocket.dto.UserDataUpdateType.Companion.getValue
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.IOException

/** [UserDataUpdate] deserializer  */
class UserDataUpdateEventDeserializer : JsonDeserializer<UserDataUpdate>() {
    @Throws(IOException::class)
    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): UserDataUpdate {
        val mapper = ObjectMapper()
        val node = jp.codec.readTree<JsonNode>(jp)
        val json = node.toString()
        val eventTypeId = node["e"].asText()
        val eventTime = node["E"].asLong()
        return when (val userDataUpdateEventType = getValue(eventTypeId)) {
            UserDataUpdateType.ACCOUNT_POSITION_UPDATE -> UserDataUpdate(
                userDataUpdateEventType, eventTime, mapper.readValue(json, AccountUpdate::class.java), null, null
            )

            UserDataUpdateType.BALANCE_UPDATE -> UserDataUpdate(
                userDataUpdateEventType, eventTime, null, mapper.readValue(json, BalanceUpdate::class.java), null
            )

            UserDataUpdateType.ORDER_TRADE_UPDATE -> UserDataUpdate(
                userDataUpdateEventType, eventTime, null, null, mapper.readValue(json, OrderTradeUpdate::class.java)
            )

            else -> throw IllegalArgumentException()
        }
    }
}