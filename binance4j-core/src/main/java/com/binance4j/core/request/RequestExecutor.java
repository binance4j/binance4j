package com.binance4j.core.request;

import java.io.IOException;

import com.binance4j.core.callback.ApiCallback;
import com.binance4j.core.callback.ApiCallbackAdapter;
import com.binance4j.core.exception.ApiError;
import com.binance4j.core.exception.ApiException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import retrofit2.Call;
import retrofit2.Response;

/**
 * A class that receives and executes sync and async retrofit calls.
 * <p>
 * If a server seems down (404), it will automatically pivot to the next server
 * until having an HTTP 200 response or throw an exception if all are down
 */
@Data
public class RequestExecutor<T> {
    /**
     * The Jackson Object mapper for deserializing the Api error response
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * The current API call
     */
    private final Call<T> call;
    /**
     * The request that originated the call
     */
    private final Request request;
    /**
     * The available api
     */
    private int currentAPI;

    /**
     * Constructor with default empty request
     * 
     * @param call The retrofit call
     */
    public RequestExecutor(Call<T> call) {
        this.call = call;
        this.request = new Request(0);
    }

    /**
     * Constructor with custom request
     * 
     * @param call The retrofit calls
     * @param req   The request parameters
     */
    public RequestExecutor(Call<T> call, Request req) {
        this.call = call;
        this.request = req;
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
