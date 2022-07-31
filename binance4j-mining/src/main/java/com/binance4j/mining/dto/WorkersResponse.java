package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

/**
 * The {@link MiningClient} response.
 * 
 * @param code    Response code.
 * @param message Response message.
 * @param data    Response data.
 */
public record WorkersResponse(int code, String msg, WorkersData data) {
}