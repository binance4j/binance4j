package com.binance4j.spot.client;

import com.binance4j.core.order.CancelOrderResponse;
import com.binance4j.core.order.OCOResponse;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.order.Trade;
import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.spot.account.Account;
import com.binance4j.spot.order.NewOrderResponse;
import com.binance4j.spot.order.OCOInfo;
import com.binance4j.spot.order.OrderCount;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface SpotMapping {
	/**
	 * The API base url
	 */
	String BASE = "/api/v3/";
	/**
	 * The signed http full header
	 */
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
	/**
	 * The API key http full header
	 */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@POST(BASE + "order")
	Call<NewOrderResponse> newOrder(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@POST(BASE + "order/test")
	Call<Void> newOrderTest(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@DELETE(BASE + "order")
	Call<CancelOrderResponse> cancelOrder(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@DELETE(BASE + "openOrders")
	Call<List<CancelOrderResponse>> cancelOpenOrders(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@GET(BASE + "order")
	Call<OrderInfo> getOrderStatus(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@GET(BASE + "openOrders")
	Call<List<OrderInfo>> getOpenOrders(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@GET(BASE + "allOrders")
	Call<List<OrderInfo>> getAllOrders(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@POST(BASE + "order/oco")
	Call<OCOResponse> newOCO(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@DELETE(BASE + "orderList")
	Call<List<OCOResponse>> cancelOCO(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@GET(BASE + "orderList")
	Call<OCOInfo> queryOCO(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@GET(BASE + "allOrderList")
	Call<List<OCOInfo>> getAllOCO(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@GET(BASE + "openOrderList")
	Call<List<OCOInfo>> getOpenOCO(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@GET(BASE + "account")
	Call<Account> getAccount(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@GET(BASE + "myTrades")
	Call<List<Trade>> getMyTrades(@QueryMap Map<String, Object> map);

	/**
	 * .
	 *
	 * @param map The queryMap
	 * @return The query result
	 */
	@Headers({API_H, SIGNED_H})
	@GET(BASE + "rateLimit/order")
	Call<List<OrderCount>> getOrderCount(@QueryMap Map<String, Object> map);
}