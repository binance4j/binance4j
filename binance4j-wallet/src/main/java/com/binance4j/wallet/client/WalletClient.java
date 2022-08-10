package com.binance4j.wallet.client;

import java.util.Map;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.wallet.dto.AccountSnapshotType;
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
import com.binance4j.wallet.param.FundingWalletParams;
import com.binance4j.wallet.param.TradeFeeParams;
import com.binance4j.wallet.param.WalletTransferHistoryParams;
import com.binance4j.wallet.param.WalletTransferParams;
import com.binance4j.wallet.param.WithdrawHistoryParams;
import com.binance4j.wallet.param.WithdrawParams;
import com.binance4j.wallet.request.DisableFastWithdrawSwitchRequest;
import com.binance4j.wallet.request.DustTransferRequest;
import com.binance4j.wallet.request.EnableFastWithdrawSwitchRequest;
import com.binance4j.wallet.request.GetAccountStatus;
import com.binance4j.wallet.request.GetAllCoinsInfoRequest;
import com.binance4j.wallet.request.GetApiPermissionsRequest;
import com.binance4j.wallet.request.GetApiTradingStatusRequest;
import com.binance4j.wallet.request.GetAssetDetailRequest;
import com.binance4j.wallet.request.GetAssetDividendRecordRequest;
import com.binance4j.wallet.request.GetConvertibleAssetsRequest;
import com.binance4j.wallet.request.GetDepositAddressRequest;
import com.binance4j.wallet.request.GetDepositHistoryRequest;
import com.binance4j.wallet.request.GetDustLogRequest;
import com.binance4j.wallet.request.GetFundingWalletRequest;
import com.binance4j.wallet.request.GetFuturesAccountSnapshotRequest;
import com.binance4j.wallet.request.GetMarginAccountSnapshotRequest;
import com.binance4j.wallet.request.GetSpotAccountSnapshotRequest;
import com.binance4j.wallet.request.GetSystemStatusRequest;
import com.binance4j.wallet.request.GetTradeFeeRequest;
import com.binance4j.wallet.request.GetTransferHistoryRequest;
import com.binance4j.wallet.request.GetWithdrawHistoryRequest;
import com.binance4j.wallet.request.WalletTransferRequest;
import com.binance4j.wallet.request.WithdrawRequest;

/**
 * The API client for the wallet endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#wallet-endpoints">Documentation</a>
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
	public GetSystemStatusRequest getSystemStatus() {
		return new GetSystemStatusRequest(service.getSystemStatus());
	}

	/**
	 * Gets the information of coins (available for deposit and withdraw) for user .
	 * 
	 * @return The request to execute.
	 */
	public GetAllCoinsInfoRequest getAllCoinsInfo() {
		return new GetAllCoinsInfoRequest(service.getAllCoinsInfo(new CoinInformationParams().toMap()));
	}

	/**
	 * Fetches the daily SPOT account snapshots.
	 * 
	 * @param timeinterval Search interval.
	 * @return The request to execute.
	 */
	public GetSpotAccountSnapshotRequest getSpotAccountSnapshot(TimeFrame timeinterval) {
		return new GetSpotAccountSnapshotRequest(service.getSpotAccountSnapshot(AccountSnapshotType.SPOT,
				Params.merge(new AccountSnapshotParams(), timeinterval)));
	}

	/**
	 * Fetches the last 5 daily SPOT account snapshots.
	 * 
	 * @return The request to execute.
	 */
	public GetSpotAccountSnapshotRequest getSpotAccountSnapshot() {
		return new GetSpotAccountSnapshotRequest(
				service.getSpotAccountSnapshot(AccountSnapshotType.SPOT, new AccountSnapshotParams().toMap()));
	}

	/**
	 * Fetches the daily MARGIN account snapshots.
	 * 
	 * @param timeinterval Search interval.
	 * @return The request to execute.
	 */
	public GetMarginAccountSnapshotRequest getMarginAccountSnapshot(TimeFrame timeinterval) {
		return new GetMarginAccountSnapshotRequest(service.getMarginAccountSnapshot(AccountSnapshotType.MARGIN,
				Params.merge(new AccountSnapshotParams(), timeinterval)));
	}

	/**
	 * Fetches the last 5 daily MARGIN account snapshots.
	 * 
	 * @return The request to execute.
	 */
	public GetMarginAccountSnapshotRequest getMarginAccountSnapshot() {
		return new GetMarginAccountSnapshotRequest(
				service.getMarginAccountSnapshot(AccountSnapshotType.MARGIN, new AccountSnapshotParams().toMap()));
	}

	/**
	 * Fetches the daily FUTURES account snapshots.
	 * 
	 * @param timeinterval Search interval.
	 * @return The request to execute.
	 */
	public GetFuturesAccountSnapshotRequest getFuturesAccountSnapshot(TimeFrame timeinterval) {
		return new GetFuturesAccountSnapshotRequest(service.getFuturesAccountSnapshot(AccountSnapshotType.FUTURES,
				Params.merge(new AccountSnapshotParams(), timeinterval)));
	}

	/**
	 * Fetches the last 5 daily FUTURES account snapshots.
	 * 
	 * @return The request to execute.
	 */
	public GetFuturesAccountSnapshotRequest getFuturesAccountSnapshot() {
		return new GetFuturesAccountSnapshotRequest(
				service.getFuturesAccountSnapshot(AccountSnapshotType.FUTURES, new AccountSnapshotParams().toMap()));
	}

	/**
	 * Disables fast withdraw switch under your account.
	 * 
	 * @return The request to execute.
	 */
	public DisableFastWithdrawSwitchRequest disableFastWithdrawSwitch() {
		return new DisableFastWithdrawSwitchRequest(
				service.disableFastWithdrawSwitch(new FastWithdrawSwitchParams().toMap()));
	}

	/**
	 * Enables fast withdraw switch under your account.
	 * 
	 * @return The request to execute.
	 */
	public EnableFastWithdrawSwitchRequest enableFastWithdrawSwitch() {
		return new EnableFastWithdrawSwitchRequest(
				service.enableFastWithdrawSwitch(new FastWithdrawSwitchParams().toMap()));
	}

	/**
	 * Submits a withdraw request.
	 * <p>
	 * If network not send, you can get {@code network} and {@code isDefault} in
	 * networkList of a coin in the response of
	 * {@link #getAllCoinsInfo()}
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public WithdrawRequest withdraw(WithdrawParams params) {
		return new WithdrawRequest(service.withdraw(params.toMap()));
	}

	/**
	 * Fetches the deposit history of one or multiple coins.
	 * <p>
	 * Please notice the default {@code startTime} and {@code endTime} to make sure
	 * that time interval is within 0-90 days.
	 * <p>
	 * If both {@code startTime</code> and <code>endTime} are sent,
	 * time between {@code startTime</code> and <code>endTime} must be less than 90
	 * days.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetDepositHistoryRequest getDepositHistory(DepositHistoryParams params) {
		return new GetDepositHistoryRequest(service.getDepositHistory(params.toMap()));
	}

	/**
	 * Fetches the last deposit history of all coins.
	 * 
	 * @return The request to execute.
	 */
	public GetDepositHistoryRequest getDepositHistory() {
		return getDepositHistory(new DepositHistoryParams());
	}

	/**
	 * Fetches the deposit history of one or multiple coins.
	 * <p>
	 * Please notice the default {@code startTime} and {@code endTime} to make sure
	 * that time interval is within 0-90 days.
	 * <p>
	 * If both {@code startTime</code> and <code>endTime} are sent,
	 * time between {@code startTime</code> and <code>endTime} must be less than 90
	 * days.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetDepositHistoryRequest getDepositHistory(DepositHistoryParams params, FramedPaging paging) {
		return new GetDepositHistoryRequest(
				service.getDepositHistory(Params.merge(params.toMap(), paging.toMap(Map.of("page", "offset")))));
	}

	/**
	 * Fetches the last deposit history of all coins.
	 * 
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetDepositHistoryRequest getDepositHistory(FramedPaging paging) {
		return new GetDepositHistoryRequest(service.getDepositHistory(
				Params.merge(new DepositHistoryParams().toMap(), paging.toMap(Map.of("page", "offset")))));
	}

	/**
	 * Fetches the withdraw history of one or multiple coins.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetWithdrawHistoryRequest getWithdrawHistory(WithdrawHistoryParams params) {
		return new GetWithdrawHistoryRequest(service.getWithdrawHistory(params.toMap()));
	}

	/**
	 * Fetches the withdraw history of one or multiple coins.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetWithdrawHistoryRequest getWithdrawHistory(WithdrawHistoryParams params, FramedPaging paging) {
		return new GetWithdrawHistoryRequest(
				service.getWithdrawHistory(Params.merge(params.toMap(), paging.toMap(Map.of("page", "offset")))));
	}

	/**
	 * Fetches the last withdraw history of all coins.
	 * 
	 * @return The request to execute.
	 */
	public GetWithdrawHistoryRequest getWithdrawHistory() {
		return getWithdrawHistory(new WithdrawHistoryParams((String) null));
	}

	/**
	 * Fetches deposit address
	 * <p>
	 * If {@code network} is not sent, return the coin.
	 * <p>
	 * You can get {@code network} and {@code isDefault} in {@code networkList} in
	 * the response of {@link #getAllCoinsInfo}
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetDepositAddressRequest getDepositAddress(DepositAddressParams params) {
		return new GetDepositAddressRequest(service.getDepositAddress(params.toMap()));
	}

	/**
	 * Fetches the account status detail.
	 * 
	 * @return The request to execute.
	 */
	public GetAccountStatus getAccountStatus() {
		return new GetAccountStatus(service.getAccountstatus(new AccountStatusParams().toMap()));
	}

	/**
	 * Fetches the account api trading status detail.
	 * 
	 * @return The request to execute.
	 */
	public GetApiTradingStatusRequest getApiTradingStatus() {
		return new GetApiTradingStatusRequest(service.getApiTradingStatus(new ApiTradingStatusParams().toMap()));
	}

	/**
	 * Fetches the dust transfer logs.
	 * 
	 * @return The request to execute.
	 */
	public GetDustLogRequest getDustLog() {
		return new GetDustLogRequest(service.getDustLog(new DustLogParams().toMap()));
	}

	/**
	 * Fetches the dust transfer logs.
	 * 
	 * @param timeFrame Search interval.
	 * @return The request to execute.
	 */
	public GetDustLogRequest getDustLog(TimeFrame timeFrame) {
		return new GetDustLogRequest(service.getDustLog(Params.merge(new DustLogParams(), timeFrame)));
	}

	/**
	 * Retrieves the assets convertible into BNB.
	 * 
	 * @return The request to execute.
	 */
	public GetConvertibleAssetsRequest getConvertibleAssets() {
		ConvertibleAssetParams params = new ConvertibleAssetParams();
		return new GetConvertibleAssetsRequest(service.getConvertibleAssets(params.toMap()));
	}

	/**
	 * Retrieves the assets convertible into BNB.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetConvertibleAssetsRequest getConvertibleAssets(ConvertibleAssetParams params) {
		return new GetConvertibleAssetsRequest(service.getConvertibleAssets(params.toMap()));
	}

	/**
	 * Convert dust assets to BNB.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public DustTransferRequest dustTransfer(DustTransferParams params) {
		return new DustTransferRequest(service.dustTransfer(params.toMap()));
	}

	/**
	 * Queries the dividend record of one or multiple assets.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetAssetDividendRecordRequest getAssetDividendRecord(AssetDividendRecordParams params) {
		return new GetAssetDividendRecordRequest(service.getAssetDividendRecord(params.toMap()));
	}

	/**
	 * Queries the last 20 dividend asset records.
	 * 
	 * @return The request to execute.
	 */
	public GetAssetDividendRecordRequest getAssetDividendRecord() {
		return getAssetDividendRecord(new AssetDividendRecordParams(null));
	}

	/**
	 * Queries the dividend record of one or multiple assets.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Search interval.
	 * @return The request to execute.
	 */
	public GetAssetDividendRecordRequest getAssetDividendRecord(AssetDividendRecordParams params, TimeFrame timeFrame) {
		return new GetAssetDividendRecordRequest(service.getAssetDividendRecord(Params.merge(params, timeFrame)));
	}

	/**
	 * Queries the last 20 dividend asset records.
	 * 
	 * @param timeFrame Search interval.
	 * @return The request to execute.
	 */
	public GetAssetDividendRecordRequest getAssetDividendRecord(TimeFrame timeFrame) {
		return new GetAssetDividendRecordRequest(
				service.getAssetDividendRecord(Params.merge(new AssetDividendRecordParams(null), timeFrame)));
	}

	/**
	 * Fetches the details of an asset supported on Binance. Please get network and
	 * other deposit or withdraw details from
	 * {@link #getAllCoinsInfo()}.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetAssetDetailRequest getAssetDetail(AssetDetailParams params) {
		return new GetAssetDetailRequest(service.getAssetDetail(params.toMap()));
	}

	/**
	 * Fetches the details of all assets supported on Binance.
	 * 
	 * @return The request to execute.
	 */
	public GetAssetDetailRequest getAssetDetail() {
		return getAssetDetail(new AssetDetailParams(null));
	}

	/**
	 * Fetches the trade fee.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetTradeFeeRequest getTradeFee(TradeFeeParams params) {
		return new GetTradeFeeRequest(service.getTradeFee(params.toMap()));
	}

	/**
	 * Fetches the trade fee.
	 * 
	 * @return The request to execute.
	 */
	public GetTradeFeeRequest getTradeFee() {
		return getTradeFee(new TradeFeeParams(null));
	}

	/**
	 * Make a universal transfer.
	 * <p>
	 * You need to enable {@code Permits Universal Transfer} option for the api key
	 * which requests this endpoint.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public WalletTransferRequest transfer(WalletTransferParams params) {
		return new WalletTransferRequest(service.transfer(params.toMap()));
	}

	/**
	 * Fetches the user universal transfer history
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetTransferHistoryRequest getTransferHistory(WalletTransferHistoryParams params) {
		return new GetTransferHistoryRequest(service.getTransferHistory(params.toMap()));
	}

	/**
	 * Fetches the user universal transfer history
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetTransferHistoryRequest getTransferHistory(WalletTransferHistoryParams params, FramedPaging paging) {
		return new GetTransferHistoryRequest(service.getTransferHistory(
				Params.merge(params.toMap(), paging.toMap(Map.of("limit", "size", "page", "current")))));
	}

	/**
	 * Fetches the funding wallet asset balance
	 * <p>
	 * Currently supports querying the following business assets：Binance Pay,
	 * Binance Card, Binance Gift Card, Stock Token
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetFundingWalletRequest getFundingWallet(FundingWalletParams params) {
		return new GetFundingWalletRequest(service.getFundingWallet(params.toMap()));
	}

	/**
	 * Fetches the funding wallet asset balance.
	 * 
	 * @return The request to execute.
	 */
	public GetFundingWalletRequest getFundingWallet() {
		return getFundingWallet(new FundingWalletParams(null, null));
	}

	/**
	 * Fetches the API Key Permission.
	 * 
	 * @return The request to execute.
	 */
	public GetApiPermissionsRequest getApiPermissions() {
		return new GetApiPermissionsRequest(service.getApiPermissions(new ApiPermissionsParams().toMap()));
	}
}