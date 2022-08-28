package com.binance4j.mining.client;

import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.mining.dto.AccountListResponse;
import com.binance4j.mining.dto.AccountProfitsResponse;
import com.binance4j.mining.dto.AlgorithmsResponse;
import com.binance4j.mining.dto.CoinsResponse;
import com.binance4j.mining.dto.HashrateResaleCancellationResponse;
import com.binance4j.mining.dto.HashrateResaleDetailResponse;
import com.binance4j.mining.dto.HashrateResaleListResponse;
import com.binance4j.mining.dto.HashrateResaleResponse;
import com.binance4j.mining.dto.MinerDetailsResponse;
import com.binance4j.mining.dto.OtherProfitsResponse;
import com.binance4j.mining.dto.ProfitResponse;
import com.binance4j.mining.dto.StatisticsResponse;
import com.binance4j.mining.dto.WorkersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/** {@link MiningClient} mapping. */
public interface MiningMapping extends RestMapping {
	/** The base uri. */
	String BASE = "/sapi/v1/mining/";

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "pub/algoList")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<AlgorithmsResponse> getAlgorithms(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "pub/coinList")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<CoinsResponse> getCoins(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "worker/detail")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<MinerDetailsResponse> getMinersDetails(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "worker/list")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<WorkersResponse> getMiners(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "payment/list")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<ProfitResponse> getProfits(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "payment/other")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<OtherProfitsResponse> getOtherProfits(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "payment/uid")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<AccountProfitsResponse> getAccountProfits(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "hash-transfer/config/details/list")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<HashrateResaleListResponse> getHashrateResales(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "hash-transfer/profit/details")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<HashrateResaleDetailResponse> getHashrateResalesDetails(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@POST(BASE + "hash-transfer/config")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<HashrateResaleResponse> resellHashrate(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@POST(BASE + "hash-transfer/config/cancel")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<HashrateResaleCancellationResponse> cancelHashrateResaleConfiguration(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "statistics/user/status")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<StatisticsResponse> getStatistics(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "statistics/user/list")
	@Headers({ SIGNED_H, IP_H, "X-WEIGHT: 5" })
	Call<AccountListResponse> getAccounts(@QueryMap Map<String, Object> map);
}