package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.DustLogRecord;

import retrofit2.Call;

/** {@link MarginClient#getDustLog} request. */
@GetRequest(path = "/sapi/v1/margin/dribblet", signature = Signature.USER_DATA)
public class GetDustLogRequest extends Request<DustLogRecord> {
	/**
	 * @param call the retrofit call
	 */
	public GetDustLogRequest(Call<DustLogRecord> call) {
		super(call);
	}
}
