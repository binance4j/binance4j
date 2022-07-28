package com.binance4j.nft.dto;

import java.util.List;

/**
 * NFT transaction
 * 
 * @param orderNo       The Order number.
 *                          <ul>
 *                          <li>0: purchase order</li>
 *                          <li>1: sell order</li>
 *                          <li>2: royalty income</li>
 *                          <li>3: primary market order</li>
 *                          <li>4: mint fee</li>
 *                          </ul>
 * @param tokens        The tokens.
 * @param tradeTime     The trade time in ms.
 * @param tradeAmount   The trade amount.
 * @param tradeCurrency The currency used to buy the NFT.
 */
public record Transaction(
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
		long tradeTime,
		/** The trade amount. */
		String tradeAmount,
		/** The currency used to buy the NFT. */
		String tradeCurrency) {
}
