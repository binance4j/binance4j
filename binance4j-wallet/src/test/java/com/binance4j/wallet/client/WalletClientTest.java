package com.binance4j.wallet.client;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exchangeinfo.ExchangeInfoRequest;
import com.binance4j.wallet.accountstatus.AccountStatus;
import com.binance4j.wallet.assetdetail.AssetDetail;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecord;
import com.binance4j.wallet.coinsinfo.CoinInformation;
import com.binance4j.wallet.deposit.DepositAddress;
import com.binance4j.wallet.deposit.DepositAddressRequest;
import com.binance4j.wallet.deposit.DepositHistory;
import com.binance4j.wallet.dust.DustLog;
import com.binance4j.wallet.dust.DustLogRequest;
import com.binance4j.wallet.funding.FundingAsset;
import com.binance4j.wallet.permissions.ApiPermissions;
import com.binance4j.wallet.snapshot.futures.FuturesAccountSnapshotResponse;
import com.binance4j.wallet.snapshot.margin.MarginAccountSnapshotResponse;
import com.binance4j.wallet.snapshot.spot.SpotAccountSnapshotResponse;
import com.binance4j.wallet.systemstatus.SystemStatus;
import com.binance4j.wallet.tradefee.TradeFee;
import com.binance4j.wallet.tradefee.TradeFeeRequest;
import com.binance4j.wallet.tradingstatus.ApiTradingStatus;
import com.binance4j.wallet.transfer.WalletTransferHistory;
import com.binance4j.wallet.transfer.WalletTransferHistoryRequest;
import com.binance4j.wallet.transfer.WalletTransferType;
import com.binance4j.wallet.withdraw.FastWithdrawSwitchRequest;
import com.binance4j.wallet.withdraw.WithdrawHistory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WalletClientTest {
    WalletClient client;

    public WalletClientTest() {
        String key = System.getenv("BINANCE_API_KEY");
        String secret = System.getenv("BINANCE_API_SECRET");
        client = new WalletClient(key, secret, false);
    }

    @Test
    @DisplayName("Properties shouldn't be null")
    public void testGetSystemStatus() throws ApiException {
            SystemStatus status = client.getSystemStatus().execute();
            assertNotNull(status.getMessage());
            assertNotNull(status.getStatus());
    }

    @Test
    @DisplayName("Properties shouldn't be null")
    public void testGetAllCoinsInfo() throws ApiException {
            List<CoinInformation> infos = client.getAllCoinsInfo().execute();
            infos.forEach(i -> {
                assertNotNull(i.getCoin());
                assertNotNull(i.getDepositAllEnable());
                assertNotNull(i.getFree());
                assertNotNull(i.getFreeze());
                assertNotNull(i.getIpoable());
                assertNotNull(i.getIpoing());
                assertNotNull(i.getIsLegalMoney());
                assertNotNull(i.getLocked());
                assertNotNull(i.getName());
                assertNotNull(i.getNetworkList());
                assertNotNull(i.getStorage());
                assertNotNull(i.getTrading());
                assertNotNull(i.getWithdrawAllEnable());
                assertNotNull(i.getWithdrawing());
            });
    }

    @Test
    @DisplayName("Properties shouldn't be null")
    public void testGetSpotAccountSnapshot() throws ApiException {
            SpotAccountSnapshotResponse snapshot = client.getSpotAccountSnapshot().execute();
            assertNotEquals(0, snapshot.getCode());
            assertNotNull(snapshot.getMsg());

            snapshot.getSnapshotVos().forEach(s -> {
                s.getData().getBalances().forEach(b -> {
                    assertNotNull(b.getClass());
                    assertNotNull(b.getFree());
                    assertNotNull(b.getLocked());
                });
                assertNotNull(s.getData().getTotalAssetOfBtc());
                assertNotNull(s.getType());
                assertNotNull(s.getUpdateTime());

            });
    }

    // @Test
    @DisplayName("Properties shouldn't be null")
    public void testGetMarginAccountSnapshot() throws InterruptedException, ExecutionException, ApiException {
            MarginAccountSnapshotResponse snapshot = client.getMarginAccountSnapshot().execute();
            assertNotEquals(0, snapshot.getCode());
            assertNotNull(snapshot.getMsg());

            snapshot.getSnapshotVos().forEach(s -> {
                assertNotNull(s.getType());
                assertNotNull(s.getUpdateTime());
                assertNotNull(s.getData().getMarginLevel());
                assertNotNull(s.getData().getTotalAssetOfBtc());
                assertNotNull(s.getData().getTotalLiabilityOfBtc());
                assertNotNull(s.getData().getTotalNetAssetOfBtc());
                s.getData().getUserAssets().forEach(ua -> {
                    assertNotNull(ua.getAsset());
                    assertNotNull(ua.getBorrowed());
                    assertNotNull(ua.getFree());
                    assertNotNull(ua.getInterest());
                    assertNotNull(ua.getLocked());
                    assertNotNull(ua.getNetAsset());
                });
            });
    }

    @Test
    @DisplayName("Properties shouldn't be null")
    public void testGetFuturesAccountSnapshot() throws ApiException {
            FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot().execute();
            assertNotEquals(0, snapshot.getCode());
            assertNotNull(snapshot.getSnapshotVos());

            snapshot.getSnapshotVos().forEach(s -> {
                assertNotNull(s.getType());
                assertNotNull(s.getUpdateTime());
                assertNotNull(s.getData().getPosition());
                s.getData().getAssets().forEach(a -> {
                    assertNotNull(a.getAsset());
                    assertNotNull(a.getMarginBalance());
                    assertNotNull(a.getWalletBalance());
                });
            });
    }

    @Test
    @DisplayName("Properties shouldn't be null")
    public void testDisableFastWithdrawSwitch() throws ApiException {
            client.disableFastWithdrawSwitch(new FastWithdrawSwitchRequest()).execute();
            System.out.println("ok");
            assertNotNull("ok");
    }

    @Test
    @DisplayName("Properties shouldn't be null")
    public void testEnableFastWithdrawSwitch() throws ApiException {
            client.enableFastWithdrawSwitch(new FastWithdrawSwitchRequest()).execute();
            System.out.println("ok");
            assertNotNull("ok");
    }

    @Test
    @DisplayName("Properties shouldn't be null")
    public void testGetDepositHistory() throws ApiException {
            List<DepositHistory> history = client.getDepositHistory().execute();
            history.forEach(h -> {
                assertNotNull(h.getAddress());
                assertNotNull(h.getAddressTag());
                assertNotNull(h.getAmount());
                assertNotNull(h.getCoin());
                assertNotNull(h.getConfirmTimes());
                assertNotNull(h.getInsertTime());
                assertNotNull(h.getNetwork());
                assertNotNull(h.getStatus());
                assertNotNull(h.getTransferType());
                assertNotNull(h.getTxId());
                assertNotNull(h.getUnlockConfirm());
            });
    }

    @Test
    @DisplayName("Properties shouldn't be null")
    public void testGetWithdrawHistory() throws ApiException {
        List<WithdrawHistory> history = client.getWithdrawHistory().execute();
        history.forEach(h -> {
            assertNotNull(h.getAddress());
            assertNotNull(h.getAmount());
            assertNotNull(h.getApplyTime());
            assertNotNull(h.getCoin());
            assertNotNull(h.getConfirmNo());
            assertNotNull(h.getId());
            assertNotNull(h.getInfo());
            assertNotNull(h.getNetwork());
            assertNotNull(h.getStatus());
            assertNotNull(h.getTransactionFee());
            assertNotNull(h.getTransferType());
            assertNotNull(h.getTxId());
            // not always true
            // assertNotNull(h.getWithdrawOrderId());
        });
    }

    // Test is hidden due to localisation restrictions when using github actions
    // (USA?)
    // @Test
    @DisplayName("Properties shouldn't be null")
    public void testGetDepositAddress() throws ApiException {
            DepositAddress address = client.getDepositAddress(new DepositAddressRequest("BNB")).execute();
            assertNotNull(address.getAddress());
            assertNotNull(address.getCoin());
            assertNotNull(address.getTag());
            assertNotNull(address.getUrl());
    }

    @Test
    @DisplayName("Properties shouldn't be null")
    public void testGetAccountstatus() throws ApiException {
            AccountStatus status = client.getAccountstatus().execute();
            assertNotNull(status.getData());
    }

    @Test
    @DisplayName("Properties shouldn't be null")
    public void testGetApiTradingStatus() throws ApiException {
        ExchangeInfoRequest req = new ExchangeInfoRequest();
        req.getSymbols();
            ApiTradingStatus status = client.getApiTradingStatus().execute();
            assertNotNull(status.getData().getIsLocked());
            assertNotNull(status.getData().getPlannedRecoverTime());
            assertNotNull(status.getData().getTriggerCondition().getGCR());
            assertNotNull(status.getData().getTriggerCondition().getIFER());
            assertNotNull(status.getData().getTriggerCondition().getUFR());
            assertNotNull(status.getData().getUpdateTime());
    }

    @Test
    @DisplayName("Properties shouldn't be null")
    public void testGetDustLog() throws ApiException {
            DustLog log = client.getDustLog(new DustLogRequest()).execute();
            assertNotNull(log.getTotal());
            log.getUserAssetDribblets().forEach(uad -> {
                assertNotNull(uad.getOperateTime());
                assertNotNull(uad.getTotalServiceChargeAmount());
                assertNotNull(uad.getTotalTransferedAmount());
                assertNotNull(uad.getTransId());
                uad.getUserAssetDribbletDetails().forEach(d -> {
                    assertNotNull(d.getAmount());
                    assertNotNull(d.getFromAsset());
                    assertNotNull(d.getOperateTime());
                    assertNotNull(d.getServiceChargeAmount());
                    assertNotNull(d.getTransId());
                    assertNotNull(d.getTransferedAmount());
                });
            });
    }


    @Test
    public void testGetApiPermissions() throws ApiException {
            ApiPermissions permissions = client.getApiPermissions().execute();
            assertNotNull(permissions.getCreateTime());
            assertNotNull(permissions.getEnableFutures());
            assertNotNull(permissions.getEnableInternalTransfer());
            assertNotNull(permissions.getEnableMargin());
            assertNotNull(permissions.getEnableReading());
            assertNotNull(permissions.getEnableSpotAndMarginTrading());
            assertNotNull(permissions.getEnableVanillaOptions());
            assertNotNull(permissions.getEnableWithdrawals());
            assertNotNull(permissions.getIpRestrict());
            assertNotNull(permissions.getPermitsUniversalTransfer());
            // can be null if not configured to expire
            // assertNotNull(permissions.getTradingAuthorityExpirationTime());
    }

    @Test
    public void testGetAssetDetail() throws ApiException {
            Map<String, AssetDetail> details = client.getAssetDetail().execute();
            details.values().forEach(v -> {
                assertNotNull(v.getDepositStatus());
                // sometimes empty
                // assertNotNull(v.getDepositTip());
                assertNotNull(v.getMinWithdrawAmount());
                assertNotNull(v.getWithdrawFee());
                assertNotNull(v.getWithdrawStatus());
            });
    }

    @Test
    public void testGetAssetDividend() throws ApiException {
            AssetDividendRecord record = client.getAssetDividendRecord().execute();
            assertNotNull(record.getTotal());
            record.getRows().forEach(r -> {
                assertNotNull(r.getAmount());
                assertNotNull(r.getAsset());
                assertNotNull(r.getDivTime());
                assertNotNull(r.getEnInfo());
                assertNotNull(r.getId());
                assertNotNull(r.getTranId());
            });
    }

    @Test
    public void testGetFundingAsset() throws ApiException {
            List<FundingAsset> fundings = client.getFundingAsset().execute();
            fundings.forEach(f -> {
                assertNotNull(f.getAsset());
                assertNotNull(f.getBtcValuation());
                assertNotNull(f.getFree());
                assertNotNull(f.getFreeze());
                assertNotNull(f.getLocked());
                assertNotNull(f.getWithdrawing());
            });
    }

    @Test
    public void testGetTradeFeeOfAll() throws ApiException {
        List<TradeFee> fees = client.getTradeFee().execute();
        fees.forEach(f -> {
            assertNotNull(f.getMakerCommission());
            assertNotNull(f.getSymbol());
            assertNotNull(f.getTakerCommission());
        });
        assertNotNull(fees);
    }

    @Test
    public void testGetTradeFeeOfOne() throws ApiException {
        List<TradeFee> fees = client.getTradeFee(new TradeFeeRequest("BNBBTC")).execute();

        fees.forEach(f -> {
            assertNotNull(f.getMakerCommission());
            assertNotNull(f.getSymbol());
            assertNotNull(f.getTakerCommission());
        });

        assertNotNull(fees);
    }

    @Test
    public void testGetTransferHistory() throws ApiException {
            WalletTransferHistory history = client
                    .getTransferHistory(new WalletTransferHistoryRequest(WalletTransferType.MAIN_FUNDING)).execute();
            assertNotNull(history.getTotal());
            if (history.getRows() != null) {
                history.getRows().forEach(r -> {
                    assertNotNull(r.getAmount());
                    assertNotNull(r.getAsset());
                    assertNotNull(r.getStatus());
                    assertNotNull(r.getTimestamp());
                    assertNotNull(r.getTranId());
                    assertNotNull(r.getType());
                });
            }
    }
}
