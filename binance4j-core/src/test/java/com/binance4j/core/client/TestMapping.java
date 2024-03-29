package com.binance4j.core.client;

import com.binance4j.core.pojo.ServerTimeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface TestMapping extends RestMapping {
	String BASE = "/api/v3/";

	@GET(BASE + "ping")
	@Headers({ "X-WEIGHT: 3", IP_H, IS_ORDER_H })
	Call<Void> ping();

	@GET(BASE + "time")
	@Headers({ "X-WEIGHT: 5", IP_H })
	Call<ServerTimeResponse> time();

	@GET(BASE + "notfound")
	@Headers({ "X-WEIGHT: 5", IP_H })
	Call<Void> notFound();
}
