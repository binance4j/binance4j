package com.binance4j.spot.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.core.dto.Trade;
import com.binance4j.spot.dto.Account;
import com.binance4j.spot.dto.CancelOrderResponse;
import com.binance4j.spot.dto.NewOrderResponse;
import com.binance4j.spot.dto.OCOInfo;
import com.binance4j.spot.dto.OCOResponse;
import com.binance4j.spot.dto.OrderCount;
import com.binance4j.spot.dto.OrderInfo;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/** {@link SpotClient} mapping. */
public interface SpotMapping extends RestMapping {

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_UID_H, WEIGHT_ONE_H, IS_ORDER_H })
	@POST("/api/v3/order")
	Call<NewOrderResponse> newOrder(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_UID_H, WEIGHT_ONE_H })
	@POST("/api/v3/order/test")
	Call<Void> newOrderTest(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	@DELETE("/api/v3/order")
	Call<CancelOrderResponse> cancelOrder(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	@DELETE("/api/v3/openOrders")
	Call<List<CancelOrderResponse>> cancelOpenOrders(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 2" })
	@GET("/api/v3/order")
	Call<OrderInfo> getOrderStatus(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 40" })
	@GET("/api/v3/openOrders")
	Call<List<OrderInfo>> getOpenOrders(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 10" })
	@GET("/api/v3/allOrders")
	Call<List<OrderInfo>> getAllOrders(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_UID_H, "X-WEIGHT: 2" })
	@POST("/api/v3/order/oco")
	Call<OCOResponse> newOCO(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	@DELETE("/api/v3/orderList")
	Call<OCOResponse> cancelOCO(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 2" })
	@GET("/api/v3/orderList")
	Call<OCOInfo> queryOCO(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 10" })
	@GET("/api/v3/allOrderList")
	Call<List<OCOInfo>> getAllOCO(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 3" })
	@GET("/api/v3/openOrderList")
	Call<List<OCOInfo>> getOpenOCO(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 10" })
	@GET("/api/v3/account")
	Call<Account> getAccount(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 10" })
	@GET("/api/v3/myTrades")
	Call<List<Trade>> getTrades(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 20" })
	@GET("/api/v3/rateLimit/order")
	Call<List<OrderCount>> getOrderCount(@QueryMap Map<String, Object> map);
}