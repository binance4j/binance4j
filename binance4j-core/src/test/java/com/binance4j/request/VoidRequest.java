package com.binance4j.request;

import com.binance4j.core.Request;

import retrofit2.Call;

public class VoidRequest extends Request<Void> {
	/**
	 * @param call the retrofit call
	 */
	public VoidRequest(Call<Void> call) {
		super(call);
	}
}
