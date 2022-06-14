package com.binance4j.websocket.userdata;

import com.binance4j.core.request.Request;

/**
 * A request to get a listen key used to listen to the account stream
 */
public class UserStreamRequest extends Request {
	/**
	 * Constructor
	 */
	public UserStreamRequest() {
		super(1);
	}
}