package com.binance4j.websocket.client;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.binance4j.websocket.callback.ApiWebSocketListener;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.configuration.WebsocketClientConfiguration;
import com.binance4j.websocket.event.WebsocketCloseClientHandler;
import com.binance4j.websocket.event.WebsocketForceClosingHandler;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

/** Websocket clients base class */
public abstract class BaseWebsocketClient<T> implements WebsocketClient {
	/** The websocket client. */
	protected BaseWebsocketClient<T> innerClient;
	/** The response data sent by the API. */
	protected Class<T> payloadClass;
	/** The stream symbols. */
	protected String symbols;
	/** The stream to connect to. */
	protected String stream;
	/** The wrapped websocket. */
	protected WebSocket innerWebsocket;
	/** The user events handler. */
	protected WebsocketCallback<T> callback;
	/** The interceptor callback. */
	protected WebsocketInterceptorCallback<T> interceptorCallback;
	/** The channel to connect to. */
	protected String channel;
	/** The listenr using the interceptor callback. */
	protected ApiWebSocketListener<T> listener;
	/** The client configuration. */
	WebsocketClientConfiguration configuration;
	/** Will call onClosing and onClosed of the interceptor callback if not. */
	protected WebsocketForceClosingHandler forceClosingHandler;
	/** Will close the client after some time. */
	protected WebsocketCloseClientHandler closeClientHandler;

	/** Constructor */
	protected BaseWebsocketClient() {
	}

	/**
	 * @param symbols      Pairs of assets.
	 * @param stream       Stream.
	 * @param payloadClass Payload type.
	 * @param callback     Events handler.
	 */
	protected BaseWebsocketClient(String symbols, String stream, Class<T> payloadClass, WebsocketCallback<T> callback) {
		this.symbols = symbols == null ? null : symbols.replaceAll(" ", "");
		this.stream = stream;
		this.payloadClass = payloadClass;
		this.callback = callback;
		interceptorCallback = new WebsocketInterceptorCallback<>(this, callback);
		listener = new ApiWebSocketListener<>(interceptorCallback, payloadClass);
		configuration = new WebsocketClientConfiguration();
		forceClosingHandler = new WebsocketForceClosingHandler(this, interceptorCallback);
		closeClientHandler = new WebsocketCloseClientHandler(this, interceptorCallback);
		generateChannel(true);
	}

	@Override
	public void open() {
		close(false);
		innerWebsocket = newWebSocket(configuration, channel, listener);
		interceptorCallback.setSocket(innerWebsocket);
		interceptorCallback.setForceClosingHandler(forceClosingHandler);
		interceptorCallback.getConnectionHandler().run();
		closeClientHandler.run();
	}

	@Override
	public void close() {
		close(true);
	}

	/**
	 * Closes the stream
	 * 
	 * @param closedByClient Defines if the cloising is made by the client.
	 */
	public void close(boolean closedByClient) {
		this.interceptorCallback.setClosedByClient(closedByClient);
		if (innerWebsocket != null) {
			innerWebsocket.close(1000, null);
			forceClosingHandler.run();
		}
	}

	/**
	 * Generate the websocket communicating with the API
	 *
	 * @param configuration Configuration.
	 * @param channel       address containing the symbols and the stream name.
	 * @param listener      Websocket listener.
	 * @return The websocket to communicate with the API.
	 */
	protected WebSocket newWebSocket(WebsocketClientConfiguration configuration, String channel,
			ApiWebSocketListener<?> listener) {
		String streamingUrl = String.format("%s/%s", configuration.getBaseUrl(), channel);
		Request request = new Request.Builder().url(streamingUrl).build();
		return new OkHttpClient.Builder().dispatcher(new Dispatcher()).pingInterval(configuration.getPingInterval())
				.build().newWebSocket(request, listener);
	}

	/**
	 * Generates the channel the Websocket will connect to
	 * 
	 * @param symbolToLowerCase Are the symbols in lower case?
	 */
	protected void generateChannel(boolean symbolToLowerCase) {
		if (symbols == null) {
			channel = stream;
		} else {
			symbols = symbolToLowerCase ? symbols.toLowerCase() : symbols.toUpperCase();
			channel = Arrays.stream(symbols.split(",")).map(String::trim).map(s -> String.format("%s@%s", s, stream))
					.collect(Collectors.joining("/"));
		}
	}

	/**
	 * @return the configuration
	 */
	public WebsocketClientConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * @param configuration Configuration to set
	 */
	public void setConfiguration(WebsocketClientConfiguration configuration) {
		this.configuration = configuration;
	}

	/**
	 * @return the symbols
	 */
	public String getSymbols() {
		return symbols;
	}
}