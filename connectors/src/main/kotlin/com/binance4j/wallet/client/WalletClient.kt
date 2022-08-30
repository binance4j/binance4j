/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.wallet.client

import com.binance4j.core.Request
import com.binance4j.core.client.RestClient
import com.binance4j.core.param.FramedPaging
import com.binance4j.core.param.Params.Companion.merge
import com.binance4j.core.param.TimeFrame
import com.binance4j.wallet.dto.*
import com.binance4j.wallet.param.*

/**
 * The API client for the wallet endpoints
 * @param key    API public key.
 * @param secret API secret key.
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/.wallet-endpoints)
 */
class WalletClient(key: String, secret: String) : RestClient<WalletMapping>(WalletMapping::class.java, key, secret) {
	/**
	 * Fetches the system status.
	 * @return The request to execute.
	 */
	fun getSystemStatus() = Request(service.getSystemStatus())
	
	/**
	 * Gets the information of coins (available for deposit and withdraw) for user .
	 * @return The request to execute.
	 */
	fun getAllCoinsInfo() =
		Request(service.getAllCoinsInfo(CoinInformationParams().toMap()))
	
	/**
	 * Fetches the daily SPOT account snapshots.
	 * @param timeFrame Search interval.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getSpotAccountSnapshot(timeFrame: TimeFrame = TimeFrame()) = Request(
		service.getSpotAccountSnapshot(AccountSnapshotType.SPOT, merge(AccountSnapshotParams(), timeFrame))
	)
	
	/**
	 * Fetches the daily MARGIN account snapshots.
	 * @param timeFrame Search interval.
	 * @return The request to execute.
	 */
	fun getMarginAccountSnapshot(timeFrame: TimeFrame = TimeFrame()) = Request(
		service.getMarginAccountSnapshot(AccountSnapshotType.MARGIN, merge(AccountSnapshotParams(), timeFrame))
	)
	
	/**
	 * Fetches the daily FUTURES account snapshots.
	 * @param timeFrame Search interval.
	 * @return The request to execute.
	 */
	fun getFuturesAccountSnapshot(timeFrame: TimeFrame = TimeFrame()) = Request(
		service.getFuturesAccountSnapshot(AccountSnapshotType.FUTURES, merge(AccountSnapshotParams(), timeFrame))
	)
	
	/**
	 * Disables fast withdraw switch under your account.
	 * @return The request to execute.
	 */
	fun disableFastWithdrawSwitch() = Request(service.disableFastWithdrawSwitch(FastWithdrawSwitchParams().toMap()))
	
	/**
	 * Enables fast withdraw switch under your account.
	 * @return The request to execute.
	 */
	fun enableFastWithdrawSwitch() = Request(service.enableFastWithdrawSwitch(FastWithdrawSwitchParams().toMap()))
	
	/**
	 * Submits a withdrawal request. If network not send, you can get `network` and `isDefault` in networkList of a coin in the response of [getAllCoinsInfo]
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun withdraw(params: WithdrawParams) = Request(service.withdraw(params.toMap()))
	
	/**
	 * Fetches the deposit history of one or multiple coins.
	 * @param params Request params.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getDepositHistory(
		params: DepositHistoryParams = DepositHistoryParams(),
		paging: FramedPaging = FramedPaging()
	): Request<List<DepositHistory>> =
		Request(service.getDepositHistory(merge(params, paging)))
	
	/**
	 * Fetches the withdrawal history of one or multiple coins.
	 * @param params Request params.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getWithdrawHistory(
		params: WithdrawHistoryParams = WithdrawHistoryParams("", "", ""),
		paging: FramedPaging = FramedPaging()
	): Request<List<WithdrawHistory>> =
		Request(service.getWithdrawHistory(merge(params, paging)))
	
	/**
	 * Fetches deposit address
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getDepositAddress(params: DepositAddressParams) = Request(service.getDepositAddress(params.toMap()))
	
	/**
	 * Fetches the account status detail.
	 * @return The request to execute.
	 */
	fun getAccountStatus() = Request(service.getAccountstatus(AccountStatusParams().toMap()))
	
	/**
	 * Fetches the account api trading status detail.
	 * @return The request to execute.
	 */
	fun getApiTradingStatus() = Request(service.getApiTradingStatus(ApiTradingStatusParams().toMap()))
	
	/**
	 * Fetches the dust transfer logs.
	 * @param timeFrame Search interval.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getDustLog(timeFrame: TimeFrame = TimeFrame()) = Request(service.getDustLog(merge(DustLogParams(), timeFrame)))
	
	/**
	 * Retrieves the assets convertible into BNB.
	 * @return The request to execute.
	 */
	fun getConvertibleAssets() = Request(service.getConvertibleAssets(ConvertibleAssetParams().toMap()))
	
	/**
	 * Retrieves the assets convertible into BNB.
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getConvertibleAssets(params: ConvertibleAssetParams) = Request(service.getConvertibleAssets(params.toMap()))
	
	/**
	 * Convert dust assets to BNB.
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun dustTransfer(params: DustTransferParams) = Request(service.dustTransfer(params.toMap()))
	
	/**
	 * Queries the dividend record of one or multiple assets.
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getAssetDividendRecord(
		params: AssetDividendRecordParams = AssetDividendRecordParams(), timeFrame: TimeFrame = TimeFrame()
	) = Request(service.getAssetDividendRecord(merge(params, timeFrame)))
	
	/**
	 * Fetches the details of an asset supported on Binance. Please get network and
	 * other deposit or withdraw details from [getAllCoinsInfo].
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getAssetDetail(params: AssetDetailParams = AssetDetailParams()): Request<Map<String, AssetDetail>> =
		Request(service.getAssetDetail(params.toMap()))
	
	/**
	 * Fetches the trade fee.
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getTradeFee(params: TradeFeeParams = TradeFeeParams()): Request<List<TradeFee>> =
		Request(service.getTradeFee(params.toMap()))
	
	/**
	 * Make a universal transfer.
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun transfer(params: WalletTransferParams) = Request(service.transfer(params.toMap()))
	
	/**
	 * Fetches the user universal transfer history
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getTransferHistory(params: WalletTransferHistoryParams, paging: FramedPaging = FramedPaging()) =
		Request(
			service.getTransferHistory(
				merge(
					params.toMap(),
					paging.toMap(mapOf("limit" to "size", "page" to "current"))
				)
			)
		)
	
	
	/**
	 * Fetches the funding wallet asset balance
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getFundingWallet(params: FundingWalletParams = FundingWalletParams()): Request<List<FundingAsset>> =
		Request(service.getFundingWallet(params.toMap()))
	
	/**
	 * Fetches the API Key Permission.
	 * @return The request to execute.
	 */
	fun getApiPermissions() = Request(service.getApiPermissions(ApiPermissionsParams().toMap()))
}