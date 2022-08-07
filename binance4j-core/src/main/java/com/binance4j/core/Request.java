package com.binance4j.core;

import java.io.IOException;

import com.binance4j.core.callback.ApiCallback;
import com.binance4j.core.callback.ApiCallbackAdapter;
import com.binance4j.core.exception.ApiError;
import com.binance4j.core.exception.ApiException;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Call;
import retrofit2.Response;

/** A class that receives and executes sync and async retrofit calls. */
public class Request<T> {
	/** The Jackson Object mapper for deserializing the Api error response. */
	static final ObjectMapper MAPPER = new ObjectMapper();
	/** The current API call */
	final Call<T> call;

	/**
	 * @param call Retrofit call.
	 */
	public Request(Call<T> call) {
		this.call = call;
	}

	/**
	 * Executes the request synchronously
	 * 
	 * @return The request response.
	 * @throws ApiException The exception produced with the server error response
	 */
	public T sync() throws ApiException {
		try {
			Response<T> response = call.execute();
			if (response.isSuccessful()) {
				System.out.println(response.body());
				return response.body();
			} else {
				ApiError error = MAPPER.readValue(response.errorBody().string(), ApiError.class);
				throw new ApiException(error);
			}
		} catch (IOException e) {
			throw new ApiException(-400, e.getMessage());
		}
	}

	/**
	 * Executes the request asynchronously
	 * 
	 * @param callback Request callback managing a success or error response.
	 */
	public void async(ApiCallback<T> callback) {
		call.enqueue(new ApiCallbackAdapter<>(callback));
	}
}
