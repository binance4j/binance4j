package com.binance4j.margin.client;

import java.util.List;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.order.CancelOpenOrdersParams;
import com.binance4j.core.order.CancelOrderParams;
import com.binance4j.core.order.CancelOrderResponse;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.param.Request;
import com.binance4j.margin.account.MarginAccount;
import com.binance4j.margin.account.MarginAccountParams;
import com.binance4j.margin.account.MarginIsolatedAccount;
import com.binance4j.margin.account.MarginIsolatedAccountLimit;
import com.binance4j.margin.account.MarginIsolatedAccountLimitParams;
import com.binance4j.margin.account.MarginIsolatedAccountParams;
import com.binance4j.margin.account.ToogleAccountParams;
import com.binance4j.margin.account.ToogleAccountResponse;
import com.binance4j.margin.asset.MarginAsset;
import com.binance4j.margin.asset.MarginAssetParams;
import com.binance4j.margin.borrow.BorrowParams;
import com.binance4j.margin.borrow.MaxBorrowableParams;
import com.binance4j.margin.borrow.MaxBorrowableResponse;
import com.binance4j.margin.borrow.MaxTransferableParams;
import com.binance4j.margin.borrow.MaxTransferableResponse;
import com.binance4j.margin.burn.BNBBurnStatus;
import com.binance4j.margin.burn.BurnStatusParams;
import com.binance4j.margin.burn.ToggleBurnParams;
import com.binance4j.margin.fee.CrossMarginFee;
import com.binance4j.margin.fee.CrossMarginFeeParams;
import com.binance4j.margin.fee.IsolatedMarginFee;
import com.binance4j.margin.fee.IsolatedMarginFeeParams;
import com.binance4j.margin.forceliquidation.ForceLiquidationRecord;
import com.binance4j.margin.forceliquidation.ForceLiquidationRecordParams;
import com.binance4j.margin.interest.InterestHistory;
import com.binance4j.margin.interest.InterestHistoryParams;
import com.binance4j.margin.interest.InterestRate;
import com.binance4j.margin.interest.InterestRateHistoryParams;
import com.binance4j.margin.loan.LoanRecord;
import com.binance4j.margin.loan.LoanRecordParams;
import com.binance4j.margin.oco.CancelMarginOCOParams;
import com.binance4j.margin.oco.GetAllMarginOCOParams;
import com.binance4j.margin.oco.GetMarginOCOParams;
import com.binance4j.margin.oco.GetMarginOCOResponse;
import com.binance4j.margin.oco.GetOpenMarginOCOParams;
import com.binance4j.margin.oco.MarginOCOOrder;
import com.binance4j.margin.oco.MarginOCOResponse;
import com.binance4j.margin.order.MarginAllOrdersParams;
import com.binance4j.margin.order.MarginOpenOrdersParams;
import com.binance4j.margin.order.MarginOrder;
import com.binance4j.margin.order.MarginOrderParams;
import com.binance4j.margin.order.MarginOrderResponse;
import com.binance4j.margin.pair.AllMarginPairsParams;
import com.binance4j.margin.pair.MarginPair;
import com.binance4j.margin.pair.MarginPairPrams;
import com.binance4j.margin.priceindex.PriceIndex;
import com.binance4j.margin.priceindex.PriceIndexParams;
import com.binance4j.margin.repay.RepayParams;
import com.binance4j.margin.repay.RepayRecord;
import com.binance4j.margin.repay.RepayRecordParams;
import com.binance4j.margin.tier.IsolatedMarginTierData;
import com.binance4j.margin.tier.IsolatedMarginTierDataParams;
import com.binance4j.margin.trade.MarginTrade;
import com.binance4j.margin.trade.MarginTradeParams;
import com.binance4j.margin.transfer.MarginIsolatedTransferHistory;
import com.binance4j.margin.transfer.MarginIsolatedTransferParams;
import com.binance4j.margin.transfer.MarginTransaction;
import com.binance4j.margin.transfer.MarginTransferParams;
import com.binance4j.margin.transferhistory.MarginTransferHistoryParams;
import com.binance4j.margin.transferhistory.MarginTransferHistoryResponse;

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

    /**
     * Execute transfer between spot account and cross margin account.
     * 
     * @param params The query request
     */
    public Request<MarginTransaction> transfer(MarginTransferParams params) {
        return new Request<>(service.transfer(params.toMap()), params);
    }

    /**
     * Apply for a loan.
     */
    public Request<MarginTransaction> borrow(BorrowParams params) {
        return new Request<>(service.borrow(params.toMap()), params);
    }

    /**
     * Repay loan for margin account.
     */
    public Request<MarginTransaction> repay(RepayParams params) {
        return new Request<>(service.repay(params.toMap()), params);
    }

    /**
     * Gets the informations about an asset
     */
    public Request<MarginAsset> getAsset(MarginAssetParams params) {
        return new Request<>(service.getAsset(params.toMap()), params);
    }

    /**
     * Gets the informations about all assets
     */
    public Request<List<MarginAsset>> getAllAssets() {
        return new Request<>(service.getAllAssets());
    }

    /**
     * Gets the informations about a cross margin pair
     */
    public Request<MarginPair> getCrossMarginPair(MarginPairPrams params) {
        return new Request<>(service.getCrossMarginPair(params.toMap()), params);
    }

    /**
     * Gets the informations about all cross margin pairs
     */
    public Request<List<MarginPair>> getAllCrossMarginPairs() {
        return getAllCrossMarginPairs(new AllMarginPairsParams());
    }

    /**
     * Gets the informations about all cross margin pairs
     */
    public Request<List<MarginPair>> getAllCrossMarginPairs(AllMarginPairsParams params) {
        return new Request<>(service.getAllCrossMarginPairs(params.toMap()), params);
    }

    /**
     * Gets the price Index of a symbol
     */
    public Request<PriceIndex> getPriceIndex(PriceIndexParams params) {
        return new Request<>(service.getPriceIndex(params.toMap()), params);
    }

    /**
     * Post a new order for margin account.
     */
    public Request<MarginOrderResponse> newOrder(MarginOrder params) {
        return new Request<>(service.newOrder(params.toMap()), params);
    }

    /**
     * Cancel an active order for margin account.
     */
    public Request<CancelOrderResponse> cancelOrder(CancelOrderParams params) {
        return new Request<>(service.cancelOrder(params.toMap()), params);
    }

    /**
     * Cancel all active orders on a symbol for margin account.
     * This includes OCO orders.
     */
    public Request<List<CancelOrderResponse>> cancelOpenOrders(CancelOpenOrdersParams params) {
        return new Request<>(service.cancelOpenOrders(params.toMap()), params);
    }

    /**
     * Get Cross Margin Transfer History
     */
    public Request<MarginTransferHistoryResponse> getTransferHistory(MarginTransferHistoryParams params) {
        return new Request<>(service.getTransferHistory(params.toMap()), params);
    }

    /**
     * Get Cross Margin Transfer History
     */
    public Request<MarginTransferHistoryResponse> getTransferHistory() {
        return getTransferHistory(new MarginTransferHistoryParams());
    }

    /**
     * Query Loan Record
     * <p>
     * txId or startTime must be sent. txId takes precedence.
     * <p>
     * Response in descending order
     * <p>
     * If isolatedSymbol is not sent, crossed margin data will be returned
     * <p>
     * Set archived to true to query data from 6 months ago
     */
    public Request<LoanRecord> getLoanRecord(LoanRecordParams params) {
        return new Request<>(service.getLoanRecord(params.toMap()), params);
    }

    /**
     * Query Repay Record
     * <p>
     * txId or startTime must be sent. txId takes precedence.
     * <p>
     * Response in descending order
     * <p>
     * If isolatedSymbol is not sent, crossed margin data will be returned
     * <p>
     * Set archived to true to query data from 6 months ago
     */
    public Request<RepayRecord> getRepayRecord(RepayRecordParams params) {
        return new Request<>(service.getRepayRecord(params.toMap()), params);
    }

    /**
     * Query Repay Record
     * <p>
     * Response in descending order
     * <p>
     * If isolatedSymbol is not sent, crossed margin data will be returned
     * <p>
     * Set archived to true to query data from 6 months ago
     */
    public Request<InterestHistory> getInterestHistory(InterestHistoryParams params) {
        return new Request<>(service.getInterestHistory(params.toMap()), params);
    }

    /**
     * Get Force Liquidation Record
     * <p>
     * Response in descending order
     */
    public Request<ForceLiquidationRecord> getForceLiquidationRecord(ForceLiquidationRecordParams params) {
        return new Request<>(
                service.getForceLiquidationRecord(params.toMap()), params);
    }

    /**
     * Get Margin Account Details
     */
    public Request<MarginAccount> getAccount(MarginAccountParams params) {
        return new Request<>(service.getAccount(params.toMap()), params);
    }

    /**
     * Get Margin Account Details
     */
    public Request<MarginAccount> getAccount() {
        return getAccount(new MarginAccountParams());
    }

    /**
     * Get Margin Account's Order Status
     */
    public Request<OrderInfo> getOrder(MarginOrderParams params) {
        return new Request<>(service.getOrder(params.toMap()), params);
    }

    /**
     * Get Margin Account's Open Orders
     * <p>
     * If the symbol is not sent, orders for all symbols will be returned
     * in an array.
     * <p>
     * When all symbols are returned, the number of requests counted
     * against the rate limiter is equal to the number of symbols currently
     * trading on the exchange.
     * <p>
     * If isIsolated ="TRUE", symbol must be sent.
     */
    public Request<List<OrderInfo>> getOpenOrders(MarginOpenOrdersParams params) {
        return new Request<>(service.getOpenOrders(params.toMap()), params);
    }

    /**
     * Get Margin Account's Open Orders
     * <p>
     * If the symbol is not sent, orders for all symbols will be returned
     * in an array.
     * <p>
     * When all symbols are returned, the number of requests counted
     * against the rate limiter is equal to the number of symbols currently
     * trading on the exchange.
     * <p>
     * If isIsolated ="TRUE", symbol must be sent.
     */
    public Request<List<OrderInfo>> getOpenOrders() {
        return getOpenOrders(new MarginOpenOrdersParams());
    }

    /**
     * Get Margin Account's Open Orders
     * <p>
     * Request Limit: 60times/min per IP
     * <p>
     * If orderId is set, it will get orders&gt;= that orderId. Otherwise
     * most recent orders are returned.
     * <p>
     * For some historical orders cummulativeQuoteQty will be &lt;0, meaning
     * the data is not available at this time.
     */
    public Request<List<OrderInfo>> getAllOrders(MarginAllOrdersParams params) {
        return new Request<>(service.getAllOrders(params.toMap()), params);
    }

    /**
     * Send in a new OCO for a margin account
     * <p>
     * Price Restrictions:
     * <ul>
     * <li>SELL: Limit Price&gt; Last Price&gt; Stop Price</li>
     * <li>BUY: Limit Price &lt;Last Price &lt;Stop Price</li>
     * </ul>
     * <p>
     * Quantity Restrictions:
     * <ul>
     * <li>Both legs must have the same quantity</li>
     * <li>ICEBERG quantities however do not have to be the same.</li>
     * </ul>
     * <p>
     * Order Rate Limit:
     * OCO counts as 2 orders against the order rate limit
     */
    public Request<MarginOCOResponse> newOCO(MarginOCOOrder params) {
        return new Request<>(service.newOCO(params.toMap()), params);
    }

    /**
     * Cancel an entire Order List
     * <p>
     * Additional notes:
     * Canceling an individual leg will cancel the entire OCO
     */
    public Request<MarginOCOResponse> cancelOCO(CancelMarginOCOParams params) {
        return new Request<>(service.cancelOCO(params.toMap()), params);
    }

    /**
     * Retrieves a specific OCO based on provided optional parameters
     */
    public Request<GetMarginOCOResponse> getOCO(GetMarginOCOParams params) {
        return new Request<>(service.getOCO(params.toMap()), params);
    }

    /**
     * Retrieves all OCO for a specific margin account based on provided optional
     * parameters
     */
    public Request<List<GetMarginOCOResponse>> getAllOCO(GetAllMarginOCOParams params) {
        return new Request<>(service.getAllOCO(params.toMap()), params);
    }

    /**
     * Retrieves all Open OCO for a specific margin account based on provided
     * optional parameters
     */
    public Request<List<GetMarginOCOResponse>> getOpenOCO(GetOpenMarginOCOParams params) {
        return new Request<>(service.getOpenOCO(params.toMap()), params);
    }

    /**
     * Retrieves all Open OCO for a specific margin account based on provided
     * optional parameters
     */
    public Request<List<GetMarginOCOResponse>> getOpenOCO() {
        return getOpenOCO(new GetOpenMarginOCOParams());
    }

    /**
     * Query Margin Account's Trade List
     * <p>
     * If fromId is set, it will get trades&gt;= that fromId. Otherwise most
     * recent trades are returned.
     */
    public Request<List<MarginTrade>> getMyTrades(MarginTradeParams params) {
        return new Request<>(service.getMyTrades(params.toMap()), params);
    }

    /**
     * Query Margin Account's Trade List
     * <p>
     * If fromId is set, it will get trades&gt;= that fromId. Otherwise most
     * recent trades are returned.
     */
    public Request<List<MarginTrade>> getMyTrades() {
        return getMyTrades(new MarginTradeParams());
    }

    /**
     * Query Max Borrow
     * <p>
     * If isolatedSymbol is not sent, crossed margin data will be sent.
     * <p>
     * borrowLimit is also available
     * <a href="https://www.binance.com/en/margin-fee">here</a>
     */
    public Request<MaxBorrowableResponse> getMaxBorrowable(MaxBorrowableParams params) {
        return new Request<>(service.getMaxBorrowable(params.toMap()), params);
    }

    /**
     * Query Max Transfer-Out Amount
     * <p>
     * If isolatedSymbol is not sent, crossed margin data will be sent.
     */
    public Request<MaxTransferableResponse> getMaxTransferable(MaxTransferableParams params) {
        return new Request<>(service.getMaxTransferable(params.toMap()), params);
    }

    /**
     * Make an Isolated Margin Account Transfer
     */
    public Request<MarginTransaction> isolatedTransfer(MarginIsolatedTransferParams params) {
        return new Request<>(service.isolatedTransfer(params.toMap()), params);
    }

    /**
     * Get Isolated Margin Transfer History
     */
    public Request<MarginIsolatedTransferHistory> getIsolatedTransferHistory(
            MarginIsolatedTransferParams params) {
        return new Request<>(
                service.getIsolatedTransferHistory(params.toMap()), params);
    }

    /**
     * Query Isolated Margin Account Info
     */
    public Request<MarginIsolatedAccount> getIsolatedAccount(MarginIsolatedAccountParams params) {
        return new Request<>(
                service.getIsolatedAccount(params.toMap()), params);
    }

    /**
     * Query Isolated Margin Account Info
     */
    public Request<MarginIsolatedAccount> getIsolatedAccount() {
        return getIsolatedAccount(new MarginIsolatedAccountParams());
    }

    /**
     * Disable isolated margin account for a specific symbol. Each trading pair can
     * only be deactivated once every 24 hours.
     */
    public Request<ToogleAccountResponse> disableIsolatedAccount(ToogleAccountParams params) {
        return new Request<>(
                service.disableIsolatedAccount(params.toMap()), params);
    }

    /**
     * Enable isolated margin account for a specific symbol(Only supports activation
     * of previously disabled accounts).
     */
    public Request<ToogleAccountResponse> enableIsolatedAccount(ToogleAccountParams params) {
        return new Request<>(
                service.enableIsolatedAccount(params.toMap()), params);
    }

    /**
     * Query enabled isolated margin account limit.
     */
    public Request<MarginIsolatedAccountLimit> getEnabledIsolatedAccountLimit(MarginIsolatedAccountLimitParams params) {
        return new Request<>(
                service.getEnabledIsolatedAccountLimit(params.toMap()), params);
    }

    /**
     * Query enabled isolated margin account limit.
     */
    public Request<MarginIsolatedAccountLimit> getEnabledIsolatedAccountLimit() {
        return getEnabledIsolatedAccountLimit(new MarginIsolatedAccountLimitParams());
    }

    /**
     * Gets the informations about an isolated symbol
     */
    public Request<MarginPair> getIsolatedSymbol(MarginPairPrams params) {
        return new Request<>(service.getIsolatedSymbol(params.toMap()), params);
    }

    /**
     * Gets the informations about all the isolated symbols
     */
    public Request<List<MarginPair>> getAllIsolatedSymbols(AllMarginPairsParams params) {
        return new Request<>(service.getAllIsolatedSymbols(params.toMap()), params);
    }

    /**
     * Gets the informations about all the isolated symbols
     */
    public Request<List<MarginPair>> getAllIsolatedSymbols() {
        return getAllIsolatedSymbols(new AllMarginPairsParams());
    }

    /**
     * Toggle BNB Burn On Spot Trade And Margin Interest
     * <p>
     * "spotBNBBurn" and "interestBNBBurn" should be sent at least one.
     */
    public Request<BNBBurnStatus> toggleBNBBurnOnSpotTradeAndMarginInterest(ToggleBurnParams params) {
        return new Request<>(service.toggleBNBBurnOnSpotTradeAndMarginInterest(params.toMap()), params);
    }

    /**
     * Toggle BNB Burn On Spot Trade And Margin Interest
     * <p>
     * "spotBNBBurn" and "interestBNBBurn" should be sent at least one.
     */
    public Request<BNBBurnStatus> toggleBNBBurnOnSpotTradeAndMarginInterest() {
        return toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams());
    }

    /**
     * Get BNB Burn Status
     */
    public Request<BNBBurnStatus> getBNBBurnStatus(BurnStatusParams params) {
        return new Request<>(
                service.getBNBBurnStatus(params.toMap()), params);
    }

    /**
     * Get BNB Burn Status
     */
    public Request<BNBBurnStatus> getBNBBurnStatus() {
        return getBNBBurnStatus(new BurnStatusParams());
    }

    /**
     * Query Margin Interest Rate History
     */
    public Request<List<InterestRate>> getInterestRateHistory(InterestRateHistoryParams params) {
        return new Request<>(
                service.getInterestRateHistory(params.toMap()), params);
    }

    /**
     * Get cross margin fee data collection with any vip level or user's current
     * specific data defined
     * <a href="https://www.binance.com/en/margin-fee">here</a>
     * <p>
     * User's current specific margin data will be returned if vipLevel is
     * omitted
     */
    public Request<List<CrossMarginFee>> getMarginFeeData(CrossMarginFeeParams params) {
        return new Request<>(
                service.getMarginFeeData(params.toMap()), params);
    }

    /**
     * Get cross margin fee data collection with any vip level or user's current
     * specific data defined
     * <a href="https://www.binance.com/en/margin-fee">here</a>
     * <p>
     * User's current specific margin data will be returned if vipLevel is
     * omitted
     */
    public Request<List<CrossMarginFee>> getMarginFeeData() {
        return getMarginFeeData(new CrossMarginFeeParams());
    }

    /**
     * Get isolated margin fee data collection with any vip level or user's current
     * specific data defined
     * <a href="https://www.binance.com/en/margin-fee">here</a>
     * <p>
     * User's current specific margin data will be returned if vipLevel is
     * omitted
     */
    public Request<List<IsolatedMarginFee>> getIsolatedFeeData(IsolatedMarginFeeParams params) {
        return new Request<>(
                service.getIsolatedFeeData(params.toMap()), params);
    }

    /**
     * Get isolated margin fee data collection with any vip level or user's current
     * specific data defined
     * <a href="https://www.binance.com/en/margin-fee">here</a>
     * <p>
     * User's current specific margin data will be returned if vipLevel is
     * omitted
     */
    public Request<List<IsolatedMarginFee>> getIsolatedFeeData() {
        return getIsolatedFeeData(new IsolatedMarginFeeParams());
    }

    /**
     * Get isolated margin tier data collection with any tier defined
     * <a href="https://www.binance.com/en/margin-data">here</a>
     * <p>
     * All margin tier data will be returned if tier is omitted
     */
    public Request<List<IsolatedMarginTierData>> getIsolatedMarginTierData(IsolatedMarginTierDataParams params) {
        return new Request<>(
                service.getIsolatedMarginTierData(params.toMap()), params);
    }
}