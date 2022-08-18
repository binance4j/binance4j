package com.binance4j.margin.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.margin.dto.Account;
import com.binance4j.margin.dto.Asset;
import com.binance4j.margin.dto.BNBBurnStatus;
import com.binance4j.margin.dto.CancelOrderResponse;
import com.binance4j.margin.dto.CrossFee;
import com.binance4j.margin.dto.CrossSymbol;
import com.binance4j.margin.dto.DustLogRecord;
import com.binance4j.margin.dto.ForceLiquidationRecords;
import com.binance4j.margin.dto.InterestHistory;
import com.binance4j.margin.dto.InterestRate;
import com.binance4j.margin.dto.IsolatedAccount;
import com.binance4j.margin.dto.IsolatedAccountLimit;
import com.binance4j.margin.dto.IsolatedFee;
import com.binance4j.margin.dto.IsolatedSymbol;
import com.binance4j.margin.dto.IsolatedTierData;
import com.binance4j.margin.dto.IsolatedTransferRecords;
import com.binance4j.margin.dto.LoanRecord;
import com.binance4j.margin.dto.MaxBorrowable;
import com.binance4j.margin.dto.MaxTransferable;
import com.binance4j.margin.dto.NewOCOOrderRecord;
import com.binance4j.margin.dto.NewOrderRecord;
import com.binance4j.margin.dto.OCOOrderRecord;
import com.binance4j.margin.dto.OrderInfo;
import com.binance4j.margin.dto.OrderRateLimit;
import com.binance4j.margin.dto.PriceIndex;
import com.binance4j.margin.dto.RepayRecords;
import com.binance4j.margin.dto.ToogleAccountResponse;
import com.binance4j.margin.dto.Trade;
import com.binance4j.margin.dto.Transaction;
import com.binance4j.margin.dto.TransferRecords;
import com.binance4j.margin.param.AllMarginPairsParams;
import com.binance4j.margin.param.AllOrdersParams;
import com.binance4j.margin.param.AssetParams;
import com.binance4j.margin.param.BorrowParams;
import com.binance4j.margin.param.BurnStatusParams;
import com.binance4j.margin.param.CancelOCOParams;
import com.binance4j.margin.param.CancelOpenOrdersParams;
import com.binance4j.margin.param.CancelOrderParams;
import com.binance4j.margin.param.CrossFeeParams;
import com.binance4j.margin.param.DustLogParams;
import com.binance4j.margin.param.ForceLiquidationRecordParams;
import com.binance4j.margin.param.GetAccountParams;
import com.binance4j.margin.param.GetAllOCOParams;
import com.binance4j.margin.param.GetOCOParams;
import com.binance4j.margin.param.GetOpenOCOParams;
import com.binance4j.margin.param.InterestRateHistoryParams;
import com.binance4j.margin.param.IsolatedAccountLimitParams;
import com.binance4j.margin.param.IsolatedAccountParams;
import com.binance4j.margin.param.IsolatedFeeParams;
import com.binance4j.margin.param.IsolatedTierDataParams;
import com.binance4j.margin.param.IsolatedTransferHistoryParams;
import com.binance4j.margin.param.LimitMakerOrder;
import com.binance4j.margin.param.LimitOrder;
import com.binance4j.margin.param.MarketOrder;
import com.binance4j.margin.param.MarketQuoteOrder;
import com.binance4j.margin.param.MaxBorrowableParams;
import com.binance4j.margin.param.MaxTransferableParams;
import com.binance4j.margin.param.NewIsolatedTransferParams;
import com.binance4j.margin.param.NewOCOOrderParams;
import com.binance4j.margin.param.NewOrderParams;
import com.binance4j.margin.param.OpenOrdersParams;
import com.binance4j.margin.param.OrderParams;
import com.binance4j.margin.param.PairParams;
import com.binance4j.margin.param.PriceIndexParams;
import com.binance4j.margin.param.RateLimitParams;
import com.binance4j.margin.param.RepayParams;
import com.binance4j.margin.param.StopLossLimitOrder;
import com.binance4j.margin.param.StopLossOrder;
import com.binance4j.margin.param.TakeProfitLimitOrder;
import com.binance4j.margin.param.TakeProfitOrder;
import com.binance4j.margin.param.ToggleBurnParams;
import com.binance4j.margin.param.ToogleAccountParams;
import com.binance4j.margin.param.TradeParams;
import com.binance4j.margin.param.TransactionHistoryParams;
import com.binance4j.margin.param.TransferParams;

/**
 * REST client for the margin endpoints.
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#margin-account-trade">Documentation</a>
 */
public class MarginClient extends RestClient<MarginMapping> {
	/**
	 * @param key        API public key.
	 * @param secret     API secret key.
	 * @param useTestnet use testnet?
	 */
	protected MarginClient(String key, String secret, boolean useTestnet) {
		super(MarginMapping.class, key, secret, useTestnet);
	}

	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public MarginClient(String key, String secret) {
		super(MarginMapping.class, key, secret);
	}

	/**
	 * Execute transfer between spot account and cross margin account.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<Transaction> transfer(TransferParams params) {
		return new Request<>(service.transfer(params.toMap()));
	}

	/**
	 * Apply for a loan.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<Transaction> borrow(BorrowParams params) {
		return new Request<>(service.borrow(params.toMap()));
	}

	/**
	 * Repay loan for margin account.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<Transaction> repay(RepayParams params) {
		return new Request<>(service.repay(params.toMap()));
	}

	/**
	 * Get info about an asset.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<Asset> getAsset(AssetParams params) {
		return new Request<>(service.getAsset(params.toMap()));
	}

	/**
	 * Get info about all assets.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<Asset>> getAllAssets() {
		return new Request<>(service.getAllAssets());
	}

	/**
	 * Get info about a cross margin pair.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<CrossSymbol> getCrossMarginPair(PairParams params) {
		return new Request<>(service.getCrossMarginPair(params.toMap()));
	}

	/**
	 * Get info about all cross margin pairs.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<CrossSymbol>> getAllCrossMarginPairs() {
		return new Request<>(service.getAllCrossMarginPairs(new AllMarginPairsParams().toMap()));
	}

	/**
	 * Gets the price Index of a symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<PriceIndex> getPriceIndex(PriceIndexParams params) {
		return new Request<>(service.getPriceIndex(params.toMap()));
	}

	/**
	 * Post a new order for margin account.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<NewOrderRecord> newOrder(NewOrderParams params) {
		return new Request<>(service.newOrder(params.toMap()));
	}

	// ORDERS

	/**
	 * Tests a {@link MarketOrder}.
	 * 
	 * @param order the {@link MarketOrder}.
	 * @return The request to execute.
	 */
	public Request<NewOrderRecord> newOrder(MarketOrder order) {
		return new Request<>(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link MarketQuoteOrder}.
	 * 
	 * @param order the {@link MarketQuoteOrder}.
	 * @return The request to execute.
	 */
	public Request<NewOrderRecord> newOrder(MarketQuoteOrder order) {
		return new Request<>(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link LimitOrder}.
	 * 
	 * @param order the {@link LimitOrder}.
	 * @return The request to execute.
	 */
	public Request<NewOrderRecord> newOrder(LimitOrder order) {
		return new Request<>(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link LimitMakerOrder}.
	 * 
	 * @param order the {@link LimitMakerOrder}.
	 * @return The request to execute.
	 */
	public Request<NewOrderRecord> newOrder(LimitMakerOrder order) {
		return new Request<>(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link StopLossLimitOrder}.
	 * 
	 * @param order the {@link StopLossLimitOrder}.
	 * @return The request to execute.
	 */
	public Request<NewOrderRecord> newOrder(StopLossLimitOrder order) {
		return new Request<>(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link StopLossOrder}.
	 * 
	 * @param order the {@link StopLossOrder}.
	 * @return The request to execute.
	 */
	public Request<NewOrderRecord> newOrder(StopLossOrder order) {
		return new Request<>(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link TakeProfitLimitOrder}.
	 * 
	 * @param order the {@link TakeProfitLimitOrder}.
	 * @return The request to execute.
	 */
	public Request<NewOrderRecord> newOrder(TakeProfitLimitOrder order) {
		return new Request<>(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link TakeProfitOrder}.
	 * 
	 * @param order the {@link TakeProfitOrder}.
	 * @return The request to execute.
	 */
	public Request<NewOrderRecord> newOrder(TakeProfitOrder order) {
		return new Request<>(service.newOrder(order.toMap()));
	}

	// END ORDERS

	/**
	 * Cancel an active order for margin account.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<CancelOrderResponse> cancelOrder(CancelOrderParams params) {
		return new Request<>(service.cancelOrder(params.toMap()));
	}

	/**
	 * Cancel all active orders on a symbol for margin account. This includes OCO
	 * orders.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<CancelOrderResponse>> cancelOpenOrders(CancelOpenOrdersParams params) {
		return new Request<>(service.cancelOpenOrders(params.toMap()));
	}

	/**
	 * Get Cross Margin Transfer History.
	 * 
	 * @return The request to execute.
	 */
	public Request<TransferRecords> getTransferHistory() {
		return getTransferHistory(new TransactionHistoryParams(null));
	}

	/**
	 * Get Cross Margin Transfer History.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<TransferRecords> getTransferHistory(TransactionHistoryParams params) {
		return new Request<>(service.getTransferHistory(params.toMap()));
	}

	/**
	 * Get Cross Margin Transfer History.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<TransferRecords> getTransferHistory(TransactionHistoryParams params, FramedPaging paging) {
		return new Request<>(service.getTransferHistory(
				Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query Loan Record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<LoanRecord> getLoanRecord(TransactionHistoryParams params) {
		return new Request<>(service.getLoanRecord(params.toMap()));
	}

	/**
	 * Query Loan Record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<LoanRecord> getLoanRecord(TransactionHistoryParams params, FramedPaging paging) {
		return new Request<>(service
				.getLoanRecord(Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query Repay Record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<RepayRecords> getRepayRecord(TransactionHistoryParams params) {
		return new Request<>(service.getRepayRecord(params.toMap()));
	}

	/**
	 * Query Repay Record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<RepayRecords> getRepayRecord(TransactionHistoryParams params, FramedPaging paging) {
		return new Request<>(service.getRepayRecord(
				Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query interest Record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<InterestHistory> getInterestHistory(TransactionHistoryParams params) {
		return new Request<>(service.getInterestHistory(params.toMap()));
	}

	/**
	 * Query interest Record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<InterestHistory> getInterestHistory(TransactionHistoryParams params, FramedPaging paging) {
		return new Request<>(service.getInterestHistory(
				Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Get Force Liquidation Record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<ForceLiquidationRecords> getForceLiquidationRecord(ForceLiquidationRecordParams params) {
		return new Request<>(service.getForceLiquidationRecord(params.toMap()));
	}

	/**
	 * Get Force Liquidation Record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<ForceLiquidationRecords> getForceLiquidationRecord(ForceLiquidationRecordParams params,
			FramedPaging paging) {
		return new Request<>(service.getForceLiquidationRecord(
				Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Get Margin Account Details.
	 * 
	 * @return The request to execute.
	 */
	public Request<Account> getAccount() {
		return new Request<>(service.getAccount(new GetAccountParams().toMap()));
	}

	/**
	 * Get order status.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<OrderInfo> getOrder(OrderParams params) {
		return new Request<>(service.getOrder(params.toMap()));
	}

	/**
	 * Get open orders.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getOpenOrders(OpenOrdersParams params) {
		return new Request<>(service.getOpenOrders(params.toMap()));
	}

	/**
	 * Get Open Orders.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getOpenOrders() {
		return getOpenOrders(new OpenOrdersParams(null, null));
	}

	/**
	 * Get all orders.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getAllOrders(AllOrdersParams params) {
		return new Request<>(service.getAllOrders(params.toMap()));
	}

	/**
	 * Get all orders.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time interval search.
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getAllOrders(AllOrdersParams params, TimeFrame timeFrame) {
		return new Request<>(service.getAllOrders(Params.merge(params, timeFrame)));
	}

	/**
	 * Send in a new OCO for a margin account.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<NewOCOOrderRecord> newOCO(NewOCOOrderParams params) {
		return new Request<>(service.newOCO(params.toMap()));
	}

	/**
	 * Cancel an entire Order List.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<NewOCOOrderRecord> cancelOCO(CancelOCOParams params) {
		return new Request<>(service.cancelOCO(params.toMap()));
	}

	/**
	 * Retrieves a specific OCO based on provided optional parameters.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<OCOOrderRecord> getOCO(GetOCOParams params) {
		return new Request<>(service.getOCO(params.toMap()));
	}

	/**
	 * Retrieves all OCO for a specific margin account based on provided optional
	 * parameters.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<OCOOrderRecord>> getAllOCO(GetAllOCOParams params) {
		return new Request<>(service.getAllOCO(params.toMap()));
	}

	/**
	 * Retrieves all OCO for a specific margin account based on provided optional
	 * parameters.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time interval seach.
	 * @return The request to execute.
	 */
	public Request<List<OCOOrderRecord>> getAllOCO(GetAllOCOParams params, TimeFrame timeFrame) {
		return new Request<>(service.getAllOCO(Params.merge(params, timeFrame)));
	}

	/**
	 * Retrieves all open OCO
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<OCOOrderRecord>> getOpenOCO(GetOpenOCOParams params) {
		return new Request<>(service.getOpenOCO(params.toMap()));
	}

	/**
	 * Retrieves all open OCO
	 * 
	 * @return The request to execute.
	 */
	public Request<List<OCOOrderRecord>> getOpenOCO() {
		return getOpenOCO(new GetOpenOCOParams(null, null));
	}

	/**
	 * Query Margin Account's Trade List.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<Trade>> getTrades(TradeParams params) {
		return new Request<>(service.getTrades(params.toMap()));
	}

	/**
	 * Query Margin Account's Trade List.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time interval seach.
	 * @return The request to execute.
	 */
	public Request<List<Trade>> getTrades(TradeParams params, TimeFrame timeFrame) {
		return new Request<>(service.getTrades(Params.merge(params, timeFrame)));
	}

	/**
	 * Query Max Borrow.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<MaxBorrowable> getMaxBorrowable(MaxBorrowableParams params) {
		return new Request<>(service.getMaxBorrowable(params.toMap()));
	}

	/**
	 * Query Max Transfer-Out Amount.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<MaxTransferable> getMaxTransferable(MaxTransferableParams params) {
		return new Request<>(service.getMaxTransferable(params.toMap()));
	}

	/**
	 * Make an Isolated Margin Account Transfer.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<Transaction> newIsolatedTransfer(NewIsolatedTransferParams params) {
		return new Request<>(service.isolatedTransfer(params.toMap()));
	}

	/**
	 * Get Isolated Margin Transfer History.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<IsolatedTransferRecords> getIsolatedTransferHistory(IsolatedTransferHistoryParams params) {
		return new Request<>(service.getIsolatedTransferHistory(params.toMap()));
	}

	/**
	 * Get Isolated Margin Transfer History.
	 * 
	 * @param params Request params.
	 * @param paging Paginated result.
	 * @return The request to execute.
	 */
	public Request<IsolatedTransferRecords> getIsolatedTransferHistory(IsolatedTransferHistoryParams params,
			FramedPaging paging) {
		return new Request<>(service.getIsolatedTransferHistory(
				Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query Isolated Margin Account Info.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<IsolatedAccount> getIsolatedAccount(IsolatedAccountParams params) {
		return new Request<>(service.getIsolatedAccount(params.toMap()));
	}

	/**
	 * Query Isolated Margin Account Info.
	 * 
	 * @return The request to execute.
	 */
	public Request<IsolatedAccount> getIsolatedAccount() {
		return getIsolatedAccount(new IsolatedAccountParams(null));
	}

	/**
	 * Disable isolated margin account for a specific symbol. Each trading pair can
	 * only be deactivated once every 24 hours.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<ToogleAccountResponse> disableIsolatedAccount(ToogleAccountParams params) {
		return new Request<>(service.disableIsolatedAccount(params.toMap()));
	}

	/**
	 * Enable isolated margin account for a specific symbol(Only supports activation
	 * of previously disabled accounts).
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<ToogleAccountResponse> enableIsolatedAccount(ToogleAccountParams params) {
		return new Request<>(service.enableIsolatedAccount(params.toMap()));
	}

	/**
	 * Query enabled isolated margin account limit.
	 * 
	 * @return The request to execute.
	 */
	public Request<IsolatedAccountLimit> getEnabledIsolatedAccountLimit() {
		return new Request<>(service.getEnabledIsolatedAccountLimit(new IsolatedAccountLimitParams().toMap()));
	}

	/**
	 * Get info about an isolated symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<IsolatedSymbol> getIsolatedSymbol(PairParams params) {
		return new Request<>(service.getIsolatedSymbol(params.toMap()));
	}

	/**
	 * Get info about all the isolated symbols.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<IsolatedSymbol>> getAllIsolatedSymbols() {
		return new Request<>(service.getAllIsolatedSymbols(new AllMarginPairsParams().toMap()));
	}

	/**
	 * Toggle BNB Burn On Spot Trade And Margin Interest
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<BNBBurnStatus> toggleBNBBurnOnSpotTradeAndMarginInterest(ToggleBurnParams params) {
		return new Request<>(service.toggleBNBBurnOnSpotTradeAndMarginInterest(params.toMap()));
	}

	/**
	 * Get BNB Burn Status.
	 * 
	 * @return The request to execute.
	 */
	public Request<BNBBurnStatus> getBNBBurnStatus() {
		return new Request<>(service.getBNBBurnStatus(new BurnStatusParams().toMap()));
	}

	/**
	 * Query Margin Interest Rate History.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<InterestRate>> getInterestRateHistory(InterestRateHistoryParams params) {
		return new Request<>(service.getInterestRateHistory(params.toMap()));
	}

	/**
	 * Get cross margin fee data collection with any vip level or user's current
	 * specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<CrossFee>> getMarginFeeData(CrossFeeParams params) {
		return new Request<>(service.getMarginFeeData(params.toMap()));
	}

	/**
	 * Get cross margin fee data collection with any vip level or user's current
	 * specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<CrossFee>> getMarginFeeData() {
		return getMarginFeeData(new CrossFeeParams(null, null));
	}

	/**
	 * Get isolated margin fee data collection with any vip level or user's current
	 * specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<IsolatedFee>> getIsolatedFeeData(IsolatedFeeParams params) {
		return new Request<>(service.getIsolatedFeeData(params.toMap()));
	}

	/**
	 * Get isolated margin fee data collection with any vip level or user's current
	 * specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<IsolatedFee>> getIsolatedFeeData() {
		return getIsolatedFeeData(new IsolatedFeeParams(null, null));
	}

	/**
	 * Get isolated margin tier data collection with any tier defined
	 * <a href="https://www.binance.com/en/margin-data">here</a>.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<IsolatedTierData>> getIsolatedMarginTierData(IsolatedTierDataParams params) {
		return new Request<>(service.getIsolatedMarginTierData(params.toMap()));
	}

	/**
	 * Displays the user's current margin order count usage for all intervals.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<OrderRateLimit>> getRateLimit() {
		return new Request<>(service.getRateLimit(new RateLimitParams(null).toMap()));
	}

	/**
	 * Displays the user's current margin order count usage for all intervals.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<OrderRateLimit>> getRateLimit(RateLimitParams params) {
		return new Request<>(service.getRateLimit(params.toMap()));
	}

	/**
	 * Query the historical information of user's margin account small-value asset
	 * conversion BNB.
	 * 
	 * @return The request to execute.
	 */
	public Request<DustLogRecord> getDustLog() {
		return new Request<>(service.getDustLog(new DustLogParams().toMap()));
	}

	/**
	 * Query the historical information of user's margin account small-value asset
	 * conversion BNB.
	 * 
	 * @param timeFrame Result time frame.
	 * @return The request to execute.
	 */
	public Request<DustLogRecord> getDustLog(TimeFrame timeFrame) {
		return new Request<>(service.getDustLog(Params.merge(new DustLogParams(), timeFrame)));
	}
}