package com.binance4j.websocket.configuration;

import java.time.Duration;

import com.binance4j.core.configuration.RestClientConfiguration;

import lombok.Data;

/**
 * The websocket client ocnfiguration
 */
@Data
public class WebsocketClientConfiguration {
	/** The websocket connection port. Default: 9443. */
	private int websocketPort = 9443;
	/** The stream base url. */
	private String baseUrl = String.format("wss://stream.%s:%s/ws", RestClientConfiguration.getDefaultBaseDomain(),
			getWebsocketPort());
	/** The interval the client will send a ping. Default: 3m. */
	private Duration pingInterval = Duration.ofMinutes(3);
	/** Reconnect if stream is closed by server. Default: true */
	private boolean keepAlive = true;
	/** The number of time the client tries to reconnect. Default: 10. */
	private int reconnectionRetries = 10;
	/** The reconnection interval. Default: 30s. */
	private Duration reconnectionInterval = Duration.ofSeconds(10);
	/** The reconnection interval. Default: 30s. */
	private int maxReconnections = 5;
	/**
	 * The time the client waits for a server response before triggering a timeout.
	 * Default: 3min.
	 */
	private Duration noResponseTimeout = Duration.ofMinutes(3);
	/**
	 * Value added to {@link WebsocketClientConfiguration#noResponseTimeout} as
	 * time margin error. Default: 5s
	 */
	private Duration noResponseTimeoutMarginError = Duration.ofSeconds(5);
	/** Time after which the client disconnects if stuck in closing state */
	private Duration disconnectionTimeout = Duration.ofSeconds(5);

	/**
	 * Time after wich the client will disconnect.
	 * Default: 1 day.
	 */
	private Duration closeAfter = Duration.ofDays(1);
}
