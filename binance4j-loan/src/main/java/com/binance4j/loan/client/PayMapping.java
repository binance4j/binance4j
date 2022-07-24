package com.binance4j.loan.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.loan.dto.LoanIncome;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** The {@link LoanClient} mapping */
public interface PayMapping {
	/** The base uri */
	String BASE = "/sapi/v1/loan/";
	/** The signed http full header. */
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
	/** The API key http full header. */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "income")
	@Headers({ API_H, SIGNED_H })
	Call<List<LoanIncome>> getLoansIncome(@QueryMap Map<String, Object> map);

}