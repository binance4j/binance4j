package com.binance4j.websocket.client;

import com.binance4j.core.misc.ListenKey;
import com.binance4j.core.request.RequestExecutor;
import com.binance4j.core.request.RestClient;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The API client for the user data endpoints
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDataClient extends RestClient<UserDataMapping> {
    /**
     * Instantiates a client for the spot endpoints with the choice to use the test
     * network
     *
     * @param key        The API public key
     * @param secret     The API secret key
     * @param useTestnet Are we using the test network?
     */
    public UserDataClient(String key, String secret, Boolean useTestnet) {
        super(UserDataMapping.class, key, secret, useTestnet);
    }

    /**
     * Instantiates a client for the spot endpoints on api
     *
     * @param key    The API public key
     * @param secret The API secret key
     */
    public UserDataClient(String key, String secret) {
        this(key, secret, false);
    }

    /**
     * Create a ListenKey
     * 
     * The stream will close after 60 minutes unless a keepalive is sent
     * <p>
     * If the account has an active listenKey, that listenKey
     * <p>
     * will be returned and its validity will be extended for 60 minutes
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot">Documentation</a>
     * @return The executor to make sync/async request
     */
    public RequestExecutor<ListenKey> startUserDataStream() {
        return new RequestExecutor<>(getServices().stream().map(UserDataMapping::startUserDataStream).toList());
    }

    /**
     * Keepalive a user data stream to prevent a time out.
     * <p>
     * User data streams will close after 60 minutes.
     * <p>
     * It's recommended to send a ping about every 30 minutes.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot">Documentation</a>
     * @return The executor to make sync/async request
     */
    public RequestExecutor<Void> keepAliveUserDataStream(String listenKey) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.keepAliveUserDataStream(listenKey)).toList());
    }

    /**
     * Close out a user data stream.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot">Documentation</a>
     * @return The executor to make sync/async request
     */
    public RequestExecutor<Void> closeUserDataStream(String listenKey) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.closeUserDataStream(listenKey)).toList());
    }
}