package com.binance4j.wallet.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dribblets.
 * 
 * @param operateTime              The operation timestamp.
 * @param totalTransferedAmount    Total transfered BNB amount for this exchange.
 * @param totalServiceChargeAmount Total service charge amount for this exchange.
 * @param transId                  The transaction id.
 * @param userAssetDribbletDetails Details of this exchange.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserAssetDribblets(
		/** The operation timestamp. */
		long operateTime,
		/** Total transfered BNB amount for this exchange. */
		BigDecimal totalTransferedAmount,
		/** Total service charge amount for this exchange. */
		BigDecimal totalServiceChargeAmount,
		/** The transaction id. */
		long transId,
		/** Details of this exchange. */
		List<UserAssetDribbletDetails> userAssetDribbletDetails) {
}