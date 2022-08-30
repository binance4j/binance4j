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

package com.binance4j.core.test

import com.binance4j.core.Binance4j
import com.binance4j.core.Request
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.assertDoesNotThrow

/** Base class for Unit test.  */ // @Execution(ExecutionMode.CONCURRENT)
abstract class CustomTest {
	/** The key.  */
	var key: String = System.getenv("BINANCE_API_KEY")
		protected set
	
	/** The secret.  */
	var secret: String = System.getenv("BINANCE_API_SECRET")
		protected set
	
	/** The testnetKey.  */
	var testnetKey: String = System.getenv("BINANCE_TESTNET_API_KEY")
		protected set
	
	/** The testnetSecret.  */
	var testnetSecret: String = System.getenv("BINANCE_TESTNET_API_SECRET")
		protected set
	
	/** The symbol.  */
	var symbol = "BNBBTC"
		protected set
	
	/** The asset.  */
	var asset = "BNB"
		protected set
	
	/** The limit.  */
	var limit = 25
		protected set
	
	/** The String.  */
	var assets = listOf(asset, "BUSD", "BTC")
		protected set
	
	/** The String.  */
	var symbols = listOf(symbol, "BNBBUSD", "BTCBUSD")
		protected set
	
	init {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
			.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	fun assertNotThrow(request: Request<*>) {
		assertDoesNotThrow { println(request.sync()) }
	}
}