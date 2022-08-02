package com.binance4j.margin.client;

import org.junit.jupiter.api.Test;

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
import com.binance4j.margin.param.TransactionHistoryParams;
import com.binance4j.margin.param.TransferParams;

public class MarginClientTest extends CustomTest {
	protected MarginClient client = new TestnetMarginClient(testnetKey, testnetSecret);

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

	@Test
	void testDisableIsolatedAccount() throws ApiException {
		testNoNulls(client.disableIsolatedAccount(new ToogleAccountParams(symbol)));
	}

	@Test
	void testEnableIsolatedAccount() throws ApiException {
		testNoNulls(client.enableIsolatedAccount(new ToogleAccountParams(symbol)));
	}

	@Test
	void testGetAccount() throws ApiException {
		testNoNulls(client.getAccount());
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
	void testGetAllOCO() throws ApiException {
		testNoNulls(client.getAllOCO(new GetAllOCOParams()));
	}

	@Test
	void testGetAllOrders() throws ApiException {
		AllOrdersParams params = new AllOrdersParams(symbol);
		testNoNulls(client.getAllOrders(params));
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
	void testGetCrossMarginPair() throws ApiException {
		testNoNulls(client.getCrossMarginPair(new PairParams(symbol)));
	}

	@Test
	void testGetEnabledIsolatedAccountLimit() throws ApiException {
		testNoNulls(client.getEnabledIsolatedAccountLimit());
	}

	@Test
	void testGetForceLiquidationRecord() throws ApiException {
		testNoNulls(client.getForceLiquidationRecord(new ForceLiquidationRecordParams()));
	}

	@Test
	void testGetInterestHistory() throws ApiException {
		testNoNulls(client.getInterestHistory(new TransactionHistoryParams(asset)));
	}

	@Test
	void testGetInterestRateHistory() throws ApiException {
		testNoNulls(client.getInterestRateHistory(new InterestRateHistoryParams(asset)));
	}

	@Test
	void testGetIsolatedAccount() throws ApiException {

		testNoNulls(client.getIsolatedAccount());
	}

	@Test
	void testGetIsolatedFeeData() throws ApiException {
		testNoNulls(client.getIsolatedFeeData());
	}

	@Test
	void testGetIsolatedMarginTierData() throws ApiException {
		testNoNulls(client.getIsolatedMarginTierData(new IsolatedTierDataParams(symbol)));
	}

	@Test
	void testGetIsolatedSymbol() throws ApiException {
		testNoNulls(client.getIsolatedSymbol(new PairParams(symbol)));
	}

	@Test
	void testGetIsolatedTransferHistory() throws ApiException {
		testNoNulls(client.getIsolatedTransferHistory(new IsolatedTransferHistoryParams(symbol)));
	}

	@Test
	void testGetLoanRecord() throws ApiException {
		testNoNulls(client.getLoanRecord(new TransactionHistoryParams(asset)));
	}

	@Test
	void testGetMarginFeeData() throws ApiException {
		testNoNulls(client.getMarginFeeData());
	}

	@Test
	void testGetMaxBorrowable() throws ApiException {
		testNoNulls(client.getMaxBorrowable(new MaxBorrowableParams(asset)));
	}

	@Test
	void testGetMaxTransferable() throws ApiException {
		testNoNulls(client.getMaxTransferable(new MaxTransferableParams(asset)));
	}

	@Test
	void testGetMyTrades() throws ApiException {
		testNoNulls(client.getMyTrades());
	}

	@Test
	void testGetOCO() throws ApiException {
		testNoNulls(client.getOCO(new GetOCOParams(false)));
	}

	@Test
	void testGetOpenOCO() throws ApiException {
		testNoNulls(client.getOpenOCO());
	}

	@Test
	void testGetOpenOrders() throws ApiException {
		testNoNulls(client.getOpenOrders());
	}

	@Test
	void testGetOrder() throws ApiException {
		testNoNulls(client.getOrder(new OrderParams(symbol)));
	}

	@Test
	void testGetPriceIndex() throws ApiException {
		testNoNulls(client.getPriceIndex(new PriceIndexParams(symbol)));
	}

	@Test
	void testGetRepayRecord() throws ApiException {
		testNoNulls(client.getRepayRecord(new TransactionHistoryParams(asset)));
	}

	@Test
	void testGetTransferHistory() throws ApiException {
		testNoNulls(client.getTransferHistory());
	}

	@Test
	void testNewIsolatedTransfer() throws ApiException {
		testNoNulls(client
				.newIsolatedTransfer(new NewIsolatedTransferParams(asset, symbol, "1", IsolatedTransferAccount.SPOT, IsolatedTransferAccount.ISOLATED_MARGIN)));
	}

	@Test
	void testNewOCO() throws ApiException {
		testNoNulls(client.newOCO(new NewOCOOrderParams(symbol, OrderSide.BUY, "1", "1", "1")));
	}

	@Test
	void testNewOrder() throws ApiException {
		testNoNulls(client.newOrder(NewOrderParams.buyMarket(symbol, "1")));
	}

	@Test
	void testRepay() throws ApiException {
		testNoNulls(client.repay(new RepayParams(asset, "amount")));
	}

	@Test
	void testToggleBNBBurnOnSpotTradeAndMarginInterest() throws ApiException {
		testNoNulls(client.toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(true, true)));
		testNoNulls(client.toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(true, true)));

	}

	@Test
	void testTransfer() throws ApiException {
		testNoNulls(client.transfer(new TransferParams(asset, "amount", TransferType.MAIN_TO_MARGIN)));
	}
}
