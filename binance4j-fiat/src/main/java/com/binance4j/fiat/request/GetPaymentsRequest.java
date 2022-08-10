package com.binance4j.fiat.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.fiat.client.FiatClient;
import com.binance4j.fiat.dto.PaymentHistory;

import retrofit2.Call;

/** {@link FiatClient#getPayments} request. */
@GetRequest(path = "/sapi/v1/fiat/payments", isOrder = false, signature = Signature.USER_DATA, weight = 1)
public class GetPaymentsRequest extends Request<PaymentHistory> {
	/**
	 * @param call the retrofit call
	 */
	public GetPaymentsRequest(Call<PaymentHistory> call) {
		super(call);
	}
}
