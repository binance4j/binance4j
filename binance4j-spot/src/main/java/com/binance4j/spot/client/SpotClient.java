package com.binance4j.spot.client;

import java.util.List;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.order.CancelOpenOrdersRequest;
import com.binance4j.core.order.CancelOrderRequest;
import com.binance4j.core.order.CancelOrderResponse;
import com.binance4j.core.order.OCOOrder;
import com.binance4j.core.order.OCOResponse;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.order.Trade;
import com.binance4j.core.request.RequestExecutor;
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
	 * Constructor
	 *
	 * @param key    The API public key
	 * @param secret The API secret key
	 */
	public SpotClient(String key, String secret) {
		super(SpotMapping.class, key, secret);
	}

	/**
	 * Send in a new order.
	 *
	 * @param order The order to execute
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#new-order-trade">Documentation</a>
	 */
	public RequestExecutor<NewOrderResponse> newOrder(NewOrder order) {
		return new RequestExecutor<>(service.newOrder(order.toMap()), order);
	}

	/**
	 * Test new order creation and signature/recvWindow long. Creates and validates
	 * a new order but does not send it into the matching engine.
	 *
	 * @param order The order to execute
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#new-order-trade">Documentation</a>
	 */
	public RequestExecutor<Void> newOrderTest(NewOrder order) {
		return new RequestExecutor<>(service.newOrderTest(order.toMap()), order);
	}

	/**
	 * Cancel an active order.
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#cancel-order-trade">Documentation</a>
	 */
	public RequestExecutor<CancelOrderResponse> cancelOrder(CancelOrderRequest req) {
		return new RequestExecutor<>(service.cancelOrder(req.toMap()), req);
	}

	/**
	 * Cancels all active orders on a symbol.
	 * This includes OCO orders.
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#cancel-all-open-orders-on-a-symbol-trade">Documentation</a>
	 */
	public RequestExecutor<List<CancelOrderResponse>> cancelOpenOrders(CancelOpenOrdersRequest req) {
		return new RequestExecutor<>(service.cancelOpenOrders(req.toMap()), req);
	}

	/**
	 * Check an order's status.
	 * <ul>
	 * <li>Either orderId or origClientOrderId must be sent.</li>
	 * <li>For some historical orders cummulativeQuoteQty will be &lt; 0, meaning
	 * the data is not available at this time.</li>
	 * </ul>
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#query-order-user_data">Documentation</a>
	 */
	public RequestExecutor<OrderInfo> getOrderStatus(OrderStatusRequest req) {
		return new RequestExecutor<>(service.getOrderStatus(req.toMap()), req);
	}

	/**
	 * Get all open orders on a symbol.
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#current-open-orders-user_data">Documentation</a>
	 */
	public RequestExecutor<List<OrderInfo>> getOpenOrders(OpenOrdersStatusRequest req) {
		return new RequestExecutor<>(service.getOpenOrders(req.toMap()), req);
	}

	/**
	 * Get all open orders.
	 *
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#current-open-orders-user_data">Documentation</a>
	 */
	public RequestExecutor<List<OrderInfo>> getOpenOrders() {
		OpenOrdersStatusRequest req = new OpenOrdersStatusRequest();
		return new RequestExecutor<>(service.getOpenOrders(req.toMap()), req);
	}

	/**
	 * Get all orders on a symbol.
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#all-orders-user_data">Documentation</a>
	 */
	public RequestExecutor<List<OrderInfo>> getAllOrders(AllOrdersRequest req) {
		return new RequestExecutor<>(service.getAllOrders(req.toMap()), req);
	}

	/**
	 * Send in an OCO order
	 *
	 * @param order The order to execute
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#new-oco-trade">Documentation</a>
	 */
	public RequestExecutor<OCOResponse> newOCO(OCOOrder order) {
		return new RequestExecutor<>(service.newOCO(order.toMap()), order);
	}

	/**
	 * Cancel an entire Order List.
	 * Canceling an individual leg will cancel the entire OCO
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#cancel-oco-trade">Documentation</a>
	 */
	public RequestExecutor<List<OCOResponse>> cancelOCO(CancelOCORequest req) {
		return new RequestExecutor<>(service.cancelOCO(req.toMap()), req);
	}

	/**
	 * Retrieves a specific OCO based on provided optional parameters
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data">Documentation</a>
	 */
	public RequestExecutor<OCOInfo> queryOCO(OCOInfoRequest req) {
		return new RequestExecutor<>(service.queryOCO(req.toMap()), req);
	}

	/**
	 * Retrieves all OCO based on provided optional parameters
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data">Documentation</a>
	 */
	public RequestExecutor<List<OCOInfo>> getAllOCO(AllOCOInfoRequest req) {
		return new RequestExecutor<>(service.getAllOCO(req.toMap()), req);
	}

	/**
	 * Retrieves all OCO based on provided optional parameters with default request
	 *
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data">Documentation</a>
	 */
	public RequestExecutor<List<OCOInfo>> getAllOCO() {
		AllOCOInfoRequest req = new AllOCOInfoRequest();
		return new RequestExecutor<>(service.getAllOCO(req.toMap()), req);
	}

	/**
	 * Retrieves all open OCO
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data">Documentation</a>
	 */
	public RequestExecutor<List<OCOInfo>> getOpenOCO(OpenOCORequest req) {
		return new RequestExecutor<>(service.getOpenOCO(req.toMap()), req);
	}

	/**
	 * Retrieves all open OCO with default request
	 *
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data">Documentation</a>
	 */
	public RequestExecutor<List<OCOInfo>> getOpenOCO() {
		OpenOCORequest req = new OpenOCORequest();
		return new RequestExecutor<>(service.getOpenOCO(req.toMap()), req);
	}

	/**
	 * Get current account information.
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#account-information-user_data">Documentation</a>
	 */
	public RequestExecutor<Account> getAccount(AccountRequest req) {
		return new RequestExecutor<>(service.getAccount(req.toMap()), req);
	}

	/**
	 * Get current account information with default AccountRequest
	 *
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#account-information-user_data">Documentation</a>
	 */
	public RequestExecutor<Account> getAccount() {
		AccountRequest req = new AccountRequest();
		return new RequestExecutor<>(service.getAccount(req.toMap()), req);
	}

	/**
	 * Get trades for a specific account and symbol.
	 * If fromId is set, it will get id &gt;= fromId. Otherwise most
	 * recent trades are returned.
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 *      "https://binance-docs.github.io/apidocs/spot/en/#account-trade-list-user_data">Documentation</a>
	 */
	public RequestExecutor<List<Trade>> getMyTrades(MyTradesRequest req) {
		return new RequestExecutor<>(service.getMyTrades(req.toMap()), req);
	}

	/**
	 * Displays the user's current order count usage for all intervals.
	 *
	 * @param req The request configuration
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#query-current-order-count-usage-trade">Documentation</a>
	 */
	public RequestExecutor<List<OrderCount>> getOrderCount(OrderCountRequest req) {
		return new RequestExecutor<>(service.getOrderCount(req.toMap()), req);
	}

	/**
	 * Displays the user's current order count usage for all intervals with default
	 * request
	 *
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#query-current-order-count-usage-trade">Documentation</a>
	 */
	public RequestExecutor<List<OrderCount>> getOrderCount() {
		OrderCountRequest req = new OrderCountRequest();
		return new RequestExecutor<>(service.getOrderCount(req.toMap()), req);
	}
}