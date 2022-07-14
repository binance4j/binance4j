package com.binance4j.spot.client;

import java.util.List;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.order.CancelOpenOrdersParams;
import com.binance4j.core.order.CancelOrderParams;
import com.binance4j.core.order.CancelOrderResponse;
import com.binance4j.core.order.OCOOrderParams;
import com.binance4j.core.order.OCOResponse;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.order.Trade;
import com.binance4j.core.param.Request;
import com.binance4j.spot.account.Account;
import com.binance4j.spot.account.AccountParams;
import com.binance4j.spot.order.AllOCOInfoParams;
import com.binance4j.spot.order.AllOrdersParams;
import com.binance4j.spot.order.CancelOCOParams;
import com.binance4j.spot.order.MyTradesParams;
import com.binance4j.spot.order.NewOrderParams;
import com.binance4j.spot.order.NewOrderResponse;
import com.binance4j.spot.order.OCOInfo;
import com.binance4j.spot.order.OCOInfoParams;
import com.binance4j.spot.order.OpenOCOParams;
import com.binance4j.spot.order.OpenOrdersStatusParams;
import com.binance4j.spot.order.OrderCount;
import com.binance4j.spot.order.OrderCountParams;
import com.binance4j.spot.order.OrderStatusParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * API client for the SPOT endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#spot-account-trade">Documentation</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SpotClient extends RestClient<SpotMapping> {

	/**
	 *
	 * 
	 * @param key    The API public key
	 * @param secret The API secret key
	 */
	public SpotClient(String key, String secret) {
		super(SpotMapping.class, key, secret);
	}

	/** Send in a new order. */
	public Request<NewOrderResponse> newOrder(NewOrderParams params) {
		return new Request<>(service.newOrder(params.toMap()), params);
	}

	/**
	 * Test new order creation and signature/recvWindow long. Creates and validates
	 * a new order but does not send it into the matching engine.
	 */
	public Request<Void> newOrderTest(NewOrderParams params) {
		return new Request<>(service.newOrderTest(params.toMap()), params);
	}

	/** Cancel an active order. */
	public Request<CancelOrderResponse> cancelOrder(CancelOrderParams params) {
		return new Request<>(service.cancelOrder(params.toMap()), params);
	}

	/**
	 * Cancels all active orders on a symbol.
	 * This includes OCO orders.
	 */
	public Request<List<CancelOrderResponse>> cancelOpenOrders(CancelOpenOrdersParams params) {
		return new Request<>(service.cancelOpenOrders(params.toMap()), params);
	}

	/**
	 * Check an order's status.
	 * <ul>
	 * <li>Either orderId or origClientOrderId must be sent.</li>
	 * <li>For some historical orders cummulativeQuoteQty will be &lt; 0, meaning
	 * the data is not available at this time.</li>
	 * </ul>
	 */
	public Request<OrderInfo> getOrderStatus(OrderStatusParams params) {
		return new Request<>(service.getOrderStatus(params.toMap()), params);
	}

	/** Get all open orders on a symbol. */
	public Request<List<OrderInfo>> getOpenOrders(OpenOrdersStatusParams params) {
		return new Request<>(service.getOpenOrders(params.toMap()), params);
	}

	/** Get all open orders. */
	public Request<List<OrderInfo>> getOpenOrders() {
		OpenOrdersStatusParams params = new OpenOrdersStatusParams();
		return new Request<>(service.getOpenOrders(params.toMap()), params);
	}

	/** Get all orders on a symbol. */
	public Request<List<OrderInfo>> getAllOrders(AllOrdersParams params) {
		return new Request<>(service.getAllOrders(params.toMap()), params);
	}

	/** Send in an OCO order. */
	public Request<OCOResponse> newOCO(OCOOrderParams params) {
		return new Request<>(service.newOCO(params.toMap()), params);
	}

	/**
	 * Cancel an entire Order List.
	 * Canceling an individual leg will cancel the entire OCO
	 */
	public Request<List<OCOResponse>> cancelOCO(CancelOCOParams params) {
		return new Request<>(service.cancelOCO(params.toMap()), params);
	}

	/** Retrieves a specific OCO based on provided optional parameters. */
	public Request<OCOInfo> queryOCO(OCOInfoParams params) {
		return new Request<>(service.queryOCO(params.toMap()), params);
	}

	/** Retrieves all OCO based on provided optional parameters. */
	public Request<List<OCOInfo>> getAllOCO(AllOCOInfoParams params) {
		return new Request<>(service.getAllOCO(params.toMap()), params);
	}

	/** Retrieves all OCO based on provided optional parameters. */
	public Request<List<OCOInfo>> getAllOCO() {
		AllOCOInfoParams params = new AllOCOInfoParams();
		return new Request<>(service.getAllOCO(params.toMap()), params);
	}

	/** Retrieves all open OCO. */
	public Request<List<OCOInfo>> getOpenOCO(OpenOCOParams params) {
		return new Request<>(service.getOpenOCO(params.toMap()), params);
	}

	/** Retrieves all open OCO. */
	public Request<List<OCOInfo>> getOpenOCO() {
		OpenOCOParams params = new OpenOCOParams();
		return new Request<>(service.getOpenOCO(params.toMap()), params);
	}

	/** Get current account information. */
	public Request<Account> getAccount(AccountParams params) {
		return new Request<>(service.getAccount(params.toMap()), params);
	}

	/** Get current account information. */
	public Request<Account> getAccount() {
		AccountParams params = new AccountParams();
		return new Request<>(service.getAccount(params.toMap()), params);
	}

	/**
	 * Get trades for a specific account and symbol.
	 * If fromId is set, it will get id &gt;= fromId. Otherwise most
	 * recent trades are returned.
	 */
	public Request<List<Trade>> getMyTrades(MyTradesParams params) {
		return new Request<>(service.getMyTrades(params.toMap()), params);
	}

	/** Displays the user's current order count usage for all intervals. */
	public Request<List<OrderCount>> getOrderCount(OrderCountParams params) {
		return new Request<>(service.getOrderCount(params.toMap()), params);
	}

	/**
	 * Displays the user's current order count usage for all intervals with default
	 * request
	 */
	public Request<List<OrderCount>> getOrderCount() {
		OrderCountParams params = new OrderCountParams();
		return new Request<>(service.getOrderCount(params.toMap()), params);
	}
}