package com.binance4j.pay.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.pay.dto.TradeHistory;
import com.binance4j.pay.param.TradeHistoryParams;

/**
 * Api client for the pay endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#pay-endpoints">Documentation</a>
 */
public class PayClient extends RestClient<PayMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public PayClient(String key, String secret) {
		super(PayMapping.class, key, secret);
	}

	/**
	 * Get pay trades.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<TradeHistory> getTrades(TradeHistoryParams params) {
		return new Request<>(service.getTrades(params.toMap()));
	}

	/**
	 * Get pay trades.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<TradeHistory> getTrades() {
		return new Request<>(service.getTrades(new TradeHistoryParams().toMap()));
	}
}
