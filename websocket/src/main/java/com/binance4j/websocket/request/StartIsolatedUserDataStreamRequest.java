package com.binance4j.websocket.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.websocket.client.UserDataClient;
import com.binance4j.websocket.dto.ListenKey;

import retrofit2.Call;

/** {@link UserDataClient#startIsolatedUserDataStream} request. */
@PostRequest(path = "/api/v3/userDataStream/isolated", signature = Signature.USER_STREAM)
public class StartIsolatedUserDataStreamRequest extends Request<ListenKey> {
	/**
	 * @param call the retrofit call
	 */
	public StartIsolatedUserDataStreamRequest(Call<ListenKey> call) {
		super(call);
	}
}
