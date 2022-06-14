package com.binance4j.websocket.userdata;

import com.binance4j.core.security.AuthenticationInterceptor;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserDataMapping {
	/**
	 * The API key http full header
	 */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	/**
	 * @return The query result
	 */
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
}