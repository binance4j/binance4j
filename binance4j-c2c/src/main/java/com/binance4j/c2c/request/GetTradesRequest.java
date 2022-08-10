package com.binance4j.c2c.request;

import com.binance4j.c2c.client.C2CClient;
import com.binance4j.c2c.dto.TradeHistory;
import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;

import retrofit2.Call;

/** {@link C2CClient#getTrades} request. */
@GetRequest(path = "/sapi/v1/c2c/orderMatch/listUserOrderHistory", isOrder = false, signature = Signature.USER_DATA, weight = 1)
public class GetTradesRequest extends Request<TradeHistory> {
	/**
	 * @param call the retrofit call
	 */
	public GetTradesRequest(Call<TradeHistory> call) {
		super(call);
	}
}
