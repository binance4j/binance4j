package com.binance4j.margin.client;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.dto.OrderInfo;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.margin.dto.IsolatedTransferAccount;
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
	}

	@Test
	void testGetAccount() throws ApiException {
		testNoNulls(client.getAccount());
	}

	@Test
	void testGetIsolatedAccount() throws ApiException {
		testNoNulls(client.getIsolatedAccount());
	}

	@Test
	void testGetMarginFeeData() throws ApiException {
		testNoNulls(client.getMarginFeeData());
	}

	// @Test OK WORKS! but system might be short of asset
	void testGetMaxBorrowable() throws ApiException {
		testNoNulls(client.getMaxBorrowable(new MaxBorrowableParams(asset)));
	}

	@Test
	void testGetMaxTransferable() throws ApiException {
		testNoNulls(client.getMaxTransferable(new MaxTransferableParams(asset)));
	}

	@Test
	void testGetAsset() throws ApiException {
		testNoNulls(client.getAsset(new AssetParams(asset)));
	}

	@Test
	void testGetBNBBurnStatus() throws ApiException {
		testNoNulls(client.getBNBBurnStatus());
	}

	@Test
	void testEnableIsolatedAccount() throws ApiException {
		testNoNulls(client.enableIsolatedAccount(new ToogleAccountParams(isolatedSymbol)));
	}

	@Test
	void testGetAllAssets() throws ApiException {
		testNoNulls(client.getAllAssets());
	}

	@Test
	void testGetAllCrossMarginPairs() throws ApiException {
		testNoNulls(client.getAllCrossMarginPairs());
	}

	@Test
	void testGetAllIsolatedSymbols() throws ApiException {
		testNoNulls(client.getAllIsolatedSymbols());
	}

	@Test
	void testGetIsolatedFeeData() throws ApiException {
		testNoNulls(client.getIsolatedFeeData());
	}

	@Test
	void testGetIsolatedMarginTierData() throws ApiException {
		testNoNulls(client.getIsolatedMarginTierData(new IsolatedTierDataParams(isolatedSymbol)));
	}

	@Test
	void testGetIsolatedSymbol() throws ApiException {
		testNoNulls(client.getIsolatedSymbol(new PairParams(isolatedSymbol)));
	}

	@Test
	void testGetIsolatedTransferHistory() throws ApiException {
		testNoNulls(client.getIsolatedTransferHistory(new IsolatedTransferHistoryParams(symbol)));
	}

	@Test
	void testToggleBNBBurnOnSpotTradeAndMarginInterest() throws ApiException {
		testNoNulls(client.toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(true, true)));
		testNoNulls(client.toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(true, true)));

	}

	@Test
	void testGetInterestRateHistory() throws ApiException {
		testNoNulls(client.getInterestRateHistory(new InterestRateHistoryParams(asset)));
	}

	@Test
	void testGetCrossMarginPair() throws ApiException {
		testNoNulls(client.getCrossMarginPair(new PairParams(symbol)));
	}

	@Test
	void testGetEnabledIsolatedAccountLimit() throws ApiException {
		testNoNulls(client.getEnabledIsolatedAccountLimit());
	}

	@Test
	void testGetPriceIndex() throws ApiException {
		testNoNulls(client.getPriceIndex(new PriceIndexParams(symbol)));
	}

	@Test
	void testGetTransferHistory() throws ApiException {
		testNoNulls(client.getTransferHistory());
	}

	// @Test WORKS!
	void testGetOpenOrdersAndGetOrder() throws ApiException {
		List<OrderInfo> orders = client.getOpenOrders().sync();
		testHasNulls(orders, List.of("origQuoteOrderQty"), true);

		orders.forEach(o -> {
			try {
				testHasNulls(client.getOrder(new OrderParams(o.symbol(), o.orderId())), List.of("origQuoteOrderQty"), true);
			} catch (ApiException e) {
				e.printStackTrace();
			}

		});
	}

	// @Test WORKS!
	void testNewIsolatedTransfer() throws ApiException {

		testNoNulls(client.newIsolatedTransfer(new NewIsolatedTransferParams(isolatedAsset, isolatedSymbol, isolatedAmount, IsolatedTransferAccount.SPOT,
				IsolatedTransferAccount.ISOLATED_MARGIN)));

		testNoNulls(client.newIsolatedTransfer(new NewIsolatedTransferParams(isolatedAsset, isolatedSymbol, isolatedAmount,
				IsolatedTransferAccount.ISOLATED_MARGIN, IsolatedTransferAccount.SPOT)));
	}

	// @Test WORKS!
	void testDisableIsolatedAccount() throws ApiException {
		testNoNulls(client.disableIsolatedAccount(new ToogleAccountParams(isolatedSymbol)));
	}

	// @Test WORKS!
	void testTransfer() throws ApiException {
		testNoNulls(client.transfer(new TransferParams(isolatedAsset, isolatedAmount, TransferType.MAIN_TO_MARGIN)));
		testNoNulls(client.transfer(new TransferParams(isolatedAsset, isolatedAmount, TransferType.MARGIN_TO_MAIN)));
	}

	// @Test WORKS!
	void testGetAllOrders() throws ApiException {
		AllOrdersParams params = new AllOrdersParams("BTCBUSD");
		testHasNulls(client.getAllOrders(params), List.of("accountId", "origQuoteOrderQty"), true);
	}

	// @Test WORKS!
	void testNewOrder() throws ApiException {
		testHasNulls(client.newOrder(NewOrderParams.buyLimit("BTCBUSD", "0.0004", "25000")),
				List.of("orderId", "quoteQty", "symbol", "marginBuyBorrowAmount", "marginBuyBorrowAsset"), true);
	}

	// ***** NOT TESTED ***** //

	// TODO @Test
	void testBorrow() throws ApiException {
		client.borrow(new BorrowParams(asset, "1"));
	}

	// TODO @Test
	void testCancelOCO() throws ApiException {
		testNoNulls(client.cancelOCO(new CancelOCOParams(symbol)));
	}

	// TODO @Test
	void testCancelOpenOrders() throws ApiException {
		testNoNulls(client.cancelOpenOrders(new CancelOpenOrdersParams(symbol)));
	}

	// TODO @Test
	void testCancelOrder() throws ApiException {
		testNoNulls(client.cancelOrder(new CancelOrderParams(symbol)));
	}

	// TODO @Test
	void testGetAllOCO() throws ApiException {
		testNoNulls(client.getAllOCO(new GetAllOCOParams()));
	}

	@Test
	void testGetForceLiquidationRecord() throws ApiException {
		testNoNulls(client.getForceLiquidationRecord(new ForceLiquidationRecordParams()));
	}

	// TODO @Test
	void testGetInterestHistory() throws ApiException {
		testNoNulls(client.getInterestHistory(new TransactionHistoryParams(asset)));
	}

	// TODO @Test
	void testGetLoanRecord() throws ApiException {
		testNoNulls(client.getLoanRecord(new TransactionHistoryParams(asset)));
	}

	// TODO @Test
	void testGetMyTrades() throws ApiException {
		testNoNulls(client.getMyTrades(new TradeParams(isolatedSymbol)));
	}

	// TODO @Test
	void testGetOCO() throws ApiException {
		testNoNulls(client.getOCO(new GetOCOParams(false)));
	}

	// TODO @Test
	void testGetOpenOCO() throws ApiException {
		testNoNulls(client.getOpenOCO());
	}

	// TODO @Test
	void testGetRepayRecord() throws ApiException {
		testNoNulls(client.getRepayRecord(new TransactionHistoryParams(asset)));
	}

	// TODO @Test
	void testNewOCO() throws ApiException {
		testNoNulls(client.newOCO(new NewOCOOrderParams(symbol, OrderSide.BUY, "1", "1", "1")));
	}

	// TODO @Test
	void testRepay() throws ApiException {
		testNoNulls(client.repay(new RepayParams(asset, "amount")));
	}
}
