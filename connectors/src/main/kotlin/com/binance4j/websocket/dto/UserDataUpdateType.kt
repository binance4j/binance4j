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

/** The user data update type.
 * @property value The enum string value. */
enum class UserDataUpdateType(var value: String) {
	/** Corresponds to "outboundAccountPosition" events.  */
	ACCOUNT_POSITION_UPDATE("outboundAccountPosition"),
	
	/** Corresponds to "balanceUpdate" events.  */
	BALANCE_UPDATE("balanceUpdate"),
	
	/** Corresponds to "executionReport" events.  */
	ORDER_TRADE_UPDATE("executionReport");
	
	override fun toString(): String = value
	
	companion object {
		/**
		 * @property eventTypeId Enum string value.
		 * @return The enum value.
		 */
		@JvmStatic
		fun getValue(eventTypeId: String): UserDataUpdateType = when (eventTypeId) {
			ORDER_TRADE_UPDATE.value -> ORDER_TRADE_UPDATE
			ACCOUNT_POSITION_UPDATE.value -> ACCOUNT_POSITION_UPDATE
			BALANCE_UPDATE.value -> BALANCE_UPDATE
			else -> throw RuntimeException("Unrecognized user data update event type id: $eventTypeId")
		}
	}
}