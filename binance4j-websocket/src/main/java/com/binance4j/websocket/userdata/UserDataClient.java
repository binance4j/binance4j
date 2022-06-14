package com.binance4j.websocket.userdata;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.request.RequestExecutor;
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
}