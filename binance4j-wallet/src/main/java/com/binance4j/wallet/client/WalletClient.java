package com.binance4j.wallet.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.request.RequestExecutor;
import com.binance4j.wallet.accountstatus.AccountStatus;
import com.binance4j.wallet.accountstatus.AccountStatusRequest;
import com.binance4j.wallet.assetdetail.AssetDetail;
import com.binance4j.wallet.assetdetail.AssetDetailRequest;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecord;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecordRequest;
import com.binance4j.wallet.coinsinfo.CoinInformation;
import com.binance4j.wallet.coinsinfo.CoinInformationRequest;
import com.binance4j.wallet.deposit.DepositAddress;
import com.binance4j.wallet.deposit.DepositAddressRequest;
import com.binance4j.wallet.deposit.DepositHistory;
import com.binance4j.wallet.deposit.DepositHistoryRequest;
import com.binance4j.wallet.dust.ConvertibleAssetRequest;
import com.binance4j.wallet.dust.ConvertibleAssets;
import com.binance4j.wallet.dust.DustLog;
import com.binance4j.wallet.dust.DustLogRequest;
import com.binance4j.wallet.dust.DustTransferRequest;
import com.binance4j.wallet.dust.DustTransferResponse;
import com.binance4j.wallet.funding.FundingAsset;
import com.binance4j.wallet.funding.FundingAssetRequest;
import com.binance4j.wallet.permissions.ApiPermissions;
import com.binance4j.wallet.permissions.ApiPermissionsRequest;
import com.binance4j.wallet.snapshot.AccountSnapshotRequest;
import com.binance4j.wallet.snapshot.AccountSnapshotType;
import com.binance4j.wallet.snapshot.futures.FuturesAccountSnapshotResponse;
import com.binance4j.wallet.snapshot.margin.MarginAccountSnapshotResponse;
import com.binance4j.wallet.snapshot.spot.SpotAccountSnapshotResponse;
import com.binance4j.wallet.systemstatus.SystemStatus;
import com.binance4j.wallet.tradefee.TradeFee;
import com.binance4j.wallet.tradefee.TradeFeeRequest;
import com.binance4j.wallet.tradingstatus.ApiTradingStatus;
import com.binance4j.wallet.tradingstatus.ApiTradingStatusRequest;
import com.binance4j.wallet.transfer.WalletTransferHistory;
import com.binance4j.wallet.transfer.WalletTransferHistoryRequest;
import com.binance4j.wallet.transfer.WalletTransferRequest;
import com.binance4j.wallet.transfer.WalletTransferResponse;
import com.binance4j.wallet.withdraw.FastWithdrawSwitchRequest;
import com.binance4j.wallet.withdraw.WithdrawHistory;
import com.binance4j.wallet.withdraw.WithdrawHistoryRequest;
import com.binance4j.wallet.withdraw.WithdrawRequest;
import com.binance4j.wallet.withdraw.WithdrawResult;

/**
 * The API client for the wallet endpoints
 */
public class WalletClient extends RestClient<WalletMapping> {

	/**
	 * Constructor
	 *
	 * @param key    The API public key
	 * @param secret The API secret key
	 */
	public WalletClient(String key, String secret) {
		super(WalletMapping.class, key, secret);
	}

	/**
	 * Fetches the system status.
	 *
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en#system-status-system">Documentation</a>
	 */
	public RequestExecutor<SystemStatus> getSystemStatus() {
		return new RequestExecutor<>(service.getSystemStatus());
	}

	/**
	 * Gets information of coins (available for deposit and withdraw) for user.
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#all-coins-39-information-user_data">Documentation</a>
	 */
	public RequestExecutor<List<CoinInformation>> getAllCoinsInfo(CoinInformationRequest req) {
		return new RequestExecutor<>(service.getAllCoinsInfo(req.toMap()), req);
	}

	/**
	 * Gets the information of coins (available for deposit and withdraw) for user
	 * with default request.
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getAllCoinsInfo(CoinInformationRequest)
	 */
	public RequestExecutor<List<CoinInformation>> getAllCoinsInfo() {
		return getAllCoinsInfo(new CoinInformationRequest());
	}

	/**
	 * Fetches the daily SPOT account snapshots.
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#daily-account-snapshot-user_data">Documentation</a>
	 */
	public RequestExecutor<SpotAccountSnapshotResponse> getSpotAccountSnapshot(AccountSnapshotRequest req) {
		return new RequestExecutor<>(service.getSpotAccountSnapshot(AccountSnapshotType.SPOT, req.toMap()), req);
	}

	/**
	 * Fetches the last 5 daily SPOT account snapshots with default request.
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getSpotAccountSnapshot(AccountSnapshotRequest)
	 */
	public RequestExecutor<SpotAccountSnapshotResponse> getSpotAccountSnapshot() {
		return getSpotAccountSnapshot(new AccountSnapshotRequest());
	}

	/**
	 * Fetches the daily MARGIN account snapshots
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#daily-account-snapshot-user_data">Documentation</a>
	 */
	public RequestExecutor<MarginAccountSnapshotResponse> getMarginAccountSnapshot(AccountSnapshotRequest req) {
		return new RequestExecutor<>(service.getMarginAccountSnapshot(AccountSnapshotType.MARGIN, req.toMap()), req);
	}

	/**
	 * Fetches the last 5 daily MARGIN account snapshots with default request.
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getMarginAccountSnapshot(AccountSnapshotRequest)
	 */
	public RequestExecutor<MarginAccountSnapshotResponse> getMarginAccountSnapshot() {
		return getMarginAccountSnapshot(new AccountSnapshotRequest());
	}

	/**
	 * Fetches the daily FUTURES account snapshots
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#daily-account-snapshot-user_data">Documentation</a>
	 */
	public RequestExecutor<FuturesAccountSnapshotResponse> getFuturesAccountSnapshot(AccountSnapshotRequest req) {
		return new RequestExecutor<>(service.getFuturesAccountSnapshot(AccountSnapshotType.FUTURES, req.toMap()), req);
	}

	/**
	 * Fetches the last 5 daily FUTURES account snapshots with default request.
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getFuturesAccountSnapshot(AccountSnapshotRequest)
	 */
	public RequestExecutor<FuturesAccountSnapshotResponse> getFuturesAccountSnapshot() {
		return getFuturesAccountSnapshot(new AccountSnapshotRequest());
	}

	/**
	 * Disables fast withdraw switch under your account.
	 * <p>
	 * You need to enable {@code trade} option for the api key which
	 * requests this endpoint.
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#disable-fast-withdraw-switch-user_data">Documentation</a>
	 */
	public RequestExecutor<Void> disableFastWithdrawSwitch(FastWithdrawSwitchRequest req) {
		return new RequestExecutor<>(service.disableFastWithdrawSwitch(req.toMap()), req);
	}

	/**
	 * Disables fast withdraw switch under your account with default request.
	 *
	 * @return The executor permitting sync/async API call
	 * @see #disableFastWithdrawSwitch(FastWithdrawSwitchRequest)
	 */
	public RequestExecutor<Void> disableFastWithdrawSwitch() {
		return disableFastWithdrawSwitch(new FastWithdrawSwitchRequest());
	}

	/**
	 * Enables fast withdraw switch under your account.
	 * <ul>
	 * <li>You need to enable "trade" option for the api key which requests
	 * this endpoint.
	 * </li>
	 *
	 * <li>When Fast Withdraw Switch is on, transferring funds to a Binance
	 * account will be done instantly. There is no on-chain transaction, no
	 * transaction ID and no withdrawal fee.
	 * </li>
	 * </ul>
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 *      "https://binance-docs.github.io/apidocs/spot/en/#enable-fast-withdraw-switch-user_data">Documentation</a>
	 */
	public RequestExecutor<Void> enableFastWithdrawSwitch(FastWithdrawSwitchRequest req) {
		return new RequestExecutor<>(service.enableFastWithdrawSwitch(req.toMap()), req);
	}

	/**
	 * Enables fast withdraw switch under your account with default request.
	 *
	 * @return The executor permitting sync/async API call
	 * @see #enableFastWithdrawSwitch(FastWithdrawSwitchRequest)
	 */
	public RequestExecutor<Void> enableFastWithdrawSwitch() {
		return enableFastWithdrawSwitch(new FastWithdrawSwitchRequest());
	}

	/**
	 * Submits a withdraw request.
	 * <p>
	 * If network not send, return with default network of the coin.
	 * You can get {@code network} and {@code isDefault} in
	 * networkList of a coin in the response of {@link #getAllCoinsInfo()}
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#withdraw-user_data">Documentation</a>
	 */
	public RequestExecutor<WithdrawResult> withdraw(WithdrawRequest req) {
		return new RequestExecutor<>(service.withdraw(req.toMap()), req);
	}

	/**
	 * Fetches the deposit history of one or multiple coins.
	 *
	 *
	 * <ul>
	 * <li>
	 * Please notice the default {@code startTime} and
	 * {@code endTime} to make sure that time interval is within 0-90
	 * days.
	 * </li>
	 * <li>
	 * If both {@code startTime</code> and <code>endTime} are sent,
	 * time between {@code startTime</code> and <code>endTime} must be
	 * less than 90 days.
	 * </li>
	 * </ul>
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#deposit-history-supporting-network-user_data">Documentation</a>
	 */
	public RequestExecutor<List<DepositHistory>> getDepositHistory(DepositHistoryRequest req) {
		return new RequestExecutor<>(service.getDepositHistory(req.toMap()), req);
	}

	/**
	 * Fetches the last deposit history of all coins.
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getDepositHistory(DepositHistoryRequest)
	 */
	public RequestExecutor<List<DepositHistory>> getDepositHistory() {
		return getDepositHistory(new DepositHistoryRequest());
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
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#withdraw-history-supporting-network-user_data">Documentation</a>
	 */
	public RequestExecutor<List<WithdrawHistory>> getWithdrawHistory(WithdrawHistoryRequest req) {
		return new RequestExecutor<>(service.getWithdrawHistory(req.toMap()), req);
	}

	/**
	 * Fetches the last withdraw history of all coins.
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getWithdrawHistory(WithdrawHistoryRequest)
	 */
	public RequestExecutor<List<WithdrawHistory>> getWithdrawHistory() {
		return getWithdrawHistory(new WithdrawHistoryRequest());

	}

	/**
	 * Fetches deposit address
	 * <ul>
	 * <li>
	 * If {@code network} is not sent, return with default network of
	 * the coin.
	 * </li>
	 * <li>
	 * You can get {@code network} and {@code isDefault} in
	 * {@code networkList} in the response of
	 * {@link #getAllCoinsInfo(CoinInformationRequest)}
	 * </li>
	 * </ul>
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#deposit-address-supporting-network-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<DepositAddress> getDepositAddress(DepositAddressRequest req) {
		return new RequestExecutor<>(service.getDepositAddress(req.toMap()), req);
	}

	/**
	 * Fetches the account status detail.
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#deposit-address-supporting-network-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<AccountStatus> getAccountstatus(AccountStatusRequest req) {
		return new RequestExecutor<>(service.getAccountstatus(req.toMap()), req);
	}

	/**
	 * Fetches the account status detail with default request.
	 *
	 * @return The executor permitting sync/async API call
	 */
	public RequestExecutor<AccountStatus> getAccountstatus() {
		return getAccountstatus(new AccountStatusRequest());
	}

	/**
	 * Fetches the account api trading status detail.
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#account-api-trading-status-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<ApiTradingStatus> getApiTradingStatus(ApiTradingStatusRequest req) {
		return new RequestExecutor<>(service.getApiTradingStatus(req.toMap()), req);
	}

	/**
	 * Fetches the account api trading status detail with default request.
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getApiTradingStatus(ApiTradingStatusRequest)
	 */
	public RequestExecutor<ApiTradingStatus> getApiTradingStatus() {
		return getApiTradingStatus(new ApiTradingStatusRequest());
	}

	/**
	 * Fetches the dust transfer logs
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#dustlog-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<DustLog> getDustLog(DustLogRequest req) {
		return new RequestExecutor<>(service.getDustLog(req.toMap()), req);
	}

	/**
	 * Fetches the dust transfer logs with default paramters
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getDustLog(DustLogRequest)
	 */
	public RequestExecutor<DustLog> getDustLog() {
		return getDustLog(new DustLogRequest());
	}

	/**
	 * Retrieves the assets convertible into BNB
	 *
	 * @return The executor permitting sync/async API call
	 */
	public RequestExecutor<ConvertibleAssets> getConvertibleAssets() {
		ConvertibleAssetRequest req = new ConvertibleAssetRequest();
		return new RequestExecutor<>(service.getConvertibleAssets(req.toMap()), req);
	}

	/**
	 * Retrieves the assets convertible into BNB
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 */
	public RequestExecutor<ConvertibleAssets> getConvertibleAssets(ConvertibleAssetRequest req) {
		return new RequestExecutor<>(service.getConvertibleAssets(req.toMap()), req);
	}

	/**
	 * Convert dust assets to BNB.
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#dust-transfer-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<DustTransferResponse> dustTransfert(DustTransferRequest req) {
		return new RequestExecutor<>(service.dustTransfert(req.toMap()), req);
	}

	/**
	 * Queries the dividend record of one or multiple assets.
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#asset-dividend-record-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<AssetDividendRecord> getAssetDividendRecord(AssetDividendRecordRequest req) {
		return new RequestExecutor<>(service.getAssetDividendRecord(req.toMap()), req);
	}

	/**
	 * Queries the last 20 dividend asset records
	 *
	 * @return The executor permitting sync/async API call
	 */
	public RequestExecutor<AssetDividendRecord> getAssetDividendRecord() {
		return getAssetDividendRecord(new AssetDividendRecordRequest());
	}

	/**
	 * Fetches the details of an asset supported on Binance.
	 * Please get network and other deposit or withdraw details from
	 * {@link #getAllCoinsInfo()}
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#asset-detail-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<Map<String, AssetDetail>> getAssetDetail(AssetDetailRequest req) {
		return new RequestExecutor<>(service.getAssetDetail(req.toMap()), req);
	}

	/**
	 * Fetches the details of all assets supported on Binance
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getAssetDetail(AssetDetailRequest)
	 */
	public RequestExecutor<Map<String, AssetDetail>> getAssetDetail() {
		return getAssetDetail(new AssetDetailRequest());
	}

	/**
	 * Fetches the trade fee
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#trade-fee-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<List<TradeFee>> getTradeFee(TradeFeeRequest req) {
		return new RequestExecutor<>(service.getTradeFee(req.toMap()), req);
	}

	/**
	 * Fetches the trade fee with default request
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getTradeFee(TradeFeeRequest)
	 */
	public RequestExecutor<List<TradeFee>> getTradeFee() {
		return getTradeFee(new TradeFeeRequest());
	}

	/**
	 * Make a universal transfer
	 * <ul>
	 * <li>
	 * You need to enable {@code Permits Universal Transfer} option
	 * for the api key which requests this endpoint.
	 * </li>
	 * <li>
	 * fromSymbol must be sent when type are ISOLATEDMARGIN_MARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 * </li>
	 * <li>
	 * toSymbol must be sent when type are MARGIN_ISOLATEDMARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 * </li>
	 * </ul>
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#user-universal-transfer-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<WalletTransferResponse> transfer(WalletTransferRequest req) {
		return new RequestExecutor<>(service.transfer(req.toMap()), req);
	}

	/**
	 * Fetches the user universal transfer history
	 * <ul>
	 * <li>
	 * fromSymbol must be sent when type are ISOLATEDMARGIN_MARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 * </li>
	 * <li>
	 * toSymbol must be sent when type are MARGIN_ISOLATEDMARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 * </li>
	 * <li>
	 * Support query within the last 6 months only
	 * </li>
	 * <li>
	 * If startTime and endTime not sent, return records of the last 7 days
	 * by default
	 * </li>
	 * </ul>
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#query-user-universal-transfer-history-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<WalletTransferHistory> getTransferHistory(WalletTransferHistoryRequest req) {
		return new RequestExecutor<>(service.getTransferHistory(req.toMap()), req);
	}

	/**
	 * Fetches the funding wallet asset balance
	 * <p>
	 * Currently supports querying the following business assets：Binance
	 * Pay, Binance Card, Binance Gift Card, Stock Token
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#funding-wallet-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<List<FundingAsset>> getFundingAsset(FundingAssetRequest req) {
		return new RequestExecutor<>(service.getFundingAsset(req.toMap()), req);
	}

	/**
	 * Fetches the funding wallet asset balance with default request
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getFundingAsset(FundingAssetRequest)
	 */
	public RequestExecutor<List<FundingAsset>> getFundingAsset() {
		return getFundingAsset(new FundingAssetRequest());
	}

	/**
	 * Fetches the API Key Permission
	 *
	 * @param req The request params
	 * @return The executor permitting sync/async API call
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#get-api-key-permission-user_data">
	 * Documentation </a>
	 */
	public RequestExecutor<ApiPermissions> getApiPermissions(ApiPermissionsRequest req) {
		return new RequestExecutor<>(service.getApiPermissions(req.toMap()));
	}

	/**
	 * Fetches the API Key Permission with default request
	 *
	 * @return The executor permitting sync/async API call
	 * @see #getApiPermissions(ApiPermissionsRequest)
	 */
	public RequestExecutor<ApiPermissions> getApiPermissions() {
		return getApiPermissions(new ApiPermissionsRequest());
	}
}