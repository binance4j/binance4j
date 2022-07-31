package com.binance4j.wallet.dto;

import java.util.List;

/**
 * The transfers wrapper.
 * 
 * @param rows  The list of transfers.
 * @param total The result size.
 */
public record WalletTransferHistory(List<WalletTransfer> rows, long total) {
}