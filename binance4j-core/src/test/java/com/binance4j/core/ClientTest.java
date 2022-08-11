package com.binance4j.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.client.TestClient;

public class ClientTest {
	@Test
	void testTestnet() {
		TestClient client = new TestClient();
		assertDoesNotThrow(() -> {
			client.ping().sync();
		});
	}

	@Test
	void testTestnet2() throws InterruptedException, ExecutionException {
		TestClient client = new TestClient();
		CompletableFuture<Void> future = new CompletableFuture<>();

		client.time().async((response, headers, exception) -> {
			System.out.println(headers);
			System.out.println(response);
			System.out.println(exception);
			assertNotNull(response);
			assertNotNull(headers);
			assertNull(exception);
			future.complete(null);
		});

		future.get();
	}

	@Test
	void testTestnet3() throws InterruptedException, ExecutionException {
		TestClient client = new TestClient();
		CompletableFuture<Void> future = new CompletableFuture<>();

		client.notFound().async((response, headers, exception) -> {
			System.out.println(headers);
			System.out.println(response);
			System.out.println(exception);
			assertNotNull(exception);
			assertNotNull(headers);
			assertNull(response);
			future.complete(null);
		});

		future.get();
	}
}
