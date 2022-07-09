package com.binance4j.utils;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.binance4j.core.test.ConcurrentTest;

/**
 * Tests the server responses
 */
public class WebsocketTester<T> extends ConcurrentTest<Void> {

	final TestCallback<T> callback;

	/**
	 * @param callback The websocket callback
	 */
	public WebsocketTester(TestCallback<T> callback) {
		super();
		this.callback = callback;
	}

	/**
	 * Asserts all content
	 */
	public void assertContent() {
		assertOpen();
		assertClosing();
		assertClosed();
		assertFailure();
		assertMessage();
	}

	/**
	 * Tests the onOpen payload content
	 */
	public void assertOpen() {
		test(callback.getContent().getOnOpenContent());
	}

	/**
	 * Tests the onClosing payload content
	 */
	public void assertClosing() {
		test(callback.getContent().getOnClosingContent());
	}

	/**
	 * Tests the onClosed payload content
	 */
	public void assertClosed() {
		test(callback.getContent().getOnClosedContent());
	}

	/**
	 * Tests the onFailure payload content
	 */
	public void assertFailure() {
		assertNull(callback.getContent().getOnFailureContent());
	}

	/**
	 * Tests the onMessage payload content
	 */
	public void assertMessage() {
		test(callback.getContent().getOnMessageContent());
	}
}
