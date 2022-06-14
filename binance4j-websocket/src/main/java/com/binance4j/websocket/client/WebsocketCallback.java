package com.binance4j.websocket.client;

import com.binance4j.core.exception.ApiException;

import okhttp3.Response;

/**
 * Callback used by a websocket client event handler
 */
@FunctionalInterface
public interface WebsocketCallback<T> {
    /**
     * Triggered when the server sends data
     * 
     * @param response The response data
     */
    void onResponse(T response);

    /**
     * Triggered when the connection fails
     * 
     * @param exception The Exception containing the API code and message error.
     */
    default void onFailure(ApiException exception) {
    }

    /**
     * Triggered when the connection is closing
     * 
     * @param code   The API close code
     * @param reason The API close reason message
     */
    default void onClosing(int code, String reason) {
    }

    /**
     * Triggered when the connection is closed
     * 
     * @param code   The API close code
     * @param reason The API close reason message
     */
    default void onClosed(int code, String reason) {
    }

    /**
     * Triggered when the connection is opened
     * 
     * @param response The API open response
     */
    default void onOpen(Response response) {
    }
}