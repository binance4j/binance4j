package com.binance4j.margin.client;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.margin.dto.IsolatedTransferAccount;
import com.binance4j.margin.dto.OrderInfo;
import com.binance4j.margin.dto.TransferType;
import com.binance4j.margin.param.AllOrdersParams;
import com.binance4j.margin.param.AssetParams;
import com.binance4j.margin.param.BorrowParams;
import com.binance4j.margin.param.CancelOCOParams;
import com.binance4j.margin.param.CancelOpenOrdersParams;
import com.binance4j.margin.param.CancelOrderParams;
import com.binance4j.margin.param.ForceLiquidationRecordParams;
import com.binance4j.margin.param.GetAllOCOParams;
import com.binance4j.margin.param.GetOCOParams;
import com.binance4j.margin.param.InterestRateHistoryParams;
import com.binance4j.margin.param.IsolatedTierDataParams;
import com.binance4j.margin.param.IsolatedTransferHistoryParams;
import com.binance4j.margin.param.MaxBorrowableParams;
import com.binance4j.margin.param.MaxTransferableParams;
import com.binance4j.margin.param.NewIsolatedTransferParams;
import com.binance4j.margin.param.NewOCOOrderParams;
import com.binance4j.margin.param.NewOrderParams;
import com.binance4j.margin.param.OrderParams;
import com.binance4j.margin.param.PairParams;
import com.binance4j.margin.param.PriceIndexParams;
import com.binance4j.margin.param.RateLimitParams;
import com.binance4j.margin.param.RepayParams;
import com.binance4j.margin.param.ToggleBurnParams;
import com.binance4j.margin.param.ToogleAccountParams;
import com.binance4j.margin.param.TradeParams;
import com.binance4j.margin.param.TransactionHistoryParams;
import com.binance4j.margin.param.TransferParams;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class MarginClientTest extends CustomTest {
	protected MarginClient client = new MarginClient(key, secret);
	String isolatedSymbol = "BTCUSDT";
	String isolatedAsset = "BTC";
	String isolatedAmount = "0.00044";

	public MarginClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
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
		List<OrderInfo> orders = client.getOpenOrders().sync();
		testHasNulls(orders, List.of("origQuoteOrderQty"), true);

		orders.forEach(o -> {
			try {
				testHasNulls(client.getOrder(new OrderParams(o.symbol(), o.orderId())), List.of("origQuoteOrderQty"),
						true);
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
				client.newIsolatedTransfer(new NewIsolatedTransferParams(isolatedAsset, isolatedSymbol, isolatedAmount,
						IsolatedTransferAccount.ISOLATED_MARGIN, IsolatedTransferAccount.SPOT)));
	}

	// @Test WORKS!
	void testDisableIsolatedAccount() throws ApiException {
		testNotThrow(client.disableIsolatedAccount(new ToogleAccountParams(isolatedSymbol)));
	}

	// @Test WORKS!
	void testTransfer() throws ApiException {
		testNotThrow(client.transfer(new TransferParams(isolatedAsset, isolatedAmount, TransferType.MAIN_TO_MARGIN)));
		testNotThrow(client.transfer(new TransferParams(isolatedAsset, isolatedAmount, TransferType.MARGIN_TO_MAIN)));
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
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(client.getDustLog());
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}
}
