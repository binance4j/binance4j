package com.binance4j.nft.dto;

import java.util.List;

/**
 * A NFT transaction history
 * 
 * @param total Total records.
 * @param list  The transactions.
 */
public record TransactionHistory(long total, List<Transaction> list) {
}
