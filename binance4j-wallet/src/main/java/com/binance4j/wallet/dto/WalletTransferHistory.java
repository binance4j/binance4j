package com.binance4j.wallet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The transfers wrapper */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WalletTransferHistory(
		/** The list of transfers. */
		List<WalletTransfer> rows,
		/** The result size. */
		Long total) {
}