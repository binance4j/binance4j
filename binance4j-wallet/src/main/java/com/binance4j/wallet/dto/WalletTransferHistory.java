package com.binance4j.wallet.dto;

import java.util.List;

/**
 * The transfers wrapper.
 * 
 * @param rows  The list of transfers.
 * @param total The result size.
 */
public record WalletTransferHistory(
		/** The list of transfers. */
		List<WalletTransfer> rows,
		/** The result size. */
		long total) {
}