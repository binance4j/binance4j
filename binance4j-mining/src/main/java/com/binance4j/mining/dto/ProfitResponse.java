package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;

/**
 * The {@link MiningClient} response.
 * 
 * @param code    Response code.
 * @param message Response message.
 * @param data    Response data.
 */
public record ProfitResponse(int code, String msg, List<Profit> data) {
}