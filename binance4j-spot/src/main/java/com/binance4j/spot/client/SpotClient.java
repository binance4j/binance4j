package com.binance4j.spot.client;

import java.util.List;

import com.binance4j.core.order.CancelOpenOrdersRequest;
import com.binance4j.core.order.CancelOrderRequest;
import com.binance4j.core.order.CancelOrderResponse;
import com.binance4j.core.order.OCOOrder;
import com.binance4j.core.order.OCOResponse;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.order.Trade;
import com.binance4j.core.request.RequestExecutor;
import com.binance4j.core.request.RestClient;
import com.binance4j.spot.account.Account;
import com.binance4j.spot.account.AccountRequest;
import com.binance4j.spot.order.AllOCOInfoRequest;
import com.binance4j.spot.order.AllOrdersRequest;
import com.binance4j.spot.order.CancelOCORequest;
import com.binance4j.spot.order.MyTradesRequest;
import com.binance4j.spot.order.NewOrder;
import com.binance4j.spot.order.NewOrderResponse;
import com.binance4j.spot.order.OCOInfo;
import com.binance4j.spot.order.OCOInfoRequest;
import com.binance4j.spot.order.OpenOCORequest;
import com.binance4j.spot.order.OpenOrdersStatusRequest;
import com.binance4j.spot.order.OrderCount;
import com.binance4j.spot.order.OrderCountRequest;
import com.binance4j.spot.order.OrderStatusRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The API client for the SPOT endpoints
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SpotClient extends RestClient<SpotMapping> {
    /**
     * Instantiates a client for the spot endpoints with the choice to use the test
     * network
     *
     * @param key        The API public key
     * @param secret     The API secret key
     * @param useTestnet Are we using the test network?
     */
    public SpotClient(String key, String secret, Boolean useTestnet) {
        super(SpotMapping.class, key, secret, useTestnet);
    }

    /**
     * Instantiates a client for the spot endpoints on api
     *
     * @param key    The API public key
     * @param secret The API secret key
     */
    public SpotClient(String key, String secret) {
        this(key, secret, false);
    }

    /**
     * Send in a new order.
     *
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#new-order-trade">Documentation</a>
     * @param order The order to execute
     * @return The executor to make sync/async request
     */
    public RequestExecutor<NewOrderResponse> newOrder(NewOrder order) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.newOrder(pojoToMap(order))).toList(), order);
    }

    /**
     * Test new order creation and signature/recvWindow long. Creates and validates
     * a new order but does not send it into the matching engine.
     *
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#new-order-trade">Documentation</a>
     * @param order The order to execute
     * @return The executor to make sync/async request
     */
    public RequestExecutor<Void> newOrderTest(NewOrder order) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.newOrderTest(pojoToMap(order))).toList(), order);
    }

    /**
     * Cancel an active order.
     *
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#cancel-order-trade">Documentation</a>
     * @param req The request configuration
     * @return The executor to make sync/async request
     */
    public RequestExecutor<CancelOrderResponse> cancelOrder(CancelOrderRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.cancelOrder(pojoToMap(req))).toList(), req);
    }

    /**
     * Cancels all active orders on a symbol.
     * This includes OCO orders.
     *
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#cancel-all-open-orders-on-a-symbol-trade">Documentation</a>
     * @param req The request configuration
     * @return The executor to make sync/async request
     */
    public RequestExecutor<List<CancelOrderResponse>> cancelOpenOrders(CancelOpenOrdersRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.cancelOpenOrders(pojoToMap(req))).toList(), req);
    }

    /**
     * Check an order's status.
     * <ul>
     * <li>Either orderId or origClientOrderId must be sent.</li>
     * <li>For some historical orders cummulativeQuoteQty will be &lt; 0, meaning
     * the data is not available at this time.</li>
     * </ul>
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-order-user_data">Documentation</a>
     * @param req The request configuration
     * @return The executor to make sync/async request
     */
    public RequestExecutor<OrderInfo> getOrderStatus(OrderStatusRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOrderStatus(pojoToMap(req))).toList(), req);
    }

    /**
     * Get all open orders on a symbol.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#current-open-orders-user_data">Documentation</a>
     * @return The executor to make sync/async request
     * @param req The request configuration
     */
    public RequestExecutor<List<OrderInfo>> getOpenOrders(OpenOrdersStatusRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOpenOrders(pojoToMap(req))).toList(), req);
    }

    /**
     * Get all open orders.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#current-open-orders-user_data">Documentation</a>
     * @return The executor to make sync/async request
     */
    public RequestExecutor<List<OrderInfo>> getOpenOrders() {
        OpenOrdersStatusRequest req = new OpenOrdersStatusRequest();
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOpenOrders(pojoToMap(req))).toList(), req);
    }

    /**
     * Get all orders on a symbol.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#all-orders-user_data">Documentation</a>
     * @param req The request configuration
     * @return The executor to make sync/async request
     */
    public RequestExecutor<List<OrderInfo>> getAllOrders(AllOrdersRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getAllOrders(pojoToMap(req))).toList(), req);
    }

    /**
     * Send in an OCO order
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#new-oco-trade">Documentation</a>
     * @param order The order to execute
     * @return The executor to make sync/async request
     */
    public RequestExecutor<OCOResponse> newOCO(OCOOrder order) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.newOCO(pojoToMap(order))).toList(), order);
    }

    /**
     * Cancel an entire Order List.
     * Canceling an individual leg will cancel the entire OCO
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#cancel-oco-trade">Documentation</a>
     * @param req The request configuration
     * @return The executor to make sync/async request
     */
    public RequestExecutor<List<OCOResponse>> cancelOCO(CancelOCORequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.cancelOCO(pojoToMap(req))).toList(), req);
    }

    /**
     * Retrieves a specific OCO based on provided optional parameters
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data">Documentation</a>
     * @param req The request configuration
     * @return The executor to make sync/async request
     */
    public RequestExecutor<OCOInfo> queryOCO(OCOInfoRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.queryOCO(pojoToMap(req))).toList(), req);
    }

    /**
     * Retrieves all OCO based on provided optional parameters
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data">Documentation</a>
     * @param req The request configuration
     * @return The executor to make sync/async request
     */
    public RequestExecutor<List<OCOInfo>> getAllOCO(AllOCOInfoRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getAllOCO(pojoToMap(req))).toList(), req);
    }

    /**
     * Retrieves all OCO based on provided optional parameters with default request
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data">Documentation</a>
     * @return The executor to make sync/async request
     */
    public RequestExecutor<List<OCOInfo>> getAllOCO() {
        AllOCOInfoRequest req = new AllOCOInfoRequest();
        return new RequestExecutor<>(getServices().stream().map(a -> a.getAllOCO(pojoToMap(req))).toList(), req);
    }

    /**
     * Retrieves all open OCO
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data">Documentation</a>
     * @param req The request configuration
     * @return The executor to make sync/async request
     */
    public RequestExecutor<List<OCOInfo>> getOpenOCO(OpenOCORequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOpenOCO(pojoToMap(req))).toList(), req);
    }

    /**
     * Retrieves all open OCO with default request
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data">Documentation</a>
     * @return The executor to make sync/async request
     */
    public RequestExecutor<List<OCOInfo>> getOpenOCO() {
        OpenOCORequest req = new OpenOCORequest();
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOpenOCO(pojoToMap(req))).toList(), req);
    }

    /**
     * Get current account information.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#account-information-user_data">Documentation</a>
     * @param req The request configuration
     * @return The executor to make sync/async request
     */
    public RequestExecutor<Account> getAccount(AccountRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getAccount(pojoToMap(req))).toList(), req);
    }

    /**
     * Get current account information with default AccountRequest
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#account-information-user_data">Documentation</a>
     * @return The executor to make sync/async request
     */
    public RequestExecutor<Account> getAccount() {
        AccountRequest req = new AccountRequest();
        return new RequestExecutor<>(getServices().stream().map(a -> a.getAccount(pojoToMap(req))).toList(), req);
    }

    /**
     * Get trades for a specific account and symbol.
     * If fromId is set, it will get id >= fromId. Otherwise most
     * recent trades are returned.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#account-trade-list-user_data">Documentation</a>
     * @param req The request configuration
     * @return The executor to make sync/async request
     */
    public RequestExecutor<List<Trade>> getMyTrades(MyTradesRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getMyTrades(pojoToMap(req))).toList(), req);
    }

    /**
     * Displays the user's current order count usage for all intervals.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-current-order-count-usage-trade">Documentation</a>
     * @param req The request configuration
     * @return The executor to make sync/async request
     */
    public RequestExecutor<List<OrderCount>> getOrderCount(OrderCountRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOrderCount(pojoToMap(req))).toList(), req);
    }

    /**
     * Displays the user's current order count usage for all intervals with default
     * request
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-current-order-count-usage-trade">Documentation</a>
     * @return The executor to make sync/async request
     */
    public RequestExecutor<List<OrderCount>> getOrderCount() {
        OrderCountRequest req = new OrderCountRequest();
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOrderCount(pojoToMap(req))).toList(), req);
    }
}