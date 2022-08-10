package com.binance4j.nft.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.dto.AssetHistory;

import retrofit2.Call;

/** {@link NFTClient#getAssets} request. */
@GetRequest(path = "/sapi/v1/nft/user/getAsset", signature = Signature.USER_DATA, rateLimit = RateLimitType.UID, weight = 3000)
public class GetAssetsRequest extends Request<AssetHistory> {
	/**
	 * @param call the retrofit call
	 */
	public GetAssetsRequest(Call<AssetHistory> call) {
		super(call);
	}
}
