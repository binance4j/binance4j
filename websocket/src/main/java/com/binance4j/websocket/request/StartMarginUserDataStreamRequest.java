package com.binance4j.websocket.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.websocket.client.UserDataClient;
import com.binance4j.websocket.dto.ListenKey;

import retrofit2.Call;

/** {@link UserDataClient#startMarginUserDataStream} request. */
@PostRequest(path = "/api/v3/userDataStream", signature = Signature.USER_STREAM)
public class StartMarginUserDataStreamRequest extends Request<ListenKey> {
	/**
	 * @param call the retrofit call
	 */
	public StartMarginUserDataStreamRequest(Call<ListenKey> call) {
		super(call);
	}
}
