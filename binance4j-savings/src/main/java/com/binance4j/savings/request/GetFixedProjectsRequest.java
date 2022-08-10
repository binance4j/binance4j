package com.binance4j.savings.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.FixedProject;

import retrofit2.Call;

/** {@link SavingsClient#getFixedProjects} request. */
@GetRequest(path = "/sapi/v1/lending/project/list", signature = Signature.USER_DATA)
public class GetFixedProjectsRequest extends Request<List<FixedProject>> {
	/**
	 * @param call the retrofit call
	 */
	public GetFixedProjectsRequest(Call<List<FixedProject>> call) {
		super(call);
	}
}
