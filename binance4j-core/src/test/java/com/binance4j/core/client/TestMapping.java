package com.binance4j.core.client;

import com.binance4j.core.pojo.ServerTime;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TestMapping extends RestMapping {
	String BASE = "/api/v3/";

	@GET(BASE + "ping")
	Call<Void> ping();

	@GET(BASE + "time")
	Call<ServerTime> time();

	@GET(BASE + "notfound")
	Call<Void> notFound();
}
