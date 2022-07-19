package com.binance4j.wallet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The transfers wrapper.
 * 
 * @param rows  The list of transfers.
 * @param total The result size.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WalletTransferHistory(
		/** The list of transfers. */
		List<WalletTransfer> rows,
		/** The result size. */
		long total) {
}