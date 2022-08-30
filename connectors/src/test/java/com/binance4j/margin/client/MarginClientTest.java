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

package com.binance4j.margin.client;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.margin.dto.IsolatedTransferAccount;
import com.binance4j.margin.dto.OrderInfo;
import com.binance4j.margin.dto.TransferType;
import com.binance4j.margin.param.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MarginClientTest extends CustomTest {
	protected MarginClient client = new MarginClient(key, secret);
	
	String isolatedSymbol = "BTCUSDT";
	
	String isolatedAsset = "BTC";
	
	String isolatedAmount = "0.00044";
	
	public MarginClientTest() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}
	
	@Test
	void testGetAccount() throws ApiException {
		testNotThrow(client.getAccount());
	}
	
	@Test
	void testGetIsolatedAccount() throws ApiException {
		testNotThrow(client.getIsolatedAccount());
	}
	
	@Test
	void testGetMarginFeeData() throws ApiException {
		testNotThrow(client.getMarginFeeData());
	}
	
	// @Test OK WORKS! but system might be short of asset
	void testGetMaxBorrowable() throws ApiException {
		testNotThrow(client.getMaxBorrowable(new MaxBorrowableParams(asset)));
	}
	
	@Test
	void testGetMaxTransferable() throws ApiException {
		testNotThrow(client.getMaxTransferable(new MaxTransferableParams(asset)));
	}
	
	@Test
	void testGetAsset() throws ApiException {
		testNotThrow(client.getAsset(new AssetParams(asset)));
	}
	
	@Test
	void testGetBNBBurnStatus() throws ApiException {
		testNotThrow(client.getBNBBurnStatus());
	}
	
	@Test
	void testEnableIsolatedAccount() throws ApiException {
		testNotThrow(client.enableIsolatedAccount(new ToogleAccountParams(isolatedSymbol)));
	}
	
	@Test
	void testGetAllAssets() throws ApiException {
		testNotThrow(client.getAllAssets());
	}
	
	@Test
	void testGetAllCrossMarginPairs() throws ApiException {
		testNotThrow(client.getAllCrossMarginPairs());
	}
	
	@Test
	void testGetAllIsolatedSymbols() throws ApiException {
		testNotThrow(client.getAllIsolatedSymbols());
	}
	
	@Test
	void testGetIsolatedFeeData() throws ApiException {
		testNotThrow(client.getIsolatedFeeData());
	}
	
	@Test
	void testGetIsolatedMarginTierData() throws ApiException {
		testNotThrow(client.getIsolatedMarginTierData(new IsolatedTierDataParams(isolatedSymbol)));
	}
	
	@Test
	void testGetIsolatedSymbol() throws ApiException {
		testNotThrow(client.getIsolatedSymbol(new PairParams(isolatedSymbol)));
	}
	
	@Test
	void testGetIsolatedTransferHistory() throws ApiException {
		testNotThrow(client.getIsolatedTransferHistory(new IsolatedTransferHistoryParams(symbol)));
	}
	
	// @Test General error?
	void testToggleBNBBurnOnSpotTradeAndMarginInterest() throws ApiException {
		testNotThrow(client.toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(false, false)));
		testNotThrow(client.toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(true, true)));
	}
	
	@Test
	void testGetInterestRateHistory() throws ApiException {
		testNotThrow(client.getInterestRateHistory(new InterestRateHistoryParams(asset)));
	}
	
	@Test
	void testGetCrossMarginPair() throws ApiException {
		testNotThrow(client.getCrossMarginPair(new PairParams(symbol)));
	}
	
	@Test
	void testGetEnabledIsolatedAccountLimit() throws ApiException {
		testNotThrow(client.getEnabledIsolatedAccountLimit());
	}
	
	@Test
	void testGetPriceIndex() throws ApiException {
		testNotThrow(client.getPriceIndex(new PriceIndexParams(symbol)));
	}
	
	@Test
	void testGetTransferHistory() throws ApiException {
		testNotThrow(client.getTransferHistory());
	}
	
	// @Test WORKS!
	void testGetOpenOrdersAndGetOrder() throws ApiException {
		var list = List.of("origQuoteOrderQty")
		List<OrderInfo> orders = client.getOpenOrders().sync();
		testHasNulls(orders,list, true);
		
		orders.forEach(o -> {
			try {
				testHasNulls(client.getOrder(new OrderParams(o.symbol(), o.orderId())), list, true);
			} catch (ApiException e) {
				e.printStackTrace();
			}
			
		});
	}
	
	// @Test WORKS!
	void testNewIsolatedTransfer() throws ApiException {
		
		testNotThrow(client.newIsolatedTransfer(new NewIsolatedTransferParams(isolatedAsset, isolatedSymbol,
				isolatedAmount, IsolatedTransferAccount.SPOT,
				IsolatedTransferAccount.ISOLATED_MARGIN)));
		
		testNotThrow(
				client.newIsolatedTransfer(
						new NewIsolatedTransferParams(isolatedAsset, isolatedSymbol, isolatedAmount,
								IsolatedTransferAccount.ISOLATED_MARGIN, IsolatedTransferAccount.SPOT)));
	}
	
	// @Test WORKS!
	void testDisableIsolatedAccount() throws ApiException {
		testNotThrow(client.disableIsolatedAccount(new ToogleAccountParams(isolatedSymbol)));
	}
	
	// @Test WORKS!
	void testTransfer() throws ApiException {
		testNotThrow(
				client.transfer(new TransferParams(isolatedAsset, isolatedAmount, TransferType.MAIN_TO_MARGIN)));
		testNotThrow(
				client.transfer(new TransferParams(isolatedAsset, isolatedAmount, TransferType.MARGIN_TO_MAIN)));
	}
	
	// @Test WORKS!
	void testGetAllOrders() throws ApiException {
		AllOrdersParams params = new AllOrdersParams("BTCBUSD");
		testHasNulls(client.getAllOrders(params), List.of("accountId", "origQuoteOrderQty"), true);
	}
	
	// @Test WORKS!
	void testNewOrder() throws ApiException {
		testHasNulls(client.newOrder(NewOrderParams.buy("BTCBUSD", "0.0004", "25000")),
				List.of("orderId", "quoteQty", "symbol", "marginBuyBorrowAmount", "marginBuyBorrowAsset"), true);
	}
	
	// ***** NOT TESTED ***** //
	
	// TODO @Test
	void testBorrow() throws ApiException {
		client.borrow(new BorrowParams(asset, "1"));
	}
	
	// TODO @Test
	void testCancelOCO() throws ApiException {
		testNotThrow(client.cancelOCO(new CancelOCOParams(symbol)));
	}
	
	// TODO @Test
	void testCancelOpenOrders() throws ApiException {
		testNotThrow(client.cancelOpenOrders(new CancelOpenOrdersParams(symbol)));
	}
	
	// TODO @Test
	void testCancelOrder() throws ApiException {
		testNotThrow(client.cancelOrder(new CancelOrderParams(symbol)));
	}
	
	// TODO @Test
	void testGetAllOCO() throws ApiException {
		testNotThrow(client.getAllOCO(new GetAllOCOParams(null, null)));
	}
	
	@Test
	void testGetForceLiquidationRecord() throws ApiException {
		testNotThrow(client.getForceLiquidationRecord(new ForceLiquidationRecordParams(null)));
	}
	
	// TODO @Test
	void testGetInterestHistory() throws ApiException {
		testNotThrow(client.getInterestHistory(new TransactionHistoryParams(asset)));
	}
	
	// TODO @Test
	void testGetLoanRecord() throws ApiException {
		testNotThrow(client.getLoanRecord(new TransactionHistoryParams(asset)));
	}
	
	// TODO @Test
	void testGetTrades() throws ApiException {
		testNotThrow(client.getTrades(new TradeParams(isolatedSymbol)));
	}
	
	// TODO @Test
	void testGetOCO() throws ApiException {
		testNotThrow(client.getOCO(new GetOCOParams(false)));
	}
	
	// TODO @Test
	void testGetOpenOCO() throws ApiException {
		testNotThrow(client.getOpenOCO());
	}
	
	// TODO @Test
	void testGetRepayRecord() throws ApiException {
		testNotThrow(client.getRepayRecord(new TransactionHistoryParams(asset)));
	}
	
	// TODO @Test
	void testNewOCO() throws ApiException {
		testNotThrow(client.newOCO(new NewOCOOrderParams(symbol, OrderSide.BUY, "1", "1", "1")));
	}
	
	// TODO @Test
	void testRepay() throws ApiException {
		testNotThrow(client.repay(new RepayParams(asset, "amount")));
	}
	
	@Test
	void testGetRateLimit() throws ApiException {
		testNotThrow(client.getRateLimit());
	}
	
	@Test
	void testGetRateLimit2() throws ApiException {
		testNotThrow(client.getRateLimit(new RateLimitParams("BTC")));
	}
	
	@Test
	void testGetDustLog() throws ApiException {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(client.getDustLog());
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}
}
