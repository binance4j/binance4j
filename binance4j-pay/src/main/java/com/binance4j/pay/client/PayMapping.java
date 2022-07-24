package com.binance4j.pay.client;

import java.util.Map;

import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.pay.dto.TradeHistory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** The {@link PayClient} mapping */
public interface PayMapping {
	/** The base uri */
	String BASE = "/sapi/v1/pay/";
	/** The signed http full header. */
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
	/** The API key http full header. */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "transactions")
	@Headers({ API_H, SIGNED_H })
	Call<TradeHistory> getTrades(@QueryMap Map<String, Object> map);

}