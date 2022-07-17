package com.binance4j.nft.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NFTTransaction(
		/**
		 * The Order number.
		 * <ul>
		 * <li>0: purchase order</li>
		 * <li>1: sell order</li>
		 * <li>2: royalty income</li>
		 * <li>3: primary market order</li>
		 * <li>4: mint fee</li>
		 * </ul>
		 */
		String orderNo,
		/** The tokens. */
		List<NFT> tokens,
		/** The trade time in ms. */
		Long tradeTime,
		/** The trade amount. */
		BigDecimal tradeAmount,
		/** The currency used to buy the NFT. */
		String tradeCurrency) {
}
