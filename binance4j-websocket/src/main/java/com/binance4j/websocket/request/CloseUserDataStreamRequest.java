package com.binance4j.websocket.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.ApiRequest;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.Signature;
import com.binance4j.websocket.client.UserDataClient;

import retrofit2.Call;

/** {@link UserDataClient#closeUserDataStream(String)} request. */
@ApiRequest(method = HttpMethod.DELETE, path = "/api/v3/userDataStream", signature = Signature.USER_STREAM)
public class CloseUserDataStreamRequest extends Request<Void> {
	/**
	 * @param call the retrofit call
	 */
	public CloseUserDataStreamRequest(Call<Void> call) {
		super(call);
	}
}
