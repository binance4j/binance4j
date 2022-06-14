package com.binance4j.wallet.client;

import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.wallet.accountstatus.AccountStatus;
import com.binance4j.wallet.assetdetail.AssetDetail;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecord;
import com.binance4j.wallet.coinsinfo.CoinInformation;
import com.binance4j.wallet.deposit.DepositAddress;
import com.binance4j.wallet.deposit.DepositHistory;
import com.binance4j.wallet.dust.ConvertibleAssets;
import com.binance4j.wallet.dust.DustLog;
import com.binance4j.wallet.dust.DustTransferResponse;
import com.binance4j.wallet.funding.FundingAsset;
import com.binance4j.wallet.permissions.ApiPermissions;
import com.binance4j.wallet.snapshot.AccountSnapshotType;
import com.binance4j.wallet.snapshot.futures.FuturesAccountSnapshotResponse;
import com.binance4j.wallet.snapshot.margin.MarginAccountSnapshotResponse;
import com.binance4j.wallet.snapshot.spot.SpotAccountSnapshotResponse;
import com.binance4j.wallet.systemstatus.SystemStatus;
import com.binance4j.wallet.tradefee.TradeFee;
import com.binance4j.wallet.tradingstatus.ApiTradingStatus;
import com.binance4j.wallet.transfer.WalletTransferHistory;
import com.binance4j.wallet.transfer.WalletTransferResponse;
import com.binance4j.wallet.withdraw.WithdrawHistory;
import com.binance4j.wallet.withdraw.WithdrawResult;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Binance Wallet endpoints mapping
 */
public interface WalletMapping {

	String BASE = "/sapi/v1/";
	String BASE_ASSET = BASE + "asset/";
	String BASE_CAPITAL = BASE + "capital/";
	String BASE_ACCOUNT = BASE + "account/";
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;

	@GET(BASE + "system/status")
	Call<SystemStatus> getSystemStatus();

	@Headers(SIGNED_H)
	@GET(BASE_CAPITAL + "config/getall")
	Call<List<CoinInformation>> getAllCoinsInfo(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE + "accountSnapshot")
	Call<SpotAccountSnapshotResponse> getSpotAccountSnapshot(@Query("type") AccountSnapshotType type,
	                                                         @QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE + "accountSnapshot")
	Call<MarginAccountSnapshotResponse> getMarginAccountSnapshot(@Query("type") AccountSnapshotType type,
	                                                             @QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE + "accountSnapshot")
	Call<FuturesAccountSnapshotResponse> getFuturesAccountSnapshot(@Query("type") AccountSnapshotType type,
	                                                               @QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@POST(BASE_ACCOUNT + "disableFastWithdrawSwitch")
	Call<Void> disableFastWithdrawSwitch(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@POST(BASE_ACCOUNT + "enableFastWithdrawSwitch")
	Call<Void> enableFastWithdrawSwitch(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@POST(BASE_CAPITAL + "withdraw/apply")
	Call<WithdrawResult> withdraw(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE_CAPITAL + "deposit/hisrec")
	Call<List<DepositHistory>> getDepositHistory(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE_CAPITAL + "withdraw/history")
	Call<List<WithdrawHistory>> getWithdrawHistory(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE_CAPITAL + "deposit/address")
	Call<DepositAddress> getDepositAddress(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE_ACCOUNT + "status")
	Call<AccountStatus> getAccountstatus(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE_ACCOUNT + "apiTradingStatus")
	Call<ApiTradingStatus> getApiTradingStatus(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE_ASSET + "dribblet")
	Call<DustLog> getDustLog(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@POST(BASE_ASSET + "dust-btc")
	Call<ConvertibleAssets> getConvertibleAssets(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@POST(BASE_ASSET + "dust")
	Call<DustTransferResponse> dustTransfert(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE_ASSET + "assetDividend")
	Call<AssetDividendRecord> getAssetDividendRecord(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE_ASSET + "assetDetail")
	Call<Map<String, AssetDetail>> getAssetDetail(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE_ASSET + "tradeFee")
	Call<List<TradeFee>> getTradeFee(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@POST(BASE_ASSET + "transfer")
	Call<WalletTransferResponse> transfer(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE_ASSET + "transfer")
	Call<WalletTransferHistory> getTransferHistory(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@POST(BASE_ASSET + "get-funding-asset")
	Call<List<FundingAsset>> getFundingAsset(@QueryMap Map<String, Object> map);

	@Headers(SIGNED_H)
	@GET(BASE_ACCOUNT + "apiRestrictions")
	Call<ApiPermissions> getApiPermissions(@QueryMap Map<String, Object> map);
}