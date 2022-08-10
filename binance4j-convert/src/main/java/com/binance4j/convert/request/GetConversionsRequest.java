package com.binance4j.convert.request;

import com.binance4j.convert.client.ConvertClient;
import com.binance4j.convert.dto.ConversionHistory;
import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;

import retrofit2.Call;

/** {@link ConvertClient#getConversions} request. */
@GetRequest(path = "/sapi/v1/convert/tradeFlow", signature = Signature.USER_DATA, weight = 3000)
public class GetConversionsRequest extends Request<ConversionHistory> {
	/**
	 * @param call the retrofit call
	 */
	public GetConversionsRequest(Call<ConversionHistory> call) {
		super(call);
	}
}
