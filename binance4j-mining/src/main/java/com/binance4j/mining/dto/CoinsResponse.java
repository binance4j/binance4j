package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;

/**
 * The {@link MiningClient#getCoins} response.
 * 
 * @param code The response code.
 * @param msg  The response message.
 * @param data The response data.
 */
public record CoinsResponse(String code, String msg, List<Coin> data) {
}