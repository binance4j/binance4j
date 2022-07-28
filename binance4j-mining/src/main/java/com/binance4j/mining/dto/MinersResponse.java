package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link MiningClient} response.
 * 
 * @param code     The response code.
 * @param message  The response message.
 * @param data     The response data.
 * @param totalNum The total amount.
 * @param pageSize The rows per page.
 */
public record MinersResponse(
		/** The response code. */
		String code,
		/** The response message. */
		@JsonProperty("msg") String message,
		/** The response data. */
		List<Miner> data,
		/** The total amount. */
		long totalNum,
		/** The rows per page. */
		long pageSize) {
}