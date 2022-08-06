package com.binance4j.websocket.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.websocket.dto.ListenKey;
import com.binance4j.websocket.param.IsolatedUserDataStreamParams;
import com.binance4j.websocket.param.KeepAliveIsolatedUserDataStreamParams;

/** The API client for the user data endpoints */
public class UserDataClient extends RestClient<UserDataMapping> {

	/**
	 * @param key    API public key.
	 * @param secret API secret key.
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
	 * @return The request to execute.
	 */
	public Request<ListenKey> startUserDataStream() {
		return new Request<>(service.startUserDataStream());
	}

	/**
	 * Keepalive a user data stream to prevent a time out.
	 * <p>
	 * User data streams will close after 60 minutes.
	 * <p>
	 * It's recommended to send a ping about every 30 minutes.
	 * 
	 * @param listenKey Listen key.
	 * @return The request to execute.
	 */
	public Request<Void> keepAliveUserDataStream(String listenKey) {
		return new Request<>(service.keepAliveUserDataStream(listenKey));
	}

	/**
	 * Close out a user data stream.
	 * 
	 * @param listenKey Listen key.
	 * @return The request to execute.
	 */
	public Request<Void> closeUserDataStream(String listenKey) {
		return new Request<>(service.closeUserDataStream(listenKey));
	}

	/**
	 * Create a ListenKey (Margin).
	 * <p>
	 * The stream will close after 60 minutes unless a keepalive is sent.
	 * <p>
	 * If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60
	 * minutes.
	 * 
	 * @return The request to execute.
	 */
	public Request<ListenKey> startMarginUserDataStream() {
		return new Request<>(service.startMarginUserDataStream());
	}

	// MARGIN

	/**
	 * Keepalive a user data stream to prevent a time out (Margin).
	 * <p>
	 * User data streams will close after 60 minutes.
	 * <p>
	 * It's recommended to send a ping about every 30 minutes.
	 * 
	 * @param listenKey Listen key.
	 * @return The request to execute.
	 */
	public Request<Void> keepAliveMarginUserDataStream(String listenKey) {
		return new Request<>(service.keepAliveMarginUserDataStream(listenKey));
	}

	/**
	 * Close out a user data stream (Margin).
	 * 
	 * @param listenKey Listen key.
	 * @return The request to execute.
	 */
	public Request<Void> closeMarginUserDataStream(String listenKey) {
		return new Request<>(service.closeMarginUserDataStream(listenKey));
	}

	/**
	 * Create a ListenKey (Isolated margin).
	 * <p>
	 * The stream will close after 60 minutes unless a keepalive is sent.
	 * <p>
	 * If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60
	 * minutes.
	 * 
	 * @param params Query params
	 * @return The request to execute.
	 */
	public Request<ListenKey> startIsolatedUserDataStream(IsolatedUserDataStreamParams params) {
		return new Request<>(service.startIsolatedUserDataStream(params.toMap()));
	}

	/**
	 * Keepalive a user data stream to prevent a time out (Isolated margin).
	 * <p>
	 * User data streams will close after 60 minutes.
	 * <p>
	 * It's recommended to send a ping about every 30 minutes.
	 * 
	 * @param params Query params
	 * @return The request to execute.
	 */
	public Request<Void> keepAliveIsolatedUserDataStream(KeepAliveIsolatedUserDataStreamParams params) {
		return new Request<>(service.keepAliveIsolatedUserDataStream(params.toMap()));
	}

	/**
	 * Close out a user data stream (Isolated margin).
	 * 
	 * @param params Query params
	 * @return The request to execute.
	 */
	public Request<Void> closeIsolatedUserDataStream(KeepAliveIsolatedUserDataStreamParams params) {
		return new Request<>(service.closeIsolatedUserDataStream(params.toMap()));
	}
}