package com.binance4j.c2c.client;

import java.util.Map;

import com.binance4j.c2c.dto.TradeHistory;
import com.binance4j.core.client.RestMapping;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** The {@link C2CClient} mapping. */
public interface C2CMapping extends RestMapping {
	/** The base uri. */
	String BASE = "/sapi/v1/c2c/";

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "orderMatch/listUserOrderHistory")
	@Headers(SIGNED_H)
	Call<TradeHistory> getTrades(@QueryMap Map<String, Object> map);
}