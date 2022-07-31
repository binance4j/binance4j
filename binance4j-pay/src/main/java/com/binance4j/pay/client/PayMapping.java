package com.binance4j.pay.client;

import java.util.Map;
import com.binance4j.core.client.RestMapping;
import com.binance4j.pay.dto.TradeHistory;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** The {@link PayClient} mapping. */
public interface PayMapping extends RestMapping {
	/** The base uri. */
	String BASE = "/sapi/v1/pay/";

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "transactions")
	@Headers(SIGNED_H)
	Call<TradeHistory> getTrades(@QueryMap Map<String, Object> map);
}