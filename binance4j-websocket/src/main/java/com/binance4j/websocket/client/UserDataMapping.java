package com.binance4j.websocket.client;

import com.binance4j.core.misc.ListenKey;
import com.binance4j.core.security.AuthenticationInterceptor;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface UserDataMapping {
	/** The API key http full header */
	public static final String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	/**
	 * @return The query result
	 */
	@Headers(API_H)
	@POST("/api/v3/userDataStream")
	Call<ListenKey> startUserDataStream();

	/**
	 * @return The query result
	 * @param listenKey The authenticated account user listen key
	 */
	@Headers(API_H)
	@PUT("/api/v3/userDataStream")
	Call<Void> keepAliveUserDataStream(@Query("listenKey") String listenKey);

	/**
	 * @return The query result
	 * @param listenKey The authenticated account user listen key
	 */
	@Headers(API_H)
	@DELETE("/api/v3/userDataStream")
	Call<Void> closeUserDataStream(@Query("listenKey") String listenKey);
}