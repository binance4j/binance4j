package com.binance4j.blvt.client;

import java.util.List;
import java.util.Map;

import com.binance4j.blvt.dto.LimitInfo;
import com.binance4j.blvt.dto.Redemption;
import com.binance4j.blvt.dto.RedemptionResponse;
import com.binance4j.blvt.dto.Subscription;
import com.binance4j.blvt.dto.SubscriptionResponse;
import com.binance4j.blvt.dto.Token;
import com.binance4j.core.client.RestMapping;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/** The {@link BLVTClient} mapping. */
public interface BLVTMapping extends RestMapping {
	/** The base uri. */
	String BASE = "/sapi/v1/blvt/";

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "tokenInfo")
	@Headers(SIGNED_H)
	Call<List<Token>> getTokenInfo(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@POST(BASE + "subscribe")
	@Headers(SIGNED_H)
	Call<SubscriptionResponse> subscribe(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "subscribe/record")
	@Headers(SIGNED_H)
	Call<List<Subscription>> getSubscriptions(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@POST(BASE + "redeem")
	@Headers(SIGNED_H)
	Call<RedemptionResponse> redeem(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "redeem/record")
	@Headers(SIGNED_H)
	Call<List<Redemption>> getRedemptions(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "userLimit")
	@Headers(SIGNED_H)
	Call<List<LimitInfo>> getLimitInfo(@QueryMap Map<String, Object> map);
}