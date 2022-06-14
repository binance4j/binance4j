package com.binance4j.utils;

import com.binance4j.websocket.client.BaseWebsocketClient;
import lombok.Data;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Base class to test a websocket client
 */
@Data
public abstract class BaseWebsocketClientTest<T> {
	/**
	 * The websocket client to test
	 */
	private BaseWebsocketClient<T> client;
	/**
	 * The CompletableFuture that will prevent the process from closing until the
	 * end of the tests
	 */
	private CompletableFuture<Void> future;
	/**
	 * The The callback collecting the server responses
	 */
	private TestCallback<T> callback;
	/**
	 * The instance responsible for testing the content returned by the server
	 */
	private WebsocketTester<T> tester;

	/**
	 * Constructor
	 */
	protected BaseWebsocketClientTest() {
		future = new CompletableFuture<>();
		callback = new TestCallback<>();
		client = newClient(callback);
		tester = newTester(callback);
		callback.setClient(client);
		callback.setFuture(future);
		client.open();
	}

	/**
	 * Waits for the server to send all to be tested data then tests it
	 */
	protected void test() {
		try {
			getFuture().get();
			getTester().assertContent();
		} catch (Exception e) {
			getFuture().complete(null);
			fail(e.getMessage());
		}
	}

	/**
	 * Generates a websocket client
	 *
	 * @param callback The websocket event handler
	 * @return a new websocket instance
	 */
	protected abstract BaseWebsocketClient<T> newClient(TestCallback<T> callback);

	/**
	 * Generates a websocket client tester
	 *
	 * @param callback The websocket event handler
	 * @return a new websocket instance
	 */
	protected abstract WebsocketTester<T> newTester(TestCallback<T> callback);
}
