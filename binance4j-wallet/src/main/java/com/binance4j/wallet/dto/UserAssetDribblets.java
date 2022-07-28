package com.binance4j.wallet.dto;

import java.util.List;

/**
 * Dribblets.
 * 
 * @param operateTime              The operation timestamp.
 * @param totalTransferedAmount    Total transfered BNB amount for this exchange.
 * @param totalServiceChargeAmount Total service charge amount for this exchange.
 * @param transId                  The transaction id.
 * @param userAssetDribbletDetails Details of this exchange.
 */
public record UserAssetDribblets(
		/** The operation timestamp. */
		long operateTime,
		/** Total transfered BNB amount for this exchange. */
		String totalTransferedAmount,
		/** Total service charge amount for this exchange. */
		String totalServiceChargeAmount,
		/** The transaction id. */
		long transId,
		/** Details of this exchange. */
		List<UserAssetDribbletDetails> userAssetDribbletDetails) {
}