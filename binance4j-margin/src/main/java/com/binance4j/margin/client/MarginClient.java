package com.binance4j.margin.client;

import java.util.List;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.order.CancelOpenOrdersParams;
import com.binance4j.core.order.CancelOrderParams;
import com.binance4j.core.order.CancelOrderResponse;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.param.Request;
import com.binance4j.margin.dto.Account;
import com.binance4j.margin.dto.Asset;
import com.binance4j.margin.dto.CrossFee;
import com.binance4j.margin.dto.CrossSymbol;
import com.binance4j.margin.dto.ForceLiquidationRecord;
import com.binance4j.margin.dto.InterestHistory;
import com.binance4j.margin.dto.InterestRate;
import com.binance4j.margin.dto.IsolatedAccount;
import com.binance4j.margin.dto.IsolatedAccountLimit;
import com.binance4j.margin.dto.IsolatedFee;
import com.binance4j.margin.dto.IsolatedSymbol;
import com.binance4j.margin.dto.IsolatedTierData;
import com.binance4j.margin.dto.IsolatedTransferHistory;
import com.binance4j.margin.dto.LoanRecord;
import com.binance4j.margin.dto.MaxBorrowable;
import com.binance4j.margin.dto.MaxTransferable;
import com.binance4j.margin.dto.OCOOrderRecord;
import com.binance4j.margin.dto.OCOResponse;
import com.binance4j.margin.dto.OrderResponse;
import com.binance4j.margin.dto.PriceIndex;
import com.binance4j.margin.dto.RepayRecord;
import com.binance4j.margin.dto.ToogleAccountResponse;
import com.binance4j.margin.dto.Trade;
import com.binance4j.margin.dto.Transaction;
import com.binance4j.margin.dto.TransferHistoryRecord;
import com.binance4j.margin.param.AllMarginPairsParams;
import com.binance4j.margin.param.AllOrdersParams;
import com.binance4j.margin.param.AssetParams;
import com.binance4j.margin.param.BNBBurnStatus;
import com.binance4j.margin.param.BorrowParams;
import com.binance4j.margin.param.BurnStatusParams;
import com.binance4j.margin.param.CancelMarginOCOParams;
import com.binance4j.margin.param.CrossMarginFeeParams;
import com.binance4j.margin.param.ForceLiquidationRecordParams;
import com.binance4j.margin.param.GetAllMarginOCOParams;
import com.binance4j.margin.param.GetMarginAccountParams;
import com.binance4j.margin.param.GetMarginOCOParams;
import com.binance4j.margin.param.GetOpenMarginOCOParams;
import com.binance4j.margin.param.InterestHistoryParams;
import com.binance4j.margin.param.InterestRateHistoryParams;
import com.binance4j.margin.param.IsolatedAccountLimitParams;
import com.binance4j.margin.param.IsolatedAccountParams;
import com.binance4j.margin.param.IsolatedMarginFeeParams;
import com.binance4j.margin.param.IsolatedMarginTierDataParams;
import com.binance4j.margin.param.IsolatedTransferHistoryParams;
import com.binance4j.margin.param.LoanRecordParams;
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
import com.binance4j.margin.param.RepayRecordParams;
import com.binance4j.margin.param.ToggleBurnParams;
import com.binance4j.margin.param.ToogleAccountParams;
import com.binance4j.margin.param.TradeParams;
import com.binance4j.margin.param.TransferHistoryParams;
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
		return new Request<>(service.transfer(params.toMap()), params);
	}

	/**
	 * Apply for a loan.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Transaction> borrow(BorrowParams params) {
		return new Request<>(service.borrow(params.toMap()), params);
	}

	/**
	 * Repay loan for margin account.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Transaction> repay(RepayParams params) {
		return new Request<>(service.repay(params.toMap()), params);
	}

	/**
	 * Gets the informations about an asset.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Asset> getAsset(AssetParams params) {
		return new Request<>(service.getAsset(params.toMap()), params);
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
		return new Request<>(service.getCrossMarginPair(params.toMap()), params);
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
		return new Request<>(service.getAllCrossMarginPairs(params.toMap()), params);
	}

	/**
	 * Gets the price Index of a symbol.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<PriceIndex> getPriceIndex(PriceIndexParams params) {
		return new Request<>(service.getPriceIndex(params.toMap()), params);
	}

	/**
	 * Post a new order for margin account.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<OrderResponse> newOrder(NewOrderParams params) {
		return new Request<>(service.newOrder(params.toMap()), params);
	}

	/**
	 * Cancel an active order for margin account.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<CancelOrderResponse> cancelOrder(CancelOrderParams params) {
		return new Request<>(service.cancelOrder(params.toMap()), params);
	}

	/**
	 * Cancel all active orders on a symbol for margin account. This includes OCO orders.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<CancelOrderResponse>> cancelOpenOrders(CancelOpenOrdersParams params) {
		return new Request<>(service.cancelOpenOrders(params.toMap()), params);
	}

	/**
	 * Get Cross Margin Transfer History.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<TransferHistoryRecord> getTransferHistory(TransferHistoryParams params) {
		return new Request<>(service.getTransferHistory(params.toMap()), params);
	}

	/**
	 * Get Cross Margin Transfer History.
	 * 
	 * @return The request to execute.
	 */
	public Request<TransferHistoryRecord> getTransferHistory() {
		return getTransferHistory(new TransferHistoryParams());
	}

	/**
	 * Query Loan Record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<LoanRecord> getLoanRecord(LoanRecordParams params) {
		return new Request<>(service.getLoanRecord(params.toMap()), params);
	}

	/**
	 * Query Repay Record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<RepayRecord> getRepayRecord(RepayRecordParams params) {
		return new Request<>(service.getRepayRecord(params.toMap()), params);
	}

	/**
	 * Query Repay Record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<InterestHistory> getInterestHistory(InterestHistoryParams params) {
		return new Request<>(service.getInterestHistory(params.toMap()), params);
	}

	/**
	 * Get Force Liquidation Record. Response in descending order.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<ForceLiquidationRecord> getForceLiquidationRecord(ForceLiquidationRecordParams params) {
		return new Request<>(service.getForceLiquidationRecord(params.toMap()), params);
	}

	/**
	 * Get Margin Account Details.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Account> getAccount(GetMarginAccountParams params) {
		return new Request<>(service.getAccount(params.toMap()), params);
	}

	/**
	 * Get Margin Account Details.
	 * 
	 * @return The request to execute.
	 */
	public Request<Account> getAccount() {
		return getAccount(new GetMarginAccountParams());
	}

	/**
	 * Get Margin Account's Order Status.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<OrderInfo> getOrder(OrderParams params) {
		return new Request<>(service.getOrder(params.toMap()), params);
	}

	/**
	 * Get Margin Account's Open Orders.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getOpenOrders(OpenOrdersParams params) {
		return new Request<>(service.getOpenOrders(params.toMap()), params);
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
		return new Request<>(service.getAllOrders(params.toMap()), params);
	}

	/**
	 * Send in a new OCO for a margin account.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<OCOResponse> newOCO(NewOCOOrderParams params) {
		return new Request<>(service.newOCO(params.toMap()), params);
	}

	/**
	 * Cancel an entire Order List.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<OCOResponse> cancelOCO(CancelMarginOCOParams params) {
		return new Request<>(service.cancelOCO(params.toMap()), params);
	}

	/**
	 * Retrieves a specific OCO based on provided optional parameters.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<OCOOrderRecord> getOCO(GetMarginOCOParams params) {
		return new Request<>(service.getOCO(params.toMap()), params);
	}

	/**
	 * Retrieves all OCO for a specific margin account based on provided optional parameters.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OCOOrderRecord>> getAllOCO(GetAllMarginOCOParams params) {
		return new Request<>(service.getAllOCO(params.toMap()), params);
	}

	/**
	 * Retrieves all Open OCO for a specific margin account based on provided optional parameters.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OCOOrderRecord>> getOpenOCO(GetOpenMarginOCOParams params) {
		return new Request<>(service.getOpenOCO(params.toMap()), params);
	}

	/**
	 * Retrieves all Open OCO for a specific margin account based on provided optional parameters.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<OCOOrderRecord>> getOpenOCO() {
		return getOpenOCO(new GetOpenMarginOCOParams());
	}

	/**
	 * Query Margin Account's Trade List.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<Trade>> getMyTrades(TradeParams params) {
		return new Request<>(service.getMyTrades(params.toMap()), params);
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
		return new Request<>(service.getMaxBorrowable(params.toMap()), params);
	}

	/**
	 * Query Max Transfer-Out Amount.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<MaxTransferable> getMaxTransferable(MaxTransferableParams params) {
		return new Request<>(service.getMaxTransferable(params.toMap()), params);
	}

	/**
	 * Make an Isolated Margin Account Transfer.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Transaction> newIsolatedTransfer(NewIsolatedTransferParams params) {
		return new Request<>(service.isolatedTransfer(params.toMap()), params);
	}

	/**
	 * Get Isolated Margin Transfer History.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<IsolatedTransferHistory> getIsolatedTransferHistory(IsolatedTransferHistoryParams params) {
		return new Request<>(service.getIsolatedTransferHistory(params.toMap()), params);
	}

	/**
	 * Query Isolated Margin Account Info.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<IsolatedAccount> getIsolatedAccount(IsolatedAccountParams params) {
		return new Request<>(service.getIsolatedAccount(params.toMap()), params);
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
		return new Request<>(service.disableIsolatedAccount(params.toMap()), params);
	}

	/**
	 * Enable isolated margin account for a specific symbol(Only supports activation of previously disabled accounts).
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<ToogleAccountResponse> enableIsolatedAccount(ToogleAccountParams params) {
		return new Request<>(service.enableIsolatedAccount(params.toMap()), params);
	}

	/**
	 * Query enabled isolated margin account limit.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<IsolatedAccountLimit> getEnabledIsolatedAccountLimit(IsolatedAccountLimitParams params) {
		return new Request<>(service.getEnabledIsolatedAccountLimit(params.toMap()), params);
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
		return new Request<>(service.getIsolatedSymbol(params.toMap()), params);
	}

	/**
	 * Gets the informations about all the isolated symbols.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<IsolatedSymbol>> getAllIsolatedSymbols(AllMarginPairsParams params) {
		return new Request<>(service.getAllIsolatedSymbols(params.toMap()), params);
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
		return new Request<>(service.toggleBNBBurnOnSpotTradeAndMarginInterest(params.toMap()), params);
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
		return new Request<>(service.getBNBBurnStatus(params.toMap()), params);
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
		return new Request<>(service.getInterestRateHistory(params.toMap()), params);
	}

	/**
	 * Get cross margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>. *
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<CrossFee>> getMarginFeeData(CrossMarginFeeParams params) {
		return new Request<>(service.getMarginFeeData(params.toMap()), params);
	}

	/**
	 * Get cross margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>. *
	 * 
	 * @return The request to execute.
	 */
	public Request<List<CrossFee>> getMarginFeeData() {
		return getMarginFeeData(new CrossMarginFeeParams());
	}

	/**
	 * Get isolated margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>. *
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<IsolatedFee>> getIsolatedFeeData(IsolatedMarginFeeParams params) {
		return new Request<>(service.getIsolatedFeeData(params.toMap()), params);
	}

	/**
	 * Get isolated margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>. *
	 * 
	 * @return The request to execute.
	 */
	public Request<List<IsolatedFee>> getIsolatedFeeData() {
		return getIsolatedFeeData(new IsolatedMarginFeeParams());
	}

	/**
	 * Get isolated margin tier data collection with any tier defined
	 * <a href="https://www.binance.com/en/margin-data">here</a>. *
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<IsolatedTierData>> getIsolatedMarginTierData(IsolatedMarginTierDataParams params) {
		return new Request<>(service.getIsolatedMarginTierData(params.toMap()), params);
	}
}