package com.binance4j.pay.client;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.pay.param.TradeHistoryParams;
import com.binance4j.pay.request.GetTradesRequest;

/**
 * Api client for the pay endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#pay-endpoints">Documentation</a>
 */
public class PayClient extends RestClient<PayMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public PayClient(String key, String secret) {
		super(PayMapping.class, key, secret);
	}

	/**
	 * Get pay trades.
	 * 
	 * @return The request to execute.
	 */
	public GetTradesRequest getTrades() {
		return new GetTradesRequest(service.getTrades(new TradeHistoryParams().toMap()));
	}

	/**
	 * Get pay trades.
	 * 
	 * @param timeFrame Time frame.
	 * @return The request to execute.
	 */
	public GetTradesRequest getTrades(TimeFrame timeFrame) {
		return new GetTradesRequest(service.getTrades(Params.merge(new TradeHistoryParams(), timeFrame)));
	}
}
