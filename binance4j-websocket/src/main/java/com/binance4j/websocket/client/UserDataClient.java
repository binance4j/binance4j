package com.binance4j.websocket.client;

import com.binance4j.core.client.RestClient;
import com.binance4j.websocket.param.IsolatedUserDataStreamParams;
import com.binance4j.websocket.param.KeepAliveIsolatedUserDataStreamParams;
import com.binance4j.websocket.request.CloseIsolatedUserDataStreamRequest;
import com.binance4j.websocket.request.CloseMarginUserDataStreamRequest;
import com.binance4j.websocket.request.CloseUserDataStreamRequest;
import com.binance4j.websocket.request.KeepALiveUserDataStreamRequest;
import com.binance4j.websocket.request.KeepAliveIsolatedUserDataStreamRequest;
import com.binance4j.websocket.request.KeepAliveMarginUserDataStreamRequest;
import com.binance4j.websocket.request.StartIsolatedUserDataStreamRequest;
import com.binance4j.websocket.request.StartMarginUserDataStreamRequest;
import com.binance4j.websocket.request.StartUserDataStreamRequest;

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
	public StartUserDataStreamRequest startUserDataStream() {
		return new StartUserDataStreamRequest(service.startUserDataStream());
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
	public KeepALiveUserDataStreamRequest keepAliveUserDataStream(String listenKey) {
		return new KeepALiveUserDataStreamRequest(service.keepAliveUserDataStream(listenKey));
	}

	/**
	 * Close out a user data stream.
	 * 
	 * @param listenKey Listen key.
	 * @return The request to execute.
	 */
	public CloseUserDataStreamRequest closeUserDataStream(String listenKey) {
		return new CloseUserDataStreamRequest(service.closeUserDataStream(listenKey));
	}

	/**
	 * Create a ListenKey (Margin).
	 * <p>
	 * The stream will close after 60 minutes unless a keepalive is sent.
	 * <p>
	 * If the account has an active listenKey, that listenKey will be returned and
	 * its validity will be extended for 60
	 * minutes.
	 * 
	 * @return The request to execute.
	 */
	public StartMarginUserDataStreamRequest startMarginUserDataStream() {
		return new StartMarginUserDataStreamRequest(service.startMarginUserDataStream());
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
	public KeepAliveMarginUserDataStreamRequest keepAliveMarginUserDataStream(String listenKey) {
		return new KeepAliveMarginUserDataStreamRequest(service.keepAliveMarginUserDataStream(listenKey));
	}

	/**
	 * Close out a user data stream (Margin).
	 * 
	 * @param listenKey Listen key.
	 * @return The request to execute.
	 */
	public CloseMarginUserDataStreamRequest closeMarginUserDataStream(String listenKey) {
		return new CloseMarginUserDataStreamRequest(service.closeMarginUserDataStream(listenKey));
	}

	/**
	 * Create a ListenKey (Isolated margin).
	 * <p>
	 * The stream will close after 60 minutes unless a keepalive is sent.
	 * <p>
	 * If the account has an active listenKey, that listenKey will be returned and
	 * its validity will be extended for 60
	 * minutes.
	 * 
	 * @param params Query params
	 * @return The request to execute.
	 */
	public StartIsolatedUserDataStreamRequest startIsolatedUserDataStream(IsolatedUserDataStreamParams params) {
		return new StartIsolatedUserDataStreamRequest(service.startIsolatedUserDataStream(params.toMap()));
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
	public KeepAliveIsolatedUserDataStreamRequest keepAliveIsolatedUserDataStream(
			KeepAliveIsolatedUserDataStreamParams params) {
		return new KeepAliveIsolatedUserDataStreamRequest(service.keepAliveIsolatedUserDataStream(params.toMap()));
	}

	/**
	 * Close out a user data stream (Isolated margin).
	 * 
	 * @param params Query params
	 * @return The request to execute.
	 */
	public CloseIsolatedUserDataStreamRequest closeIsolatedUserDataStream(
			KeepAliveIsolatedUserDataStreamParams params) {
		return new CloseIsolatedUserDataStreamRequest(service.closeIsolatedUserDataStream(params.toMap()));
	}
}