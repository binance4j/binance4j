package com.binance4j.portfoliomargin.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.portfoliomargin.dto.AccountInfo;
import com.binance4j.portfoliomargin.dto.CollaterateRateInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** {@link PortfolioMarginClient} mapping. */
public interface PortfolioMarginMapping extends RestMapping {
	/** The base uri. */
	String BASE = "/sapi/v1/portfolio/";

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "account")
	@Headers({ SIGNED_H, IP_H, WEIGHT_ONE_H })
	Call<AccountInfo> getAccountInfo(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "collateralRate")
	@Headers({ API_H, IP_H, "X-WEIGHT: 50" })
	Call<List<CollaterateRateInfo>> getCollateralRate(@QueryMap Map<String, Object> map);
}