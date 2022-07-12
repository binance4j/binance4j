package com.binance4j.rebate.client;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.request.RequestExecutor;
import com.binance4j.rebate.record.SpotRebateHistoryRequest;
import com.binance4j.rebate.record.SpotRebateHistoryResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The API client for the SPOT endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#rebate-endpoints">Documentation</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RebateClient extends RestClient<RebateMapping> {

	/**
	 * Constructor
	 *
	 * @param key    The API public key
	 * @param secret The API secret key
	 */
	public RebateClient(String key, String secret) {
		super(RebateMapping.class, key, secret);
	}

	/**
	 * Get the spot rebate history records
	 */
	public RequestExecutor<SpotRebateHistoryResponse> getSpotRebateHistoryRecords(SpotRebateHistoryRequest req) {
		return new RequestExecutor<>(service.getSpotRebateHistoryRecords(req.toMap()), req);
	}
}