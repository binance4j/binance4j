package com.binance4j.margin.client;

import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
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
import com.binance4j.margin.param.ToggleBurnParams;
import com.binance4j.margin.param.ToogleAccountParams;
import com.binance4j.margin.param.TradeParams;
import com.binance4j.margin.param.TransactionHistoryParams;
import com.binance4j.margin.param.TransferParams;
import com.binance4j.margin.request.BorrowRequest;
import com.binance4j.margin.request.CancelOCORequest;
import com.binance4j.margin.request.CancelOpenOrdersRequest;
import com.binance4j.margin.request.CancelOrderRequest;
import com.binance4j.margin.request.DisableIsolatedAccountRequest;
import com.binance4j.margin.request.EnableIsolatedAccountRequest;
import com.binance4j.margin.request.GetAccountRequest;
import com.binance4j.margin.request.GetAllAssetsRequest;
import com.binance4j.margin.request.GetAllCrossMarginPairRequest;
import com.binance4j.margin.request.GetAllIsolatedSymbolRequest;
import com.binance4j.margin.request.GetAllOCORequest;
import com.binance4j.margin.request.GetAssetRequest;
import com.binance4j.margin.request.GetBNBBurnStatusRequest;
import com.binance4j.margin.request.GetCrossMarginPairRequest;
import com.binance4j.margin.request.GetDustLogRequest;
import com.binance4j.margin.request.GetEnabledIsolatedAccountLimitRequest;
import com.binance4j.margin.request.GetForceLiquidationRecordRequest;
import com.binance4j.margin.request.GetInterestHistoryRequest;
import com.binance4j.margin.request.GetInterestRateHistoryRequest;
import com.binance4j.margin.request.GetIsolatedAccountRequest;
import com.binance4j.margin.request.GetIsolatedFeeDataRequest;
import com.binance4j.margin.request.GetIsolatedMarginTierDataRequest;
import com.binance4j.margin.request.GetIsolatedSymbolRequest;
import com.binance4j.margin.request.GetIsolatedTransferHistoryRequest;
import com.binance4j.margin.request.GetLoanRecordRequest;
import com.binance4j.margin.request.GetMarginFeeDataRequest;
import com.binance4j.margin.request.GetMaxBorrowableRequest;
import com.binance4j.margin.request.GetMaxTransferableRequest;
import com.binance4j.margin.request.GetOCORequest;
import com.binance4j.margin.request.GetOpenOCORequest;
import com.binance4j.margin.request.GetOpenOrdersRequest;
import com.binance4j.margin.request.GetOrderRequest;
import com.binance4j.margin.request.GetPriceIndexRequest;
import com.binance4j.margin.request.GetRateLimitRequest;
import com.binance4j.margin.request.GetRepayRecordRequest;
import com.binance4j.margin.request.GetTradesRequest;
import com.binance4j.margin.request.GetTransferHistoryRequest;
import com.binance4j.margin.request.NewIsolatedTransferRequest;
import com.binance4j.margin.request.NewOCORequest;
import com.binance4j.margin.request.NewOrderRequest;
import com.binance4j.margin.request.RepayRequest;
import com.binance4j.margin.request.ToggleBNBRequest;
import com.binance4j.margin.request.TransferRequest;

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
	public TransferRequest transfer(TransferParams params) {
		return new TransferRequest(service.transfer(params.toMap()));
	}

	/**
	 * Apply for a loan.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public BorrowRequest borrow(BorrowParams params) {
		return new BorrowRequest(service.borrow(params.toMap()));
	}

	/**
	 * Repay loan for margin account.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public RepayRequest repay(RepayParams params) {
		return new RepayRequest(service.repay(params.toMap()));
	}

	/**
	 * Get info about an asset.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetAssetRequest getAsset(AssetParams params) {
		return new GetAssetRequest(service.getAsset(params.toMap()));
	}

	/**
	 * Get info about all assets.
	 * 
	 * @return The request to execute.
	 */
	public GetAllAssetsRequest getAllAssets() {
		return new GetAllAssetsRequest(service.getAllAssets());
	}

	/**
	 * Get info about a cross margin pair.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetCrossMarginPairRequest getCrossMarginPair(PairParams params) {
		return new GetCrossMarginPairRequest(service.getCrossMarginPair(params.toMap()));
	}

	/**
	 * Get info about all cross margin pairs.
	 * 
	 * @return The request to execute.
	 */
	public GetAllCrossMarginPairRequest getAllCrossMarginPairs() {
		return new GetAllCrossMarginPairRequest(service.getAllCrossMarginPairs(new AllMarginPairsParams().toMap()));
	}

	/**
	 * Gets the price Index of a symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetPriceIndexRequest getPriceIndex(PriceIndexParams params) {
		return new GetPriceIndexRequest(service.getPriceIndex(params.toMap()));
	}

	/**
	 * Post a new order for margin account.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public NewOrderRequest newOrder(NewOrderParams params) {
		return new NewOrderRequest(service.newOrder(params.toMap()));
	}

	/**
	 * Cancel an active order for margin account.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public CancelOrderRequest cancelOrder(CancelOrderParams params) {
		return new CancelOrderRequest(service.cancelOrder(params.toMap()));
	}

	/**
	 * Cancel all active orders on a symbol for margin account. This includes OCO
	 * orders.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public CancelOpenOrdersRequest cancelOpenOrders(CancelOpenOrdersParams params) {
		return new CancelOpenOrdersRequest(service.cancelOpenOrders(params.toMap()));
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
	public GetTransferHistoryRequest getTransferHistory(TransactionHistoryParams params) {
		return new GetTransferHistoryRequest(service.getTransferHistory(params.toMap()));
	}

	/**
	 * Get Cross Margin Transfer History.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetTransferHistoryRequest getTransferHistory(TransactionHistoryParams params, FramedPaging paging) {
		return new GetTransferHistoryRequest(service.getTransferHistory(
				Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query Loan Record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetLoanRecordRequest getLoanRecord(TransactionHistoryParams params) {
		return new GetLoanRecordRequest(service.getLoanRecord(params.toMap()));
	}

	/**
	 * Query Loan Record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetLoanRecordRequest getLoanRecord(TransactionHistoryParams params, FramedPaging paging) {
		return new GetLoanRecordRequest(service
				.getLoanRecord(Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query Repay Record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetRepayRecordRequest getRepayRecord(TransactionHistoryParams params) {
		return new GetRepayRecordRequest(service.getRepayRecord(params.toMap()));
	}

	/**
	 * Query Repay Record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetRepayRecordRequest getRepayRecord(TransactionHistoryParams params, FramedPaging paging) {
		return new GetRepayRecordRequest(service.getRepayRecord(
				Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query interest Record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetInterestHistoryRequest getInterestHistory(TransactionHistoryParams params) {
		return new GetInterestHistoryRequest(service.getInterestHistory(params.toMap()));
	}

	/**
	 * Query interest Record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetInterestHistoryRequest getInterestHistory(TransactionHistoryParams params, FramedPaging paging) {
		return new GetInterestHistoryRequest(service.getInterestHistory(
				Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Get Force Liquidation Record. Response in descending order.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetForceLiquidationRecordRequest getForceLiquidationRecord(ForceLiquidationRecordParams params) {
		return new GetForceLiquidationRecordRequest(service.getForceLiquidationRecord(params.toMap()));
	}

	/**
	 * Get Force Liquidation Record. Response in descending order.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetForceLiquidationRecordRequest getForceLiquidationRecord(ForceLiquidationRecordParams params,
			FramedPaging paging) {
		return new GetForceLiquidationRecordRequest(service.getForceLiquidationRecord(
				Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Get Margin Account Details.
	 * 
	 * @return The request to execute.
	 */
	public GetAccountRequest getAccount() {
		return new GetAccountRequest(service.getAccount(new GetAccountParams().toMap()));
	}

	/**
	 * Get order status.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetOrderRequest getOrder(OrderParams params) {
		return new GetOrderRequest(service.getOrder(params.toMap()));
	}

	/**
	 * Get open orders.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetOpenOrdersRequest getOpenOrders(OpenOrdersParams params) {
		return new GetOpenOrdersRequest(service.getOpenOrders(params.toMap()));
	}

	/**
	 * Get Open Orders.
	 * 
	 * @return The request to execute.
	 */
	public GetOpenOrdersRequest getOpenOrders() {
		return getOpenOrders(new OpenOrdersParams(null, null));
	}

	/**
	 * Get all orders.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetOpenOrdersRequest getAllOrders(AllOrdersParams params) {
		return new GetOpenOrdersRequest(service.getAllOrders(params.toMap()));
	}

	/**
	 * Get all orders.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time interval search.
	 * @return The request to execute.
	 */
	public GetOpenOrdersRequest getAllOrders(AllOrdersParams params, TimeFrame timeFrame) {
		return new GetOpenOrdersRequest(service.getAllOrders(Params.merge(params, timeFrame)));
	}

	/**
	 * Send in a new OCO for a margin account.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public NewOCORequest newOCO(NewOCOOrderParams params) {
		return new NewOCORequest(service.newOCO(params.toMap()));
	}

	/**
	 * Cancel an entire Order List.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public CancelOCORequest cancelOCO(CancelOCOParams params) {
		return new CancelOCORequest(service.cancelOCO(params.toMap()));
	}

	/**
	 * Retrieves a specific OCO based on provided optional parameters.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetOCORequest getOCO(GetOCOParams params) {
		return new GetOCORequest(service.getOCO(params.toMap()));
	}

	/**
	 * Retrieves all OCO for a specific margin account based on provided optional
	 * parameters.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetAllOCORequest getAllOCO(GetAllOCOParams params) {
		return new GetAllOCORequest(service.getAllOCO(params.toMap()));
	}

	/**
	 * Retrieves all OCO for a specific margin account based on provided optional
	 * parameters.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time interval seach.
	 * @return The request to execute.
	 */
	public GetAllOCORequest getAllOCO(GetAllOCOParams params, TimeFrame timeFrame) {
		return new GetAllOCORequest(service.getAllOCO(Params.merge(params, timeFrame)));
	}

	/**
	 * Retrieves all open OCO
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetOpenOCORequest getOpenOCO(GetOpenOCOParams params) {
		return new GetOpenOCORequest(service.getOpenOCO(params.toMap()));
	}

	/**
	 * Retrieves all open OCO
	 * 
	 * @return The request to execute.
	 */
	public GetOpenOCORequest getOpenOCO() {
		return getOpenOCO(new GetOpenOCOParams(null, null));
	}

	/**
	 * Query Margin Account's Trade List.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetTradesRequest getTrades(TradeParams params) {
		return new GetTradesRequest(service.getTrades(params.toMap()));
	}

	/**
	 * Query Margin Account's Trade List.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time interval seach.
	 * @return The request to execute.
	 */
	public GetTradesRequest getTrades(TradeParams params, TimeFrame timeFrame) {
		return new GetTradesRequest(service.getTrades(Params.merge(params, timeFrame)));
	}

	/**
	 * Query Max Borrow.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetMaxBorrowableRequest getMaxBorrowable(MaxBorrowableParams params) {
		return new GetMaxBorrowableRequest(service.getMaxBorrowable(params.toMap()));
	}

	/**
	 * Query Max Transfer-Out Amount.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetMaxTransferableRequest getMaxTransferable(MaxTransferableParams params) {
		return new GetMaxTransferableRequest(service.getMaxTransferable(params.toMap()));
	}

	/**
	 * Make an Isolated Margin Account Transfer.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public NewIsolatedTransferRequest newIsolatedTransfer(NewIsolatedTransferParams params) {
		return new NewIsolatedTransferRequest(service.isolatedTransfer(params.toMap()));
	}

	/**
	 * Get Isolated Margin Transfer History.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetIsolatedTransferHistoryRequest getIsolatedTransferHistory(IsolatedTransferHistoryParams params) {
		return new GetIsolatedTransferHistoryRequest(service.getIsolatedTransferHistory(params.toMap()));
	}

	/**
	 * Get Isolated Margin Transfer History.
	 * 
	 * @param params Request params.
	 * @param paging Paginated result.
	 * @return The request to execute.
	 */
	public GetIsolatedTransferHistoryRequest getIsolatedTransferHistory(IsolatedTransferHistoryParams params,
			FramedPaging paging) {
		return new GetIsolatedTransferHistoryRequest(service.getIsolatedTransferHistory(
				Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Query Isolated Margin Account Info.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetIsolatedAccountRequest getIsolatedAccount(IsolatedAccountParams params) {
		return new GetIsolatedAccountRequest(service.getIsolatedAccount(params.toMap()));
	}

	/**
	 * Query Isolated Margin Account Info.
	 * 
	 * @return The request to execute.
	 */
	public GetIsolatedAccountRequest getIsolatedAccount() {
		return getIsolatedAccount(new IsolatedAccountParams(null));
	}

	/**
	 * Disable isolated margin account for a specific symbol. Each trading pair can
	 * only be deactivated once every 24 hours.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public DisableIsolatedAccountRequest disableIsolatedAccount(ToogleAccountParams params) {
		return new DisableIsolatedAccountRequest(service.disableIsolatedAccount(params.toMap()));
	}

	/**
	 * Enable isolated margin account for a specific symbol(Only supports activation
	 * of previously disabled accounts).
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public EnableIsolatedAccountRequest enableIsolatedAccount(ToogleAccountParams params) {
		return new EnableIsolatedAccountRequest(service.enableIsolatedAccount(params.toMap()));
	}

	/**
	 * Query enabled isolated margin account limit.
	 * 
	 * @return The request to execute.
	 */
	public GetEnabledIsolatedAccountLimitRequest getEnabledIsolatedAccountLimit() {
		return new GetEnabledIsolatedAccountLimitRequest(
				service.getEnabledIsolatedAccountLimit(new IsolatedAccountLimitParams().toMap()));
	}

	/**
	 * Get info about an isolated symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetIsolatedSymbolRequest getIsolatedSymbol(PairParams params) {
		return new GetIsolatedSymbolRequest(service.getIsolatedSymbol(params.toMap()));
	}

	/**
	 * Get info about all the isolated symbols.
	 * 
	 * @return The request to execute.
	 */
	public GetAllIsolatedSymbolRequest getAllIsolatedSymbols() {
		return new GetAllIsolatedSymbolRequest(service.getAllIsolatedSymbols(new AllMarginPairsParams().toMap()));
	}

	/**
	 * Toggle BNB Burn On Spot Trade And Margin Interest
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public ToggleBNBRequest toggleBNBBurnOnSpotTradeAndMarginInterest(ToggleBurnParams params) {
		return new ToggleBNBRequest(service.toggleBNBBurnOnSpotTradeAndMarginInterest(params.toMap()));
	}

	/**
	 * Get BNB Burn Status.
	 * 
	 * @return The request to execute.
	 */
	public GetBNBBurnStatusRequest getBNBBurnStatus() {
		return new GetBNBBurnStatusRequest(service.getBNBBurnStatus(new BurnStatusParams().toMap()));
	}

	/**
	 * Query Margin Interest Rate History.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetInterestRateHistoryRequest getInterestRateHistory(InterestRateHistoryParams params) {
		return new GetInterestRateHistoryRequest(service.getInterestRateHistory(params.toMap()));
	}

	/**
	 * Get cross margin fee data collection with any vip level or user's current
	 * specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetMarginFeeDataRequest getMarginFeeData(CrossFeeParams params) {
		return new GetMarginFeeDataRequest(service.getMarginFeeData(params.toMap()));
	}

	/**
	 * Get cross margin fee data collection with any vip level or user's current
	 * specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>.
	 * 
	 * @return The request to execute.
	 */
	public GetMarginFeeDataRequest getMarginFeeData() {
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
	public GetIsolatedFeeDataRequest getIsolatedFeeData(IsolatedFeeParams params) {
		return new GetIsolatedFeeDataRequest(service.getIsolatedFeeData(params.toMap()));
	}

	/**
	 * Get isolated margin fee data collection with any vip level or user's current
	 * specific data defined
	 * <a href="https://www.binance.com/en/margin-fee">here</a>.
	 * 
	 * @return The request to execute.
	 */
	public GetIsolatedFeeDataRequest getIsolatedFeeData() {
		return getIsolatedFeeData(new IsolatedFeeParams(null, null));
	}

	/**
	 * Get isolated margin tier data collection with any tier defined
	 * <a href="https://www.binance.com/en/margin-data">here</a>.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetIsolatedMarginTierDataRequest getIsolatedMarginTierData(IsolatedTierDataParams params) {
		return new GetIsolatedMarginTierDataRequest(service.getIsolatedMarginTierData(params.toMap()));
	}

	/**
	 * Displays the user's current margin order count usage for all intervals.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetRateLimitRequest getRateLimit(RateLimitParams params) {
		return new GetRateLimitRequest(service.getRateLimit(params.toMap()));
	}

	/**
	 * Displays the user's current margin order count usage for all intervals.
	 * 
	 * @return The request to execute.
	 */
	public GetRateLimitRequest getRateLimit() {
		return new GetRateLimitRequest(service.getRateLimit(new RateLimitParams(null, null).toMap()));
	}

	/**
	 * Query the historical information of user's margin account small-value asset
	 * conversion BNB.
	 * 
	 * @return The request to execute.
	 */
	public GetDustLogRequest getDustLog() {
		return new GetDustLogRequest(service.getDustLog(new DustLogParams().toMap()));
	}

	/**
	 * Query the historical information of user's margin account small-value asset
	 * conversion BNB.
	 * 
	 * @param timeFrame Result time frame.
	 * @return The request to execute.
	 */
	public GetDustLogRequest getDustLog(TimeFrame timeFrame) {
		return new GetDustLogRequest(service.getDustLog(Params.merge(new DustLogParams(), timeFrame)));
	}
}