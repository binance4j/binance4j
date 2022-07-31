package com.binance4j.nft.dto;

import java.util.List;

/**
 * A NFT withdraw history
 * 
 * @param total Total records.
 * @param list  The transactions.
 */
public record AssetHistory(long total, List<Asset> list) {
}
