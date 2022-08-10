package com.binance4j.savings.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.Purchase;

import retrofit2.Call;

/** {@link SavingsClient#getPurchases} request. */
@GetRequest(path = "/sapi/v1/lending/union/purchaseRecord", signature = Signature.USER_DATA)
public class GetPurchasesRequest extends Request<List<Purchase>> {
	/**
	 * @param call the retrofit call
	 */
	public GetPurchasesRequest(Call<List<Purchase>> call) {
		super(call);
	}
}
