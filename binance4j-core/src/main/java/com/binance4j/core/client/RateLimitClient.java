package com.binance4j.core.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.dto.RateLimit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
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
	public GetRateLimitRequest getRateLimits() {
		return new GetRateLimitRequest(service.getRateLimits(Map.of("symbol", "BNBBUSD")));
	}

	/** Mapping. */
	public interface RateLimitMapping extends RestMapping {
		/**
		 * @param map map
		 * @return Rate limits.
		 */
		@GET("/api/v3/exchangeInfo")
		@Headers({ "X-WEIGHT: 10" })
		Call<RateLimits> getRateLimits(@QueryMap Map<String, Object> map);
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
		/**
		 * @return THe first "REQUEST_WEIGHT" rate limit
		 */
		public RateLimit getRequestWeight() {
			return rateLimits.stream().filter(rl -> rl.rateLimitType().equals("REQUEST_WEIGHT")).findFirst().get();
		}

		/**
		 * @return THe first "ORDERS" rate limit
		 */
		public RateLimit getOrders() {
			return rateLimits.stream().filter(rl -> rl.rateLimitType().equals("ORDERS")).findFirst().get();
		}

		/**
		 * @return THe first "RAW_REQUESTS" rate limit
		 */
		public RateLimit getRawRequests() {
			return rateLimits.stream().filter(rl -> rl.rateLimitType().equals("RAW_REQUESTS")).findFirst().get();
		}
	}
}