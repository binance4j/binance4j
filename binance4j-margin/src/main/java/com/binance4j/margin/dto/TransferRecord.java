package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A transfer history record
 * 
 * @param id        The transaction id.
 * @param amount    The transfered amount.
 * @param asset     The transfered asset.
 * @param status    The transfer status.
 * @param timestamp The transaction time in ms.
 * @param type      The transfer history type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TransferRecord(
		/** The transaction id. */
		@JsonProperty("txId") long id,
		/** The transfered amount. */
		BigDecimal amount,
		/** The transfered asset. */
		String asset,
		/** The transfer status. */
		String status,
		/** The transaction time in ms. */
		long timestamp,
		/** The transfer history type. */
		TransferRecordType type) {
}