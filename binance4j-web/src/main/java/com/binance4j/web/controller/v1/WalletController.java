package com.binance4j.web.controller.v1;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.wallet.dto.AccountStatus;
import com.binance4j.wallet.dto.ApiPermissions;
import com.binance4j.wallet.dto.ApiTradingStatus;
import com.binance4j.wallet.dto.AssetDetail;
import com.binance4j.wallet.dto.AssetDividendRecord;
import com.binance4j.wallet.dto.CoinInformation;
import com.binance4j.wallet.dto.DepositAddress;
import com.binance4j.wallet.dto.DepositHistory;
import com.binance4j.wallet.dto.DepositStatus;
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
import com.binance4j.wallet.dto.WalletTransferType;
import com.binance4j.wallet.dto.WithdrawHistory;
import com.binance4j.wallet.dto.WithdrawResult;
import com.binance4j.wallet.dto.WithdrawStatus;
import com.binance4j.wallet.param.AssetDetailParams;
import com.binance4j.wallet.param.AssetDividendRecordParams;
import com.binance4j.wallet.param.DepositAddressParams;
import com.binance4j.wallet.param.DepositHistoryParams;
import com.binance4j.wallet.param.DustTransferParams;
import com.binance4j.wallet.param.FundingWalletParams;
import com.binance4j.wallet.param.TradeFeeParams;
import com.binance4j.wallet.param.WalletTransferHistoryParams;
import com.binance4j.wallet.param.WalletTransferParams;
import com.binance4j.wallet.param.WithdrawHistoryParams;
import com.binance4j.wallet.param.WithdrawParams;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.annotation.JsonPostMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/** Controller for Wallet endpoints. */
@RestController
@RequestMapping("api/v1/wallet")
@Api(value = "Wallet", tags = "Wallet", produces = "application/json", description = "Wallet endpoints")
public class WalletController extends BaseController {
	/**
	 * @return The system status.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "system-status")
	@ApiOperation(value = "Get the system status.")

	public SystemStatus getSystemStatus() throws ApiException {
		return connectors.rest().wallet().getSystemStatus().sync();
	}

	/**
	 * @return The information of coins (available for deposit and withdraw) for
	 *         user.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "coins")
	@ApiOperation(value = "Get the information of coins (available for deposit and withdraw) for user .")

	public List<CoinInformation> getAllCoinsInfo() throws ApiException {
		return connectors.rest().wallet().getAllCoinsInfo().sync();
	}

	/**
	 * @return The daily SPOT account snapshots.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "spot-snapshot")
	@ApiOperation(value = "Get the daily SPOT account snapshots.")

	public SpotAccountSnapshotResponse getSpotAccountSnapshot(
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().wallet().getSpotAccountSnapshot(new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * @return The daily MARGIN account snapshots.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "margin-snapshot")
	@ApiOperation(value = "Get the daily MARGIN account snapshots.")

	public MarginAccountSnapshotResponse getMarginAccountSnapshot(
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().wallet().getMarginAccountSnapshot(new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * @return The daily FUTURES account snapshots.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "futures-snapshot")
	@ApiOperation(value = "Get the daily FUTURES account snapshots.")

	public FuturesAccountSnapshotResponse getFuturesAccountSnapshot(
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().wallet().getFuturesAccountSnapshot(new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * Enables fast withdraw switch under your account.
	 * 
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "enable-fast-withdraw-switch")
	@ApiOperation(value = "Enables fast withdraw switch under your account.")

	public Void enableFastWithdrawSwitch() throws ApiException {
		return connectors.rest().wallet().enableFastWithdrawSwitch().sync();
	}

	/**
	 * Disables fast withdraw switch under your account.
	 * 
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "disable-fast-withdraw-switch")
	@ApiOperation(value = "Disables fast withdraw switch under your account.")

	public Void disableFastWithdrawSwitch() throws ApiException {
		return connectors.rest().wallet().disableFastWithdrawSwitch().sync();
	}

	/**
	 * Submits a withdraw request.
	 * 
	 * @param coin    Coin to withdraw.
	 * @param address Destination address.
	 * @param amount  Volume to withdraw.
	 * @return The result of a withdraw.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonPostMapping(path = "withdraw")
	@ApiOperation(value = "Submits a withdraw request.")

	public WithdrawResult withdraw(
			@RequestParam(name = "Volume to withdraw.") String amount,
			@RequestParam(name = COIN_DESCRIPTION) String coin,
			@RequestParam(name = "Destination address.") String address)
			throws ApiException {
		return connectors.rest().wallet().withdraw(new WithdrawParams(amount, coin, address)).sync();
	}

	/**
	 * @return Deposit history.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "deposits")
	@ApiOperation(value = "Get the deposit history of one or multiple coins.")

	public List<DepositHistory> getDepositHistory(
			@RequestParam(required = false, name = COIN_DESCRIPTION) String coin,
			@RequestParam(required = false, name = "Deposit status.") DepositStatus status,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = PAGE_DESCRIPTION, defaultValue = "1") Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().wallet().getDepositHistory(new DepositHistoryParams(status, coin),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param coin            Coin.
	 * @param withdrawOrderId Withdraw order id.
	 * @param status          Withdraw status.
	 * @param startTime       Start time in ms.
	 * @param endTime         End time in ms.
	 * @param page            Results page.
	 * @param limit           Results limit.
	 * @return Withdraw history.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "withdraws")
	@ApiOperation(value = "Get the last withdraw history of all coins.")

	public List<WithdrawHistory> getWithdrawHistory(
			@RequestParam(required = false, name = COIN_DESCRIPTION) String coin,
			@RequestParam(required = false, name = "Withdraw status.") WithdrawStatus status,
			@RequestParam(required = false, name = "Withdraw order id.") String withdrawOrderId,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = PAGE_DESCRIPTION, defaultValue = "1") Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().wallet()
				.getWithdrawHistory(new WithdrawHistoryParams(coin, withdrawOrderId, status),
						new FramedPaging(startTime, endTime, page, limit))
				.sync();
	}

	/**
	 * @param coin    Coin abbreviation.
	 * @param network Transfer network.
	 * @return Deposit address.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "deposit-address")
	@ApiOperation(value = "Get deposit address.")
	public DepositAddress getDepositAddress(
			@RequestParam(name = COIN_DESCRIPTION) String coin,
			@RequestParam(required = false, name = "Transfer network.") String network) throws ApiException {
		return connectors.rest().wallet().getDepositAddress(new DepositAddressParams(coin, network)).sync();
	}

	/**
	 * @return Account status.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "account-status")
	@ApiOperation(value = "Get account status.")

	public AccountStatus getAccountStatus() throws ApiException {
		return connectors.rest().wallet().getAccountStatus().sync();
	}

	/**
	 * @return The account api trading status detail.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "trading-status")
	@ApiOperation(value = "Get the account api trading status detail.")

	public ApiTradingStatus getApiTradingStatus() throws ApiException {
		return connectors.rest().wallet().getApiTradingStatus().sync();
	}

	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @return The the dust transfer logs.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "dust-log")
	@ApiOperation(value = "Get the dust transfer logs.")

	public DustLog getDustLog(@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime) throws ApiException {
		return connectors.rest().wallet().getDustLog(new TimeFrame(startTime, endTime)).sync();
	}

	/**
	 * Convert dust assets to BNB.
	 * 
	 * @param symbols Symbols separated by a coma.
	 * @return The dust transfer response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonPostMapping(path = "dust-transfer")
	@ApiOperation(value = "Convert dust assets to BNB.")

	public DustTransferResponse dustTransfer(
			@RequestParam(name = SYMBOL_DESCRIPTION) String symbols)
			throws ApiException {
		return connectors.rest().wallet().dustTransfer(new DustTransferParams(symbols)).sync();
	}

	/**
	 * @param asset     Asset.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * @return The dividend record of one or multiple assets.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "asset-dividends")
	@ApiOperation(value = "Get the dividend record of one or multiple assets.")

	public AssetDividendRecord getAssetDividendRecord(
			@RequestParam(required = false, name = ASSET_DESCRIPTION) String asset,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().wallet()
				.getAssetDividendRecord(new AssetDividendRecordParams(asset), new TimeFrame(startTime, endTime, limit))
				.sync();
	}

	/**
	 * @param asset Asset.
	 * @return The details of one or all assets supported on Binance.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "asset-details")
	@ApiOperation(value = "Get the details of one or all assets supported on Binance.")

	public Map<String, AssetDetail> getAssetDetail(
			@RequestParam(required = false, name = ASSET_DESCRIPTION) String asset)
			throws ApiException {
		return connectors.rest().wallet().getAssetDetail(new AssetDetailParams(asset)).sync();
	}

	/**
	 * @param symbol Symbol.
	 * @return Trade fees of one or all symbols
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "trade-fee")
	@ApiOperation(value = "Get trade fees of one or all symbols.")

	public List<TradeFee> getTradeFee(
			@RequestParam(required = false, name = "Symbol.") String symbol)
			throws ApiException {
		return connectors.rest().wallet().getTradeFee(new TradeFeeParams(symbol)).sync();
	}

	/**
	 * Make a universal transfer.
	 * 
	 * @param asset      Asset.
	 * @param type       Transfer type.
	 * @param amount     Volume.
	 * @param fromSymbol Mandatory when {@code ISOLATEDMARGIN_MARGIN} and
	 *                   {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 * @param toSymbol   Mandatory when {@code ISOLATEDMARGIN_MARGIN} and
	 *                   {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 * @return The user universal transfer response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonPostMapping(path = "universal-transfer")
	@ApiOperation(value = "Make a universal transfer.")

	public WalletTransferResponse transfer(
			@RequestParam(name = ASSET_DESCRIPTION) String asset,
			@RequestParam(name = "Transfer type.") WalletTransferType type,
			@RequestParam(name = "Amount.") String amount,
			@RequestParam(required = false, name = "Mandatory when transfer type is ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN.") String fromSymbol,
			@RequestParam(required = false, name = "Mandatory when transfer type is ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN.") String toSymbol)
			throws ApiException {
		return connectors.rest().wallet().transfer(new WalletTransferParams(asset, type, amount, fromSymbol, toSymbol))
				.sync();
	}

	/**
	 * @param type       Transfer type.
	 * @param fromSymbol Mandatory when {@code ISOLATEDMARGIN_MARGIN} and
	 *                   {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 * @param toSymbol   Mandatory when {@code ISOLATEDMARGIN_MARGIN} and
	 *                   {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 * @param startTime  Start time in ms.
	 * @param endTime    End time in ms.
	 * @param page       Results page.
	 * @param limit      Results limit.
	 * @return The user universal transfer history.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "universal-transfers")
	@ApiOperation(value = "Get the user universal transfer history.")

	public WalletTransferHistory getTransferHistory(
			@RequestParam(name = "Transfer type.") WalletTransferType type,
			@RequestParam(required = false, name = "Mandatory when transfer type is ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN.") String fromSymbol,
			@RequestParam(required = false, name = "Mandatory when transfer type is ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN.") String toSymbol,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = PAGE_DESCRIPTION, defaultValue = "1") Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().wallet()
				.getTransferHistory(new WalletTransferHistoryParams(type, fromSymbol, toSymbol),
						new FramedPaging(startTime, endTime, page, limit))
				.sync();
	}

	/**
	 * @param asset            Asset we want the balance.
	 * @param needBtcValuation Get the BTC value of the asset.
	 * @return the funding wallet asset balance.
	 * @throws ApiException
	 */
	@JsonGetMapping(path = "funding-wallet")
	@ApiOperation(value = "Get the funding wallet asset balance.")

	public List<FundingAsset> getFundingWallet(
			@RequestParam(required = false, name = ASSET_DESCRIPTION) String asset,
			@RequestParam(required = false, name = "BTC value of the asset.") Boolean needBtcValuation)
			throws ApiException {
		return connectors.rest().wallet().getFundingWallet(new FundingWalletParams(asset, needBtcValuation)).sync();
	}

	/**
	 * @return the API Key Permission.
	 * @throws ApiException
	 */
	@JsonGetMapping(path = "api-permissions")
	@ApiOperation(value = "Get the API Key Permission.")

	public ApiPermissions getApiPermissions() throws ApiException {
		return connectors.rest().wallet().getApiPermissions().sync();
	}
}