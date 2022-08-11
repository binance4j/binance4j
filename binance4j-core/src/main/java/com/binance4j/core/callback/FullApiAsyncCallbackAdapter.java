package com.binance4j.core.callback;

import java.io.IOException;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.NotFoundException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/** A wrapper for {@link FullApiAsyncCallback} */
public class FullApiAsyncCallbackAdapter<T> implements Callback<T> {
	/** The wrapped callback. */
	final FullApiAsyncCallback<T> callback;

	/** @param callback Wrapped callback */
	public FullApiAsyncCallbackAdapter(FullApiAsyncCallback<T> callback) {
		this.callback = callback;
	}

	/**
	 * Calls {@link ApiCallback} corresponding method according to the response HTTP
	 * code
	 * 
	 * @param call     Retrofit call.
	 * @param response API response.
	 */
	@Override
	public void onResponse(Call<T> call, Response<T> response) {
		switch (response.code()) {
			case 200 -> callback.onResponse(response.body(), response.headers(), null);
			case 403 ->
				callback.onResponse(null, response.headers(),
						new ApiException(403, "The Web Application Firewall has been violated"));
			case 404 -> callback.onResponse(null, response.headers(), new NotFoundException());
			case 418 -> callback.onResponse(null, response.headers(), new ApiException(418,
					"IP has been auto-banned for continuing to send requests after receiving 429 codes"));
			case 429 ->
				callback.onResponse(null, response.headers(), new ApiException(429, "Request rate limit exceeded"));
			default -> {
				try {
					callback.onResponse(null, response.headers(),
							new ApiException(response.code(), response.errorBody().string()));
				} catch (IOException e) {
					callback.onResponse(null, response.headers(), new ApiException(-400, e.getMessage()));
				}
			}
		}
	}

	/**
	 * Generates a {@link ApiException} from the given Throwable and calls
	 * {@link ApiCallback#onFailure(ApiException)}
	 * 
	 * @param call      Retrofit call.
	 * @param throwable API error message.
	 */
	@Override
	public void onFailure(Call<T> call, Throwable throwable) {
		callback.onResponse(null, null, new ApiException(-1000, throwable.getMessage()));
	}
}
