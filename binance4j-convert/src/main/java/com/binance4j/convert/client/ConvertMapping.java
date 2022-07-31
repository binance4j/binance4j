package com.binance4j.convert.client;

import java.util.Map;

import com.binance4j.convert.dto.ConversionHistory;
import com.binance4j.core.client.RestMapping;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** The {@link ConvertClient} mapping. */
public interface ConvertMapping extends RestMapping {
	/** The base uri. */
	String BASE = "/sapi/v1/convert/";

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "tradeFlow")
	@Headers(SIGNED_H)
	Call<ConversionHistory> getConversions(@QueryMap Map<String, Object> map);
}