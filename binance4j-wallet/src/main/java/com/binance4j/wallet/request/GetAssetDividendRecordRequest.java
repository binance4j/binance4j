package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.AssetDividendRecord;

import retrofit2.Call;

/** {@link WalletClient#getAssetDividendRecord} request. */
@GetRequest(path = "/sapi/v1/asset/assetDividend", signature = Signature.USER_DATA, weight = 10)
public class GetAssetDividendRecordRequest extends Request<AssetDividendRecord> {
	/**
	 * @param call the retrofit call
	 */
	public GetAssetDividendRecordRequest(Call<AssetDividendRecord> call) {
		super(call);
	}
}
