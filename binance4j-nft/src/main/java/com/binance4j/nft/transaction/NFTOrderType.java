package com.binance4j.nft.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The NFT order type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public enum NFTOrderType {
	PURCHASE_ORDER(0),
	SELL_ORDER(1),
	ROYALTY_INCOME(2),
	PRIMARY_MARKET_ORDER(3),
	MINT_FEE(4);

	/**
	 * The error code
	 */
	@Getter
	private final int value;

}
