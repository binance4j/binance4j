package com.binance4j.wallet.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.binance4j.wallet.dto.DepositStatus;
import com.binance4j.wallet.dto.MarginAccountSnapshotResponse;
import com.binance4j.wallet.dto.WalletTransferType;
import com.binance4j.wallet.dto.WithdrawStatus;
import com.binance4j.wallet.param.AssetDetailParams;
import com.binance4j.wallet.param.AssetDividendRecordParams;
import com.binance4j.wallet.param.DepositAddressParams;
import com.binance4j.wallet.param.DepositHistoryParams;
import com.binance4j.wallet.param.DustTransferParams;
import com.binance4j.wallet.param.FundingAssetParams;
import com.binance4j.wallet.param.TradeFeeParams;
import com.binance4j.wallet.param.WalletTransferHistoryParams;
import com.binance4j.wallet.param.WithdrawHistoryParams;
import com.binance4j.wallet.param.WithdrawParams;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class WalletClientTest extends CustomTest {
	protected WalletClient client = new WalletClient(key, secret);

	public WalletClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testDisableFastWithdrawSwitch() throws ApiException {
		assertDoesNotThrow(() -> client.disableFastWithdrawSwitch().sync());
	}

	@Test
	void testEnableFastWithdrawSwitch() throws ApiException {
		assertDoesNotThrow(() -> client.enableFastWithdrawSwitch().sync());
	}

	// TODO @Test
	void testDustTransfert() throws ApiException {
		testNotThrow(client.dustTransfert(new DustTransferParams(assets)));
	}

	@Test
	void testGetAccountstatus() throws ApiException {
		testNotThrow(client.getAccountStatus());
	}

	@Test
	void testGetAllCoinsInfo() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(client.getAllCoinsInfo(), List.of("country", "specialTips", "specialWithdrawTips", "depositDust"), true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetApiPermissions() throws ApiException {
		testNotThrow(client.getApiPermissions());
	}

	@Test
	void testGetApiTradingStatus() throws ApiException {
		testNotThrow(client.getApiTradingStatus());
	}

	@Test
	void testGetAssetDetail() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(client.getAssetDetail());
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetAssetDetail2() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(client.getAssetDetail(new AssetDetailParams(asset)));
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetAssetDividendRecord() throws ApiException {
		testNotThrow(client.getAssetDividendRecord());
	}

	@Test
	void testGetAssetDividendRecord2() throws ApiException {
		testNotThrow(client.getAssetDividendRecord(new AssetDividendRecordParams(asset)));
	}

	@Test
	void testGetAssetDividendRecord3() throws ApiException {
		testNotThrow(client.getAssetDividendRecord(new AssetDividendRecordParams(asset), new TimeFrame(limit)));
	}

	@Test
	void testGetConvertibleAssets() throws ApiException {
		testNotThrow(client.getConvertibleAssets());

	}

	@Test
	void testGetDepositAddress() throws ApiException {
		testNotThrow(client.getDepositAddress(new DepositAddressParams("BNB")));
	}

	@Test
	void testGetDepositHistory() throws ApiException {
		testNotThrow(client.getDepositHistory());
	}

	@Test
	void testGetDepositHistory2() throws ApiException {
		testNotThrow(client.getDepositHistory(new DepositHistoryParams(asset)));
	}

	@Test
	void testGetDepositHistory3() throws ApiException {
		testNotThrow(client.getDepositHistory(new DepositHistoryParams(DepositStatus.SUCCESS)));
	}

	@Test
	void testGetDepositHistory4() throws ApiException {
		testNotThrow(client.getDepositHistory(new DepositHistoryParams(DepositStatus.SUCCESS, asset)));
	}

	@Test
	void testGetDustLog() throws ApiException {
		testNotThrow(client.getDustLog());

	}

	@Test
	void testGetDustLog2() throws ApiException {
		testNotThrow(client.getDustLog(new TimeFrame(10)));

	}

	@Test
	void testGetFundingAsset() throws ApiException {
		testNotThrow(client.getFundingAsset());
	}

	@Test
	void testGetFundingAsset2() throws ApiException {
		testNotThrow(client.getFundingAsset(new FundingAssetParams(asset)));
	}

	@Test
	void testGetFundingAsset3() throws ApiException {
		testNotThrow(client.getFundingAsset(new FundingAssetParams(asset, true)));
	}

	@Test
	void testGetFuturesAccountSnapshot() throws ApiException {
		testNotThrow(client.getFuturesAccountSnapshot());
	}

	@Test
	void testGetFuturesAccountSnapshot2() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(client.getFuturesAccountSnapshot(new TimeFrame(limit)));
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetMarginAccountSnapshot() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		MarginAccountSnapshotResponse res = client.getMarginAccountSnapshot(new TimeFrame(limit)).sync();
		assertDoesNotThrow(() -> assertTrue(getNullProperties(res, true).contains("marginLevel")));
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetSpotAccountSnapshot() throws ApiException {
		testNotThrow(client.getSpotAccountSnapshot());
	}

	@Test
	void testGetSpotAccountSnapshot2() throws ApiException {
		testNotThrow(client.getSpotAccountSnapshot(new TimeFrame(limit)));
	}

	@Test
	void testGetSystemStatus() throws ApiException {
		testNotThrow(client.getSystemStatus());
	}

	@Test
	void testGetTradeFee() throws ApiException {
		testNotThrow(client.getTradeFee());
	}

	@Test
	void testGetTradeFee2() throws ApiException {
		testNotThrow(client.getTradeFee(new TradeFeeParams("BNBBTC")));
	}

	@Test
	void testGetTransferHistory() throws ApiException {
		testNotThrow(client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN)));
	}

	@Test
	void testGetTransferHistory2() throws ApiException {
		testNotThrow(client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset)));
	}

	@Test
	void testGetWithdrawHistory() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(client.getWithdrawHistory(), List.of("withdrawOrderId"), true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetWithdrawHistory2() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		WithdrawStatus status = WithdrawStatus.COMPLETED;
		testHasNulls(client.getWithdrawHistory(new WithdrawHistoryParams("FTM", status)), List.of("withdrawOrderId"), true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);

	}

	@Test
	void testTransfer() throws ApiException {

	}

	// @Test
	void testWithdraw() throws ApiException {
		testNotThrow(client.withdraw(new WithdrawParams("amount", "coin", "address")));
	}
}
