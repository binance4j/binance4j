package com.binance4j.c2c.client;

import java.util.Map;

import com.binance4j.c2c.dto.TradeHistory;
import com.binance4j.core.security.AuthenticationInterceptor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** The {@link C2CClient} mapping */
public interface C2CMapping {
	/** The base uri */
	String BASE = "/sapi/v1/c2c/";
	/** The signed http full header. */
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
	/** The API key http full header. */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "orderMatch/listUserOrderHistory")
	@Headers({ API_H, SIGNED_H })
	Call<TradeHistory> getTrades(@QueryMap Map<String, Object> map);

}