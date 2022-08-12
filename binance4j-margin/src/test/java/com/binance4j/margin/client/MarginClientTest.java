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

	@Override
	protected MarginClient getClient() {
		return client;
	}

	@Test
	void testGetAccount() throws ApiException {
		testNotThrow(getClient().getAccount());
	}

	@Test
	void testGetIsolatedAccount() throws ApiException {
		testNotThrow(getClient().getIsolatedAccount());
	}

	@Test
	void testGetMarginFeeData() throws ApiException {
		testNotThrow(getClient().getMarginFeeData());
	}

	// @Test OK WORKS! but system might be short of asset
	void testGetMaxBorrowable() throws ApiException {
		testNotThrow(getClient().getMaxBorrowable(new MaxBorrowableParams(asset)));
	}

	@Test
	void testGetMaxTransferable() throws ApiException {
		testNotThrow(getClient().getMaxTransferable(new MaxTransferableParams(asset)));
	}

	@Test
	void testGetAsset() throws ApiException {
		testNotThrow(getClient().getAsset(new AssetParams(asset)));
	}

	@Test
	void testGetBNBBurnStatus() throws ApiException {
		testNotThrow(getClient().getBNBBurnStatus());
	}

	@Test
	void testEnableIsolatedAccount() throws ApiException {
		testNotThrow(getClient().enableIsolatedAccount(new ToogleAccountParams(isolatedSymbol)));
	}

	@Test
	void testGetAllAssets() throws ApiException {
		testNotThrow(getClient().getAllAssets());
	}

	@Test
	void testGetAllCrossMarginPairs() throws ApiException {
		testNotThrow(getClient().getAllCrossMarginPairs());
	}

	@Test
	void testGetAllIsolatedSymbols() throws ApiException {
		testNotThrow(getClient().getAllIsolatedSymbols());
	}

	@Test
	void testGetIsolatedFeeData() throws ApiException {
		testNotThrow(getClient().getIsolatedFeeData());
	}

	@Test
	void testGetIsolatedMarginTierData() throws ApiException {
		testNotThrow(getClient().getIsolatedMarginTierData(new IsolatedTierDataParams(isolatedSymbol)));
	}

	@Test
	void testGetIsolatedSymbol() throws ApiException {
		testNotThrow(getClient().getIsolatedSymbol(new PairParams(isolatedSymbol)));
	}

	@Test
	void testGetIsolatedTransferHistory() throws ApiException {
		testNotThrow(getClient().getIsolatedTransferHistory(new IsolatedTransferHistoryParams(symbol)));
	}

	// @Test General error?
	void testToggleBNBBurnOnSpotTradeAndMarginInterest() throws ApiException {
		testNotThrow(getClient().toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(false, false)));
		testNotThrow(getClient().toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(true, true)));
	}

	@Test
	void testGetInterestRateHistory() throws ApiException {
		testNotThrow(getClient().getInterestRateHistory(new InterestRateHistoryParams(asset)));
	}

	@Test
	void testGetCrossMarginPair() throws ApiException {
		testNotThrow(getClient().getCrossMarginPair(new PairParams(symbol)));
	}

	@Test
	void testGetEnabledIsolatedAccountLimit() throws ApiException {
		testNotThrow(getClient().getEnabledIsolatedAccountLimit());
	}

	@Test
	void testGetPriceIndex() throws ApiException {
		testNotThrow(getClient().getPriceIndex(new PriceIndexParams(symbol)));
	}

	@Test
	void testGetTransferHistory() throws ApiException {
		testNotThrow(getClient().getTransferHistory());
	}

	// @Test WORKS!
	void testGetOpenOrdersAndGetOrder() throws ApiException {
		List<OrderInfo> orders = getClient().getOpenOrders().sync();
		testHasNulls(orders, List.of("origQuoteOrderQty"), true);

		orders.forEach(o -> {
			try {
				testHasNulls(getClient().getOrder(new OrderParams(o.symbol(), o.orderId())),
						List.of("origQuoteOrderQty"),
						true);
			} catch (ApiException e) {
				e.printStackTrace();
			}

		});
	}

	// @Test WORKS!
	void testNewIsolatedTransfer() throws ApiException {

		testNotThrow(getClient().newIsolatedTransfer(new NewIsolatedTransferParams(isolatedAsset, isolatedSymbol,
				isolatedAmount, IsolatedTransferAccount.SPOT,
				IsolatedTransferAccount.ISOLATED_MARGIN)));

		testNotThrow(
				getClient().newIsolatedTransfer(
						new NewIsolatedTransferParams(isolatedAsset, isolatedSymbol, isolatedAmount,
								IsolatedTransferAccount.ISOLATED_MARGIN, IsolatedTransferAccount.SPOT)));
	}

	// @Test WORKS!
	void testDisableIsolatedAccount() throws ApiException {
		testNotThrow(getClient().disableIsolatedAccount(new ToogleAccountParams(isolatedSymbol)));
	}

	// @Test WORKS!
	void testTransfer() throws ApiException {
		testNotThrow(
				getClient().transfer(new TransferParams(isolatedAsset, isolatedAmount, TransferType.MAIN_TO_MARGIN)));
		testNotThrow(
				getClient().transfer(new TransferParams(isolatedAsset, isolatedAmount, TransferType.MARGIN_TO_MAIN)));
	}

	// @Test WORKS!
	void testGetAllOrders() throws ApiException {
		AllOrdersParams params = new AllOrdersParams("BTCBUSD");
		testHasNulls(getClient().getAllOrders(params), List.of("accountId", "origQuoteOrderQty"), true);
	}

	// @Test WORKS!
	void testNewOrder() throws ApiException {
		testHasNulls(getClient().newOrder(NewOrderParams.buy("BTCBUSD", "0.0004", "25000")),
				List.of("orderId", "quoteQty", "symbol", "marginBuyBorrowAmount", "marginBuyBorrowAsset"), true);
	}

	// ***** NOT TESTED ***** //

	// TODO @Test
	void testBorrow() throws ApiException {
		getClient().borrow(new BorrowParams(asset, "1"));
	}

	// TODO @Test
	void testCancelOCO() throws ApiException {
		testNotThrow(getClient().cancelOCO(new CancelOCOParams(symbol)));
	}

	// TODO @Test
	void testCancelOpenOrders() throws ApiException {
		testNotThrow(getClient().cancelOpenOrders(new CancelOpenOrdersParams(symbol)));
	}

	// TODO @Test
	void testCancelOrder() throws ApiException {
		testNotThrow(getClient().cancelOrder(new CancelOrderParams(symbol)));
	}

	// TODO @Test
	void testGetAllOCO() throws ApiException {
		testNotThrow(getClient().getAllOCO(new GetAllOCOParams(null, null)));
	}

	@Test
	void testGetForceLiquidationRecord() throws ApiException {
		testNotThrow(getClient().getForceLiquidationRecord(new ForceLiquidationRecordParams(null)));
	}

	// TODO @Test
	void testGetInterestHistory() throws ApiException {
		testNotThrow(getClient().getInterestHistory(new TransactionHistoryParams(asset)));
	}

	// TODO @Test
	void testGetLoanRecord() throws ApiException {
		testNotThrow(getClient().getLoanRecord(new TransactionHistoryParams(asset)));
	}

	// TODO @Test
	void testGetTrades() throws ApiException {
		testNotThrow(getClient().getTrades(new TradeParams(isolatedSymbol)));
	}

	// TODO @Test
	void testGetOCO() throws ApiException {
		testNotThrow(getClient().getOCO(new GetOCOParams(false)));
	}

	// TODO @Test
	void testGetOpenOCO() throws ApiException {
		testNotThrow(getClient().getOpenOCO());
	}

	// TODO @Test
	void testGetRepayRecord() throws ApiException {
		testNotThrow(getClient().getRepayRecord(new TransactionHistoryParams(asset)));
	}

	// TODO @Test
	void testNewOCO() throws ApiException {
		testNotThrow(getClient().newOCO(new NewOCOOrderParams(symbol, OrderSide.BUY, "1", "1", "1")));
	}

	// TODO @Test
	void testRepay() throws ApiException {
		testNotThrow(getClient().repay(new RepayParams(asset, "amount")));
	}

	@Test
	void testGetRateLimit() throws ApiException {
		testNotThrow(getClient().getRateLimit());
	}

	@Test
	void testGetRateLimit2() throws ApiException {
		testNotThrow(getClient().getRateLimit(new RateLimitParams("BTC")));
	}

	@Test
	void testGetDustLog() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(getClient().getDustLog());
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}
}
