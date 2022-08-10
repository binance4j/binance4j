package com.binance4j.wallet.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.FundingAsset;

import retrofit2.Call;

/** {@link WalletClient#getFundingWallet} request. */
@PostRequest(path = "/sapi/v1/asset/get-funding-asset", signature = Signature.USER_DATA)
public class GetFundingWalletRequest extends Request<List<FundingAsset>> {
	/**
	 * @param call the retrofit call
	 */
	public GetFundingWalletRequest(Call<List<FundingAsset>> call) {
		super(call);
	}
}
