package com.binance4j.utils;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import lombok.Data;
import okhttp3.Response;

/**
 * Stores the server responses
 */
@Data
public class TestCallbackContent<T> {
	private WebsocketCloseObject onClosingContent;
	private WebsocketCloseObject onClosedContent;
	private Response onOpenContent;
	private ApiException onFailureContent;
	private T onMessageContent;
}
