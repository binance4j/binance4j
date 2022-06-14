package com.binance4j.spot.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.misc.ListenKey;
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
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface SpotMapping {
	/** The API base url */
	public static final String BASE = "/api/v3/";
	/** The signed http full header */
	public static final String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
	/** The API key http full header */
	public static final String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@POST(BASE + "order")
	Call<NewOrderResponse> newOrder(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@POST(BASE + "order/test")
	Call<Void> newOrderTest(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@DELETE(BASE + "order")
	Call<CancelOrderResponse> cancelOrder(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@DELETE(BASE + "openOrders")
	Call<List<CancelOrderResponse>> cancelOpenOrders(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "order")
	Call<OrderInfo> getOrderStatus(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "openOrders")
	Call<List<OrderInfo>> getOpenOrders(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "allOrders")
	Call<List<OrderInfo>> getAllOrders(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@POST(BASE + "order/oco")
	Call<OCOResponse> newOCO(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@DELETE(BASE + "orderList")
	Call<List<OCOResponse>> cancelOCO(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "orderList")
	Call<OCOInfo> queryOCO(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "allOrderList")
	Call<List<OCOInfo>> getAllOCO(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "openOrderList")
	Call<List<OCOInfo>> getOpenOCO(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "account")
	Call<Account> getAccount(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "myTrades")
	Call<List<Trade>> getMyTrades(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param map The queryMap
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "rateLimit/order")
	Call<List<OrderCount>> getOrderCount(@QueryMap Map<String, Object> map);

	/**
	 * .
	 * 
	 * @return The query result
	 */
	@Headers(API_H)
	@POST(BASE + "userDataStream")
	Call<ListenKey> startUserDataStream();

	/**
	 * .
	 * 
	 * @return The query result
	 * @param listenKey The authenticated account user listen key
	 */
	@Headers(API_H)
	@PUT(BASE + "userDataStream")
	Call<Void> keepAliveUserDataStream(@Query("listenKey") String listenKey);

	/**
	 * .
	 * 
	 * @return The query result
	 * @param listenKey The authenticated account user listen key
	 */
	@Headers(API_H)
	@DELETE(BASE + "userDataStream")
	Call<Void> closeUserDataStream(@Query("listenKey") String listenKey);
}