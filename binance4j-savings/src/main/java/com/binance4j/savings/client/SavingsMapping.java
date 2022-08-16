package com.binance4j.savings.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.savings.dto.FixedProject;
import com.binance4j.savings.dto.FixedProjectPosition;
import com.binance4j.savings.dto.FlexibleProduct;
import com.binance4j.savings.dto.FlexibleProductPosition;
import com.binance4j.savings.dto.Interest;
import com.binance4j.savings.dto.LendingAccount;
import com.binance4j.savings.dto.PositionChangedResponse;
import com.binance4j.savings.dto.Purchase;
import com.binance4j.savings.dto.PurchaseQuota;
import com.binance4j.savings.dto.PurchaseResponse;
import com.binance4j.savings.dto.Redemption;
import com.binance4j.savings.dto.RedemptionQuota;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/** {@link SavingsClient} mapping. */
public interface SavingsMapping extends RestMapping {
	/** The base uri. */
	String BASE = "/sapi/v1/lending/";

	// FLEXIBLE //

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "daily/product/list")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<List<FlexibleProduct>> getFlexibleProducts(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "daily/userLeftQuota")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<PurchaseQuota> getLeftDailyFlexiblePurchaseQuota(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@POST(BASE + "daily/purchase")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<PurchaseResponse> purchaseFlexible(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "daily/userRedemptionQuota")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<RedemptionQuota> getLeftDailyRedemptionQuota(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@POST(BASE + "daily/redeem")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<Void> redeemFlexible(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "daily/token/position")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<List<FlexibleProductPosition>> getFlexibleProductPosition(@QueryMap Map<String, Object> map);

	// FIXED //

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "project/list")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<List<FixedProject>> getFixedProjects(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@POST(BASE + "customizedFixed/purchase")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<PurchaseResponse> purchaseFixed(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "project/position/list")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<List<FixedProjectPosition>> getFixedProjectPosition(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "union/account")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<LendingAccount> getAccount(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "union/purchaseRecord")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<List<Purchase>> getPurchases(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "union/redemptionRecord")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<List<Redemption>> getRedemptions(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "union/interestHistory")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<List<Interest>> getInterests(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@POST(BASE + "positionChanged")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<PositionChangedResponse> fixedToDailyPosition(@QueryMap Map<String, Object> map);
}