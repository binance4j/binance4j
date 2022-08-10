package com.binance4j.rebate.client;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Params;
import com.binance4j.rebate.param.SpotRebateHistoryParams;
import com.binance4j.rebate.request.GetSpotRebateHistoryRecordsRequest;

/**
 * The API client for the SPOT endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#rebate-endpoints">Documentation</a>
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
	public GetSpotRebateHistoryRecordsRequest getSpotRebateHistoryRecords() {
		return new GetSpotRebateHistoryRecordsRequest(
				service.getSpotRebateHistoryRecords(new SpotRebateHistoryParams().toMap()));
	}

	/**
	 * Get the spot rebate history records.
	 * 
	 * @param interval Interval search.
	 * @return The request to execute.
	 */
	public GetSpotRebateHistoryRecordsRequest getSpotRebateHistoryRecords(FramedPaging interval) {
		return new GetSpotRebateHistoryRecordsRequest(
				service.getSpotRebateHistoryRecords(Params.merge(new SpotRebateHistoryParams(), interval)));
	}
}