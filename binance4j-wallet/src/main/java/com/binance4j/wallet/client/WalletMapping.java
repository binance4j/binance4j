package com.binance4j.wallet.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.wallet.dto.AccountSnapshotType;
import com.binance4j.wallet.dto.AccountStatus;
import com.binance4j.wallet.dto.ApiPermissions;
import com.binance4j.wallet.dto.ApiTradingStatus;
import com.binance4j.wallet.dto.AssetDetail;
import com.binance4j.wallet.dto.AssetDividendRecord;
import com.binance4j.wallet.dto.CoinInformation;
import com.binance4j.wallet.dto.ConvertibleAssets;
import com.binance4j.wallet.dto.DepositAddress;
import com.binance4j.wallet.dto.DepositHistory;
import com.binance4j.wallet.dto.DustLog;
import com.binance4j.wallet.dto.DustTransferResponse;
import com.binance4j.wallet.dto.FundingAsset;
import com.binance4j.wallet.dto.FuturesAccountSnapshotResponse;
import com.binance4j.wallet.dto.MarginAccountSnapshotResponse;
import com.binance4j.wallet.dto.SpotAccountSnapshotResponse;
import com.binance4j.wallet.dto.SystemStatus;
import com.binance4j.wallet.dto.TradeFee;
import com.binance4j.wallet.dto.WalletTransferHistory;
import com.binance4j.wallet.dto.WalletTransferResponse;
import com.binance4j.wallet.dto.WithdrawHistory;
import com.binance4j.wallet.dto.WithdrawResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/** Binance Wallet endpoints mapping. */
public interface WalletMapping extends RestMapping {

	/** Base url */
	String BASE = "/sapi/v1/";
	/** Base url */
	String BASE_ASSET = BASE + "asset/";
	/** Base url */
	String BASE_CAPITAL = BASE + "capital/";
	/** Base url */
	String BASE_ACCOUNT = BASE + "account/";
	/** Signed header */
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;

	/**
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "system/status")
	Call<SystemStatus> getSystemStatus();

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_CAPITAL + "config/getall")
	Call<List<CoinInformation>> getAllCoinsInfo(@QueryMap Map<String, Object> map);

	/**
	 * @param type The snapshot type.
	 * @param map  The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE + "accountSnapshot")
	Call<SpotAccountSnapshotResponse> getSpotAccountSnapshot(@Query("type") AccountSnapshotType type, @QueryMap Map<String, Object> map);

	/**
	 * @param type The snapshot type.
	 * @param map  The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE + "accountSnapshot")
	Call<MarginAccountSnapshotResponse> getMarginAccountSnapshot(@Query("type") AccountSnapshotType type, @QueryMap Map<String, Object> map);

	/**
	 * @param type The snapshot type.
	 * @param map  The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE + "accountSnapshot")
	Call<FuturesAccountSnapshotResponse> getFuturesAccountSnapshot(@Query("type") AccountSnapshotType type, @QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@POST(BASE_ACCOUNT + "disableFastWithdrawSwitch")
	Call<Void> disableFastWithdrawSwitch(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@POST(BASE_ACCOUNT + "enableFastWithdrawSwitch")
	Call<Void> enableFastWithdrawSwitch(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@POST(BASE_CAPITAL + "withdraw/apply")
	Call<WithdrawResult> withdraw(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_CAPITAL + "deposit/hisrec")
	Call<List<DepositHistory>> getDepositHistory(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_CAPITAL + "withdraw/history")
	Call<List<WithdrawHistory>> getWithdrawHistory(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_CAPITAL + "deposit/address")
	Call<DepositAddress> getDepositAddress(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_ACCOUNT + "status")
	Call<AccountStatus> getAccountstatus(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_ACCOUNT + "apiTradingStatus")
	Call<ApiTradingStatus> getApiTradingStatus(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_ASSET + "dribblet")
	Call<DustLog> getDustLog(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@POST(BASE_ASSET + "dust-btc")
	Call<ConvertibleAssets> getConvertibleAssets(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@POST(BASE_ASSET + "dust")
	Call<DustTransferResponse> dustTransfert(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_ASSET + "assetDividend")
	Call<AssetDividendRecord> getAssetDividendRecord(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_ASSET + "assetDetail")
	Call<Map<String, AssetDetail>> getAssetDetail(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_ASSET + "tradeFee")
	Call<List<TradeFee>> getTradeFee(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@POST(BASE_ASSET + "transfer")
	Call<WalletTransferResponse> transfer(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_ASSET + "transfer")
	Call<WalletTransferHistory> getTransferHistory(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@POST(BASE_ASSET + "get-funding-asset")
	Call<List<FundingAsset>> getFundingAsset(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H)
	@GET(BASE_ACCOUNT + "apiRestrictions")
	Call<ApiPermissions> getApiPermissions(@QueryMap Map<String, Object> map);
}