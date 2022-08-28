package com.binance4j.websocket.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.ApiRequest;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.Signature;
import com.binance4j.websocket.client.UserDataClient;

import retrofit2.Call;

/** {@link UserDataClient#keepAliveMarginUserDataStream} request. */
@ApiRequest(method = HttpMethod.PUT, path = "/sapi/v1/userDataStream", signature = Signature.USER_STREAM)
public class KeepAliveMarginUserDataStreamRequest extends Request<Void> {
	/**
	 * @param call the retrofit call
	 */
	public KeepAliveMarginUserDataStreamRequest(Call<Void> call) {
		super(call);
	}
}
