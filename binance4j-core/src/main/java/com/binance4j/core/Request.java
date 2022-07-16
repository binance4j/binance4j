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
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /** The current API call */
    private final Call<T> call;

    /**
     * @param call The retrofit call
     */
    public Request(Call<T> call) {
        this.call = call;
    }

    /**
     * Executes the request synchronously
     * 
     * @return The request response
     * @throws ApiException The exception produced with the server error response
     */
    public T execute() throws ApiException {
        try {
            Response<T> response = call.execute();

            if (response.isSuccessful()) {
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
     * @param callback The request callback managing a success or error response
     */
    public void then(ApiCallback<T> callback) {
        call.enqueue(new ApiCallbackAdapter<>(callback));
    }
}
