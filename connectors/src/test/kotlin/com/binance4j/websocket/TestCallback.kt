/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.websocket;

import java.util.concurrent.CompletableFuture;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.client.BaseWebsocketClient;

import okhttp3.Response;

/** Event handler callback. */
public class TestCallback<T> extends CustomTest:WebsocketCallback<T>
{
	/** The CompletableFuture preventing the process to end before the tests. */
	protected CompletableFuture<Void> future;
	/** The ws client. */
	protected BaseWebsocketClient<T> websocketClient;

	/** @param client. */
	public TestCallback() {
		super();
		future = new CompletableFuture<>();
	}

	public void onMessage(Object response) {
		testNoNulls(response);
		if (websocketClient != null) {
			websocketClient.close();
		}
	}

	public void onOpen(Response response) {
		testNoNulls(response);
	}

	public void onFailure(ApiException exception) {
		testNoNulls(exception);
		websocketClient.close();
		future.complete(null);
	}

	public void onClosing(WebsocketCloseObject websocketCloseObject) {
		testNoNulls(websocketCloseObject);
	}

	public void onClosed(WebsocketCloseObject websocketCloseObject) {
		testNoNulls(websocketCloseObject);
		future.complete(null);
	}

	/**
	 * @return the future.
	 */
	public CompletableFuture<Void> getFuture() {
		return future;
	}

	/**
	 * @param future Future to set.
	 */
	public void setFuture(CompletableFuture<Void> future) {
		this.future = future;
	}

	/**
	 * @return the websocketClient.
	 */
	public BaseWebsocketClient<T> getWebsocketClient() {
		return websocketClient;
	}

	/**
	 * @param websocketClient WebsocketClient to set.
	 */
	public void setWebsocketClient(BaseWebsocketClient<T> websocketClient) {
		this.websocketClient = websocketClient;
	}
}
