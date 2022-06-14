package com.binance4j.nft.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * A NFT transaction history
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NFTTransactionHistory {
	/**
	 * total records
	 */
	private Long total;
	/**
	 * THe transactions
	 */
	private List<NFTTransaction> list;
}
