package com.binance4j.rebate.client;

import java.util.Map;

import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.rebate.dto.SpotRebateHistoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** The {@link RebateClient} mapping. */
public interface RebateMapping {
	/** The API base url. */
	String BASE = "/sapi/v1/rebate/";
	/** The signed http full header. */
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
	/** The API key http full header. */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	/**
	 * @param map The query map
	 * @return The server response
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "taxQuery")
	Call<SpotRebateHistoryResponse> getSpotRebateHistoryRecords(@QueryMap Map<String, Object> map);
}