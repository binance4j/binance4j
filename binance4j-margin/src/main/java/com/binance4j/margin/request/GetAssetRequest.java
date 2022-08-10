package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.Asset;

import retrofit2.Call;

/** {@link MarginClient#getAsset} request. */
@GetRequest(path = "/sapi/v1/margin/asset", signature = Signature.MARKET_DATA, weight = 10)
public class GetAssetRequest extends Request<Asset> {
	/**
	 * @param call the retrofit call
	 */
	public GetAssetRequest(Call<Asset> call) {
		super(call);
	}
}
