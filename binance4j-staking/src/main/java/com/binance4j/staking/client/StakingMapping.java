package com.binance4j.staking.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.staking.dto.AutoStakingResponse;
import com.binance4j.staking.dto.LeftQuota;
import com.binance4j.staking.dto.Product;
import com.binance4j.staking.dto.ProductPosition;
import com.binance4j.staking.dto.PurchaseResponse;
import com.binance4j.staking.dto.RedeemResponse;
import com.binance4j.staking.dto.StakingRecord;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/** {@link StakingClient} mapping. */
public interface StakingMapping extends RestMapping {
	/** The base uri. */
	String BASE = "/sapi/v1/staking/";

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "productList")
	@Headers(SIGNED_H)
	Call<List<Product>> getProductList(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@POST(BASE + "purchase")
	@Headers(SIGNED_H)
	Call<PurchaseResponse> purchase(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@POST(BASE + "redeem")
	@Headers(SIGNED_H)
	Call<RedeemResponse> redeem(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "position")
	@Headers(SIGNED_H)
	Call<List<ProductPosition>> getPosition(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "stakingRecord")
	@Headers(SIGNED_H)
	Call<List<StakingRecord>> getHistory(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "setAutoStaking")
	@Headers(SIGNED_H)
	Call<AutoStakingResponse> setAutoStaking(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "personalLeftQuota")
	@Headers(SIGNED_H)
	Call<LeftQuota> getLeftQuota(@QueryMap Map<String, Object> map);
}