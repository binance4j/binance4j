package com.binance4j.websocket.configuration;

import java.time.Duration;

/** The websocket client ocnfiguration */
public class WebsocketClientConfiguration {
	/** The stream base url. */
	String baseUrl = "wss://stream.binance.com:9443/ws";
	/** The interval the client will send a ping. Default: 3m. */
	Duration pingInterval = Duration.ofMinutes(3);
	/** Reconnect if stream is closed by server. Default: true. */
	boolean keepAlive = true;
	/** The reconnection interval. Default: 30s. */
	Duration reconnectionInterval = Duration.ofSeconds(10);
	/** The number of time the client tries to reconnect. Default: 5. */
	int maxReconnections = 5;
	/**
	 * The time the client waits for a server response before triggering a timeout.
	 * Default: 3min.
	 */
	Duration noResponseTimeout = Duration.ofMinutes(3);
	/**
	 * Value added to {@link WebsocketClientConfiguration#noResponseTimeout} as time
	 * margin error. Default: 5s
	 */
	Duration noResponseTimeoutMarginError = Duration.ofSeconds(5);
	/** Time after which the client disconnects if stuck in closing state. */
	Duration disconnectionTimeout = Duration.ofSeconds(5);
	/**
	 * Time after wich the client will disconnect. Default: 1 day.
	 */
	Duration closeAfter = Duration.ofDays(1);

	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * @param baseUrl BaseUrl to set
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * @return the pingInterval
	 */
	public Duration getPingInterval() {
		return pingInterval;
	}

	/**
	 * @param pingInterval PingInterval to set
	 */
	public void setPingInterval(Duration pingInterval) {
		this.pingInterval = pingInterval;
	}

	/**
	 * @return the keepAlive
	 */
	public boolean isKeepAlive() {
		return keepAlive;
	}

	/**
	 * @param keepAlive KeepAlive to set
	 */
	public void setKeepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
	}

	/**
	 * @return the reconnectionInterval
	 */
	public Duration getReconnectionInterval() {
		return reconnectionInterval;
	}

	/**
	 * @param reconnectionInterval ReconnectionInterval to set
	 */
	public void setReconnectionInterval(Duration reconnectionInterval) {
		this.reconnectionInterval = reconnectionInterval;
	}

	/**
	 * @return the maxReconnections
	 */
	public int getMaxReconnections() {
		return maxReconnections;
	}

	/**
	 * @param maxReconnections MaxReconnections to set
	 */
	public void setMaxReconnections(int maxReconnections) {
		this.maxReconnections = maxReconnections;
	}

	/**
	 * @return the noResponseTimeout
	 */
	public Duration getNoResponseTimeout() {
		return noResponseTimeout;
	}

	/**
	 * @param noResponseTimeout NoResponseTimeout to set
	 */
	public void setNoResponseTimeout(Duration noResponseTimeout) {
		this.noResponseTimeout = noResponseTimeout;
	}

	/**
	 * @return the noResponseTimeoutMarginError
	 */
	public Duration getNoResponseTimeoutMarginError() {
		return noResponseTimeoutMarginError;
	}

	/**
	 * @param noResponseTimeoutMarginError NoResponseTimeoutMarginError to set
	 */
	public void setNoResponseTimeoutMarginError(Duration noResponseTimeoutMarginError) {
		this.noResponseTimeoutMarginError = noResponseTimeoutMarginError;
	}

	/**
	 * @return the disconnectionTimeout
	 */
	public Duration getDisconnectionTimeout() {
		return disconnectionTimeout;
	}

	/**
	 * @param disconnectionTimeout DisconnectionTimeout to set
	 */
	public void setDisconnectionTimeout(Duration disconnectionTimeout) {
		this.disconnectionTimeout = disconnectionTimeout;
	}

	/**
	 * @return the closeAfter
	 */
	public Duration getCloseAfter() {
		return closeAfter;
	}

	/**
	 * @param closeAfter CloseAfter to set
	 */
	public void setCloseAfter(Duration closeAfter) {
		this.closeAfter = closeAfter;
	}

	@Override
	public String toString() {
		return "WebsocketClientConfiguration [baseUrl=" + baseUrl + ", closeAfter=" + closeAfter
				+ ", disconnectionTimeout=" + disconnectionTimeout
				+ ", keepAlive=" + keepAlive + ", maxReconnections=" + maxReconnections + ", noResponseTimeout="
				+ noResponseTimeout
				+ ", noResponseTimeoutMarginError=" + noResponseTimeoutMarginError + ", pingInterval=" + pingInterval
				+ ", reconnectionInterval="
				+ reconnectionInterval + "]";
	}
}
