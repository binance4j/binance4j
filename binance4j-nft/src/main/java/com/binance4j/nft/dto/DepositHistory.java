package com.binance4j.nft.dto;

import java.util.List;

/**
 * A NFT deposit history
 * 
 * @param total Total records.
 * @param list  The transactions.
 */
public record DepositHistory(long total, List<Deposit> list) {
}
