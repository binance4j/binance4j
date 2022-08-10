package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.ForceLiquidationRecords;

import retrofit2.Call;

/** {@link MarginClient#getForceLiquidationRecord} request. */
@GetRequest(path = "/sapi/v1/margin/forceLiquidationRec", signature = Signature.USER_DATA, weight = 1)
public class GetForceLiquidationRecordRequest extends Request<ForceLiquidationRecords> {
	/**
	 * @param call the retrofit call
	 */
	public GetForceLiquidationRecordRequest(Call<ForceLiquidationRecords> call) {
		super(call);
	}
}
