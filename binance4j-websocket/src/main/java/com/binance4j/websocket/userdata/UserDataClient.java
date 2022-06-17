package com.binance4j.websocket.userdata;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.request.RequestExecutor;
import com.binance4j.websocket.stream.IsolatedUserDataStreamRequest;
import com.binance4j.websocket.stream.KeepAliveIsolatedUserDataStreamRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The API client for the user data endpoints
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDataClient extends RestClient<UserDataMapping> {

	/**
	 * Instantiates a client for the spot endpoints on api
	 *
	 * @param key    The API public key
	 * @param secret The API secret key
	 */
	public UserDataClient(String key, String secret) {
		super(UserDataMapping.class, key, secret);
	}

	/**
	 * Create a ListenKey
	 * <p>
	 * The stream will close after 60 minutes unless a keepalive is sent
	 * <p>
	 * If the account has an active listenKey, that listenKey
	 * <p>
	 * will be returned and its validity will be extended for 60 minutes
	 *
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot">Documentation</a>
	 */
	public RequestExecutor<ListenKey> startUserDataStream() {
		return new RequestExecutor<>(service.startUserDataStream());
	}

	/**
	 * Keepalive a user data stream to prevent a time out.
	 * <p>
	 * User data streams will close after 60 minutes.
	 * <p>
	 * It's recommended to send a ping about every 30 minutes.
	 *
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot">Documentation</a>
	 */
	public RequestExecutor<Void> keepAliveUserDataStream(String listenKey) {
		return new RequestExecutor<>(service.keepAliveUserDataStream(listenKey));
	}

	/**
	 * Close out a user data stream.
	 *
	 * @return The executor to make sync/async request
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot">Documentation</a>
	 */
	public RequestExecutor<Void> closeUserDataStream(String listenKey) {
		return new RequestExecutor<>(service.closeUserDataStream(listenKey));
	}

	/**
	 * Create a ListenKey (Margin).
	 * 
	 * <p>
	 * The stream will close after 60 minutes unless a
	 * keepalive is sent.
	 * <p>
	 * If the account has an active listenKey, that listenKey
	 * will be returned and its validity will be extended for 60 minutes.
	 * 
	 * @see <a href=
	 *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin">Documentation</a>
	 */
	public RequestExecutor<ListenKey> startMarginUserDataStream() {
		return new RequestExecutor<>(service.startMarginUserDataStream());
	}

	// MARGIN

	/**
	 * Keepalive a user data stream to prevent a time out (Margin).
	 * 
	 * <p>
	 * User data streams will close after 60 minutes.
	 * <p>
	 * It's recommended to send a ping about every 30 minutes.
	 * 
	 * @see <a href=
	 *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin">Documentation</a>
	 */
	public RequestExecutor<Void> keepAliveMarginUserDataStream(String listenKey) {
		return new RequestExecutor<>(service.keepAliveMarginUserDataStream(listenKey));
	}

	/**
	 * Close out a user data stream (Margin).
	 * 
	 * @see <a href=
	 *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin">Documentation</a>
	 */
	public RequestExecutor<Void> closeMarginUserDataStream(String listenKey) {
		return new RequestExecutor<>(service.closeMarginUserDataStream(listenKey));
	}

	/**
	 * Create a ListenKey (Isolated margin).
	 * 
	 * <p>
	 * The stream will close after 60 minutes unless a
	 * keepalive is sent.
	 * <p>
	 * If the account has an active listenKey, that listenKey
	 * will be returned and its validity will be extended for 60 minutes.
	 * 
	 * @see <a href=
	 *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin">Documentation</a>
	 */
	public RequestExecutor<ListenKey> startIsolatedUserDataStream(IsolatedUserDataStreamRequest req) {
		return new RequestExecutor<>(service.startIsolatedUserDataStream(req.toMap()));
	}

	/**
	 * Keepalive a user data stream to prevent a time out (Isolated margin).
	 * 
	 * <p>
	 * User data streams will close after 60 minutes.
	 * <p>
	 * It's recommended to send a ping about every 30 minutes.
	 * 
	 * @see <a href=
	 *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin">Documentation</a>
	 */
	public RequestExecutor<Void> keepAliveIsolatedUserDataStream(KeepAliveIsolatedUserDataStreamRequest req) {
		return new RequestExecutor<>(service.keepAliveIsolatedUserDataStream(req.toMap()));
	}

	/**
	 * Close out a user data stream (Isolated margin).
	 * 
	 * @see <a href=
	 *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin">Documentation</a>
	 */
	public RequestExecutor<Void> closeIsolatedUserDataStream(KeepAliveIsolatedUserDataStreamRequest req) {
		return new RequestExecutor<>(service.closeIsolatedUserDataStream(req.toMap()));
	}
}