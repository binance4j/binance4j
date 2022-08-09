package com.binance4j.wallet.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
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
import com.binance4j.wallet.param.AccountSnapshotParams;
import com.binance4j.wallet.param.AccountStatusParams;
import com.binance4j.wallet.param.ApiPermissionsParams;
import com.binance4j.wallet.param.ApiTradingStatusParams;
import com.binance4j.wallet.param.AssetDetailParams;
import com.binance4j.wallet.param.AssetDividendRecordParams;
import com.binance4j.wallet.param.CoinInformationParams;
import com.binance4j.wallet.param.ConvertibleAssetParams;
import com.binance4j.wallet.param.DepositAddressParams;
import com.binance4j.wallet.param.DepositHistoryParams;
import com.binance4j.wallet.param.DustLogParams;
import com.binance4j.wallet.param.DustTransferParams;
import com.binance4j.wallet.param.FastWithdrawSwitchParams;
import com.binance4j.wallet.param.FundingAssetParams;
import com.binance4j.wallet.param.TradeFeeParams;
import com.binance4j.wallet.param.WalletTransferHistoryParams;
import com.binance4j.wallet.param.WalletTransferParams;
import com.binance4j.wallet.param.WithdrawHistoryParams;
import com.binance4j.wallet.param.WithdrawParams;

/**
 * The API client for the wallet endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#wallet-endpoints">Documentation</a>
 */
public class WalletClient extends RestClient<WalletMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public WalletClient(String key, String secret) {
		super(WalletMapping.class, key, secret);
	}

	/**
	 * Fetches the system status.
	 * 
	 * @return The request to execute.
	 */
	public Request<SystemStatus> getSystemStatus() {
		return new Request<>(service.getSystemStatus());
	}

	/**
	 * Gets the information of coins (available for deposit and withdraw) for user .
	 * 
	 * @return The request to execute.
	 */
	public Request<List<CoinInformation>> getAllCoinsInfo() {
		return new Request<>(service.getAllCoinsInfo(new CoinInformationParams().toMap()));
	}

	/**
	 * Fetches the daily SPOT account snapshots.
	 * 
	 * @param timeinterval Search interval.
	 * @return The request to execute.
	 */
	public Request<SpotAccountSnapshotResponse> getSpotAccountSnapshot(TimeFrame timeinterval) {
		return new Request<>(service.getSpotAccountSnapshot(AccountSnapshotType.SPOT, Params.merge(new AccountSnapshotParams(), timeinterval)));
	}

	/**
	 * Fetches the last 5 daily SPOT account snapshots.
	 * 
	 * @return The request to execute.
	 */
	public Request<SpotAccountSnapshotResponse> getSpotAccountSnapshot() {
		return new Request<>(service.getSpotAccountSnapshot(AccountSnapshotType.SPOT, new AccountSnapshotParams().toMap()));
	}

	/**
	 * Fetches the daily MARGIN account snapshots.
	 * 
	 * @param timeinterval Search interval.
	 * @return The request to execute.
	 */
	public Request<MarginAccountSnapshotResponse> getMarginAccountSnapshot(TimeFrame timeinterval) {
		return new Request<>(service.getMarginAccountSnapshot(AccountSnapshotType.MARGIN, Params.merge(new AccountSnapshotParams(), timeinterval)));
	}

	/**
	 * Fetches the last 5 daily MARGIN account snapshots.
	 * 
	 * @return The request to execute.
	 */
	public Request<MarginAccountSnapshotResponse> getMarginAccountSnapshot() {
		return new Request<>(service.getMarginAccountSnapshot(AccountSnapshotType.MARGIN, new AccountSnapshotParams().toMap()));
	}

	/**
	 * Fetches the daily FUTURES account snapshots.
	 * 
	 * @param timeinterval Search interval.
	 * @return The request to execute.
	 */
	public Request<FuturesAccountSnapshotResponse> getFuturesAccountSnapshot(TimeFrame timeinterval) {
		return new Request<>(service.getFuturesAccountSnapshot(AccountSnapshotType.FUTURES, Params.merge(new AccountSnapshotParams(), timeinterval)));
	}

	/**
	 * Fetches the last 5 daily FUTURES account snapshots.
	 * 
	 * @return The request to execute.
	 */
	public Request<FuturesAccountSnapshotResponse> getFuturesAccountSnapshot() {
		return new Request<>(service.getFuturesAccountSnapshot(AccountSnapshotType.FUTURES, new AccountSnapshotParams().toMap()));
	}

	/**
	 * Disables fast withdraw switch under your account.
	 * 
	 * @return The request to execute.
	 */
	public Request<Void> disableFastWithdrawSwitch() {
		return new Request<>(service.disableFastWithdrawSwitch(new FastWithdrawSwitchParams().toMap()));
	}

	/**
	 * Enables fast withdraw switch under your account.
	 * 
	 * @return The request to execute.
	 */
	public Request<Void> enableFastWithdrawSwitch() {
		return new Request<>(service.enableFastWithdrawSwitch(new FastWithdrawSwitchParams().toMap()));
	}

	/**
	 * Submits a withdraw request.
	 * <p>
	 * If network not send, you can get {@code network} and {@code isDefault} in networkList of a coin in the response of
	 * {@link #getAllCoinsInfo()}
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<WithdrawResult> withdraw(WithdrawParams params) {
		return new Request<>(service.withdraw(params.toMap()));
	}

	/**
	 * Fetches the deposit history of one or multiple coins.
	 * <p>
	 * Please notice the default {@code startTime} and {@code endTime} to make sure that time interval is within 0-90 days.
	 * <p>
	 * If both {@code startTime</code> and <code>endTime} are sent,
	 * time between {@code startTime</code> and <code>endTime} must be less than 90 days.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<DepositHistory>> getDepositHistory(DepositHistoryParams params) {
		return new Request<>(service.getDepositHistory(params.toMap()));
	}

	/**
	 * Fetches the last deposit history of all coins.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<DepositHistory>> getDepositHistory() {
		return getDepositHistory(new DepositHistoryParams());
	}

	/**
	 * Fetches the deposit history of one or multiple coins.
	 * <p>
	 * Please notice the default {@code startTime} and {@code endTime} to make sure that time interval is within 0-90 days.
	 * <p>
	 * If both {@code startTime</code> and <code>endTime} are sent,
	 * time between {@code startTime</code> and <code>endTime} must be less than 90 days.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<List<DepositHistory>> getDepositHistory(DepositHistoryParams params, FramedPaging paging) {
		return new Request<>(service.getDepositHistory(Params.merge(params.toMap(), paging.toMap(Map.of("page", "offset")))));
	}

	/**
	 * Fetches the last deposit history of all coins.
	 * 
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<List<DepositHistory>> getDepositHistory(FramedPaging paging) {
		return new Request<>(service.getDepositHistory(Params.merge(new DepositHistoryParams().toMap(), paging.toMap(Map.of("page", "offset")))));
	}

	/**
	 * Fetches the withdraw history of one or multiple coins.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<WithdrawHistory>> getWithdrawHistory(WithdrawHistoryParams params) {
		return new Request<>(service.getWithdrawHistory(params.toMap()));
	}

	/**
	 * Fetches the withdraw history of one or multiple coins.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<List<WithdrawHistory>> getWithdrawHistory(WithdrawHistoryParams params, FramedPaging paging) {
		return new Request<>(service.getWithdrawHistory(Params.merge(params.toMap(), paging.toMap(Map.of("page", "offset")))));
	}

	/**
	 * Fetches the last withdraw history of all coins.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<WithdrawHistory>> getWithdrawHistory() {
		return getWithdrawHistory(new WithdrawHistoryParams((String) null));
	}

	/**
	 * Fetches deposit address
	 * <p>
	 * If {@code network} is not sent, return the coin.
	 * <p>
	 * You can get {@code network} and {@code isDefault} in {@code networkList} in the response of {@link #getAllCoinsInfo}
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<DepositAddress> getDepositAddress(DepositAddressParams params) {
		return new Request<>(service.getDepositAddress(params.toMap()));
	}

	/**
	 * Fetches the account status detail.
	 * 
	 * @return The request to execute.
	 */
	public Request<AccountStatus> getAccountstatus() {
		return new Request<>(service.getAccountstatus(new AccountStatusParams().toMap()));
	}

	/**
	 * Fetches the account api trading status detail.
	 * 
	 * @return The request to execute.
	 */
	public Request<ApiTradingStatus> getApiTradingStatus() {
		return new Request<>(service.getApiTradingStatus(new ApiTradingStatusParams().toMap()));
	}

	/**
	 * Fetches the dust transfer logs.
	 * 
	 * @return The request to execute.
	 */
	public Request<DustLog> getDustLog() {
		return new Request<>(service.getDustLog(new DustLogParams().toMap()));
	}

	/**
	 * Fetches the dust transfer logs.
	 * 
	 * @param timeFrame Search interval.
	 * @return The request to execute.
	 */
	public Request<DustLog> getDustLog(TimeFrame timeFrame) {
		return new Request<>(service.getDustLog(Params.merge(new DustLogParams(), timeFrame)));
	}

	/**
	 * Retrieves the assets convertible into BNB.
	 * 
	 * @return The request to execute.
	 */
	public Request<ConvertibleAssets> getConvertibleAssets() {
		ConvertibleAssetParams params = new ConvertibleAssetParams();
		return new Request<>(service.getConvertibleAssets(params.toMap()));
	}

	/**
	 * Retrieves the assets convertible into BNB.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<ConvertibleAssets> getConvertibleAssets(ConvertibleAssetParams params) {
		return new Request<>(service.getConvertibleAssets(params.toMap()));
	}

	/**
	 * Convert dust assets to BNB.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<DustTransferResponse> dustTransfert(DustTransferParams params) {
		return new Request<>(service.dustTransfert(params.toMap()));
	}

	/**
	 * Queries the dividend record of one or multiple assets.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<AssetDividendRecord> getAssetDividendRecord(AssetDividendRecordParams params) {
		return new Request<>(service.getAssetDividendRecord(params.toMap()));
	}

	/**
	 * Queries the last 20 dividend asset records.
	 * 
	 * @return The request to execute.
	 */
	public Request<AssetDividendRecord> getAssetDividendRecord() {
		return getAssetDividendRecord(new AssetDividendRecordParams(null));
	}

	/**
	 * Queries the dividend record of one or multiple assets.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Search interval.
	 * @return The request to execute.
	 */
	public Request<AssetDividendRecord> getAssetDividendRecord(AssetDividendRecordParams params, TimeFrame timeFrame) {
		return new Request<>(service.getAssetDividendRecord(Params.merge(params, timeFrame)));
	}

	/**
	 * Queries the last 20 dividend asset records.
	 * 
	 * @param timeFrame Search interval.
	 * @return The request to execute.
	 */
	public Request<AssetDividendRecord> getAssetDividendRecord(TimeFrame timeFrame) {
		return new Request<>(service.getAssetDividendRecord(Params.merge(new AssetDividendRecordParams(null), timeFrame)));
	}

	/**
	 * Fetches the details of an asset supported on Binance. Please get network and other deposit or withdraw details from
	 * {@link #getAllCoinsInfo()}.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<Map<String, AssetDetail>> getAssetDetail(AssetDetailParams params) {
		return new Request<>(service.getAssetDetail(params.toMap()));
	}

	/**
	 * Fetches the details of all assets supported on Binance.
	 * 
	 * @return The request to execute.
	 */
	public Request<Map<String, AssetDetail>> getAssetDetail() {
		return getAssetDetail(new AssetDetailParams(null));
	}

	/**
	 * Fetches the trade fee.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<TradeFee>> getTradeFee(TradeFeeParams params) {
		return new Request<>(service.getTradeFee(params.toMap()));
	}

	/**
	 * Fetches the trade fee.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<TradeFee>> getTradeFee() {
		return getTradeFee(new TradeFeeParams(null));
	}

	/**
	 * Make a universal transfer.
	 * <p>
	 * You need to enable {@code Permits Universal Transfer} option for the api key which requests this endpoint.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<WalletTransferResponse> transfer(WalletTransferParams params) {
		return new Request<>(service.transfer(params.toMap()));
	}

	/**
	 * Fetches the user universal transfer history
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<WalletTransferHistory> getTransferHistory(WalletTransferHistoryParams params) {
		return new Request<>(service.getTransferHistory(params.toMap()));
	}

	/**
	 * Fetches the user universal transfer history
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<WalletTransferHistory> getTransferHistory(WalletTransferHistoryParams params, FramedPaging paging) {
		return new Request<>(service.getTransferHistory(Params.merge(params.toMap(), paging.toMap(Map.of("limit", "size", "page", "current")))));
	}

	/**
	 * Fetches the funding wallet asset balance
	 * <p>
	 * Currently supports querying the following business assets：Binance Pay, Binance Card, Binance Gift Card, Stock Token
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<FundingAsset>> getFundingAsset(FundingAssetParams params) {
		return new Request<>(service.getFundingAsset(params.toMap()));
	}

	/**
	 * Fetches the funding wallet asset balance.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<FundingAsset>> getFundingAsset() {
		return getFundingAsset(new FundingAssetParams(null, null));
	}

	/**
	 * Fetches the API Key Permission.
	 * 
	 * @return The request to execute.
	 */
	public Request<ApiPermissions> getApiPermissions() {
		return new Request<>(service.getApiPermissions(new ApiPermissionsParams().toMap()));
	}
}