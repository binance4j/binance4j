package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

/**
 * The {@link MiningClient} response.
 * 
 * @param code     The response code.
 * @param message  The response message.
 * @param data     The response data.
 * @param totalNum The total amount.
 * @param pageSize The rows per page.
 */
public record OtherProfitsResponse(int code, String msg, ProfitsData data, long totalNum, long pageSize) {
}