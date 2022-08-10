package com.binance4j.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.pojo.ServerTimeResponse;

import retrofit2.Call;

@GetRequest(path = "/api/v3/time")
public class GetServerTimeRequest extends Request<ServerTimeResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetServerTimeRequest(Call<ServerTimeResponse> call) {
		super(call);
	}
}
