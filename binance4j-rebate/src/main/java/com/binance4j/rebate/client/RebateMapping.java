package com.binance4j.rebate.client;

import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.rebate.dto.SpotRebateHistoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** {@link RebateClient} mapping. */
public interface RebateMapping extends RestMapping {
	/** The API base url. */
	String BASE = "/sapi/v1/rebate/";

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ SIGNED_H, UID_H, "X-WEIGHT: 3000" })
	@GET(BASE + "taxQuery")
	Call<SpotRebateHistoryResponse> getSpotRebateHistoryRecords(@QueryMap Map<String, Object> map);
}