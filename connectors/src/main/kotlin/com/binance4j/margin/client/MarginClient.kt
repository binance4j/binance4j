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
package com.binance4j.margin.client

import com.binance4j.core.Request
import com.binance4j.core.client.RestClient
import com.binance4j.margin.param.*

/**
 * REST client for the margin endpoints.
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/.margin-account-trade)
 */
open class MarginClient : RestClient<MarginMapping> {
	/**
	 * @param key        API public key.
	 * @param secret     API secret key.
	 * @param useTestnet use testnet
	 */
	protected constructor(key: String, secret: String, useTestnet: Boolean) : super(
		MarginMapping::class.java,
		key,
		secret,
		useTestnet
	)
	
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	constructor(key: String, secret: String) : super(MarginMapping::class.java, key, secret)
	
	/**
	 * Execute transfer between spot account and cross margin account.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun transfer(params: TransferParams) = Request(service.transfer(params.toMap()))
	
	/**
	 * Apply for a loan.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun borrow(params: BorrowParams) = Request(service.borrow(params.toMap()))
	
	/**
	 * Repay loan for margin account.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun repay(params: RepayParams) = Request(service.repay(params.toMap()))
	
	/**
	 * Get info about an asset.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getAsset(params: AssetParams) = Request(service.getAsset(params.toMap()))
	
	/**
	 * Get info about all assets.
	 *
	 * @return The request to execute.
	 */
	fun getAllAssets() = Request(service.allAssets)
	
	/**
	 * Get info about a cross margin pair.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getCrossMarginPair(params: PairParams) = Request(service.getCrossMarginPair(params.toMap()))
	
	/**
	 * Get info about all cross margin pairs.
	 *
	 * @return The request to execute.
	 */
	fun getAllCrossMarginPairs() = Request(service.getAllCrossMarginPairs(AllMarginPairsParams().toMap()))
	
	/**
	 * Gets the price Index of a symbol.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getPriceIndex(params: PriceIndexParams) = Request(service.getPriceIndex(params.toMap()))
	
	/**
	 * Post a new order for margin account.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun newOrder(params: NewOrder) = Request(service.newOrder(params.toMap()))
	
	/**
	 * Send in a new OCO for a margin account.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun newOCO(params: NewOCO) = Request(service.newOCO(params.toMap()))
	
	/**
	 * Cancel an active order for margin account.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun cancelOrder(params: CancelOrderParams) = Request(service.cancelOrder(params.toMap()))
	
	/**
	 * Cancel all active orders on a symbol for margin account. This includes OCO
	 * orders.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun cancelOpenOrders(params: CancelOpenOrdersParams) = Request(service.cancelOpenOrders(params.toMap()))
	
	
	/**
	 * Get Cross Margin Transfer History.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getTransferHistory(params: TransactionHistoryParams = TransactionHistoryParams()) =
		Request(service.getTransferHistory(params.toMap()))
	
	/**
	 * Query Loan Record.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getLoanRecord(params: TransactionHistoryParams) = Request(service.getLoanRecord(params.toMap()))
	
	/**
	 * Query Repay Record.
	 *
	 * @param params Request params.
	 *
	 * @return The request to execute.
	 */
	fun getRepayRecord(params: TransactionHistoryParams) = Request(service.getRepayRecord(params.toMap()))
	
	
	/**
	 * Query interest Record.
	 *
	 * @param params Request params.
	 *
	 * @return The request to execute.
	 */
	fun getInterestHistory(params: TransactionHistoryParams) = Request(service.getInterestHistory(params.toMap()))
	
	/**
	 * Get Force Liquidation Record.
	 *
	 * @param params Request params.
	 *
	 * @return The request to execute.
	 */
	fun getForceLiquidationRecord(params: ForceLiquidationRecordParams) =
		Request(service.getForceLiquidationRecord(params.toMap()))
	
	/**
	 * Get Margin Account Details.
	 *
	 * @return The request to execute.
	 */
	fun getAccount() = Request(service.getAccount(GetAccountParams().toMap()))
	
	/**
	 * Get order status.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getOrder(params: OrderParams) = Request(service.getOrder(params.toMap()))
	
	/**
	 * Get open orders.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getOpenOrders(params: OpenOrdersParams = OpenOrdersParams()) = Request(service.getOpenOrders(params.toMap()))
	
	/**
	 * Get all orders.
	 *
	 * @param params Request params.
	 *
	 * @return The request to execute.
	 */
	fun getAllOrders(params: AllOrdersParams) = Request(service.getAllOrders(params.toMap()))
	
	/**
	 * Cancel an entire Order List.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun cancelOCO(params: CancelOCOParams) = Request(service.cancelOCO(params.toMap()))
	
	/**
	 * Retrieves a specific OCO based on provided optional parameters.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getOCO(params: GetOCOParams) = Request(service.getOCO(params.toMap()))
	
	/**
	 * Retrieves all OCO for a specific margin account based on provided optional
	 * parameters.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getAllOCO(params: GetAllOCOParams) = Request(service.getAllOCO(params.toMap()))
	
	/**
	 * Retrieves all open OCO
	 *
	 * @param params Request params.
	 *
	 * @return The request to execute.
	 */
	fun getOpenOCO(params: GetOpenOCOParams = GetOpenOCOParams()) = Request(service.getOpenOCO(params.toMap()))
	
	/**
	 * Query Margin Account's Trade List.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getTrades(params: TradeParams) = Request(service.getTrades(params.toMap()))
	
	/**
	 * Query Max Borrow.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getMaxBorrowable(params: MaxBorrowableParams) = Request(service.getMaxBorrowable(params.toMap()))
	
	/**
	 * Query Max Transfer-Out Amount.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getMaxTransferable(params: MaxTransferableParams) = Request(service.getMaxTransferable(params.toMap()))
	
	/**
	 * Make an Isolated Margin Account Transfer.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun newIsolatedTransfer(params: NewIsolatedTransferParams) = Request(service.isolatedTransfer(params.toMap()))
	
	/**
	 * Get Isolated Margin Transfer History.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getIsolatedTransferHistory(params: IsolatedTransferHistoryParams) =
		Request(service.getIsolatedTransferHistory(params.toMap()))
	
	/**
	 * Query Isolated Margin Account Info.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getIsolatedAccount(params: IsolatedAccountParams = IsolatedAccountParams()) =
		Request(service.getIsolatedAccount(params.toMap()))
	
	/**
	 * Disable isolated margin account for a specific symbol. Each trading pair can
	 * only be deactivated once every 24 hours.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun disableIsolatedAccount(params: ToogleAccountParams) = Request(service.disableIsolatedAccount(params.toMap()))
	
	/**
	 * Enable isolated margin account for a specific symbol(Only supports activation
	 * of previously disabled accounts).
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun enableIsolatedAccount(params: ToogleAccountParams) = Request(service.enableIsolatedAccount(params.toMap()))
	
	/**
	 * Query enabled isolated margin account limit.
	 *
	 * @return The request to execute.
	 */
	fun getEnabledIsolatedAccountLimit() =
		Request(service.getEnabledIsolatedAccountLimit(IsolatedAccountLimitParams().toMap()))
	
	/**
	 * Get info about an isolated symbol.
	 *
	 * @param params Request params.
	 *
	 * @return The request to execute.
	 */
	fun getIsolatedSymbol(params: PairParams) = Request(service.getIsolatedSymbol(params.toMap()))
	
	/**
	 * Get info about all the isolated symbols.
	 *
	 * @return The request to execute.
	 */
	fun getAllIsolatedSymbols() = Request(service.getAllIsolatedSymbols(AllMarginPairsParams().toMap()))
	
	/**
	 * Toggle BNB Burn On Spot Trade And Margin Interest
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun toggleBNBBurnOnSpotTradeAndMarginInterest(params: ToggleBurnParams) =
		Request(service.toggleBNBBurnOnSpotTradeAndMarginInterest(params.toMap()))
	
	/**
	 * Get BNB Burn Status.
	 *
	 * @return The request to execute.
	 */
	fun getBNBBurnStatus() = Request(service.getBNBBurnStatus(BurnStatusParams().toMap()))
	
	/**
	 * Query Margin Interest Rate History.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getInterestRateHistory(params: InterestRateHistoryParams) =
		Request(service.getInterestRateHistory(params.toMap()))
	
	/**
	 * Get cross margin fee data collection with any vip level or user's current
	 * specific data defined
	 * [here](https://www.binance.com/en/margin-fee).
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getMarginFeeData(params: CrossFeeParams = CrossFeeParams()) = Request(service.getMarginFeeData(params.toMap()))
	
	/**
	 * Get isolated margin fee data collection with any vip level or user's current
	 * specific data defined
	 * [here](https://www.binance.com/en/margin-fee).
	 *
	 * @param params Request params.
	 *
	 * @return The request to execute.
	 */
	fun getIsolatedFeeData(params: IsolatedFeeParams = IsolatedFeeParams()) =
		Request(service.getIsolatedFeeData(params.toMap()))
	
	/**
	 * Get isolated margin tier data collection with any tier defined
	 * [here](https://www.binance.com/en/margin-data).
	 *
	 * @param params Request params.
	 *
	 * @return The request to execute.
	 */
	fun getIsolatedMarginTierData(params: IsolatedTierDataParams) =
		Request(service.getIsolatedMarginTierData(params.toMap()))
	
	/**
	 * Displays the user's current margin order count usage for all intervals.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getRateLimit(params: RateLimitParams = RateLimitParams()) = Request(service.getRateLimit(params.toMap()))
	
	/**
	 * Query the historical information of user's margin account small-value asset
	 * conversion BNB.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getDustLog(params: DustLogParams = DustLogParams()) = Request(service.getDustLog(params.toMap()))
}