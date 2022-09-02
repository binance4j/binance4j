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
package com.binance4j.margin.client

import com.binance4j.core.Binance4j
import com.binance4j.core.dto.OrderSide
import com.binance4j.core.exception.ApiException
import com.binance4j.core.test.CustomTest
import com.binance4j.margin.dto.IsolatedTransferAccount
import com.binance4j.margin.dto.TransferType
import com.binance4j.margin.param.*
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.Test

class MarginClientTest : CustomTest() {
	protected var client = MarginClient(key, secret)
	var isolatedSymbol = "BTCUSDT"
	var isolatedAsset = "BTC"
	var isolatedAmount = "0.00044"
	
	init {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetAccount() {
		assertNotThrow(client.getAccount())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetIsolatedAccount() {
		assertNotThrow(client.getIsolatedAccount())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetMarginFeeData() {
		assertNotThrow(client.getMarginFeeData())
	}
	
	// @Test OK WORKS! but system might be short of asset
	@Throws(ApiException::class)
	fun testGetMaxBorrowable() {
		assertNotThrow(client.getMaxBorrowable(MaxBorrowableParams(asset)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetMaxTransferable() {
		assertNotThrow(client.getMaxTransferable(MaxTransferableParams(asset)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetAsset() {
		assertNotThrow(client.getAsset(AssetParams(asset)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetBNBBurnStatus() {
		assertNotThrow(client.getBNBBurnStatus())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testEnableIsolatedAccount() {
		assertNotThrow(client.enableIsolatedAccount(ToogleAccountParams(isolatedSymbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetAllAssets() {
		assertNotThrow(client.getAllAssets())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetAllCrossMarginPairs() {
		assertNotThrow(client.getAllCrossMarginPairs())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetAllIsolatedSymbols() {
		assertNotThrow(client.getAllIsolatedSymbols())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetIsolatedFeeData() {
		assertNotThrow(client.getIsolatedFeeData())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetIsolatedMarginTierData() {
		assertNotThrow(client.getIsolatedMarginTierData(IsolatedTierDataParams(isolatedSymbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetIsolatedSymbol() {
		assertNotThrow(client.getIsolatedSymbol(PairParams(isolatedSymbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetIsolatedTransferHistory() {
		assertNotThrow(client.getIsolatedTransferHistory(IsolatedTransferHistoryParams(symbol)))
	}
	
	// @Test General error?
	@Throws(ApiException::class)
	fun testToggleBNBBurnOnSpotTradeAndMarginInterest() {
		assertNotThrow(client.toggleBNBBurnOnSpotTradeAndMarginInterest(ToggleBurnParams(false, false)))
		assertNotThrow(client.toggleBNBBurnOnSpotTradeAndMarginInterest(ToggleBurnParams(true, true)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetInterestRateHistory() {
		assertNotThrow(client.getInterestRateHistory(InterestRateHistoryParams(asset)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetCrossMarginPair() {
		assertNotThrow(client.getCrossMarginPair(PairParams(symbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetEnabledIsolatedAccountLimit() {
		assertNotThrow(client.getEnabledIsolatedAccountLimit())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetPriceIndex() {
		assertNotThrow(client.getPriceIndex(PriceIndexParams(symbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetTransferHistory() {
		assertNotThrow(client.getTransferHistory())
	}
	
	// @Test WORKS!
	@Throws(ApiException::class)
	fun testGetOpenOrdersAndGetOrder() {
		assertNotThrow(client.getOpenOrders())
	}
	
	// @Test WORKS!
	@Throws(ApiException::class)
	fun testNewIsolatedTransfer() {
		assertNotThrow(
			client.newIsolatedTransfer(
				NewIsolatedTransferParams(
					isolatedAsset, isolatedSymbol,
					isolatedAmount, IsolatedTransferAccount.SPOT,
					IsolatedTransferAccount.ISOLATED_MARGIN
				)
			)
		)
		assertNotThrow(
			client.newIsolatedTransfer(
				NewIsolatedTransferParams(
					isolatedAsset, isolatedSymbol, isolatedAmount,
					IsolatedTransferAccount.ISOLATED_MARGIN, IsolatedTransferAccount.SPOT
				)
			)
		)
	}
	
	// @Test WORKS!
	@Throws(ApiException::class)
	fun testDisableIsolatedAccount() {
		assertNotThrow(client.disableIsolatedAccount(ToogleAccountParams(isolatedSymbol)))
	}
	
	// @Test WORKS!
	@Throws(ApiException::class)
	fun testTransfer() {
		assertNotThrow(
			client.transfer(TransferParams(isolatedAsset, isolatedAmount, TransferType.MAIN_TO_MARGIN))
		)
		assertNotThrow(
			client.transfer(TransferParams(isolatedAsset, isolatedAmount, TransferType.MARGIN_TO_MAIN))
		)
	}
	
	// @Test WORKS!
	@Throws(ApiException::class)
	fun testGetAllOrders() {
		val params = AllOrdersParams("BTCBUSD")
		assertNotThrow(client.getAllOrders(params))
	}
	
	// @Test WORKS!
	@Throws(ApiException::class)
	fun testNewOrder() {
		assertNotThrow(
			client.newOrder(NewOrder.limit("BTCBUSD", OrderSide.BUY, "0.0004", "25000"))
		)
	}
	
	// ***** NOT TESTED ***** //
	// TODO @Test
	@Throws(ApiException::class)
	fun testBorrow() {
		client.borrow(BorrowParams(asset, "1"))
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testCancelOCO() {
		assertNotThrow(client.cancelOCO(CancelOCOParams(symbol)))
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testCancelOpenOrders() {
		assertNotThrow(client.cancelOpenOrders(CancelOpenOrdersParams(symbol)))
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testCancelOrder() {
		assertNotThrow(client.cancelOrder(CancelOrderParams(symbol)))
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testGetAllOCO() {
		assertNotThrow(client.getAllOCO(GetAllOCOParams(null, null)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetForceLiquidationRecord() {
		assertNotThrow(client.getForceLiquidationRecord(ForceLiquidationRecordParams()))
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testGetInterestHistory() {
		assertNotThrow(client.getInterestHistory(TransactionHistoryParams(asset)))
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testGetLoanRecord() {
		assertNotThrow(client.getLoanRecord(TransactionHistoryParams(asset)))
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testGetTrades() {
		assertNotThrow(client.getTrades(TradeParams(isolatedSymbol)))
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testGetOCO() {
		assertNotThrow(client.getOCO(GetOCOParams(symbol)))
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testGetOpenOCO() {
		assertNotThrow(client.getOpenOCO())
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testGetRepayRecord() {
		assertNotThrow(client.getRepayRecord(TransactionHistoryParams(asset)))
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testNewOCO() {
		assertNotThrow(client.newOCO(NewOCO(symbol, OrderSide.BUY, "1", "1", "1")))
	}
	
	// TODO @Test
	@Throws(ApiException::class)
	fun testRepay() {
		assertNotThrow(client.repay(RepayParams(asset, "amount")))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetRateLimit() {
		assertNotThrow(client.getRateLimit())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetRateLimit2() {
		assertNotThrow(client.getRateLimit(RateLimitParams("BTC")))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetDustLog() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		assertNotThrow(client.getDustLog())
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
}