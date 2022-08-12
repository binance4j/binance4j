package com.binance4j.core.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.dto.RateLimit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/** Simple client for fetching API Rate Limits. */
public class RateLimitClient extends RestClient<RateLimitClient.RateLimitMapping> {
	/** Constructor. */
	public RateLimitClient() {
		super(RateLimitMapping.class, "", "");
	}

	/**
	 * @return Exchange info.
	 */
	public GetRateLimitRequest getExchangeInfo() {
		return new GetRateLimitRequest(service.getExchangeInfo(Map.of("symbol", "BNBBUSD")));
	}

	/** Mapping. */
	public interface RateLimitMapping extends RestMapping {
		/**
		 * @param map map
		 * @return Rate limits.
		 */
		@GET("/api/v3/exchangeInfo")
		Call<RateLimits> getExchangeInfo(@QueryMap Map<String, Object> map);
	}

	/** Request. */
	public class GetRateLimitRequest extends Request<RateLimits> {
		/**
		 * Constructor.
		 * 
		 * @param call call.
		 */
		public GetRateLimitRequest(Call<RateLimits> call) {
			super(call);
		}
	}

	/**
	 * Rate limits wrapper.
	 * 
	 * @param rateLimits rate limits.
	 */
	public record RateLimits(List<RateLimit> rateLimits) {
	}
}