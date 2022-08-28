package com.binance4j.loan.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.loan.dto.LoanIncome;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** {@link LoanClient} mapping. */
public interface LoanMapping extends RestMapping {
	/** The base uri. */
	String BASE = "/sapi/v1/loan/";

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "income")
	@Headers({ SIGNED_H, "X-WEIGHT: 6000", UID_H })
	Call<List<LoanIncome>> getLoansIncome(@QueryMap Map<String, Object> map);
}