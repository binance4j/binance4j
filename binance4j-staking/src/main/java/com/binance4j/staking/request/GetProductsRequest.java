package com.binance4j.staking.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.Product;

import retrofit2.Call;

/** {@link StakingClient#getProducts} request. */
@GetRequest(path = "/sapi/v1/staking/productList", signature = Signature.USER_DATA)
public class GetProductsRequest extends Request<List<Product>> {
	/**
	 * @param call the retrofit call
	 */
	public GetProductsRequest(Call<List<Product>> call) {
		super(call);
	}
}
