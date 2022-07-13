package com.binance4j.websocket.userdata;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Request;
import com.binance4j.websocket.stream.IsolatedUserDataStreamParams;
import com.binance4j.websocket.stream.KeepAliveIsolatedUserDataStreamParams;

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
	 */
	public Request<Void> keepAliveUserDataStream(String listenKey) {
		return new Request<>(service.keepAliveUserDataStream(listenKey));
	}

	/**
	 * Close out a user data stream.
	 */
	public Request<Void> closeUserDataStream(String listenKey) {
		return new Request<>(service.closeUserDataStream(listenKey));
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
	 */
	public Request<ListenKey> startMarginUserDataStream() {
		return new Request<>(service.startMarginUserDataStream());
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
	 */
	public Request<Void> keepAliveMarginUserDataStream(String listenKey) {
		return new Request<>(service.keepAliveMarginUserDataStream(listenKey));
	}

	/**
	 * Close out a user data stream (Margin).
	 * 
	 */
	public Request<Void> closeMarginUserDataStream(String listenKey) {
		return new Request<>(service.closeMarginUserDataStream(listenKey));
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
	 */
	public Request<ListenKey> startIsolatedUserDataStream(IsolatedUserDataStreamParams params) {
		return new Request<>(service.startIsolatedUserDataStream(params.toMap()));
	}

	/**
	 * Keepalive a user data stream to prevent a time out (Isolated margin).
	 * 
	 * <p>
	 * User data streams will close after 60 minutes.
	 * <p>
	 * It's recommended to send a ping about every 30 minutes.
	 * 
	 */
	public Request<Void> keepAliveIsolatedUserDataStream(KeepAliveIsolatedUserDataStreamParams params) {
		return new Request<>(service.keepAliveIsolatedUserDataStream(params.toMap()));
	}

	/**
	 * Close out a user data stream (Isolated margin).
	 * 
	 */
	public Request<Void> closeIsolatedUserDataStream(KeepAliveIsolatedUserDataStreamParams params) {
		return new Request<>(service.closeIsolatedUserDataStream(params.toMap()));
	}
}