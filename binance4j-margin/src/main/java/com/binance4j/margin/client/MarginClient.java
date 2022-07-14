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
import com.binance4j.margin.dto.CrossMarginFee;
import com.binance4j.margin.dto.ForceLiquidationRecord;
import com.binance4j.margin.dto.GetMarginOCOResponse;
import com.binance4j.margin.dto.InterestHistory;
import com.binance4j.margin.dto.InterestRate;
import com.binance4j.margin.dto.IsolatedAccount;
import com.binance4j.margin.dto.IsolatedAccountLimit;
import com.binance4j.margin.dto.IsolatedMarginFee;
import com.binance4j.margin.dto.IsolatedMarginTierData;
import com.binance4j.margin.dto.IsolatedTransferHistory;
import com.binance4j.margin.dto.LoanRecord;
import com.binance4j.margin.dto.MaxBorrowableResponse;
import com.binance4j.margin.dto.MaxTransferableResponse;
import com.binance4j.margin.dto.OCOResponse;
import com.binance4j.margin.dto.OrderResponse;
import com.binance4j.margin.dto.Pair;
import com.binance4j.margin.dto.PriceIndex;
import com.binance4j.margin.dto.RepayRecord;
import com.binance4j.margin.dto.ToogleAccountResponse;
import com.binance4j.margin.dto.Trade;
import com.binance4j.margin.dto.Transaction;
import com.binance4j.margin.dto.TransferHistoryResponse;
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
import com.binance4j.margin.param.PairPrams;
import com.binance4j.margin.param.PriceIndexParams;
import com.binance4j.margin.param.RepayParams;
import com.binance4j.margin.param.RepayRecordParams;
import com.binance4j.margin.param.ToggleBurnParams;
import com.binance4j.margin.param.ToogleAccountParams;
import com.binance4j.margin.param.TradeParams;
import com.binance4j.margin.param.TransferHistoryParams;
import com.binance4j.margin.param.TransferParams;

/**
 * Api client for the margin endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#margin-account-trade">Documentation</a>
 */
public class MarginClient extends RestClient<MarginMapping> {
	/**
	 * Instantiates a client for the margin endpoints
	 *
	 * @param key    The API public key
	 * @param secret The API secret key
	 */
	public MarginClient(String key, String secret) {
		super(MarginMapping.class, key, secret);
	}

	/** Execute transfer between spot account and cross margin account. */
	public Request<Transaction> transfer(TransferParams params) {
		return new Request<>(service.transfer(params.toMap()), params);
	}

	/** Apply for a loan. */
	public Request<Transaction> borrow(BorrowParams params) {
		return new Request<>(service.borrow(params.toMap()), params);
	}

	/** Repay loan for margin account. */
	public Request<Transaction> repay(RepayParams params) {
		return new Request<>(service.repay(params.toMap()), params);
	}

	/** Gets the informations about an asset. */
	public Request<Asset> getAsset(AssetParams params) {
		return new Request<>(service.getAsset(params.toMap()), params);
	}

	/** Gets the informations about all assets. */
	public Request<List<Asset>> getAllAssets() {
		return new Request<>(service.getAllAssets());
	}

	/** Gets the informations about a cross margin pair. */
	public Request<Pair> getCrossMarginPair(PairPrams params) {
		return new Request<>(service.getCrossMarginPair(params.toMap()), params);
	}

	/** Gets the informations about all cross margin pairs. */
	public Request<List<Pair>> getAllCrossMarginPairs() {
		return getAllCrossMarginPairs(new AllMarginPairsParams());
	}

	/** Gets the informations about all cross margin pairs. */
	public Request<List<Pair>> getAllCrossMarginPairs(AllMarginPairsParams params) {
		return new Request<>(service.getAllCrossMarginPairs(params.toMap()), params);
	}

	/** Gets the price Index of a symbol. */
	public Request<PriceIndex> getPriceIndex(PriceIndexParams params) {
		return new Request<>(service.getPriceIndex(params.toMap()), params);
	}

	/** Post a new order for margin account. */
	public Request<OrderResponse> newOrder(NewOrderParams params) {
		return new Request<>(service.newOrder(params.toMap()), params);
	}

	/** Cancel an active order for margin account. */
	public Request<CancelOrderResponse> cancelOrder(CancelOrderParams params) {
		return new Request<>(service.cancelOrder(params.toMap()), params);
	}

	/** Cancel all active orders on a symbol for margin account. This includes OCO orders. */
	public Request<List<CancelOrderResponse>> cancelOpenOrders(CancelOpenOrdersParams params) {
		return new Request<>(service.cancelOpenOrders(params.toMap()), params);
	}

	/** Get Cross Margin Transfer History. */
	public Request<TransferHistoryResponse> getTransferHistory(TransferHistoryParams params) {
		return new Request<>(service.getTransferHistory(params.toMap()), params);
	}

	/** Get Cross Margin Transfer History. */
	public Request<TransferHistoryResponse> getTransferHistory() {
		return getTransferHistory(new TransferHistoryParams());
	}

	/**
	 * Query Loan Record
	 */
	public Request<LoanRecord> getLoanRecord(LoanRecordParams params) {
		return new Request<>(service.getLoanRecord(params.toMap()), params);
	}

	/**
	 * Query Repay Record.
	 */
	public Request<RepayRecord> getRepayRecord(RepayRecordParams params) {
		return new Request<>(service.getRepayRecord(params.toMap()), params);
	}

	/**
	 * Query Repay Record.
	 */
	public Request<InterestHistory> getInterestHistory(InterestHistoryParams params) {
		return new Request<>(service.getInterestHistory(params.toMap()), params);
	}

	/**
	 * Get Force Liquidation Record. Response in descending order.
	 */
	public Request<ForceLiquidationRecord> getForceLiquidationRecord(ForceLiquidationRecordParams params) {
		return new Request<>(service.getForceLiquidationRecord(params.toMap()), params);
	}

	/** Get Margin Account Details. */
	public Request<Account> getAccount(GetMarginAccountParams params) {
		return new Request<>(service.getAccount(params.toMap()), params);
	}

	/** Get Margin Account Details. */
	public Request<Account> getAccount() {
		return getAccount(new GetMarginAccountParams());
	}

	/** Get Margin Account's Order Status. */
	public Request<OrderInfo> getOrder(OrderParams params) {
		return new Request<>(service.getOrder(params.toMap()), params);
	}

	/**
	 * Get Margin Account's Open Orders
	 * <p>
	 * If the symbol is not sent, orders for all symbols will be returned in an array.
	 * <p>
	 * When all symbols are returned, the number of requests counted against the rate limiter is equal to the number of
	 * symbols currently trading on the exchange.
	 * <p>
	 * If isIsolated ="TRUE", symbol must be sent.
	 */
	public Request<List<OrderInfo>> getOpenOrders(OpenOrdersParams params) {
		return new Request<>(service.getOpenOrders(params.toMap()), params);
	}

	/**
	 * Get Margin Account's Open Orders
	 * <p>
	 * If the symbol is not sent, orders for all symbols will be returned in an array.
	 * <p>
	 * When all symbols are returned, the number of requests counted against the rate limiter is equal to the number of
	 * symbols currently trading on the exchange.
	 * <p>
	 * If isIsolated ="TRUE", symbol must be sent.
	 */
	public Request<List<OrderInfo>> getOpenOrders() {
		return getOpenOrders(new OpenOrdersParams());
	}

	/**
	 * Get Margin Account's Open Orders
	 * <p>
	 * Request Limit: 60times/min per IP
	 * <p>
	 * If orderId is set, it will get orders&gt;= that orderId. Otherwise most recent orders are returned.
	 * <p>
	 * For some historical orders cummulativeQuoteQty will be &lt;0, meaning the data is not available at this time.
	 */
	public Request<List<OrderInfo>> getAllOrders(AllOrdersParams params) {
		return new Request<>(service.getAllOrders(params.toMap()), params);
	}

	/**
	 * Send in a new OCO for a margin account
	 */
	public Request<OCOResponse> newOCO(NewOCOOrderParams params) {
		return new Request<>(service.newOCO(params.toMap()), params);
	}

	/**
	 * Cancel an entire Order List
	 */
	public Request<OCOResponse> cancelOCO(CancelMarginOCOParams params) {
		return new Request<>(service.cancelOCO(params.toMap()), params);
	}

	/** Retrieves a specific OCO based on provided optional parameters. */
	public Request<GetMarginOCOResponse> getOCO(GetMarginOCOParams params) {
		return new Request<>(service.getOCO(params.toMap()), params);
	}

	/** Retrieves all OCO for a specific margin account based on provided optional parameters. */
	public Request<List<GetMarginOCOResponse>> getAllOCO(GetAllMarginOCOParams params) {
		return new Request<>(service.getAllOCO(params.toMap()), params);
	}

	/** Retrieves all Open OCO for a specific margin account based on provided optional parameters. */
	public Request<List<GetMarginOCOResponse>> getOpenOCO(GetOpenMarginOCOParams params) {
		return new Request<>(service.getOpenOCO(params.toMap()), params);
	}

	/** Retrieves all Open OCO for a specific margin account based on provided optional parameters. */
	public Request<List<GetMarginOCOResponse>> getOpenOCO() {
		return getOpenOCO(new GetOpenMarginOCOParams());
	}

	/**
	 * Query Margin Account's Trade List
	 */
	public Request<List<Trade>> getMyTrades(TradeParams params) {
		return new Request<>(service.getMyTrades(params.toMap()), params);
	}

	/**
	 * Query Margin Account's Trade List
	 */
	public Request<List<Trade>> getMyTrades() {
		return getMyTrades(new TradeParams());
	}

	/**
	 * Query Max Borrow
	 */
	public Request<MaxBorrowableResponse> getMaxBorrowable(MaxBorrowableParams params) {
		return new Request<>(service.getMaxBorrowable(params.toMap()), params);
	}

	/**
	 * Query Max Transfer-Out Amount
	 */
	public Request<MaxTransferableResponse> getMaxTransferable(MaxTransferableParams params) {
		return new Request<>(service.getMaxTransferable(params.toMap()), params);
	}

	/** Make an Isolated Margin Account Transfer. */
	public Request<Transaction> newIsolatedTransfer(NewIsolatedTransferParams params) {
		return new Request<>(service.isolatedTransfer(params.toMap()), params);
	}

	/** Get Isolated Margin Transfer History. */
	public Request<IsolatedTransferHistory> getIsolatedTransferHistory(IsolatedTransferHistoryParams params) {
		return new Request<>(service.getIsolatedTransferHistory(params.toMap()), params);
	}

	/** Query Isolated Margin Account Info. */
	public Request<IsolatedAccount> getIsolatedAccount(IsolatedAccountParams params) {
		return new Request<>(service.getIsolatedAccount(params.toMap()), params);
	}

	/** Query Isolated Margin Account Info. */
	public Request<IsolatedAccount> getIsolatedAccount() {
		return getIsolatedAccount(new IsolatedAccountParams());
	}

	/**
	 * Disable isolated margin account for a specific symbol. Each trading pair can only be deactivated once every 24 hours.
	 */
	public Request<ToogleAccountResponse> disableIsolatedAccount(ToogleAccountParams params) {
		return new Request<>(service.disableIsolatedAccount(params.toMap()), params);
	}

	/** Enable isolated margin account for a specific symbol(Only supports activation of previously disabled accounts). */
	public Request<ToogleAccountResponse> enableIsolatedAccount(ToogleAccountParams params) {
		return new Request<>(service.enableIsolatedAccount(params.toMap()), params);
	}

	/** Query enabled isolated margin account limit. */
	public Request<IsolatedAccountLimit> getEnabledIsolatedAccountLimit(IsolatedAccountLimitParams params) {
		return new Request<>(service.getEnabledIsolatedAccountLimit(params.toMap()), params);
	}

	/** Query enabled isolated margin account limit. */
	public Request<IsolatedAccountLimit> getEnabledIsolatedAccountLimit() {
		return getEnabledIsolatedAccountLimit(new IsolatedAccountLimitParams());
	}

	/** Gets the informations about an isolated symbol. */
	public Request<Pair> getIsolatedSymbol(PairPrams params) {
		return new Request<>(service.getIsolatedSymbol(params.toMap()), params);
	}

	/** Gets the informations about all the isolated symbols. */
	public Request<List<Pair>> getAllIsolatedSymbols(AllMarginPairsParams params) {
		return new Request<>(service.getAllIsolatedSymbols(params.toMap()), params);
	}

	/** Gets the informations about all the isolated symbols. */
	public Request<List<Pair>> getAllIsolatedSymbols() {
		return getAllIsolatedSymbols(new AllMarginPairsParams());
	}

	/**
	 * Toggle BNB Burn On Spot Trade And Margin Interest
	 */
	public Request<BNBBurnStatus> toggleBNBBurnOnSpotTradeAndMarginInterest(ToggleBurnParams params) {
		return new Request<>(service.toggleBNBBurnOnSpotTradeAndMarginInterest(params.toMap()), params);
	}

	/**
	 * Toggle BNB Burn On Spot Trade And Margin Interest
	 */
	public Request<BNBBurnStatus> toggleBNBBurnOnSpotTradeAndMarginInterest() {
		return toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams());
	}

	/** Get BNB Burn Status. */
	public Request<BNBBurnStatus> getBNBBurnStatus(BurnStatusParams params) {
		return new Request<>(service.getBNBBurnStatus(params.toMap()), params);
	}

	/** Get BNB Burn Status. */
	public Request<BNBBurnStatus> getBNBBurnStatus() {
		return getBNBBurnStatus(new BurnStatusParams());
	}

	/** Query Margin Interest Rate History. */
	public Request<List<InterestRate>> getInterestRateHistory(InterestRateHistoryParams params) {
		return new Request<>(service.getInterestRateHistory(params.toMap()), params);
	}

	/**
	 * Get cross margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>
	 */
	public Request<List<CrossMarginFee>> getMarginFeeData(CrossMarginFeeParams params) {
		return new Request<>(service.getMarginFeeData(params.toMap()), params);
	}

	/**
	 * Get cross margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>
	 */
	public Request<List<CrossMarginFee>> getMarginFeeData() {
		return getMarginFeeData(new CrossMarginFeeParams());
	}

	/**
	 * Get isolated margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>
	 */
	public Request<List<IsolatedMarginFee>> getIsolatedFeeData(IsolatedMarginFeeParams params) {
		return new Request<>(service.getIsolatedFeeData(params.toMap()), params);
	}

	/**
	 * Get isolated margin fee data collection with any vip level or user's current specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>
	 */
	public Request<List<IsolatedMarginFee>> getIsolatedFeeData() {
		return getIsolatedFeeData(new IsolatedMarginFeeParams());
	}

	/**
	 * Get isolated margin tier data collection with any tier defined
	 * <a href="https://www.binance.com/en/margin-data">here</a>
	 */
	public Request<List<IsolatedMarginTierData>> getIsolatedMarginTierData(IsolatedMarginTierDataParams params) {
		return new Request<>(service.getIsolatedMarginTierData(params.toMap()), params);
	}
}