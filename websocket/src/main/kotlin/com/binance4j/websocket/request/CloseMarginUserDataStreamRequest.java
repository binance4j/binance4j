package com.binance4j.websocket.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.ApiRequest;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.Signature;
import com.binance4j.websocket.client.UserDataClient;

import retrofit2.Call;

/** [UserDataClient.closeMarginUserDataStream] request. */
@ApiRequest(method = HttpMethod.DELETE, path = "/sapi/v1/userDataStream", signature = Signature.USER_STREAM)
public class CloseMarginUserDataStreamRequest extends Request<Void> {
	/**
	 * @param call the retrofit call
	 */
	public CloseMarginUserDataStreamRequest(Call<Void> call) {
		super(call);
	}
}
