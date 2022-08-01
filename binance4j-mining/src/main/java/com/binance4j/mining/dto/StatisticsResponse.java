package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

/**
 * The {@link MiningClient} response.
 * 
 * @param code The response code.
 * @param msg  The response message.
 * @param data The response data.
 */
public record StatisticsResponse(int code, String msg, Statistics data) {
}
