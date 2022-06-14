package com.binance4j.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Tests the server responses
 */
public abstract class WebsocketTester<T> {
	final TestCallback<T> callback;

	/**
	 * @param callback The websocket callback
	 */
	public WebsocketTester(TestCallback<T> callback) {
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
		assertNotNull(callback.getContent().getOnOpenContent());
	}

	/**
	 * Tests the onClosing payload content
	 */
	public void assertClosing() {
		assertNotNull(callback.getContent().getOnClosingContent());
	}

	/**
	 * Tests the onClosed payload content
	 */
	public void assertClosed() {
		assertNotNull(callback.getContent().getOnClosedContent());
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
		testMessageContent(callback.getContent().getOnMessageContent());
	}

	/**
	 * Tests the onMessage payload content
	 *
	 * @param message the payload
	 */
	public abstract void testMessageContent(T message);
}
