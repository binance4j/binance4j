package com.binance4j.rebate.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Params;
import com.binance4j.rebate.dto.SpotRebateHistoryResponse;
import com.binance4j.rebate.param.SpotRebateHistoryParams;

/**
 * The API client for the SPOT endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#rebate-endpoints">Documentation</a>
 */
public class RebateClient extends RestClient<RebateMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
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
	 * @param interval Interval search.
	 * @return The request to execute.
	 */
	public Request<SpotRebateHistoryResponse> getSpotRebateHistoryRecords(FramedPaging interval) {
		return new Request<>(service.getSpotRebateHistoryRecords(Params.merge(new SpotRebateHistoryParams(), interval)));
	}
}