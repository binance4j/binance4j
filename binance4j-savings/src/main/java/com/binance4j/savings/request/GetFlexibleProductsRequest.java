package com.binance4j.savings.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.FlexibleProduct;

import retrofit2.Call;

/** {@link SavingsClient#getFlexibleProducts} request. */
@GetRequest(path = "/sapi/v1/lending/daily/product/list", signature = Signature.USER_DATA)
public class GetFlexibleProductsRequest extends Request<List<FlexibleProduct>> {
	/**
	 * @param call the retrofit call
	 */
	public GetFlexibleProductsRequest(Call<List<FlexibleProduct>> call) {
		super(call);
	}
}
