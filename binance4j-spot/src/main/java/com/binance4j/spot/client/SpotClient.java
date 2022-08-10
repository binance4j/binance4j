package com.binance4j.spot.client;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.spot.param.AccountParams;
import com.binance4j.spot.param.AllOCOInfoParams;
import com.binance4j.spot.param.AllOrdersParams;
import com.binance4j.spot.param.CancelOCOParams;
import com.binance4j.spot.param.CancelOpenOrdersParams;
import com.binance4j.spot.param.CancelOrderParams;
import com.binance4j.spot.param.LimitMakerOrder;
import com.binance4j.spot.param.LimitOrder;
import com.binance4j.spot.param.MarketOrder;
import com.binance4j.spot.param.MarketQuoteOrder;
import com.binance4j.spot.param.NewOCOOrderParams;
import com.binance4j.spot.param.NewOrderParams;
import com.binance4j.spot.param.OCOInfoParams;
import com.binance4j.spot.param.OpenOCOParams;
import com.binance4j.spot.param.OpenOrdersStatusParams;
import com.binance4j.spot.param.OrderCountParams;
import com.binance4j.spot.param.OrderStatusParams;
import com.binance4j.spot.param.StopLossLimitOrder;
import com.binance4j.spot.param.StopLossOrder;
import com.binance4j.spot.param.TakeProfitLimitOrder;
import com.binance4j.spot.param.TakeProfitOrder;
import com.binance4j.spot.param.TradesParams;
import com.binance4j.spot.request.CancelOCORequest;
import com.binance4j.spot.request.CancelOpenOrderRequest;
import com.binance4j.spot.request.CancelOrderRequest;
import com.binance4j.spot.request.GetAccountRequest;
import com.binance4j.spot.request.GetAllOCORequest;
import com.binance4j.spot.request.GetAllOrdersRequest;
import com.binance4j.spot.request.GetOCORequest;
import com.binance4j.spot.request.GetOpenOCORequest;
import com.binance4j.spot.request.GetOpenOrdersRequest;
import com.binance4j.spot.request.GetOrderCountRequest;
import com.binance4j.spot.request.GetOrderStatusRequest;
import com.binance4j.spot.request.GetTradesRequest;
import com.binance4j.spot.request.NewOCORequest;
import com.binance4j.spot.request.NewOrderRequest;
import com.binance4j.spot.request.NewOrderTestRequest;

/**
 * API client for the SPOT endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#spot-account-trade">Documentation</a>
 */
public class SpotClient extends RestClient<SpotMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public SpotClient(String key, String secret) {
		super(SpotMapping.class, key, secret);
	}

	/**
	 * @param key        API public key.
	 * @param secret     API secret key.
	 * @param useTestnet use testnet.
	 */
	protected SpotClient(String key, String secret, boolean useTestnet) {
		super(SpotMapping.class, key, secret, useTestnet);
	}

	/**
	 * Send in a new order.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 * @deprecated Use specific Order.
	 */
	@Deprecated
	public NewOrderRequest newOrder(NewOrderParams params) {
		return new NewOrderRequest(service.newOrder(params.toMap()));
	}

	// ORDERS

	/**
	 * Tests a {@link MarketOrder}.
	 * 
	 * @param order the {@link MarketOrder}.
	 * @return The request to execute.
	 */
	public NewOrderRequest newOrder(MarketOrder order) {
		return new NewOrderRequest(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link MarketQuoteOrder}.
	 * 
	 * @param order the {@link MarketQuoteOrder}.
	 * @return The request to execute.
	 */
	public NewOrderRequest newOrder(MarketQuoteOrder order) {
		return new NewOrderRequest(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link LimitOrder}.
	 * 
	 * @param order the {@link LimitOrder}.
	 * @return The request to execute.
	 */
	public NewOrderRequest newOrder(LimitOrder order) {
		return new NewOrderRequest(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link LimitMakerOrder}.
	 * 
	 * @param order the {@link LimitMakerOrder}.
	 * @return The request to execute.
	 */
	public NewOrderRequest newOrder(LimitMakerOrder order) {
		return new NewOrderRequest(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link StopLossLimitOrder}.
	 * 
	 * @param order the {@link StopLossLimitOrder}.
	 * @return The request to execute.
	 */
	public NewOrderRequest newOrder(StopLossLimitOrder order) {
		return new NewOrderRequest(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link StopLossOrder}.
	 * 
	 * @param order the {@link StopLossOrder}.
	 * @return The request to execute.
	 */
	public NewOrderRequest newOrder(StopLossOrder order) {
		return new NewOrderRequest(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link TakeProfitLimitOrder}.
	 * 
	 * @param order the {@link TakeProfitLimitOrder}.
	 * @return The request to execute.
	 */
	public NewOrderRequest newOrder(TakeProfitLimitOrder order) {
		return new NewOrderRequest(service.newOrder(order.toMap()));
	}

	/**
	 * Tests a {@link TakeProfitOrder}.
	 * 
	 * @param order the {@link TakeProfitOrder}.
	 * @return The request to execute.
	 */
	public NewOrderRequest newOrder(TakeProfitOrder order) {
		return new NewOrderRequest(service.newOrder(order.toMap()));
	}

	// END ORDERS

	// TEST ORDERS

	/**
	 * Creates and validates a new order but does not send it into the matching
	 * engine.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 * @deprecated Use specific Order.
	 */
	@Deprecated
	public NewOrderTestRequest newOrderTest(NewOrderParams params) {
		return new NewOrderTestRequest(service.newOrderTest(params.toMap()));
	}

	/**
	 * Tests a {@link MarketOrder}.
	 * 
	 * @param order the {@link MarketOrder}.
	 * @return The request to execute.
	 */
	public NewOrderTestRequest newOrderTest(MarketOrder order) {
		return new NewOrderTestRequest(service.newOrderTest(order.toMap()));
	}

	/**
	 * Tests a {@link MarketQuoteOrder}.
	 * 
	 * @param order the {@link MarketQuoteOrder}.
	 * @return The request to execute.
	 */
	public NewOrderTestRequest newOrderTest(MarketQuoteOrder order) {
		return new NewOrderTestRequest(service.newOrderTest(order.toMap()));
	}

	/**
	 * Tests a {@link LimitOrder}.
	 * 
	 * @param order the {@link LimitOrder}.
	 * @return The request to execute.
	 */
	public NewOrderTestRequest newOrderTest(LimitOrder order) {
		return new NewOrderTestRequest(service.newOrderTest(order.toMap()));
	}

	/**
	 * Tests a {@link LimitMakerOrder}.
	 * 
	 * @param order the {@link LimitMakerOrder}.
	 * @return The request to execute.
	 */
	public NewOrderTestRequest newOrderTest(LimitMakerOrder order) {
		return new NewOrderTestRequest(service.newOrderTest(order.toMap()));
	}

	/**
	 * Tests a {@link StopLossLimitOrder}.
	 * 
	 * @param order the {@link StopLossLimitOrder}.
	 * @return The request to execute.
	 */
	public NewOrderTestRequest newOrderTest(StopLossLimitOrder order) {
		return new NewOrderTestRequest(service.newOrderTest(order.toMap()));
	}

	/**
	 * Tests a {@link StopLossOrder}.
	 * 
	 * @param order the {@link StopLossOrder}.
	 * @return The request to execute.
	 */
	public NewOrderTestRequest newOrderTest(StopLossOrder order) {
		return new NewOrderTestRequest(service.newOrderTest(order.toMap()));
	}

	/**
	 * Tests a {@link TakeProfitLimitOrder}.
	 * 
	 * @param order the {@link TakeProfitLimitOrder}.
	 * @return The request to execute.
	 */
	public NewOrderTestRequest newOrderTest(TakeProfitLimitOrder order) {
		return new NewOrderTestRequest(service.newOrderTest(order.toMap()));
	}

	/**
	 * Tests a {@link TakeProfitOrder}.
	 * 
	 * @param order the {@link TakeProfitOrder}.
	 * @return The request to execute.
	 */
	public NewOrderTestRequest newOrderTest(TakeProfitOrder order) {
		return new NewOrderTestRequest(service.newOrderTest(order.toMap()));
	}

	// END TEST ORDERS

	/**
	 * Cancel an active order.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public CancelOrderRequest cancelOrder(CancelOrderParams params) {
		return new CancelOrderRequest(service.cancelOrder(params.toMap()));
	}

	/**
	 * Cancels all active orders on a symbol. This includes OCO orders.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public CancelOpenOrderRequest cancelOpenOrders(CancelOpenOrdersParams params) {
		return new CancelOpenOrderRequest(service.cancelOpenOrders(params.toMap()));
	}

	/**
	 * Check an order's status.
	 * <ul>
	 * <li>Either orderId or origClientOrderId must be sent.</li>
	 * <li>For some historical orders cummulative quote quantity will be &lt; 0,
	 * meaning the data is not available at this
	 * time.</li>
	 * </ul>
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetOrderStatusRequest getOrderStatus(OrderStatusParams params) {
		return new GetOrderStatusRequest(service.getOrderStatus(params.toMap()));
	}

	/**
	 * Get all open orders on a symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetOpenOrdersRequest getOpenOrders(OpenOrdersStatusParams params) {
		return new GetOpenOrdersRequest(service.getOpenOrders(params.toMap()));
	}

	/**
	 * Get all open orders.
	 * 
	 * @return The request to execute.
	 */
	public GetOpenOrdersRequest getOpenOrders() {
		OpenOrdersStatusParams params = new OpenOrdersStatusParams(null);
		return new GetOpenOrdersRequest(service.getOpenOrders(params.toMap()));
	}

	/**
	 * Get all orders on a symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetAllOrdersRequest getAllOrders(AllOrdersParams params) {
		return new GetAllOrdersRequest(service.getAllOrders(params.toMap()));
	}

	/**
	 * Get all orders on a symbol.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time frame.
	 * @return The request to execute.
	 */
	public GetAllOrdersRequest getAllOrders(AllOrdersParams params, TimeFrame timeFrame) {
		return new GetAllOrdersRequest(service.getAllOrders(Params.merge(params, timeFrame)));
	}

	/**
	 * Send in an OCO order.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public NewOCORequest newOCO(NewOCOOrderParams params) {
		return new NewOCORequest(service.newOCO(params.toMap()));
	}

	/**
	 * Cancel an entire Order List. Canceling an individual leg will cancel the
	 * entire OCO
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
	public GetOCORequest getOCO(OCOInfoParams params) {
		return new GetOCORequest(service.queryOCO(params.toMap()));
	}

	/**
	 * Retrieves all OCO based on provided optional parameters.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetAllOCORequest getAllOCO(AllOCOInfoParams params) {
		return new GetAllOCORequest(service.getAllOCO(params.toMap()));
	}

	/**
	 * Retrieves all OCO based on provided optional parameters.
	 * 
	 * @return The request to execute.
	 */
	public GetAllOCORequest getAllOCO() {
		return new GetAllOCORequest(service.getAllOCO(new AllOCOInfoParams(null).toMap()));
	}

	/**
	 * Retrieves all OCO based on provided optional parameters.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time frame.
	 * @return The request to execute.
	 */
	public GetAllOCORequest getAllOCO(AllOCOInfoParams params, TimeFrame timeFrame) {
		return new GetAllOCORequest(service.getAllOCO(Params.merge(params, timeFrame)));
	}

	/**
	 * Retrieves all OCO based on provided optional parameters.
	 * 
	 * @param timeFrame Time frame.
	 * @return The request to execute.
	 */
	public GetAllOCORequest getAllOCO(TimeFrame timeFrame) {
		return new GetAllOCORequest(service.getAllOCO(Params.merge(new AllOCOInfoParams(null), timeFrame)));
	}

	/**
	 * Retrieves all open OCO.
	 * 
	 * @return The request to execute.
	 */
	public GetOpenOCORequest getOpenOCO() {
		return new GetOpenOCORequest(service.getOpenOCO(new OpenOCOParams().toMap()));
	}

	/**
	 * Get current account information.
	 * 
	 * @return The request to execute.
	 */
	public GetAccountRequest getAccount() {
		return new GetAccountRequest(service.getAccount(new AccountParams().toMap()));
	}

	/**
	 * Get trades for a specific account and symbol. If fromId is set, it will get
	 * id &gt;= fromId. Otherwise most recent
	 * trades are returned.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetTradesRequest getTrades(TradesParams params) {
		return new GetTradesRequest(service.getTrades(params.toMap()));
	}

	/**
	 * Get trades for a specific account and symbol. If fromId is set, it will get
	 * id &gt;= fromId. Otherwise most recent
	 * trades are returned.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time frame.
	 * @return The request to execute.
	 */
	public GetTradesRequest getTrades(TradesParams params, TimeFrame timeFrame) {
		return new GetTradesRequest(service.getTrades(Params.merge(params, timeFrame)));
	}

	/**
	 * Displays the user's current order count usage for all intervals with default
	 * request
	 * 
	 * @return The request to execute.
	 */
	public GetOrderCountRequest getOrderCount() {
		return new GetOrderCountRequest(service.getOrderCount(new OrderCountParams().toMap()));
	}
}