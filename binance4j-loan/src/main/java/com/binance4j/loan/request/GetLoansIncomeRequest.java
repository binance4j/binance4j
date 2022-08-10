package com.binance4j.loan.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.loan.client.LoanClient;
import com.binance4j.loan.dto.LoanIncome;

import retrofit2.Call;

/** {@link LoanClient#getLoansIncome} request. */
@GetRequest(path = "/sapi/v1/loan/income", rateLimit = RateLimitType.UID, signature = Signature.USER_DATA, weight = 6000)
public class GetLoansIncomeRequest extends Request<List<LoanIncome>> {
	/**
	 * @param call the retrofit call
	 */
	public GetLoansIncomeRequest(Call<List<LoanIncome>> call) {
		super(call);
	}
}
