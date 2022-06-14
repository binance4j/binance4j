package com.binance4j.core.callback;

import java.io.IOException;

import com.binance4j.core.exception.ApiException;

import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A wrapper for the {@link ApiCallback}
 */
public class ApiCallbackAdapter<T> implements Callback<T> {

    /** The wrapped callback */
    private final ApiCallback<T> callback;

    /**
     * @param callback The wrapped callback
     */
    public ApiCallbackAdapter(ApiCallback<T> callback) {
        this.callback = callback;
    }

    /**
     * Calls the {@link ApiCallback} corresponding method according to the
     * response HTTP code
     * 
     * @param call     The retrofit call
     * @param response The API response
     */
    @Override
    public void onResponse(@NotNull Call<T> call, Response<T> response) {
        switch (response.code()) {
            case 200:
                callback.onResponse(response.body());
                break;
            case 403:
                callback.onFailure(new ApiException(403, "The Web Application Firewall has been violated"));
                break;
            case 404:
                callback.onFailure(new ApiException(404, "Not Found"));
                break;
            case 418:
                callback.onFailure(new ApiException(418,
                        "IP has been auto-banned for continuing to send requests after receiving 429 codes"));
                break;
            case 429:
                callback.onFailure(new ApiException(429, "Request rate limit exceeded"));
                break;
            default:
                try {
                    callback
                            .onFailure(new ApiException(response.code(), response.errorBody().string()));
                } catch (IOException e) {
                    callback
                            .onFailure(new ApiException(-400, e.getMessage()));
                }
                break;
        }
    }

    /**
     * Generates a {@link ApiException} from the given Throwable and calls
     * {@link ApiCallback#onFailure(ApiException)}
     * 
     * @param call      The retrofit call
     * @param throwable The API error message
     */
    @Override
    public void onFailure(@NotNull Call<T> call, Throwable throwable) {
        callback.onFailure(new ApiException(-1000, throwable.getMessage()));
    }
}
