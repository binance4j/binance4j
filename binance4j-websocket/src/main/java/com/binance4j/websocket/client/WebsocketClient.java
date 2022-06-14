package com.binance4j.websocket.client;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import com.binance4j.core.exception.ApiErrorCode;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.request.RestClient;

import io.reactivex.rxjava3.functions.Consumer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;

/**
 * Websocket clients base class
 */
@Data
public abstract class WebsocketClient<T> {
	/**
	 * The websocket connection port
	 */
	@Getter
	@Setter
	private static int websocketPort = 9443;

	/** The client callbacks */
	protected WebsocketCallback<T> callback;

	/** The timer responsible to schedule the no message timeout task */
	@Setter(value = AccessLevel.NONE)
	@Getter(value = AccessLevel.NONE)
	private Timer noResponseTimer;

	/**
	 * The interval the client will send a ping
	 */
	private Duration pingInterval = Duration.ofMinutes(3);

	/**
	 * The duration after which the client triggers a timeout if no data is sent
	 * from the server. Default 3 minutes.
	 */
	private Duration noResponseTimeout = Duration.ofMinutes(3);

	/** The last message timestamp in ms */
	@Setter(value = AccessLevel.NONE)
	private long lastResponseTimestamp;

	/**
	 * The response data sent by the API
	 */
	protected Class<T> payloadClass;
	/**
	 * The symbols we want the payload
	 */
	protected String symbols;
	/**
	 * The data type we need / the stream we want to connect to
	 */
	protected String stream;
	/**
	 * The wrapped websocket
	 */
	protected WebSocket websocket;
	/**
	 * Should we use testnet?
	 */
	protected boolean useTestnet;

	/** Reconnect if stream is closed non manually */
	protected boolean isKeptAlive = true;

	/** Tells if stream has been closed manually */
	protected boolean isManualClosing;

	/**
	 * Tells if the client reconnects after a failur. Default true.
	 */
	private boolean isRetryOnConnectionFailure = true;

	/**
	 * The {@link #onMessage} consumer
	 */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	protected Consumer<T> onMessageConsumer = (T payload) -> {
	};

	/**
	 * The {@link #onOpen} consumer
	 */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	protected Consumer<Response> onOpenConsumer = (Response response) -> {
	};

	/**
	 * The {@link #onClosing} consumer
	 */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	protected Consumer<WebsocketCloseObject> onClosingConsumer = (WebsocketCloseObject closeObject) -> {
	};

	/**
	 * The {@link #onClosed} consumer
	 */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	protected Consumer<WebsocketCloseObject> onClosedConsumer = (WebsocketCloseObject closeObject) -> {
	};

	/**
	 * The {@link #onFailure} consumer
	 */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	protected Consumer<ApiException> onFailureConsumer = (ApiException response) -> {
	};

	/**
	 * Constructor
	 * 
	 * @param symbols      The pairs of assets
	 * @param stream       The stream
	 * @param payloadClass The payload type
	 */
	protected WebsocketClient(String symbols, String stream, Class<T> payloadClass) {
		this.symbols = symbols;
		this.stream = stream;
		this.payloadClass = payloadClass;
	}

	/**
	 * Triggered when payload is received
	 * 
	 * @param onMessageConsumer The response consumer
	 */
	public void onMessage(Consumer<T> onMessageConsumer) {
		this.onMessageConsumer = onMessageConsumer;
	}

	/**
	 * Triggered when stream is opened
	 * 
	 * @param onOpenConsumer The response consumer
	 */
	public void onOpen(Consumer<Response> onOpenConsumer) {
		this.onOpenConsumer = onOpenConsumer;
	}

	/**
	 * Triggered when stream is closing
	 * 
	 * @param onClosingConsumer The response consumer
	 */
	public void onClosing(Consumer<WebsocketCloseObject> onClosingConsumer) {
		this.onClosingConsumer = onClosingConsumer;
	}

	/**
	 * Triggered when stream is closed
	 * 
	 * @param onClosedConsumer The response consumer
	 */
	public void onClosed(Consumer<WebsocketCloseObject> onClosedConsumer) {
		this.onClosedConsumer = onClosedConsumer;
	}

	/**
	 * Triggered when connection fails
	 * 
	 * @param onFailureConsumer The response consumer
	 */
	public void onFailure(Consumer<ApiException> onFailureConsumer) {
		this.onFailureConsumer = onFailureConsumer;
	}

	/** Opens the stream */
	public void open() {
		isManualClosing = false;

		// At opening, we define the last message as now
		lastResponseTimestamp = new Date().getTime();

		callback = new WebsocketCallback<T>() {
			@Override
			public void onResponse(T payload) {
				// At response, we define the last message as now
				lastResponseTimestamp = new Date().getTime();

				try {
					onMessageConsumer.accept(payload);
				} catch (Throwable e) {
					onFailure(new ApiException(ApiErrorCode.DESERIALIZATION_FAILURE, e.getMessage()));
				}
			}

			@Override
			public void onClosing(int code, String reason) {
				try {
					onClosingConsumer.accept(new WebsocketCloseObject(code, reason));
				} catch (Throwable e) {
					onFailure(new ApiException(ApiErrorCode.DESERIALIZATION_FAILURE, e.getMessage()));
				}
			}

			@Override
			public void onClosed(int code, String reason) {
				try {
					onClosedConsumer.accept(new WebsocketCloseObject(code, reason));

					if (isKeptAlive && !isManualClosing) {
						open();
					}
					noResponseTimer.cancel();

				} catch (Throwable e) {
					onFailure(new ApiException(ApiErrorCode.DESERIALIZATION_FAILURE, e.getMessage()));
				}
			}

			@Override
			public void onOpen(Response response) {
				try {
					onOpenConsumer.accept(response);
					// we launche the no response timer
					noResponseTimer = new Timer();
					noResponseTimer.schedule(new HandleLastResponseTask(), noResponseTimeout.toMillis(),
							noResponseTimeout.toMillis());
				} catch (Throwable e) {
					onFailure(new ApiException(ApiErrorCode.DESERIALIZATION_FAILURE, e.getMessage()));
				}
			}

			@Override
			public void onFailure(ApiException exception) {
				try {
					onFailureConsumer.accept(exception);
					noResponseTimer.cancel();
				} catch (Throwable e) {
					onFailure(new ApiException(ApiErrorCode.DESERIALIZATION_FAILURE, e.getMessage()));
				}
			}
		};

		// we close the websocket if it already exists
		if (websocket != null) {
			close();
		}

		websocket = createNewWebSocket(generateChannel(symbols, stream),
				new ApiWebSocketListener<>(callback, payloadClass));
	}

	/** Closes the stream */
	public void close() {
		close(true);
	}

	/**
	 * Closes the stream telling the websocket is closing has been made by the
	 * client
	 * 
	 * @param isManualClosing is the stream closed by the client?
	 */
	protected void close(boolean isManualClosing) {
		this.isManualClosing = isManualClosing;
		websocket.close(1000, null);
	}

	/**
	 * Generate the websocket communicating with the API
	 * 
	 * @param channel  address containing the symbols and the stream name
	 * @param listener The websocket listener
	 * @return The websocket to communicate with the API
	 */
	protected WebSocket createNewWebSocket(String channel, ApiWebSocketListener<?> listener) {
		String streamingUrl = String.format("%s/%s", getStreamApiBaseUrl(useTestnet), channel);
		Request request = new Request.Builder().url(streamingUrl).build();
		return new OkHttpClient.Builder()
				.dispatcher(new Dispatcher())
				.pingInterval(pingInterval)
				.retryOnConnectionFailure(isRetryOnConnectionFailure)
				.build()
				.newWebSocket(request, listener);
	}

	/**
	 * Returns the WebSocket API base URL
	 * 
	 * @param useTestnet should the base URL be the testNet url?
	 * @return The stream base url
	 */
	protected String getStreamApiBaseUrl(boolean useTestnet) {
		return !useTestnet
				? String.format("wss://stream.%s:%s/ws", RestClient.getBaseDomain(), getWebsocketPort())
				: String.format("wss://%s/ws", RestClient.getTestnetDomain());
	}

	/**
	 * Generates the channel the Websocket will connect to
	 * 
	 * @param symbols The symbols we want the market datas seperated by a coma
	 * @param stream  The stream enpoint
	 * @return The stream channel
	 */
	protected String generateChannel(String symbols, String stream) {
		return symbols == null ? stream
				: Arrays.stream(symbols.toLowerCase().split(","))
						.map(String::trim)
						.map(s -> String.format("%s@%s", s, stream))
						.collect(Collectors.joining("/"));
	}

	/**
	 * Tells the client to reconnect or not if the stream is closed by an external
	 * event
	 */
	public void keepAlive(boolean isKeptAlive) {
		this.isKeptAlive = isKeptAlive;
	}

	/**
	 * Tells the client to reconnect on connnection failure
	 */
	public void retryOnConnectionFailure(boolean retry) {
		this.isRetryOnConnectionFailure = retry;
	}

	/**
	 * The task responsible of triggering timeout failure is no message has been
	 * received for some time
	 */
	private class HandleLastResponseTask extends TimerTask {
		@Override
		public void run() {
			long now = new Date().getTime();

			if (now - noResponseTimeout.toMillis() > lastResponseTimestamp) {
				callback.onFailure(new ApiException(403, "Response timeout : no data received for "
						+ Long.toString(noResponseTimeout.getSeconds()) + " seconds"));
				close(false);
			}
		}
	}
}
