package com.binance4j.rebate.dto;

import com.binance4j.rebate.client.RebateClient;

/**
 * {@link RebateClient#getSpotRebateHistoryRecords} response.
 * 
 * @param status The status.
 * @param type   The type.
 * @param code   The code.
 * @param data   The data.
 */
public record SpotRebateHistoryResponse(String status, String type, String code, RebateData data) {
}
