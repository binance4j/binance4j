package com.binance4j.core.request;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
     * All the available calls to contact the API
     */
    private final List<Call<T>> calls;
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
     * @param calls The retrofit calls
     */
    public RequestExecutor(List<Call<T>> calls) {
        this.calls = calls;
        this.request = new Request(1);
    }

    /**
     * Constructor with custom request
     * 
     * @param calls The retrofit calls
     * @param req   The request parameters
     */
    public RequestExecutor(List<Call<T>> calls, Request req) {
        this.calls = calls;
        this.request = req;
    }

    /**
     * Constructor with default empty request
     * 
     * @param call The retrofit call
     */
    public RequestExecutor(Call<T> call) {
        this.calls = Arrays.asList(call);
        this.request = new Request(0);
    }

    /**
     * Constructor with custom request
     * 
     * @param call The retrofit call
     * @param req  The request parameters
     */
    public RequestExecutor(Call<T> call, Request req) {
        this.calls = Arrays.asList(call);
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
            Response<T> response = calls.get(currentAPI).execute();

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
        calls.get(currentAPI).enqueue(new ApiCallbackAdapter<>(callback));
    }
}
