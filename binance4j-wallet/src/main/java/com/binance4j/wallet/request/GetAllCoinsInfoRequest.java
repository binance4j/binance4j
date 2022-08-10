package com.binance4j.wallet.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.CoinInformation;

import retrofit2.Call;

/** {@link WalletClient#getAllCoinsInfo} request. */
@GetRequest(path = "/sapi/v1/capital/config/getall", signature = Signature.USER_DATA, weight = 10)
public class GetAllCoinsInfoRequest extends Request<List<CoinInformation>> {
	/**
	 * @param call the retrofit call
	 */
	public GetAllCoinsInfoRequest(Call<List<CoinInformation>> call) {
		super(call);
	}
}
