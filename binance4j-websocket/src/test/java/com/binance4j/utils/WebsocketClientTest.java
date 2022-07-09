package com.binance4j.utils;

import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CompletableFuture;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.depth.WebsocketAllBookTickersClient;
import com.binance4j.websocket.userdata.UserDataClient;
import com.binance4j.websocket.userdata.WebsocketUserDataClient;

import lombok.Data;

/**
 * Base class to test a websocket client
 */
@Data
public abstract class WebsocketClientTest<T> {
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
	public WebsocketClientTest(Class<? extends BaseWebsocketClient<T>> clientClass) {
		System.out.println(clientClass);
		try {
			future = new CompletableFuture<>();
			callback = new TestCallback<>();
			tester = new WebsocketTester<T>(callback);

			if (clientClass.getSimpleName() == WebsocketUserDataClient.class.getSimpleName()) {
				String key = System.getenv("BINANCE_API_KEY"), secret = System.getenv("BINANCE_API_SECRET");
				client = clientClass.getDeclaredConstructor(UserDataClient.class, WebsocketCallback.class)
						.newInstance(new UserDataClient(key, secret), callback);
			} else if (clientClass.getSimpleName() == WebsocketAllBookTickersClient.class.getSimpleName()) {
				client = clientClass.getDeclaredConstructor(WebsocketCallback.class).newInstance(callback);
			} else {
				client = clientClass.getDeclaredConstructor(String.class, WebsocketCallback.class).newInstance(
						tester.getSymbol(), callback);
			}

			callback.setClient(client);
			callback.setFuture(future);
			client.open();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Waits for the server to send all to be tested data then tests it
	 */
	public void test() {
		try {
			getFuture().get();
			getTester().assertContent();
		} catch (Exception e) {
			getFuture().complete(null);
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
}
