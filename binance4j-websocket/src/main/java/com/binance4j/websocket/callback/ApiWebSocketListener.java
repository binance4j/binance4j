package com.binance4j.websocket.callback;

import com.binance4j.core.exception.ApiException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;

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
	 * {@link WebsocketCallback#onMessage(Object)} ()} wrapper
	 *
	 * @param webSocket The websocket
	 * @param text      The payload as a string
	 */
	@Override
	public void onMessage(@NotNull final WebSocket webSocket, @NotNull final String text) {
		try {
			callback.onMessage(objectReader.readValue(text));
		} catch (Exception e) {
			callback.onFailure(new ApiException(-1000, e.getMessage()));
		}
	}

	/**
	 * {@link WebsocketCallback#onOpen} wrapper
	 *
	 * @param webSocket The websocket
	 * @param response  The opening payload
	 */
	@Override
	public void onOpen(@NotNull final WebSocket webSocket, @NotNull final Response response) {
		try {
			callback.onOpen(response);
		} catch (Exception e) {
			callback.onFailure(new ApiException(-1000, e.getMessage()));
		}
	}

	/**
	 * {@link WebsocketCallback#onClosing} wrapper
	 *
	 * @param webSocket The websocket
	 * @param code      The closing code
	 * @param reason    The closing reason
	 */
	@Override
	public void onClosing(@NotNull final WebSocket webSocket, final int code, @NotNull final String reason) {
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
	 * @param webSocket The websocket
	 * @param code      The closing code
	 * @param reason    The closing reason
	 */
	@Override
	public void onClosed(@NotNull final WebSocket webSocket, final int code, @NotNull final String reason) {
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
	 * @param webSocket The websocket
	 * @param t         The error object
	 * @param response  The HTTP response
	 */
	@Override
	public void onFailure(@NotNull final WebSocket webSocket, @NotNull final Throwable t, final Response response) {
		if (!closing) {
			try {
				callback.onFailure(new ApiException(-1000, t.getMessage()));
			} catch (Exception e) {
				callback.onFailure(new ApiException(-1000, e.getMessage()));
			}
		}
	}
}
