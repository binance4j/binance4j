package com.binance4j.spot.client;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.dto.CancelOrderResponse;
import com.binance4j.core.dto.OCOResponse;
import com.binance4j.core.dto.OrderInfo;
import com.binance4j.core.dto.Trade;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.spot.dto.Account;
import com.binance4j.spot.dto.NewOrderResponse;
import com.binance4j.spot.dto.OCOInfo;
import com.binance4j.spot.dto.OrderCount;
import com.binance4j.spot.param.AccountParams;
import com.binance4j.spot.param.AllOCOInfoParams;
import com.binance4j.spot.param.AllOrdersParams;
import com.binance4j.spot.param.CancelOCOParams;
import com.binance4j.spot.param.CancelOpenOrdersParams;
import com.binance4j.spot.param.CancelOrderParams;
import com.binance4j.spot.param.MyTradesParams;
import com.binance4j.spot.param.NewOCOOrderParams;
import com.binance4j.spot.param.NewOrderParams;
import com.binance4j.spot.param.OCOInfoParams;
import com.binance4j.spot.param.OpenOCOParams;
import com.binance4j.spot.param.OpenOrdersStatusParams;
import com.binance4j.spot.param.OrderCountParams;
import com.binance4j.spot.param.OrderStatusParams;

/**
 * API client for the SPOT endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#spot-account-trade">Documentation</a>
 */
public class SpotClient extends RestClient<SpotMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public SpotClient(String key, String secret) {
		super(SpotMapping.class, key, secret);
	}

	/**
	 * Send in a new order.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<NewOrderResponse> newOrder(NewOrderParams params) {
		return new Request<>(service.newOrder(params.toMap()));
	}

	/**
	 * Test new order creation and signature/recvWindow long. Creates and validates a new order but does not send it into
	 * the matching engine.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Void> newOrderTest(NewOrderParams params) {
		return new Request<>(service.newOrderTest(params.toMap()));
	}

	/**
	 * Cancel an active order.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<CancelOrderResponse> cancelOrder(CancelOrderParams params) {
		return new Request<>(service.cancelOrder(params.toMap()));
	}

	/**
	 * Cancels all active orders on a symbol. This includes OCO orders.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<CancelOrderResponse>> cancelOpenOrders(CancelOpenOrdersParams params) {
		return new Request<>(service.cancelOpenOrders(params.toMap()));
	}

	/**
	 * Check an order's status.
	 * <ul>
	 * <li>Either orderId or origClientOrderId must be sent.</li>
	 * <li>For some historical orders cummulative quote quantity will be &lt; 0, meaning the data is not available at this
	 * time.</li>
	 * </ul>
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<OrderInfo> getOrderStatus(OrderStatusParams params) {
		return new Request<>(service.getOrderStatus(params.toMap()));
	}

	/**
	 * Get all open orders on a symbol.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getOpenOrders(OpenOrdersStatusParams params) {
		return new Request<>(service.getOpenOrders(params.toMap()));
	}

	/**
	 * Get all open orders.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getOpenOrders() {
		OpenOrdersStatusParams params = new OpenOrdersStatusParams();
		return new Request<>(service.getOpenOrders(params.toMap()));
	}

	/**
	 * Get all orders on a symbol.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getAllOrders(AllOrdersParams params) {
		return new Request<>(service.getAllOrders(params.toMap()));
	}

	/**
	 * Get all orders on a symbol.
	 * 
	 * @param params    The request params.
	 * @param timeFrame The time frame.
	 * @return The request to execute.
	 */
	public Request<List<OrderInfo>> getAllOrders(AllOrdersParams params, TimeFrame timeFrame) {
		return new Request<>(service.getAllOrders(Params.merge(params, timeFrame)));
	}

	/**
	 * Send in an OCO order.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<OCOResponse> newOCO(NewOCOOrderParams params) {
		return new Request<>(service.newOCO(params.toMap()));
	}

	/**
	 * Cancel an entire Order List. Canceling an individual leg will cancel the entire OCO
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OCOResponse>> cancelOCO(CancelOCOParams params) {
		return new Request<>(service.cancelOCO(params.toMap()));
	}

	/**
	 * Retrieves a specific OCO based on provided optional parameters.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<OCOInfo> getOCO(OCOInfoParams params) {
		return new Request<>(service.queryOCO(params.toMap()));
	}

	/**
	 * Retrieves all OCO based on provided optional parameters.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OCOInfo>> getAllOCO(AllOCOInfoParams params) {
		return new Request<>(service.getAllOCO(params.toMap()));
	}

	/**
	 * Retrieves all OCO based on provided optional parameters.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<OCOInfo>> getAllOCO() {
		return new Request<>(service.getAllOCO(new AllOCOInfoParams().toMap()));
	}

	/**
	 * Retrieves all OCO based on provided optional parameters.
	 * 
	 * @param params    The request params.
	 * @param timeFrame The time frame.
	 * @return The request to execute.
	 */
	public Request<List<OCOInfo>> getAllOCO(AllOCOInfoParams params, TimeFrame timeFrame) {
		return new Request<>(service.getAllOCO(Params.merge(params, timeFrame)));
	}

	/**
	 * Retrieves all OCO based on provided optional parameters.
	 * 
	 * @param timeFrame The time frame.
	 * @return The request to execute.
	 */
	public Request<List<OCOInfo>> getAllOCO(TimeFrame timeFrame) {
		return new Request<>(service.getAllOCO(Params.merge(new AllOCOInfoParams(), timeFrame)));
	}

	/**
	 * Retrieves all open OCO.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OCOInfo>> getOpenOCO(OpenOCOParams params) {
		return new Request<>(service.getOpenOCO(params.toMap()));
	}

	/**
	 * Retrieves all open OCO.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<OCOInfo>> getOpenOCO() {
		OpenOCOParams params = new OpenOCOParams();
		return new Request<>(service.getOpenOCO(params.toMap()));
	}

	/**
	 * Get current account information.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Account> getAccount(AccountParams params) {
		return new Request<>(service.getAccount(params.toMap()));
	}

	/**
	 * Get current account information.
	 * 
	 * @return The request to execute.
	 */
	public Request<Account> getAccount() {
		AccountParams params = new AccountParams();
		return new Request<>(service.getAccount(params.toMap()));
	}

	/**
	 * Get trades for a specific account and symbol. If fromId is set, it will get id &gt;= fromId. Otherwise most recent
	 * trades are returned.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<Trade>> getMyTrades(MyTradesParams params) {
		return new Request<>(service.getMyTrades(params.toMap()));
	}

	/**
	 * Get trades for a specific account and symbol. If fromId is set, it will get id &gt;= fromId. Otherwise most recent
	 * trades are returned.
	 * 
	 * @param params    The request params.
	 * @param timeFrame The time frame.
	 * @return The request to execute.
	 */
	public Request<List<Trade>> getMyTrades(MyTradesParams params, TimeFrame timeFrame) {
		return new Request<>(service.getMyTrades(Params.merge(params, timeFrame)));
	}

	/**
	 * Displays the user's current order count usage for all intervals.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<OrderCount>> getOrderCount(OrderCountParams params) {
		return new Request<>(service.getOrderCount(params.toMap()));
	}

	/**
	 * Displays the user's current order count usage for all intervals with default request
	 * 
	 * @return The request to execute.
	 */
	public Request<List<OrderCount>> getOrderCount() {
		OrderCountParams params = new OrderCountParams();
		return new Request<>(service.getOrderCount(params.toMap()));
	}
}