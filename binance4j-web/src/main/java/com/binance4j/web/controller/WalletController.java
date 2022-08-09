package com.binance4j.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Wallet endpoints. */
@RestController
@RequestMapping("api/v1/wallet")
@Api(value = "Wallet", tags = "Wallet", produces = "application/json", description = "Wallet endpoints")
public class WalletController extends BaseController {
	/**
	 * @return The system status.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "system-status", produces = "application/json")
	@ApiOperation(value = "Get the system status.")
	public SystemStatus getSystemStatus() throws ApiException {
		return connectors.wallet().getSystemStatus().sync();
	}

	/**
	 * @return The information of coins (available for deposit and withdraw) for user.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "coins", produces = "application/json")
	@ApiOperation(value = "Get the information of coins (available for deposit and withdraw) for user .")
	public List<CoinInformation> getAllCoinsInfo() throws ApiException {
		return connectors.wallet().getAllCoinsInfo().sync();
	}

	/**
	 * @return The daily SPOT account snapshots.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "spot-snapshot", produces = "application/json")
	@ApiOperation(value = "Get the daily SPOT account snapshots.")
	public SpotAccountSnapshotResponse getSpotAccountSnapshot(@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.wallet().getSpotAccountSnapshot(new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * @return The daily MARGIN account snapshots.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "margin-snapshot", produces = "application/json")
	@ApiOperation(value = "Get the daily MARGIN account snapshots.")
	public MarginAccountSnapshotResponse getMarginAccountSnapshot(@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.wallet().getMarginAccountSnapshot(new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * @return The daily FUTURES account snapshots.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "futures-snapshot", produces = "application/json")
	@ApiOperation(value = "Get the daily FUTURES account snapshots.")
	public FuturesAccountSnapshotResponse getFuturesAccountSnapshot(@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.wallet().getFuturesAccountSnapshot(new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * Enables fast withdraw switch under your account.
	 * 
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "enable-fast-withdraw-switch", produces = "application/json")
	@ApiOperation(value = "Enables fast withdraw switch under your account.")
	public Void enableFastWithdrawSwitch() throws ApiException {
		return connectors.wallet().enableFastWithdrawSwitch().sync();
	}

	/**
	 * Disables fast withdraw switch under your account.
	 * 
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "disable-fast-withdraw-switch", produces = "application/json")
	@ApiOperation(value = "Disables fast withdraw switch under your account.")
	public Void disableFastWithdrawSwitch() throws ApiException {
		return connectors.wallet().disableFastWithdrawSwitch().sync();
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
	@PostMapping(path = "withdraw", produces = "application/json")
	@ApiOperation(value = "Submits a withdraw request.")
	public WithdrawResult withdraw(@RequestParam(required = true) @ApiParam(value = "Volume to withdraw.") String amount,
			@RequestParam(required = true) @ApiParam(value = "Coin to withdraw.") String coin,
			@RequestParam(required = true) @ApiParam(value = "Destination address.") String address) throws ApiException {
		return connectors.wallet().withdraw(new WithdrawParams(amount, coin, address)).sync();
	}

	/**
	 * @return Deposit history.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "deposits", produces = "application/json")
	@ApiOperation(value = "Get the deposit history of one or multiple coins.")
	public List<DepositHistory> getDepositHistory(@RequestParam(required = false) @ApiParam(value = "Deposited coin.") String coin,
			@RequestParam(required = false) @ApiParam(value = "Deposit status.") DepositStatus status,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page", defaultValue = "1") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.wallet().getDepositHistory(new DepositHistoryParams(status, coin), new FramedPaging(startTime, endTime, page, limit)).sync();
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
	@GetMapping(path = "withdraws", produces = "application/json")
	@ApiOperation(value = "Get the last withdraw history of all coins.")
	public List<WithdrawHistory> getWithdrawHistory(@RequestParam(required = false) @ApiParam(value = "Withdrawn coin.") String coin,
			@RequestParam(required = false) @ApiParam(value = "Withdraw status.") WithdrawStatus status,
			@RequestParam(required = false) @ApiParam(value = "Withdraw order id.") String withdrawOrderId,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page", defaultValue = "1") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.wallet()
				.getWithdrawHistory(new WithdrawHistoryParams(coin, withdrawOrderId, status), new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param coin    Coin abbreviation.
	 * @param network Transfer network.
	 * @return Deposit address.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "deposit-address", produces = "application/json", params = { "coin" })
	@ApiOperation(value = "Get deposit address.")
	public DepositAddress getDepositAddress(@RequestParam(required = true) @ApiParam(value = "Coin abbreviation.") String coin,
			@RequestParam(required = false) @ApiParam(value = "Transfer network.") String network) throws ApiException {
		return connectors.wallet().getDepositAddress(new DepositAddressParams(coin, network)).sync();
	}

	/**
	 * @return Account status.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "account-status", produces = "application/json")
	@ApiOperation(value = "Get account status.")
	public AccountStatus getAccountStatus() throws ApiException {
		return connectors.wallet().getAccountStatus().sync();
	}

	/**
	 * @return The account api trading status detail.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "trading-status", produces = "application/json")
	@ApiOperation(value = "Get the account api trading status detail.")
	public ApiTradingStatus getApiTradingStatus() throws ApiException {
		return connectors.wallet().getApiTradingStatus().sync();
	}

	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @return The the dust transfer logs.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "dust-log", produces = "application/json")
	@ApiOperation(value = "Get the dust transfer logs.")
	public DustLog getDustLog(@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime) throws ApiException {
		return connectors.wallet().getDustLog(new TimeFrame(startTime, endTime)).sync();
	}

	/**
	 * Convert dust assets to BNB.
	 * 
	 * @param symbols Symbols separated by a coma.
	 * @return The dust transfer response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "dust-transfer", produces = "application/json")
	@ApiOperation(value = "Convert dust assets to BNB.")
	public DustTransferResponse dustTransfer(
			@RequestParam(required = true) @ApiParam(example = "BTC, BNB, CAKE", value = "Symbols separated by a coma.") String symbols) throws ApiException {
		return connectors.wallet().dustTransfer(new DustTransferParams(symbols)).sync();
	}

	/**
	 * @param asset     Asset.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * @return The dividend record of one or multiple assets.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "asset-dividends", produces = "application/json")
	@ApiOperation(value = "Get the dividend record of one or multiple assets.")
	public AssetDividendRecord getAssetDividendRecord(@RequestParam(required = false) @ApiParam(example = "BNB", value = "Asset.") String asset,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.wallet().getAssetDividendRecord(new AssetDividendRecordParams(asset), new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * @param asset Asset.
	 * @return The details of one or all assets supported on Binance.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "asset-details", produces = "application/json")
	@ApiOperation(value = "Get the details of one or all assets supported on Binance.")
	public Map<String, AssetDetail> getAssetDetail(@RequestParam(required = false) @ApiParam(example = "BNB", value = "Asset.") String asset)
			throws ApiException {
		return connectors.wallet().getAssetDetail(new AssetDetailParams(asset)).sync();
	}

	/**
	 * @param symbol Symbol.
	 * @return Trade fees of one or all symbols
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "trade-fee", produces = "application/json")
	@ApiOperation(value = "Get trade fees of one or all symbols.")
	public List<TradeFee> getTradeFee(@RequestParam(required = false) @ApiParam(example = "BTCUSDT", value = "Symbol.") String symbol) throws ApiException {
		return connectors.wallet().getTradeFee(new TradeFeeParams(symbol)).sync();
	}

	/**
	 * Make a universal transfer.
	 * 
	 * @param asset      Asset.
	 * @param type       Transfer type.
	 * @param amount     Volume.
	 * @param fromSymbol Mandatory when {@code ISOLATEDMARGIN_MARGIN} and {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 * @param toSymbol   Mandatory when {@code ISOLATEDMARGIN_MARGIN} and {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 * @return The user universal transfer response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "universal-transfer", produces = "application/json")
	@ApiOperation(value = "Make a universal transfer.")
	public WalletTransferResponse transfer(@RequestParam(required = true) @ApiParam(example = "BTC", value = "Asset.") String asset,
			@RequestParam(required = true) @ApiParam(value = "Transfer type.") WalletTransferType type,
			@RequestParam(required = true) @ApiParam(value = "Amount.") String amount,
			@RequestParam(required = false) @ApiParam(value = "Mandatory when transfer type is ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN.") String fromSymbol,
			@RequestParam(required = false) @ApiParam(value = "Mandatory when transfer type is ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN.") String toSymbol)
			throws ApiException {
		return connectors.wallet().transfer(new WalletTransferParams(asset, type, amount, fromSymbol, toSymbol)).sync();
	}

	/**
	 * @param type       Transfer type.
	 * @param fromSymbol Mandatory when {@code ISOLATEDMARGIN_MARGIN} and {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 * @param toSymbol   Mandatory when {@code ISOLATEDMARGIN_MARGIN} and {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
	 * @param startTime  Start time in ms.
	 * @param endTime    End time in ms.
	 * @param page       Results page.
	 * @param limit      Results limit.
	 * @return The user universal transfer history.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "universal-transfers", produces = "application/json")
	@ApiOperation(value = "Get the user universal transfer history.")
	public WalletTransferHistory getTransferHistory(@RequestParam(required = true) @ApiParam(value = "Transfer type.") WalletTransferType type,
			@RequestParam(required = false) @ApiParam(value = "Mandatory when transfer type is ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN.") String fromSymbol,
			@RequestParam(required = false) @ApiParam(value = "Mandatory when transfer type is ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN.") String toSymbol,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page", defaultValue = "1") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.wallet()
				.getTransferHistory(new WalletTransferHistoryParams(type, fromSymbol, toSymbol), new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param asset            Asset we want the balance.
	 * @param needBtcValuation Get the BTC value of the asset.
	 * @return the funding wallet asset balance.
	 * @throws ApiException
	 */
	@GetMapping(path = "funding-wallet", produces = "application/json")
	@ApiOperation(value = "Get the funding wallet asset balance.")
	public List<FundingAsset> getFundingWallet(@RequestParam(required = false) @ApiParam(example = "BNB", value = "Asset.") String asset,
			@RequestParam(required = false) @ApiParam(example = "true", value = "BTC value of the asset.") Boolean needBtcValuation) throws ApiException {
		return connectors.wallet().getFundingWallet(new FundingWalletParams(asset, needBtcValuation)).sync();
	}

	/**
	 * @return the API Key Permission.
	 * @throws ApiException
	 */
	@GetMapping(path = "api-permissions", produces = "application/json")
	@ApiOperation(value = "Get the API Key Permission.")
	public ApiPermissions getApiPermissions() throws ApiException {
		return connectors.wallet().getApiPermissions().sync();
	}
}