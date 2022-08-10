package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.ConvertibleAssets;

import retrofit2.Call;

/** {@link WalletClient#getConvertibleAssets} request. */
@GetRequest(path = "/sapi/v1/asset/dust-btc", signature = Signature.USER_DATA)
public class GetConvertibleAssetsRequest extends Request<ConvertibleAssets> {
	/**
	 * @param call the retrofit call
	 */
	public GetConvertibleAssetsRequest(Call<ConvertibleAssets> call) {
		super(call);
	}
}
