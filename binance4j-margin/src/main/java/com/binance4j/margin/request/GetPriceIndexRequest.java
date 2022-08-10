package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.PriceIndex;

import retrofit2.Call;

/** {@link MarginClient#getPriceIndex} request. */
@GetRequest(path = "/sapi/v1/margin/priceIndex", signature = Signature.MARKET_DATA, weight = 1)
public class GetPriceIndexRequest extends Request<PriceIndex> {
	/**
	 * @param call the retrofit call
	 */
	public GetPriceIndexRequest(Call<PriceIndex> call) {
		super(call);
	}
}
