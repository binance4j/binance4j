package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.Asset;

import retrofit2.Call;

/** {@link MarginClient#getAllAssets} request. */
@GetRequest(path = "/sapi/v1/margin/allAssets", signature = Signature.MARKET_DATA, weight = 1)
public class GetAllAssetsRequest extends Request<List<Asset>> {
	/**
	 * @param call the retrofit call
	 */
	public GetAllAssetsRequest(Call<List<Asset>> call) {
		super(call);
	}
}
