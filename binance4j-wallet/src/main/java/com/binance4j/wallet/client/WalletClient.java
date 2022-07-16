package com.binance4j.wallet.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
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
import com.binance4j.wallet.param.FuturesAccountSnapshotResponse;
import com.binance4j.wallet.param.MarginAccountSnapshotResponse;
import com.binance4j.wallet.param.SpotAccountSnapshotResponse;
import com.binance4j.wallet.param.TradeFeeParams;
import com.binance4j.wallet.param.WalletTransferHistoryParams;
import com.binance4j.wallet.param.WalletTransferParams;
import com.binance4j.wallet.param.WithdrawHistoryParams;
import com.binance4j.wallet.param.WithdrawParams;

/**
 * The API client for the wallet endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#wallet-endpoints">Documentation</a>
 */
public class WalletClient extends RestClient<WalletMapping> {

	/**
	 *
	 * 
	 * @param key    The API public key
	 * @param secret The API secret key
	 */
	public WalletClient(String key, String secret) {
		super(WalletMapping.class, key, secret);
	}

	/** Fetches the system status. */
	public Request<SystemStatus> getSystemStatus() {
		return new Request<>(service.getSystemStatus());
	}

	/** Gets information of coins (available for deposit and withdraw) for user. */
	public Request<List<CoinInformation>> getAllCoinsInfo(CoinInformationParams params) {
		return new Request<>(service.getAllCoinsInfo(params.toMap()));
	}

	/**
	 * Gets the information of coins (available for deposit and withdraw) for user
	 * .
	 */
	public Request<List<CoinInformation>> getAllCoinsInfo() {
		return getAllCoinsInfo(new CoinInformationParams());
	}

	/** Fetches the daily SPOT account snapshots. */
	public Request<SpotAccountSnapshotResponse> getSpotAccountSnapshot(AccountSnapshotParams params) {
		return new Request<>(service.getSpotAccountSnapshot(AccountSnapshotType.SPOT, params.toMap()));
	}

	/** Fetches the last 5 daily SPOT account snapshots. */
	public Request<SpotAccountSnapshotResponse> getSpotAccountSnapshot() {
		return getSpotAccountSnapshot(new AccountSnapshotParams());
	}

	/** Fetches the daily MARGIN account snapshots. */
	public Request<MarginAccountSnapshotResponse> getMarginAccountSnapshot(AccountSnapshotParams params) {
		return new Request<>(service.getMarginAccountSnapshot(AccountSnapshotType.MARGIN, params.toMap()));
	}

	/** Fetches the last 5 daily MARGIN account snapshots. */
	public Request<MarginAccountSnapshotResponse> getMarginAccountSnapshot() {
		return getMarginAccountSnapshot(new AccountSnapshotParams());
	}

	/** Fetches the daily FUTURES account snapshots. */
	public Request<FuturesAccountSnapshotResponse> getFuturesAccountSnapshot(AccountSnapshotParams params) {
		return new Request<>(service.getFuturesAccountSnapshot(AccountSnapshotType.FUTURES, params.toMap()));
	}

	/** Fetches the last 5 daily FUTURES account snapshots. */
	public Request<FuturesAccountSnapshotResponse> getFuturesAccountSnapshot() {
		return getFuturesAccountSnapshot(new AccountSnapshotParams());
	}

	/**
	 * Disables fast withdraw switch under your account.
	 * <p>
	 * You need to enable {@code trade} option for the api key which
	 * requests this endpoint.
	 */
	public Request<Void> disableFastWithdrawSwitch(FastWithdrawSwitchParams params) {
		return new Request<>(service.disableFastWithdrawSwitch(params.toMap()));
	}

	/** Disables fast withdraw switch under your account. */
	public Request<Void> disableFastWithdrawSwitch() {
		return disableFastWithdrawSwitch(new FastWithdrawSwitchParams());
	}

	/**
	 * Enables fast withdraw switch under your account.
	 * <p>
	 * You need to enable "trade" option for the api key which requests
	 * this endpoint.
	 * <p>
	 * When Fast Withdraw Switch is on, transferring funds to a Binance
	 * account will be done instantly. There is no on-chain transaction, no
	 * transaction ID and no withdrawal fee.
	 */
	public Request<Void> enableFastWithdrawSwitch(FastWithdrawSwitchParams params) {
		return new Request<>(service.enableFastWithdrawSwitch(params.toMap()));
	}

	/** Enables fast withdraw switch under your account. */
	public Request<Void> enableFastWithdrawSwitch() {
		return enableFastWithdrawSwitch(new FastWithdrawSwitchParams());
	}

	/**
	 * Submits a withdraw request.
	 * <p>
	 * If network not send, return
	 * You can get {@code network} and {@code isDefault} in
	 * networkList of a coin in the response of {@link #getAllCoinsInfo()}
	 */
	public Request<WithdrawResult> withdraw(WithdrawParams params) {
		return new Request<>(service.withdraw(params.toMap()));
	}

	/**
	 * Fetches the deposit history of one or multiple coins.
	 * <p>
	 * Please notice the default {@code startTime} and
	 * {@code endTime} to make sure that time interval is within 0-90
	 * days.
	 * <p>
	 * If both {@code startTime</code> and <code>endTime} are sent,
	 * time between {@code startTime</code> and <code>endTime} must be
	 * less than 90 days.
	 */
	public Request<List<DepositHistory>> getDepositHistory(DepositHistoryParams params) {
		return new Request<>(service.getDepositHistory(params.toMap()));
	}

	/** Fetches the last deposit history of all coins. */
	public Request<List<DepositHistory>> getDepositHistory() {
		return getDepositHistory(new DepositHistoryParams());
	}

	/**
	 * Fetches the withdraw history of one or multiple coins.
	 * <p>
	 * network may not be in the response for old withdraw.
	 * <p>
	 * Please notice the default {@code startTime} and
	 * {@code endTime} to make sure that time interval is within 0-90
	 * days.
	 * <p>
	 * If both {@code startTime} and {@code endTime} are sent,
	 * time between {@code startTime} and {@code endTime}
	 * must be less than 90 days.
	 */
	public Request<List<WithdrawHistory>> getWithdrawHistory(WithdrawHistoryParams params) {
		return new Request<>(service.getWithdrawHistory(params.toMap()));
	}

	/** Fetches the last withdraw history of all coins. */
	public Request<List<WithdrawHistory>> getWithdrawHistory() {
		return getWithdrawHistory(new WithdrawHistoryParams());

	}

	/**
	 * Fetches deposit address
	 * <p>
	 * If {@code network} is not sent, return
	 * the coin.
	 * <p>
	 * You can get {@code network} and {@code isDefault} in
	 * {@code networkList} in the response of
	 * {@link #getAllCoinsInfo(CoinInformationParams)}
	 */
	public Request<DepositAddress> getDepositAddress(DepositAddressParams params) {
		return new Request<>(service.getDepositAddress(params.toMap()));
	}

	/** Fetches the account status detail. */
	public Request<AccountStatus> getAccountstatus(AccountStatusParams params) {
		return new Request<>(service.getAccountstatus(params.toMap()));
	}

	/** Fetches the account status detail. */
	public Request<AccountStatus> getAccountstatus() {
		return getAccountstatus(new AccountStatusParams());
	}

	/** Fetches the account api trading status detail. */
	public Request<ApiTradingStatus> getApiTradingStatus(ApiTradingStatusParams params) {
		return new Request<>(service.getApiTradingStatus(params.toMap()));
	}

	/** Fetches the account api trading status detail. */
	public Request<ApiTradingStatus> getApiTradingStatus() {
		return getApiTradingStatus(new ApiTradingStatusParams());
	}

	/** Fetches the dust transfer logs. */
	public Request<DustLog> getDustLog(DustLogParams params) {
		return new Request<>(service.getDustLog(params.toMap()));
	}

	/** Fetches the dust transfer logs. */
	public Request<DustLog> getDustLog() {
		return getDustLog(new DustLogParams());
	}

	/** Retrieves the assets convertible into BNB. */
	public Request<ConvertibleAssets> getConvertibleAssets() {
		ConvertibleAssetParams params = new ConvertibleAssetParams();
		return new Request<>(service.getConvertibleAssets(params.toMap()));
	}

	/** Retrieves the assets convertible into BNB. */
	public Request<ConvertibleAssets> getConvertibleAssets(ConvertibleAssetParams params) {
		return new Request<>(service.getConvertibleAssets(params.toMap()));
	}

	/** Convert dust assets to BNB. */
	public Request<DustTransferResponse> dustTransfert(DustTransferParams params) {
		return new Request<>(service.dustTransfert(params.toMap()));
	}

	/** Queries the dividend record of one or multiple assets. */
	public Request<AssetDividendRecord> getAssetDividendRecord(AssetDividendRecordParams params) {
		return new Request<>(service.getAssetDividendRecord(params.toMap()));
	}

	/** Queries the last 20 dividend asset records. */
	public Request<AssetDividendRecord> getAssetDividendRecord() {
		return getAssetDividendRecord(new AssetDividendRecordParams());
	}

	/**
	 * Fetches the details of an asset supported on Binance.
	 * Please get network and other deposit or withdraw details from
	 * {@link #getAllCoinsInfo()}.
	 */
	public Request<Map<String, AssetDetail>> getAssetDetail(AssetDetailParams params) {
		return new Request<>(service.getAssetDetail(params.toMap()));
	}

	/** Fetches the details of all assets supported on Binance. */
	public Request<Map<String, AssetDetail>> getAssetDetail() {
		return getAssetDetail(new AssetDetailParams());
	}

	/** Fetches the trade fee. */
	public Request<List<TradeFee>> getTradeFee(TradeFeeParams params) {
		return new Request<>(service.getTradeFee(params.toMap()));
	}

	/** Fetches the trade fee. */
	public Request<List<TradeFee>> getTradeFee() {
		return getTradeFee(new TradeFeeParams());
	}

	/**
	 * Make a universal transfer.
	 * <p>
	 * You need to enable {@code Permits Universal Transfer} option
	 * for the api key which requests this endpoint.
	 * <p>
	 * fromSymbol must be sent when type are ISOLATEDMARGIN_MARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 * <p>
	 * toSymbol must be sent when type are MARGIN_ISOLATEDMARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 */
	public Request<WalletTransferResponse> transfer(WalletTransferParams params) {
		return new Request<>(service.transfer(params.toMap()));
	}

	/**
	 * Fetches the user universal transfer history
	 * <p>
	 * fromSymbol must be sent when type are ISOLATEDMARGIN_MARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 * <p>
	 * toSymbol must be sent when type are MARGIN_ISOLATEDMARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 * <p>
	 * Support query within the last 6 months only
	 * <p>
	 * If startTime and endTime not sent, return records of the last 7 days
	 * by default
	 */
	public Request<WalletTransferHistory> getTransferHistory(WalletTransferHistoryParams params) {
		return new Request<>(service.getTransferHistory(params.toMap()));
	}

	/**
	 * Fetches the funding wallet asset balance
	 * <p>
	 * Currently supports querying the following business assets：Binance
	 * Pay, Binance Card, Binance Gift Card, Stock Token
	 */
	public Request<List<FundingAsset>> getFundingAsset(FundingAssetParams params) {
		return new Request<>(service.getFundingAsset(params.toMap()));
	}

	/** Fetches the funding wallet asset balance. */
	public Request<List<FundingAsset>> getFundingAsset() {
		return getFundingAsset(new FundingAssetParams());
	}

	/** Fetches the API Key Permission. */
	public Request<ApiPermissions> getApiPermissions(ApiPermissionsParams params) {
		return new Request<>(service.getApiPermissions(params.toMap()));
	}

	/** Fetches the API Key Permission. */
	public Request<ApiPermissions> getApiPermissions() {
		return getApiPermissions(new ApiPermissionsParams());
	}
}