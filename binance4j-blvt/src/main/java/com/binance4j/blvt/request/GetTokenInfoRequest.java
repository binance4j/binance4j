package com.binance4j.blvt.request;

import java.util.List;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.blvt.dto.Token;
import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;

import retrofit2.Call;

/** {@link BLVTClient#getTokenInfo} request. */
@GetRequest(path = "/sapi/v1/blvt/tokenInfo")
public class GetTokenInfoRequest extends Request<List<Token>> {
	/**
	 * @param call the retrofit call
	 */
	public GetTokenInfoRequest(Call<List<Token>> call) {
		super(call);
	}
}
