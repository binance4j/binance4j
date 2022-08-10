package com.binance4j.wallet.request;

import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.AssetDetail;

import retrofit2.Call;

/** {@link WalletClient#getAssetDetail} request. */
@GetRequest(path = "/sapi/v1/asset/assetDetail", signature = Signature.USER_DATA)
public class GetAssetDetailRequest extends Request<Map<String, AssetDetail>> {
	/**
	 * @param call the retrofit call
	 */
	public GetAssetDetailRequest(Call<Map<String, AssetDetail>> call) {
		super(call);
	}
}
