package com.binance4j.fiat.client;

import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.fiat.dto.PaymentHistory;
import com.binance4j.fiat.dto.TransactionHistory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** {@link FiatClient} mapping. */
public interface FiatMapping extends RestMapping {
	/** The base uri. */
	String BASE = "/sapi/v1/fiat/";

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "orders")
	@Headers({ SIGNED_H, WEIGHT_ONE_H, IP_H })
	Call<TransactionHistory> getTransactions(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "payments")
	@Headers({ SIGNED_H, WEIGHT_ONE_H, IP_H })
	Call<PaymentHistory> getPayments(@QueryMap Map<String, Object> map);
}