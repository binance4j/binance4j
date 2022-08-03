package com.binance4j.wallet.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.binance4j.wallet.dto.AssetDetail;
import com.binance4j.wallet.dto.DepositStatus;
import com.binance4j.wallet.dto.FuturesAccountSnapshotResponse;
import com.binance4j.wallet.dto.MarginAccountSnapshotResponse;
import com.binance4j.wallet.param.AssetDetailParams;
import com.binance4j.wallet.param.DepositHistoryParams;
import com.binance4j.wallet.param.DustTransferParams;
import com.binance4j.wallet.param.WithdrawParams;

public class WalletClientTest extends CustomTest {
	protected WalletClient client = new WalletClient(key, secret);

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
		testNoNulls(client.dustTransfert(new DustTransferParams(assets)));
	}

	@Test
	void testGetAccountstatus() throws ApiException {
		testNoNulls(client.getAccountstatus());
	}

	@Test
	void testGetAllCoinsInfo() throws ApiException {
		testHasNulls(client.getAllCoinsInfo(), List.of("specialTips", "specialWithdrawTips", "depositDust"), true);
	}

	@Test
	void testGetApiPermissions() throws ApiException {
		testNoNulls(client.getApiPermissions());
	}

	@Test
	void testGetApiTradingStatus() throws ApiException {
		testNoNulls(client.getApiTradingStatus());
	}

	@Test
	void testGetAssetDetail() throws ApiException {
		testNoNulls(client.getAssetDetail());
	}

	@Test
	void testGetAssetDetail2() throws ApiException {
		AssetDetailParams params = new AssetDetailParams(asset);
		Map<String, AssetDetail> details = client.getAssetDetail(params).sync();
		assertEquals(1, details.size());
		assertTrue(details.containsKey(asset));
		testNoNulls(details);
	}

	@Test
	void testGetAssetDividendRecord() throws ApiException {

	}

	@Test
	void testGetAssetDividendRecord2() throws ApiException {

	}

	@Test
	void testGetAssetDividendRecord3() throws ApiException {

	}

	@Test
	void testGetAssetDividendRecord4() throws ApiException {

	}

	@Test
	void testGetConvertibleAssets() throws ApiException {

	}

	@Test
	void testGetConvertibleAssets2() throws ApiException {

	}

	@Test
	void testGetDepositAddress() throws ApiException {

	}

	@Test
	void testGetDepositHistory() throws ApiException {
		testNoNulls(client.getDepositHistory());
	}

	@Test
	void testGetDepositHistory2() throws ApiException {
		testNoNulls(client.getDepositHistory(new DepositHistoryParams(asset)));
	}

	@Test
	void testGetDepositHistory3() throws ApiException {
		testNoNulls(client.getDepositHistory(new DepositHistoryParams(DepositStatus.SUCCESS)));
	}

	@Test
	void testGetDepositHistory4() throws ApiException {
		testNoNulls(client.getDepositHistory(new DepositHistoryParams(DepositStatus.SUCCESS, asset)));
	}

	@Test
	void testGetDustLog() throws ApiException {
		testNoNulls(client.getDustLog());

	}

	@Test
	void testGetDustLog2() throws ApiException {
		testNoNulls(client.getDustLog(new TimeFrame(10)));

	}

	@Test
	void testGetFundingAsset() throws ApiException {

	}

	@Test
	void testGetFundingAsset2() throws ApiException {

	}

	@Test
	void testGetFuturesAccountSnapshot() throws ApiException {
		FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot().sync();
		testNoNulls(snapshot);
		assertNotEquals(0, snapshot.code());
	}

	@Test
	void testGetFuturesAccountSnapshot2() throws ApiException {
		FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot(new TimeFrame(limit)).sync();
		testNoNulls(snapshot);
		assertTrue(snapshot.snapshotVos().size() <= limit);
		assertNotEquals(0, snapshot.code());
	}

	@Test
	void testGetMarginAccountSnapshot() throws ApiException {
		MarginAccountSnapshotResponse res = client.getMarginAccountSnapshot(new TimeFrame(limit)).sync();
		assertDoesNotThrow(() -> assertTrue(getNullProperties(res, true).contains("marginLevel")));
	}

	@Test
	void testGetSpotAccountSnapshot() throws ApiException {
		testNoNulls(client.getSpotAccountSnapshot());
	}

	@Test
	void testGetSpotAccountSnapshot2() throws ApiException {
		testNoNulls(client.getSpotAccountSnapshot(new TimeFrame(limit)));
	}

	@Test
	void testGetSystemStatus() throws ApiException {
		testNoNulls(client.getSystemStatus());
	}

	@Test
	void testGetTradeFee() throws ApiException {

	}

	@Test
	void testGetTradeFee2() throws ApiException {

	}

	@Test
	void testGetTransferHistory() throws ApiException {

	}

	@Test
	void testGetTransferHistory2() throws ApiException {

	}

	@Test
	void testGetWithdrawHistory() throws ApiException {

	}

	@Test
	void testGetWithdrawHistory2() throws ApiException {

	}

	@Test
	void testGetWithdrawHistory3() throws ApiException {

	}

	@Test
	void testTransfer() throws ApiException {

	}

	@Test
	void testWithdraw() throws ApiException {
		testNoNulls(client.withdraw(new WithdrawParams("amount", "coin", "address")));
	}
}
