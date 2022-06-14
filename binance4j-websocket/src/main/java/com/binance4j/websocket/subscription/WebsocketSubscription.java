package com.binance4j.websocket.subscription;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Websocket subscription
 */
@Data
@AllArgsConstructor
public class WebsocketSubscription {
	/**
	 * The subscription method
	 */
	private WebsocketSubscriptionMethod method;
	/**
	 * The subscription params
	 */
	private String[] params;
	/**
	 * The subscription id
	 */
	private Long id;

	/**
	 * Constructor
	 *
	 * @param method  The subscription method
	 * @param symbols The symbols to subscribe to
	 */
	public WebsocketSubscription(WebsocketSubscriptionMethod method, String[] symbols) {
		this.method = method;
		this.params = symbols;
	}

	/**
	 * Converts the object into a string
	 */
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
}