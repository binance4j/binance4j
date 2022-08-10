package com.binance4j.c2c.client;

import com.binance4j.c2c.dto.TradeHistory;
import com.binance4j.c2c.param.TradeHistoryParams;
import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.Params;

/**
 * Api client for the c2c endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#convert-endpoints">Documentation</a>
 */
public class C2CClient extends RestClient<C2CMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public C2CClient(String key, String secret) {
		super(C2CMapping.class, key, secret);
	}

	/**
	 * Get C2C trades.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<TradeHistory> getTrades(TradeHistoryParams params, Paging paging) {
		return new Request<>(service.getTrades(Params.merge(params, paging)));
	}

	/**
	 * Get C2C trades.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<TradeHistory> getTrades(TradeHistoryParams params) {
		return new Request<>(service.getTrades(params.toMap()));
	}
}
