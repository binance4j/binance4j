package com.binance4j.nft.deposit;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * A NFT deposit history
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NFTDepositHistory {
	/**
	 * total records
	 */
	private Long total;
	/**
	 * THe transactions
	 */
	private List<NFTDeposit> list;
}
