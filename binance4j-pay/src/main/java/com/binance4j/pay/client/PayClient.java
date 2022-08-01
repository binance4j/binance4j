package com.binance4j.pay.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
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
	 * @return The request to execute.
	 */
	public Request<TradeHistory> getTrades() {
		return new Request<>(service.getTrades(new TradeHistoryParams().toMap()));
	}

	/**
	 * Get pay trades.
	 * 
	 * @param timeFrame The time frame.
	 * @return The request to execute.
	 */
	public Request<TradeHistory> getTrades(TimeFrame timeFrame) {
		return new Request<>(service.getTrades(Params.merge(new TradeHistoryParams(), timeFrame)));
	}
}
