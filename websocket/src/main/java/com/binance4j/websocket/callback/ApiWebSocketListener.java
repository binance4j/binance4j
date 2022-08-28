package com.binance4j.websocket.callback;

import com.binance4j.core.exception.ApiException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/** Binance API WebSocket listener. */
public class ApiWebSocketListener<T> extends WebSocketListener {
	/** The jackson object mapper. */
	static final ObjectMapper MAPPER = new ObjectMapper();
	/** The websocket callback. */
	final WebsocketCallback<T> callback;
	/** Changes a string into an object. */
	final ObjectReader objectReader;
	/**
	 * Makes it able to make the difference between a closing event and a failure
	 * event
	 */
	boolean closing = false;

	/**
	 * Default constructor
	 *
	 * @param callback   Websocket callback.
	 * @param eventClass Payload class.
	 */
	public ApiWebSocketListener(final WebsocketCallback<T> callback, final Class<T> eventClass) {
		this.callback = callback;
		this.objectReader = MAPPER.readerFor(eventClass);
	}

	/**
	 * @param callback           Websocket callback.
	 * @param eventTypeReference ???
	 */
	public ApiWebSocketListener(final WebsocketCallback<T> callback, final TypeReference<T> eventTypeReference) {
		this.callback = callback;
		this.objectReader = MAPPER.readerFor(eventTypeReference);
	}

	/**
	 * {@link WebsocketCallback#onMessage(Object)} ()} wrapper
	 *
	 * @param webSocket Websocket.
	 * @param text      Payload as a string.
	 */
	@Override
	public void onMessage(final WebSocket webSocket, final String text) {
		try {
			callback.onMessage(objectReader.readValue(text));
		} catch (Exception e) {
			callback.onFailure(new ApiException(-1000, e.getMessage()));
		}
	}

	/**
	 * {@link WebsocketCallback#onOpen} wrapper
	 *
	 * @param webSocket Websocket.
	 * @param response  Opening payload.
	 */
	@Override
	public void onOpen(final WebSocket webSocket, final Response response) {
		try {
			callback.onOpen(response);
		} catch (Exception e) {
			callback.onFailure(new ApiException(-1000, e.getMessage()));
		}
	}

	/**
	 * {@link WebsocketCallback#onClosing} wrapper
	 *
	 * @param webSocket Websocket.
	 * @param code      Closing code.
	 * @param reason    Closing reason.
	 */
	@Override
	public void onClosing(final WebSocket webSocket, final int code, final String reason) {
		closing = true;
		try {
			callback.onClosing(new WebsocketCloseObject(code, reason));
		} catch (Exception e) {
			callback.onFailure(new ApiException(-1000, e.getMessage()));
		}
	}

	/**
	 * {@link WebsocketCallback#onClosed} wrapper
	 *
	 * @param webSocket Websocket.
	 * @param code      Closing code.
	 * @param reason    Closing reason.
	 */
	@Override
	public void onClosed(final WebSocket webSocket, final int code, final String reason) {
		closing = false;
		try {
			callback.onClosed(new WebsocketCloseObject(code, reason));
		} catch (Exception e) {
			callback.onFailure(new ApiException(-1000, e.getMessage()));
		}
	}

	/**
	 * {@link WebsocketCallback#onFailure} wrapper
	 *
	 * @param webSocket Websocket.
	 * @param t         Error object.
	 * @param response  HTTP response.
	 */
	@Override
	public void onFailure(final WebSocket webSocket, final Throwable t, final Response response) {
		if (!closing) {
			try {
				callback.onFailure(new ApiException(-1000, t.getMessage()));
			} catch (Exception e) {
				callback.onFailure(new ApiException(-1000, e.getMessage()));
			}
		}
	}
}
