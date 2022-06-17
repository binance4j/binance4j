package com.binance4j.margin.client;

import java.util.List;

import com.binance4j.core.misc.ListenKey;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.order.cancelorder.CancelOpenOrdersRequest;
import com.binance4j.core.order.cancelorder.CancelOrderRequest;
import com.binance4j.core.order.cancelorder.CancelOrderResponse;
import com.binance4j.core.request.RequestExecutor;
import com.binance4j.core.request.RestClient;
import com.binance4j.margin.account.MarginAccount;
import com.binance4j.margin.account.MarginAccountRequest;
import com.binance4j.margin.account.MarginIsolatedAccount;
import com.binance4j.margin.account.MarginIsolatedAccountLimit;
import com.binance4j.margin.account.MarginIsolatedAccountLimitRequest;
import com.binance4j.margin.account.MarginIsolatedAccountRequest;
import com.binance4j.margin.account.ToogleAccountRequest;
import com.binance4j.margin.account.ToogleAccountResponse;
import com.binance4j.margin.asset.MarginAsset;
import com.binance4j.margin.asset.MarginAssetRequest;
import com.binance4j.margin.borrow.BorrowRequest;
import com.binance4j.margin.borrow.MaxBorrowableRequest;
import com.binance4j.margin.borrow.MaxBorrowableResponse;
import com.binance4j.margin.borrow.MaxTransferableRequest;
import com.binance4j.margin.borrow.MaxTransferableResponse;
import com.binance4j.margin.burn.BNBBurnStatus;
import com.binance4j.margin.burn.ToggleBurnRequest;
import com.binance4j.margin.fee.CrossMarginFee;
import com.binance4j.margin.fee.CrossMarginFeeRequest;
import com.binance4j.margin.fee.IsolatedMarginFee;
import com.binance4j.margin.fee.IsolatedMarginFeeRequest;
import com.binance4j.margin.forceliquidation.ForceLiquidationRecord;
import com.binance4j.margin.forceliquidation.ForceLiquidationRecordRequest;
import com.binance4j.margin.interest.InterestHistory;
import com.binance4j.margin.interest.InterestHistoryRequest;
import com.binance4j.margin.interest.InterestRate;
import com.binance4j.margin.loan.LoanRecord;
import com.binance4j.margin.loan.LoanRecordRequest;
import com.binance4j.margin.oco.CancelMarginOCORequest;
import com.binance4j.margin.oco.GetAllMarginOCORequest;
import com.binance4j.margin.oco.GetMarginOCORequest;
import com.binance4j.margin.oco.GetMarginOCOResponse;
import com.binance4j.margin.oco.GetOpenMarginOCORequest;
import com.binance4j.margin.oco.MarginOCOOrder;
import com.binance4j.margin.oco.MarginOCOResponse;
import com.binance4j.margin.order.MarginAllOrdersRequest;
import com.binance4j.margin.order.MarginOpenOrdersRequest;
import com.binance4j.margin.order.MarginOrder;
import com.binance4j.margin.order.MarginOrderRequest;
import com.binance4j.margin.order.MarginOrderResponse;
import com.binance4j.margin.priceindex.PriceIndex;
import com.binance4j.margin.priceindex.PriceIndexRequest;
import com.binance4j.margin.repay.RepayRecord;
import com.binance4j.margin.repay.RepayRecordRequest;
import com.binance4j.margin.repay.RepayRequest;
import com.binance4j.margin.stream.HandleIsolatedUserDataStreamRequest;
import com.binance4j.margin.stream.NewIsolatedUserDataStreamRequest;
import com.binance4j.margin.symbol.MarginSymbol;
import com.binance4j.margin.symbol.MarginSymbolRequest;
import com.binance4j.margin.symbol.MarginSymbolsRequest;
import com.binance4j.margin.tier.IsolatedMarginTierData;
import com.binance4j.margin.tier.IsolatedMarginTierDataRequest;
import com.binance4j.margin.trade.MarginTrade;
import com.binance4j.margin.transfer.MarginIsolatedTransferHistory;
import com.binance4j.margin.transfer.MarginIsolatedTransferRequest;
import com.binance4j.margin.transfer.MarginTransaction;
import com.binance4j.margin.transfer.MarginTransferRequest;
import com.binance4j.margin.transferhistory.MarginTransferHistoryRequest;
import com.binance4j.margin.transferhistory.MarginTransferHistoryResponse;

public class MarginClient extends RestClient<MarginMapping> {
    /**
     * Instantiates a client for the margin endpoints
     *
     * @param key        The API public key
     * @param secret     The API secret key
     * @param useTestnet Are we using TestNet?
     */
    public MarginClient(String key, String secret, Boolean useTestnet) {
        super(MarginMapping.class, key, secret, useTestnet);
    }

    /**
     * Execute transfer between spot account and cross margin account.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#cross-margin-account-transfer-margin">Documentation</a>
     */
    public RequestExecutor<MarginTransaction> transfer(MarginTransferRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.transfer(pojoToMap(req))).toList());
    }

    /**
     * Apply for a loan.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#margin-account-borrow-margin">Documentation</a>
     */
    public RequestExecutor<MarginTransaction> borrow(BorrowRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.borrow(pojoToMap(req))).toList());
    }

    /**
     * Repay loan for margin account.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#margin-account-repay-margin">Documentation</a>
     */
    public RequestExecutor<MarginTransaction> repay(RepayRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.repay(pojoToMap(req))).toList());
    }

    /**
     * Gets the informations about an asset
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-margin-asset-market_data">Documentation</a>
     */
    public RequestExecutor<MarginAsset> getAsset(MarginAssetRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getAsset(pojoToMap(req))).toList());
    }

    /**
     * Gets the informations about all assets
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#get-all-margin-assets-market_data">Documentation</a>
     */
    public RequestExecutor<List<MarginAsset>> getAllAssets() {
        return new RequestExecutor<>(getServices().stream().map(MarginMapping::getAllAssets).toList());
    }

    /**
     * Gets the informations about an symbol
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-cross-margin-pair-market_data">Documentation</a>
     */
    public RequestExecutor<MarginSymbol> getSymbol(MarginSymbolRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getSymbol(pojoToMap(req))).toList());
    }

    /**
     * Gets the informations about all symbols
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#get-all-cross-margin-pairs-market_data">Documentation</a>
     */
    public RequestExecutor<List<MarginSymbol>> getAllSymbols() {
        return new RequestExecutor<>(getServices().stream().map(MarginMapping::getAllSymbols).toList());
    }

    /**
     * Gets the price Index of a symbol
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-margin-priceindex-market_data">Documentation</a>
     */
    public RequestExecutor<PriceIndex> getPriceIndex(PriceIndexRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getPriceIndex(pojoToMap(req))).toList());
    }

    /**
     * Post a new order for margin account.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#margin-account-new-order-trade">Documentation</a>
     */
    public RequestExecutor<MarginOrderResponse> newOrder(MarginOrder order) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.newOrder(pojoToMap(order))).toList());
    }

    /**
     * Cancel an active order for margin account.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#margin-account-cancel-order-trade">Documentation</a>
     */
    public RequestExecutor<CancelOrderResponse> cancelOrder(CancelOrderRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.cancelOrder(pojoToMap(req))).toList());
    }

    /**
     * Cancel all active orders on a symbol for margin account.
     * This includes OCO orders.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#margin-account-cancel-all-open-orders-on-a-symbol-trade">Documentation</a>
     */
    public RequestExecutor<List<CancelOrderResponse>> cancelOpenOrders(CancelOpenOrdersRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.cancelOpenOrders(pojoToMap(req))).toList());
    }

    /**
     * Get Cross Margin Transfer History
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#get-cross-margin-transfer-history-user_data">Documentation</a>
     */
    public RequestExecutor<MarginTransferHistoryResponse> getTransferHistory(MarginTransferHistoryRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getTransferHistory(pojoToMap(req))).toList());
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
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-loan-record-user_data">Documentation</a>
     */
    public RequestExecutor<LoanRecord> getLoanRecord(LoanRecordRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getLoanRecord(pojoToMap(req))).toList());
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
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-repay-record-user_data">Documentation</a>
     */
    public RequestExecutor<RepayRecord> getRepayRecord(RepayRecordRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getRepayRecord(pojoToMap(req))).toList());
    }

    /**
     * Query Repay Record
     * <p>
     * Response in descending order
     * <p>
     * If isolatedSymbol is not sent, crossed margin data will be returned
     * <p>
     * Set archived to true to query data from 6 months ago
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#get-interest-history-user_data">Documentation</a>
     */
    public RequestExecutor<InterestHistory> getInterestHistory(InterestHistoryRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getInterestHistory(pojoToMap(req))).toList());
    }

    /**
     * Get Force Liquidation Record
     * <p>
     * Response in descending order
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#get-force-liquidation-record-user_data">Documentation</a>
     */
    public RequestExecutor<ForceLiquidationRecord> getForceLiquidationRecord(ForceLiquidationRecordRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.getForceLiquidationRecord(pojoToMap(req))).toList());
    }

    /**
     * Get Margin Account Details
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-cross-margin-account-details-user_data">Documentation</a>
     */
    public RequestExecutor<MarginAccount> getAccount(MarginAccountRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getAccount(pojoToMap(req))).toList());
    }

    /**
     * Get Margin Account's Order Status
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-order-user_data">Documentation</a>
     */
    public RequestExecutor<OrderInfo> getOrder(MarginOrderRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOrder(pojoToMap(req))).toList());
    }

    /**
     * Get Margin Account's Open Orders
     * 
     * <p>
     * If the symbol is not sent, orders for all symbols will be returned
     * in an array.
     * <p>
     * When all symbols are returned, the number of requests counted
     * against the rate limiter is equal to the number of symbols currently
     * trading on the exchange.
     * <p>
     * If isIsolated ="TRUE", symbol must be sent.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-open-orders-user_data">Documentation</a>
     */
    public RequestExecutor<List<OrderInfo>> getOpenOrders(MarginOpenOrdersRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOpenOrders(pojoToMap(req))).toList());
    }

    /**
     * Get Margin Account's Open Orders
     * 
     * <p>
     * Request Limit: 60times/min per IP
     * <p>
     * If orderId is set, it will get orders&gt;= that orderId. Otherwise
     * most recent orders are returned.
     * <p>
     * For some historical orders cummulativeQuoteQty will be &lt;0, meaning
     * the data is not available at this time.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-all-orders-user_data">Documentation</a>
     */
    public RequestExecutor<List<OrderInfo>> getAllOrders(MarginAllOrdersRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getAllOrders(pojoToMap(req))).toList());
    }

    /**
     * Send in a new OCO for a margin account
     * 
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
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-all-orders-user_data">Documentation</a>
     */
    public RequestExecutor<MarginOCOResponse> newOCO(MarginOCOOrder order) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.newOCO(pojoToMap(order))).toList());
    }

    /**
     * Cancel an entire Order List
     * 
     * <p>
     * Additional notes:
     * Canceling an individual leg will cancel the entire OCO
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#margin-account-cancel-oco-trade">Documentation</a>
     */
    public RequestExecutor<MarginOCOResponse> cancelOCO(CancelMarginOCORequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.cancelOCO(pojoToMap(req))).toList());
    }

    /**
     * Retrieves a specific OCO based on provided optional parameters
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-oco-user_data">Documentation</a>
     */
    public RequestExecutor<GetMarginOCOResponse> getOCO(GetMarginOCORequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOCO(pojoToMap(req))).toList());
    }

    /**
     * Retrieves all OCO for a specific margin account based on provided optional
     * parameters
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-oco-user_data">Documentation</a>
     */
    public RequestExecutor<List<GetMarginOCOResponse>> getAllOCO(GetAllMarginOCORequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getAllOCO(pojoToMap(req))).toList());
    }

    /**
     * Retrieves all Open OCO for a specific margin account based on provided
     * optional parameters
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-open-oco-user_data">Documentation</a>
     */
    public RequestExecutor<List<GetMarginOCOResponse>> getOpenOCO(GetOpenMarginOCORequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOpenOCO(pojoToMap(req))).toList());
    }

    /**
     * Query Margin Account's Trade List
     * 
     * <p>
     * If fromId is set, it will get trades&gt;= that fromId. Otherwise most
     * recent trades are returned.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-open-oco-user_data">Documentation</a>
     */
    public RequestExecutor<List<MarginTrade>> getMyTrades(GetOpenMarginOCORequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getMyTrades(pojoToMap(req))).toList());
    }

    /**
     * Query Max Borrow
     * 
     * <p>
     * If isolatedSymbol is not sent, crossed margin data will be sent.
     * <p>
     * borrowLimit is also available
     * <a href="https://www.binance.com/en/margin-fee">here</a>
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-max-borrow-user_data">Documentation</a>
     */
    public RequestExecutor<MaxBorrowableResponse> getMaxBorrowable(MaxBorrowableRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getMaxBorrowable(pojoToMap(req))).toList());
    }

    /**
     * Query Max Transfer-Out Amount
     * 
     * <p>
     * If isolatedSymbol is not sent, crossed margin data will be sent.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-max-transfer-out-amount-user_data">Documentation</a>
     */
    public RequestExecutor<MaxTransferableResponse> getMaxTransferable(MaxTransferableRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getMaxTransferable(pojoToMap(req))).toList());
    }

    /**
     * Make an Isolated Margin Account Transfer
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#isolated-margin-account-transfer-margin">Documentation</a>
     */
    public RequestExecutor<MarginTransaction> isolatedTransfer(MarginIsolatedTransferRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.isolatedTransfer(pojoToMap(req))).toList());
    }

    /**
     * Get Isolated Margin Transfer History
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#get-isolated-margin-transfer-history-user_data">Documentation</a>
     */
    public RequestExecutor<MarginIsolatedTransferHistory> getIsolatedTransferHistory(
            MarginIsolatedTransferRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.getIsolatedTransferHistory(pojoToMap(req))).toList());
    }

    /**
     * Query Isolated Margin Account Info
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-account-info-user_data">Documentation</a>
     */
    public RequestExecutor<MarginIsolatedAccount> getIsolatedAccount(MarginIsolatedAccountRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.getIsolatedAccount(pojoToMap(req))).toList());
    }

    /**
     * Disable isolated margin account for a specific symbol. Each trading pair can
     * only be deactivated once every 24 hours.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#disable-isolated-margin-account-trade">Documentation</a>
     */
    public RequestExecutor<ToogleAccountResponse> disableIsolatedAccount(ToogleAccountRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.disableIsolatedAccount(pojoToMap(req))).toList());
    }

    /**
     * Enable isolated margin account for a specific symbol(Only supports activation
     * of previously disabled accounts).
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#enable-isolated-margin-account-trade">Documentation</a>
     */
    public RequestExecutor<ToogleAccountResponse> enableIsolatedAccount(ToogleAccountRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.enableIsolatedAccount(pojoToMap(req))).toList());
    }

    /**
     * Query enabled isolated margin account limit.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-enabled-isolated-margin-account-limit-user_data">Documentation</a>
     */
    public RequestExecutor<MarginIsolatedAccountLimit> getEnabledIsolatedAccountLimit(
            MarginIsolatedAccountLimitRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.getEnabledIsolatedAccountLimit(pojoToMap(req))).toList());
    }

    /**
     * Gets the informations about an isolated symbol
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-symbol-user_data">Documentation</a>
     */
    public RequestExecutor<MarginSymbol> getIsolatedSymbol(MarginSymbolRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.getIsolatedSymbol(pojoToMap(req))).toList());
    }

    /**
     * Gets the informations about all the isolated symbols
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#get-all-isolated-margin-symbol-user_data">Documentation</a>
     */
    public RequestExecutor<List<MarginSymbol>> getAllIsolatedSymbols(MarginSymbolsRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.getAllIsolatedSymbols(pojoToMap(req))).toList());
    }

    /**
     * Toggle BNB Burn On Spot Trade And Margin Interest
     * 
     * <p>
     * "spotBNBBurn" and "interestBNBBurn" should be sent at least one.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#toggle-bnb-burn-on-spot-trade-and-margin-interest-user_data">Documentation</a>
     */
    public RequestExecutor<BNBBurnStatus> toggleBNBBurnOnSpotTradeAndMarginInterest(ToggleBurnRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.toggleBNBBurnOnSpotTradeAndMarginInterest(pojoToMap(req))).toList());
    }

    /**
     * Get BNB Burn Status
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#get-bnb-burn-status-user_data">Documentation</a>
     */
    public RequestExecutor<BNBBurnStatus> getBNBBurnStatus(ToggleBurnRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.getBNBBurnStatus(pojoToMap(req))).toList());
    }

    /**
     * Query Margin Interest Rate History
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-margin-interest-rate-history-user_data">Documentation</a>
     */
    public RequestExecutor<List<InterestRate>> getInterestRateHistory(ToggleBurnRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.getInterestRateHistory(pojoToMap(req))).toList());
    }

    /**
     * Get cross margin fee data collection with any vip level or user's current
     * specific data defined
     * <a href="https://www.binance.com/en/margin-fee">here</a>
     * 
     * <p>
     * User's current specific margin data will be returned if vipLevel is
     * omitted
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-cross-margin-fee-data-user_data">Documentation</a>
     */
    public RequestExecutor<List<CrossMarginFee>> getMarginFeeData(CrossMarginFeeRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.getMarginFeeData(pojoToMap(req))).toList());
    }

    /**
     * Get isolated margin fee data collection with any vip level or user's current
     * specific data defined
     * <a href="https://www.binance.com/en/margin-fee">here</a>
     * 
     * <p>
     * User's current specific margin data will be returned if vipLevel is
     * omitted
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-cross-margin-fee-data-user_data">Documentation</a>
     */
    public RequestExecutor<List<IsolatedMarginFee>> getIsolatedFeeData(IsolatedMarginFeeRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.getIsolatedFeeData(pojoToMap(req))).toList());
    }

    /**
     * Get isolated margin tier data collection with any tier defined
     * <a href="https://www.binance.com/en/margin-data">here</a>
     * 
     * <p>
     * All margin tier data will be returned if tier is omitted
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-tier-data-user_data">Documentation</a>
     */
    public RequestExecutor<List<IsolatedMarginTierData>> getIsolatedMarginTierData(IsolatedMarginTierDataRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.getIsolatedMarginTierData(pojoToMap(req))).toList());
    }

    /**
     * Create a ListenKey (Margin).
     * 
     * <p>
     * The stream will close after 60 minutes unless a
     * keepalive is sent.
     * <p>
     * If the account has an active listenKey, that listenKey
     * will be returned and its validity will be extended for 60 minutes.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin">Documentation</a>
     */
    public RequestExecutor<ListenKey> startUserDataStream() {
        return new RequestExecutor<>(
                getServices().stream().map(MarginMapping::startUserDataStream).toList());
    }

    /**
     * Keepalive a user data stream to prevent a time out (Margin).
     * 
     * <p>
     * User data streams will close after 60 minutes.
     * <p>
     * It's recommended to send a ping about every 30 minutes.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin">Documentation</a>
     */
    public RequestExecutor<Void> keepAliveUserDataStream(String listenKey) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.keepAliveUserDataStream(listenKey)).toList());
    }

    /**
     * Close out a user data stream (Margin).
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin">Documentation</a>
     */
    public RequestExecutor<Void> closeUserDataStream(String listenKey) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.closeUserDataStream(listenKey)).toList());
    }

    /**
     * Create a ListenKey (Isolated margin).
     * 
     * <p>
     * The stream will close after 60 minutes unless a
     * keepalive is sent.
     * <p>
     * If the account has an active listenKey, that listenKey
     * will be returned and its validity will be extended for 60 minutes.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin">Documentation</a>
     */
    public RequestExecutor<ListenKey> startIsolatedUserDataStream(NewIsolatedUserDataStreamRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.startIsolatedUserDataStream(pojoToMap(req))).toList());
    }

    /**
     * Keepalive a user data stream to prevent a time out (Isolated margin).
     * 
     * <p>
     * User data streams will close after 60 minutes.
     * <p>
     * It's recommended to send a ping about every 30 minutes.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin">Documentation</a>
     */
    public RequestExecutor<Void> keepAliveIsolatedUserDataStream(HandleIsolatedUserDataStreamRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.keepAliveIsolatedUserDataStream(pojoToMap(req))).toList());
    }

    /**
     * Close out a user data stream (Isolated margin).
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin">Documentation</a>
     */
    public RequestExecutor<Void> closeIsolatedUserDataStream(HandleIsolatedUserDataStreamRequest req) {
        return new RequestExecutor<>(
                getServices().stream().map(a -> a.closeIsolatedUserDataStream(pojoToMap(req))).toList());
    }
}