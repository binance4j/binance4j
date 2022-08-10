package com.binance4j.wallet.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.TradeFee;

import retrofit2.Call;

/** {@link WalletClient#getTradeFee} request. */
@GetRequest(path = "/sapi/v1/asset/tradeFee", signature = Signature.USER_DATA)
public class GetTradeFeeRequest extends Request<List<TradeFee>> {
	/**
	 * @param call the retrofit call
	 */
	public GetTradeFeeRequest(Call<List<TradeFee>> call) {
		super(call);
	}
}
