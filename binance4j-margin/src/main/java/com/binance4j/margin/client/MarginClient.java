package com.binance4j.margin.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.dto.CancelOrderResponse;
import com.binance4j.core.dto.OrderInfo;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.margin.dto.Account;
import com.binance4j.margin.dto.Asset;
import com.binance4j.margin.dto.BNBBurnStatus;
import com.binance4j.margin.dto.CrossFee;
import com.binance4j.margin.dto.CrossSymbol;
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
import com.binance4j.margin.param.MaxBorrowableParams;
import com.binance4j.margin.param.MaxTransferableParams;
import com.binance4j.margin.param.NewIsolatedTransferParams;
import com.binance4j.margin.param.NewOCOOrderParams;
import com.binance4j.margin.param.NewOrderParams;
import com.binance4j.margin.param.OpenOrdersParams;
import com.binance4j.margin.param.OrderParams;
import com.binance4j.margin.param.PairParams;
import com.binance4j.margin.param.PriceIndexParams;
import com.binance4j.margin.param.RepayParams;
import com.binance4j.margin.param.ToggleBurnParams;
import com.binance4j.margin.param.ToogleAccountParams;
import com.binance4j.margin.param.TradeParams;
import com.binance4j.margin.param.TransactionHistoryParams;
import com.binance4j.margin.param.TransferParams;

/**
 * REST client for the margin endpoints.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#margin-account-trade">Documentation</a>
 */
public class MarginClient extends RestClient<MarginMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public MarginClient(String key, String secret) {
		super(MarginMapping.class, key, secret);
	}

	/**
	 * Execute transfer between spot account and cross margin account.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Transaction> transfer(TransferParams params) {
		return new Request<>(service.transfer(params.toMap()));
	}

	/**
	 * Apply for a loan.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Transaction> borrow(BorrowParams params) {
		return new Request<>(service.borrow(params.toMap()));
	}

	/**
	 * Repay loan for margin account.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Transaction> repay(RepayParams params) {
		return new Request<>(service.repay(params.toMap()));
	}

	/**
	 * Gets the informations about an asset.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Asset> getAsset(AssetParams params) {
		return new Request<>(service.getAsset(params.toMap()));
	}

	/**
	 * Gets the informations about all assets.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<Asset>> getAllAssets() {
		return new Request<>(service.getAllAssets());
	}

	/**
	 * Gets the informations about a cross margin pair.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<CrossSymbol> getCrossMarginPair(PairParams params) {
		return new Request<>(service.getCrossMarginPair(params.toMap()));
	}

	/**
	 * Gets the informations about all cross margin pairs.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<CrossSymbol>> getAllCrossMarginPairs() {
		return getAllCrossMarginPairs(new AllMarginPairsParams());
	}

	/**
	 * Gets the informations about all cross margin pairs.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<CrossSymbol>> getAllCrossMarginPairs(AllMarginPairsParams params) {
		return new Request<>(service.getAllCrossMarginPairs(params.toMap()));
	}

	/**
	 * Gets the price Index of a symbol.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<PriceIndex> getPriceIndex(PriceIndexParams params) {
		return new Request<>(service.getPriceIndex(params.toMap()));
	}

	/**
	 * Post a new order for margin account.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<NewOrderRecord> newOrder(NewOrderParams params) {
		return new Request<>(service.newOrder(params.toMap()));
	}

	/**
	 * Cancel an active order for margin account.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<CancelOrderResponse> cancelOrder(CancelOrderParams params) {
		return new Request<>(service.cancelOrder(params.toMap()));
	}

	/**
	 * Cancel all active orders on a symbol for margin account. This includes OCO orders.
	 * 
	 * @param params The request params.
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
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<TransferRecords> getTransferHistory(TransactionHistoryParams params) {
		return new Request<>(service.getTransferHistory(params.toMap()));
	}

	/**
	 * Get Cross Margin Transfer History.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<TransferRecords> getTransferHistory(TransactionHistoryParams params, FramedPaging interval) {
		return new Request<>(service.getTransferHistory(Params.merge(params.toMap(), interval.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query Loan Record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<LoanRecord> getLoanRecord(TransactionHistoryParams params) {
		return new Request<>(service.getLoanRecord(params.toMap()));
	}

	/**
	 * Query Loan Record.
	 * 
	 * @param params   The request params.
	 * @param interval The result paginated.
	 * @return The request to execute.
	 */
	public Request<LoanRecord> getLoanRecord(TransactionHistoryParams params, FramedPaging interval) {
		return new Request<>(service.getLoanRecord(Params.merge(params.toMap(), interval.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query Repay Record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<RepayRecords> getRepayRecord(TransactionHistoryParams params) {
		return new Request<>(service.getRepayRecord(params.toMap()));
	}

	/**
	 * Query Repay Record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<RepayRecords> getRepayRecord(TransactionHistoryParams params, FramedPaging interval) {
		return new Request<>(service.getRepayRecord(Params.merge(params.toMap(), interval.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query interest Record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<InterestHistory> getInterestHistory(TransactionHistoryParams params) {
		return new Request<>(service.getInterestHistory(params.toMap()));
	}

	/**
	 * Query interest Record.
	 * 
	 * @param params   The request params.
	 * @param interval The search paging.
	 * @return The request to execute.
	 */
	public Request<InterestHistory> getInterestHistory(TransactionHistoryParams params, FramedPaging interval) {
		return new Request<>(service.getInterestHistory(Params.merge(params.toMap(), interval.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Get Force Liquidation Record. Response in descending order.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<ForceLiquidationRecords> getForceLiquidationRecord(ForceLiquidationRecordParams params) {
		return new Request<>(service.getForceLiquidationRecord(params.toMap()));
	}

	/**
	 * Get Force Liquidation Record. Response in descending order.
	 * 
	 * @param params   The request params.
	 * @param interval The search paging.
	 * @return The request to execute.
	 */
	public Request<ForceLiquidationRecords> getForceLiquidationRecord(ForceLiquidationRecordParams params, FramedPaging interval) {
		return new Request<>(service.getForceLiquidationRecord(Params.merge(params.toMap(), interval.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Get Margin Account Details.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Account> getAccount(GetAccountParams params) {
		return new Request<>(service.getAccount(params.toMap()));
	}

	/**
	 * Get Margin Account Details.
	 * 
	 * @return The request to execute.
	 */
	public Request<Account> getAccount() {
		return getAccount(new GetAccountParams());
	}

	/**
	 * Get Margin Account's Order Status.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<OrderInfo> getOrder(OrderParams params) {
		return new Request<>(service.getOrder(params.toMap()));
	}

	/**
	 * Get Margin Account's Open Orders.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getOpenOrders(OpenOrdersParams params) {
		return new Request<>(service.getOpenOrders(params.toMap()));
	}

	/**
	 * Get Margin Account's Open Orders.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getOpenOrders() {
		return getOpenOrders(new OpenOrdersParams());
	}

	/**
	 * Get Margin Account's Open Orders.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getAllOrders(AllOrdersParams params) {
		return new Request<>(service.getAllOrders(params.toMap()));
	}

	/**
	 * Get Margin Account's Open Orders.
	 * 
	 * @param params   The request params.
	 * @param interval The time interval search.
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getAllOrders(AllOrdersParams params, TimeFrame timeFrame) {
		return new Request<>(service.getAllOrders(Params.merge(params, timeFrame)));
	}

	/**
	 * Send in a new OCO for a margin account.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<NewOCOOrderRecord> newOCO(NewOCOOrderParams params) {
		return new Request<>(service.newOCO(params.toMap()));
	}

	/**
	 * Cancel an entire Order List.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<NewOCOOrderRecord> cancelOCO(CancelOCOParams params) {
		return new Request<>(service.cancelOCO(params.toMap()));
	}

	/**
	 * Retrieves a specific OCO based on provided optional parameters.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<OCOOrderRecord> getOCO(GetOCOParams params) {
		return new Request<>(service.getOCO(params.toMap()));
	}

	/**
	 * Retrieves all OCO for a specific margin account based on provided optional parameters.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OCOOrderRecord>> getAllOCO(GetAllOCOParams params) {
		return new Request<>(service.getAllOCO(params.toMap()));
	}

	/**
	 * Retrieves all OCO for a specific margin account based on provided optional parameters.
	 * 
	 * @param params   The request params.
	 * @param interval The time interval seach.
	 * @return The request to execute.
	 */
	public Request<List<OCOOrderRecord>> getAllOCO(GetAllOCOParams params, TimeFrame timeFrame) {
		return new Request<>(service.getAllOCO(Params.merge(params, timeFrame)));
	}

	/**
	 * Retrieves all Open OCO for a specific margin account based on provided optional parameters.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OCOOrderRecord>> getOpenOCO(GetOpenOCOParams params) {
		return new Request<>(service.getOpenOCO(params.toMap()));
	}

	/**
	 * Retrieves all Open OCO for a specific margin account based on provided optional parameters.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<OCOOrderRecord>> getOpenOCO() {
		return getOpenOCO(new GetOpenOCOParams());
	}

	/**
	 * Query Margin Account's Trade List.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<Trade>> getMyTrades(TradeParams params) {
		return new Request<>(service.getMyTrades(params.toMap()));
	}

	/**
	 * Query Margin Account's Trade List.
	 * 
	 * @param params   The request params.
	 * @param interval The time interval seach.
	 * @return The request to execute.
	 */
	public Request<List<Trade>> getMyTrades(TradeParams params, TimeFrame timeFrame) {
		return new Request<>(service.getMyTrades(Params.merge(params, timeFrame)));
	}

	/**
	 * Query Margin Account's Trade List.
	 * 
	 * @param interval The time interval seach.
	 * @return The request to execute.
	 */
	public Request<List<Trade>> getMyTrades(TimeFrame timeFrame) {
		return new Request<>(service.getMyTrades(timeFrame.toMap()));
	}

	/**
	 * Query Margin Account's Trade List.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<Trade>> getMyTrades() {
		return getMyTrades(new TradeParams());
	}

	/**
	 * Query Max Borrow.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<MaxBorrowable> getMaxBorrowable(MaxBorrowableParams params) {
		return new Request<>(service.getMaxBorrowable(params.toMap()));
	}

	/**
	 * Query Max Transfer-Out Amount.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<MaxTransferable> getMaxTransferable(MaxTransferableParams params) {
		return new Request<>(service.getMaxTransferable(params.toMap()));
	}

	/**
	 * Make an Isolated Margin Account Transfer.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Transaction> newIsolatedTransfer(NewIsolatedTransferParams params) {
		return new Request<>(service.isolatedTransfer(params.toMap()));
	}

	/**
	 * Get Isolated Margin Transfer History.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<IsolatedTransferRecords> getIsolatedTransferHistory(IsolatedTransferHistoryParams params) {
		return new Request<>(service.getIsolatedTransferHistory(params.toMap()));
	}

	/**
	 * Get Isolated Margin Transfer History.
	 * 
	 * @param params   The request params.
	 * @param interval The paginated result.
	 * @return The request to execute.
	 */
	public Request<IsolatedTransferRecords> getIsolatedTransferHistory(IsolatedTransferHistoryParams params, FramedPaging interval) {
		return new Request<>(service.getIsolatedTransferHistory(Params.merge(params.toMap(), interval.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query Isolated Margin Account Info.
	 * 
	 * @param params The request params.
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
		return getIsolatedAccount(new IsolatedAccountParams());
	}

	/**
	 * Disable isolated margin account for a specific symbol. Each trading pair can only be deactivated once every 24 hours.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<ToogleAccountResponse> disableIsolatedAccount(ToogleAccountParams params) {
		return new Request<>(service.disableIsolatedAccount(params.toMap()));
	}

	/**
	 * Enable isolated margin account for a specific symbol(Only supports activation of previously disabled accounts).
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<ToogleAccountResponse> enableIsolatedAccount(ToogleAccountParams params) {
		return new Request<>(service.enableIsolatedAccount(params.toMap()));
	}

	/**
	 * Query enabled isolated margin account limit.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<IsolatedAccountLimit> getEnabledIsolatedAccountLimit(IsolatedAccountLimitParams params) {
		return new Request<>(service.getEnabledIsolatedAccountLimit(params.toMap()));
	}

	/**
	 * Query enabled isolated margin account limit.
	 * 
	 * @return The request to execute.
	 */
	public Request<IsolatedAccountLimit> getEnabledIsolatedAccountLimit() {
		return getEnabledIsolatedAccountLimit(new IsolatedAccountLimitParams());
	}

	/**
	 * Gets the informations about an isolated symbol.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<IsolatedSymbol> getIsolatedSymbol(PairParams params) {
		return new Request<>(service.getIsolatedSymbol(params.toMap()));
	}

	/**
	 * Gets the informations about all the isolated symbols.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<IsolatedSymbol>> getAllIsolatedSymbols(AllMarginPairsParams params) {
		return new Request<>(service.getAllIsolatedSymbols(params.toMap()));
	}

	/**
	 * Gets the informations about all the isolated symbols.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<IsolatedSymbol>> getAllIsolatedSymbols() {
		return getAllIsolatedSymbols(new AllMarginPairsParams());
	}

	/**
	 * Toggle BNB Burn On Spot Trade And Margin Interest
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<BNBBurnStatus> toggleBNBBurnOnSpotTradeAndMarginInterest(ToggleBurnParams params) {
		return new Request<>(service.toggleBNBBurnOnSpotTradeAndMarginInterest(params.toMap()));
	}

	/**
	 * Toggle BNB Burn On Spot Trade And Margin Interest
	 * 
	 * @return The request to execute.
	 */
	public Request<BNBBurnStatus> toggleBNBBurnOnSpotTradeAndMarginInterest() {
		return toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams());
	}

	/**
	 * Get BNB Burn Status.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<BNBBurnStatus> getBNBBurnStatus(BurnStatusParams params) {
		return new Request<>(service.getBNBBurnStatus(params.toMap()));
	}

	/**
	 * Get BNB Burn Status.
	 * 
	 * @return The request to execute.
	 */
	public Request<BNBBurnStatus> getBNBBurnStatus() {
		return getBNBBurnStatus(new BurnStatusParams());
	}

	/**
	 * Query Margin Interest Rate History.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<InterestRate>> getInterestRateHistory(InterestRateHistoryParams params) {
		return new Request<>(service.getInterestRateHistory(params.toMap()));
	}

	/**
	 * Get cross margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>. *
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<CrossFee>> getMarginFeeData(CrossFeeParams params) {
		return new Request<>(service.getMarginFeeData(params.toMap()));
	}

	/**
	 * Get cross margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>. *
	 * 
	 * @return The request to execute.
	 */
	public Request<List<CrossFee>> getMarginFeeData() {
		return getMarginFeeData(new CrossFeeParams());
	}

	/**
	 * Get isolated margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>. *
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<IsolatedFee>> getIsolatedFeeData(IsolatedFeeParams params) {
		return new Request<>(service.getIsolatedFeeData(params.toMap()));
	}

	/**
	 * Get isolated margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>. *
	 * 
	 * @return The request to execute.
	 */
	public Request<List<IsolatedFee>> getIsolatedFeeData() {
		return getIsolatedFeeData(new IsolatedFeeParams());
	}

	/**
	 * Get isolated margin tier data collection with any tier defined
	 * <a href="https://www.binance.com/en/margin-data">here</a>. *
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<IsolatedTierData>> getIsolatedMarginTierData(IsolatedTierDataParams params) {
		return new Request<>(service.getIsolatedMarginTierData(params.toMap()));
	}
}