package com.binance4j.portfoliomargin.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.portfoliomargin.dto.AccountInfo;
import com.binance4j.portfoliomargin.dto.CollaterateRateInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** The {@link PortfolioMarginClient} mapping */
public interface PortfolioMarginMapping {
	/** The base uri */
	String BASE = "/sapi/v1/portfolio/";
	/** The signed http full header. */
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
	/** The API key http full header. */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "account")
	@Headers({ API_H, SIGNED_H })
	Call<AccountInfo> getAccountInfo(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "collateralRate")
	@Headers({ API_H })
	Call<List<CollaterateRateInfo>> getCollateralRate(@QueryMap Map<String, Object> map);
}