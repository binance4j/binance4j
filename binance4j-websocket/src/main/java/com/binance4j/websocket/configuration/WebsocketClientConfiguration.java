package com.binance4j.websocket.configuration;

import java.time.Duration;

/** The websocket client ocnfiguration */
public class WebsocketClientConfiguration {
	/** The websocket connection port. Default: 9443. */
	private int websocketPort = 9443;
	/** stream base domain. */
	private String baseDomain = "binance.com";
	/** The stream base url. */
	private String baseUrl = String.format("wss://stream.%s:%s/ws", baseDomain, websocketPort);
	/** The interval the client will send a ping. Default: 3m. */
	private Duration pingInterval = Duration.ofMinutes(3);
	/** Reconnect if stream is closed by server. Default: true. */
	private boolean keepAlive = true;
	/** The number of time the client tries to reconnect. Default: 10. */
	private int reconnectionRetries = 10;
	/** The reconnection interval. Default: 30s. */
	private Duration reconnectionInterval = Duration.ofSeconds(10);
	/** The reconnection interval. Default: 30s. */
	private int maxReconnections = 5;
	/**
	 * The time the client waits for a server response before triggering a timeout. Default: 3min.
	 */
	private Duration noResponseTimeout = Duration.ofMinutes(3);
	/**
	 * Value added to {@link WebsocketClientConfiguration#noResponseTimeout} as time margin error. Default: 5s
	 */
	private Duration noResponseTimeoutMarginError = Duration.ofSeconds(5);
	/** Time after which the client disconnects if stuck in closing state. */
	private Duration disconnectionTimeout = Duration.ofSeconds(5);

	/**
	 * Time after wich the client will disconnect. Default: 1 day.
	 */
	private Duration closeAfter = Duration.ofDays(1);

	/**
	 * @return the websocketPort
	 */
	public int getWebsocketPort() {
		return websocketPort;
	}

	/**
	 * @param websocketPort the websocketPort to set
	 */
	public void setWebsocketPort(int websocketPort) {
		this.websocketPort = websocketPort;
	}

	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * @param baseUrl the baseUrl to set
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
	 * @param pingInterval the pingInterval to set
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
	 * @param keepAlive the keepAlive to set
	 */
	public void setKeepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
	}

	/**
	 * @return the reconnectionRetries
	 */
	public int getReconnectionRetries() {
		return reconnectionRetries;
	}

	/**
	 * @param reconnectionRetries the reconnectionRetries to set
	 */
	public void setReconnectionRetries(int reconnectionRetries) {
		this.reconnectionRetries = reconnectionRetries;
	}

	/**
	 * @return the reconnectionInterval
	 */
	public Duration getReconnectionInterval() {
		return reconnectionInterval;
	}

	/**
	 * @param reconnectionInterval the reconnectionInterval to set
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
	 * @param maxReconnections the maxReconnections to set
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
	 * @param noResponseTimeout the noResponseTimeout to set
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
	 * @param noResponseTimeoutMarginError the noResponseTimeoutMarginError to set
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
	 * @param disconnectionTimeout the disconnectionTimeout to set
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
	 * @param closeAfter the closeAfter to set
	 */
	public void setCloseAfter(Duration closeAfter) {
		this.closeAfter = closeAfter;
	}

	@Override
	public String toString() {
		return "WebsocketClientConfiguration [baseUrl=" + baseUrl + ", closeAfter=" + closeAfter + ", disconnectionTimeout=" + disconnectionTimeout
				+ ", keepAlive=" + keepAlive + ", maxReconnections=" + maxReconnections + ", noResponseTimeout=" + noResponseTimeout
				+ ", noResponseTimeoutMarginError=" + noResponseTimeoutMarginError + ", pingInterval=" + pingInterval + ", reconnectionInterval="
				+ reconnectionInterval + ", reconnectionRetries=" + reconnectionRetries + ", websocketPort=" + websocketPort + "]";
	}

}
