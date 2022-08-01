package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;

/**
 * The {@link MiningClient#getAlgorithms} response.
 * 
 * @param code Response code.
 * @param msg  Response message.
 * @param data Response data.
 */
public record AlgorithmsResponse(int code, String msg, List<Algorithm> data) {
}