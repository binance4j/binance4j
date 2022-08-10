package com.binance4j.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.ApiRequest;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;

import retrofit2.Call;

@ApiRequest(isOrder = true, method = HttpMethod.HEAD, path = "/foo/bar/", rateLimit = RateLimitType.UID_AND_IP, signature = Signature.USER_STREAM, weight = 10)
public class VoidRequest extends Request<Void> {
	/**
	 * @param call the retrofit call
	 */
	public VoidRequest(Call<Void> call) {
		super(call);
	}

	public VoidRequest() {
		super(null);
	}

}
