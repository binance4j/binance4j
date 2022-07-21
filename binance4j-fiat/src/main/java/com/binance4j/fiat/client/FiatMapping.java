package com.binance4j.fiat.client;

import java.util.Map;

import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.fiat.dto.PaymentHistory;
import com.binance4j.fiat.dto.TransactionHistory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** The {@link FiatClient} mapping */
public interface FiatMapping {
	/** The base uri */
	String BASE = "/sapi/v1/fiat/";
	/** The signed http full header. */
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
	/** The API key http full header. */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "orders")
	@Headers({ API_H, SIGNED_H })
	Call<TransactionHistory> getTransactions(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "payments")
	@Headers({ API_H, SIGNED_H })
	Call<PaymentHistory> getPayments(@QueryMap Map<String, Object> map);
}