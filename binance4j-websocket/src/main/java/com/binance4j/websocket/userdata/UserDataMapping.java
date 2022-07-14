package com.binance4j.websocket.userdata;

import java.util.Map;

import com.binance4j.core.security.AuthenticationInterceptor;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface UserDataMapping {

	/** The API key http full header */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	// SPOT

	/** @return The query result */
	@Headers(API_H)
	@POST("/api/v3/userDataStream")
	Call<ListenKey> startUserDataStream();

	/**
	 * @param listenKey The authenticated account user listen key
	 * @return The query result
	 */
	@Headers(API_H)
	@PUT("/api/v3/userDataStream")
	Call<Void> keepAliveUserDataStream(@Query("listenKey") String listenKey);

	/**
	 * @param listenKey The authenticated account user listen key
	 * @return The query result
	 */
	@Headers(API_H)
	@DELETE("/api/v3/userDataStream")
	Call<Void> closeUserDataStream(@Query("listenKey") String listenKey);

	// MARGIN

	@Headers(API_H)
	@POST("/sapi/v1/userDataStream")
	Call<ListenKey> startMarginUserDataStream();

	@Headers(API_H)
	@PUT("/sapi/v1/userDataStream")
	Call<Void> keepAliveMarginUserDataStream(@Query("listenKey") String listenKey);

	@Headers(API_H)
	@DELETE("/sapi/v1/userDataStream")
	Call<Void> closeMarginUserDataStream(@Query("listenKey") String listenKey);

	// ISOLATED

	@Headers(API_H)
	@POST("/sapi/v1/userDataStream/isolated")
	Call<ListenKey> startIsolatedUserDataStream(@QueryMap Map<String, Object> map);

	@Headers(API_H)
	@PUT("/sapi/v1/userDataStream/isolated")
	Call<Void> keepAliveIsolatedUserDataStream(@QueryMap Map<String, Object> map);

	@Headers(API_H)
	@DELETE("/sapi/v1/userDataStream/isolated")
	Call<Void> closeIsolatedUserDataStream(@QueryMap Map<String, Object> map);
}