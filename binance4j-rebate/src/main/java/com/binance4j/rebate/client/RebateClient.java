package com.binance4j.rebate.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.rebate.dto.SpotRebateHistoryResponse;
import com.binance4j.rebate.param.SpotRebateHistoryParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The API client for the SPOT endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#rebate-endpoints">Documentation</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RebateClient extends RestClient<RebateMapping> {

	/**
	 * @param key    The API public key
	 * @param secret The API secret key
	 */
	public RebateClient(String key, String secret) {
		super(RebateMapping.class, key, secret);
	}

	/**
	 * Get the spot rebate history records.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<SpotRebateHistoryResponse> getSpotRebateHistoryRecords(SpotRebateHistoryParams params) {
		return new Request<>(service.getSpotRebateHistoryRecords(params.toMap()));
	}
}