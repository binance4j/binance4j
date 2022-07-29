package com.binance4j.rebate.client;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Page;
import com.binance4j.core.param.TimeIntervalParams;
import com.binance4j.rebate.dto.SpotRebateHistoryResponse;
import com.binance4j.rebate.param.SpotRebateHistoryParams;

/**
 * The API client for the SPOT endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#rebate-endpoints">Documentation</a>
 */
public class RebateClient extends RestClient<RebateMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public RebateClient(String key, String secret) {
		super(RebateMapping.class, key, secret);
	}

	/**
	 * Get the spot rebate history records.
	 * 
	 * @return The request to execute.
	 */
	public Request<SpotRebateHistoryResponse> getSpotRebateHistoryRecords() {
		return new Request<>(service.getSpotRebateHistoryRecords(new SpotRebateHistoryParams().toMap()));
	}

	/**
	 * Get the spot rebate history records.
	 * 
	 * @param intervalParams The interval search.
	 * @param page           The results page.
	 * @return The request to execute.
	 */
	public Request<SpotRebateHistoryResponse> getSpotRebateHistoryRecords(TimeIntervalParams intervalParams, Page page) {
		return new Request<>(service.getSpotRebateHistoryRecords(new SpotRebateHistoryParams().toMap(List.of(intervalParams.toMap(), page.toMap()))));
	}

	/**
	 * Get the spot rebate history records.
	 * 
	 * @param page The results page.
	 * @return The request to execute.
	 */
	public Request<SpotRebateHistoryResponse> getSpotRebateHistoryRecords(Page page) {
		return new Request<>(service.getSpotRebateHistoryRecords(new SpotRebateHistoryParams().toMap(page)));
	}

	/**
	 * Get the spot rebate history records.
	 * 
	 * @param intervalParams The interval search.
	 * @return The request to execute.
	 */
	public Request<SpotRebateHistoryResponse> getSpotRebateHistoryRecords(TimeIntervalParams intervalParams) {
		return new Request<>(service.getSpotRebateHistoryRecords(new SpotRebateHistoryParams().toMap(intervalParams)));
	}
}