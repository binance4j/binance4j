package com.binance4j.convert.client;

import com.binance4j.convert.dto.ConversionHistory;
import com.binance4j.convert.param.ConversionParams;
import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;

/**
 * Api client for the convert endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#convert-endpoints">Documentation</a>
 */
public class ConvertClient extends RestClient<ConvertMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public ConvertClient(String key, String secret) {
		super(ConvertMapping.class, key, secret);
	}

	/**
	 * Get assets conversion history.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<ConversionHistory> getConversions(TimeFrame params) {
		return new Request<>(service.getConversions(Params.merge(new ConversionParams(), params)));
	}
}
