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
public record SpotRebateHistoryResponse(
		/** The status */
		String status,
		/** The type */
		String type,
		/** The code */
		String code,
		/** The data */
		RebateData data) {
}
