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
import com.binance4j.wallet.param.FundingWalletParams;
import com.binance4j.wallet.param.TradeFeeParams;
import com.binance4j.wallet.param.WalletTransferHistoryParams;
import com.binance4j.wallet.param.WithdrawHistoryParams;
import com.binance4j.wallet.param.WithdrawParams;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class WalletClientTest extends CustomTest {
	protected WalletClient client = new WalletClient(key, secret);

	@Override
	protected WalletClient getClient() {
		return client;
	}

	@Test
	void testDisableFastWithdrawSwitch() throws ApiException {
		assertDoesNotThrow(() -> getClient().disableFastWithdrawSwitch().sync());
	}

	@Test
	void testEnableFastWithdrawSwitch() throws ApiException {
		assertDoesNotThrow(() -> getClient().enableFastWithdrawSwitch().sync());
	}

	// TODO @Test
	void testdustTransfer() throws ApiException {
		testNotThrow(getClient().dustTransfer(new DustTransferParams(assets)));
	}

	@Test
	void testGetAccountstatus() throws ApiException {
		testNotThrow(getClient().getAccountStatus());
	}

	@Test
	void testGetAllCoinsInfo() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(getClient().getAllCoinsInfo(),
				List.of("country", "specialTips", "specialWithdrawTips", "depositDust"),
				true);
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetApiPermissions() throws ApiException {
		testNotThrow(getClient().getApiPermissions());
	}

	@Test
	void testGetApiTradingStatus() throws ApiException {
		testNotThrow(getClient().getApiTradingStatus());
	}

	@Test
	void testGetAssetDetail() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(getClient().getAssetDetail());
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetAssetDetail2() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(getClient().getAssetDetail(new AssetDetailParams(asset)));
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetAssetDividendRecord() throws ApiException {
		testNotThrow(getClient().getAssetDividendRecord());
	}

	@Test
	void testGetAssetDividendRecord2() throws ApiException {
		testNotThrow(getClient().getAssetDividendRecord(new AssetDividendRecordParams(asset)));
	}

	@Test
	void testGetAssetDividendRecord3() throws ApiException {
		testNotThrow(getClient().getAssetDividendRecord(new AssetDividendRecordParams(asset), new TimeFrame(limit)));
	}

	@Test
	void testGetConvertibleAssets() throws ApiException {
		testNotThrow(getClient().getConvertibleAssets());

	}

	@Test
	void testGetDepositAddress() throws ApiException {
		testNotThrow(getClient().getDepositAddress(new DepositAddressParams("BNB")));
	}

	@Test
	void testGetDepositHistory() throws ApiException {
		testNotThrow(getClient().getDepositHistory());
	}

	@Test
	void testGetDepositHistory2() throws ApiException {
		testNotThrow(getClient().getDepositHistory(new DepositHistoryParams(asset)));
	}

	@Test
	void testGetDepositHistory3() throws ApiException {
		testNotThrow(getClient().getDepositHistory(new DepositHistoryParams(DepositStatus.SUCCESS)));
	}

	@Test
	void testGetDepositHistory4() throws ApiException {
		testNotThrow(getClient().getDepositHistory(new DepositHistoryParams(DepositStatus.SUCCESS, asset)));
	}

	@Test
	void testGetDustLog() throws ApiException {
		testNotThrow(getClient().getDustLog());

	}

	@Test
	void testGetDustLog2() throws ApiException {
		testNotThrow(getClient().getDustLog(new TimeFrame(10)));

	}

	@Test
	void testgetFundingWallet() throws ApiException {
		testNotThrow(getClient().getFundingWallet());
	}

	@Test
	void testgetFundingWallet2() throws ApiException {
		testNotThrow(getClient().getFundingWallet(new FundingWalletParams(asset)));
	}

	@Test
	void testgetFundingWallet3() throws ApiException {
		testNotThrow(getClient().getFundingWallet(new FundingWalletParams(asset, true)));
	}

	@Test
	void testGetFuturesAccountSnapshot() throws ApiException {
		testNotThrow(getClient().getFuturesAccountSnapshot());
	}

	@Test
	void testGetFuturesAccountSnapshot2() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(getClient().getFuturesAccountSnapshot(new TimeFrame(limit)));
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetMarginAccountSnapshot() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		MarginAccountSnapshotResponse res = getClient().getMarginAccountSnapshot(new TimeFrame(limit)).sync();
		assertDoesNotThrow(() -> assertTrue(getNullProperties(res, true).contains("marginLevel")));
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetSpotAccountSnapshot() throws ApiException {
		testNotThrow(getClient().getSpotAccountSnapshot());
	}

	@Test
	void testGetSpotAccountSnapshot2() throws ApiException {
		testNotThrow(getClient().getSpotAccountSnapshot(new TimeFrame(limit)));
	}

	@Test
	void testGetSystemStatus() throws ApiException {
		testNotThrow(getClient().getSystemStatus());
	}

	@Test
	void testGetTradeFee() throws ApiException {
		testNotThrow(getClient().getTradeFee());
	}

	@Test
	void testGetTradeFee2() throws ApiException {
		testNotThrow(getClient().getTradeFee(new TradeFeeParams("BNBBTC")));
	}

	@Test
	void testGetTransferHistory() throws ApiException {
		testNotThrow(getClient().getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN)));
	}

	@Test
	void testGetTransferHistory2() throws ApiException {
		testNotThrow(client
				.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset)));
	}

	@Test
	void testGetWithdrawHistory() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(getClient().getWithdrawHistory());
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetWithdrawHistory2() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		WithdrawStatus status = WithdrawStatus.COMPLETED;
		testNotThrow(getClient().getWithdrawHistory(new WithdrawHistoryParams("FTM", status)));
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);

	}

	@Test
	void testTransfer() throws ApiException {

	}

	// @Test
	void testWithdraw() throws ApiException {
		testNotThrow(getClient().withdraw(new WithdrawParams("amount", "coin", "address")));
	}
}
