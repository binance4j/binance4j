package com.binance4j.websocket.client;

import java.io.IOException;

import com.binance4j.core.exception.ApiException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/**
 * Binance API WebSocket listener.
 */
public class ApiWebSocketListener<T> extends WebSocketListener {
    /**
     * The jackson object mapper
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * The websocket callback
     */
    private final WebsocketCallback<T> callback;
    /**
     * Changes a string into an object
     */
    private final ObjectReader objectReader;
    /**
     * Makes it able to make the difference between a closing event and a
     * failure event
     * 
     * 
     */
    private boolean closing = false;

    /**
     * Default constructor
     * 
     * @param callback   The websocket callback
     * @param eventClass The payload class
     */
    public ApiWebSocketListener(final WebsocketCallback<T> callback, final Class<T> eventClass) {
        this.callback = callback;
        this.objectReader = MAPPER.readerFor(eventClass);
    }

    /**
     * Constructor
     * 
     * @param callback           The websocket callback
     * @param eventTypeReference ???
     */
    public ApiWebSocketListener(final WebsocketCallback<T> callback,
            final TypeReference<T> eventTypeReference) {
        this.callback = callback;
        this.objectReader = MAPPER.readerFor(eventTypeReference);
    }

    /**
     * Callback.onResponse wrapper
     * 
     * @param webSocket The websocket
     * @param text      The payload as a string
     */
    @Override
    public void onMessage(final WebSocket webSocket, final String text) {
        try {
            callback.onResponse(objectReader.readValue(text));
        } catch (final IOException e) {
            callback.onFailure(new ApiException(-1000, e.getMessage()));
        }
    }

    /**
     * Callback.onOpen wrapper
     * 
     * @param webSocket The websocket
     * @param response  The opening payload
     */
    @Override
    public void onOpen(final WebSocket webSocket, final Response response) {
        callback.onOpen(response);
    }

    /**
     * Callback.onClosing wrapper
     * 
     * @param webSocket The websocket
     * @param code      The closing code
     * @param reason    The closing reason
     */
    @Override
    public void onClosing(final WebSocket webSocket, final int code, final String reason) {
        closing = true;
        callback.onClosing(code, reason);
    }

    /**
     * Callback.onClosed wrapper
     * 
     * @param webSocket The websocket
     * @param code      The closing code
     * @param reason    The closing reason
     */
    @Override
    public void onClosed(final WebSocket webSocket, final int code, final String reason) {
        closing = false;
        callback.onClosed(code, reason);
    }

    /**
     * Callback.onFailure wrapper
     * 
     * @param webSocket The websocket
     * @param t         The error object
     * @param response  The HTTP response
     */
    @Override
    public void onFailure(final WebSocket webSocket, final Throwable t, final Response response) {
        if (!closing) {
            callback.onFailure(new ApiException(-1000, t.getMessage()));
        }
    }
}
