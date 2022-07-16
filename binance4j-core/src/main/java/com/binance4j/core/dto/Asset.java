package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** An asset on binance. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Asset(
		/** The asset id. */
		String id,
		/** The asset abbreviation. */
		String assetCode,
		/** The asset full name. */
		String assetName,
		/** Unit */
		String unit,
		/** The cost of a transaction. */
		BigDecimal transactionFee,
		/** The payment associated with a certain amount of sale. */
		BigDecimal commissionRate,
		/** Free audit withdraw amount */
		BigDecimal freeAuditWithdrawAmount,
		/** Free user charge amount */
		BigDecimal freeUserChargeAmount,
		/** The minimal amount you can withdraw. */
		BigDecimal minProductWithdraw,
		/** The smallest withdraw multiple. */
		BigDecimal withdrawIntegerMultiple,
		/** Time elapsed between the moment a blockchain transaction is submitted and recorded into a confirmed block */
		Long confirmTimes,
		/** is the withdrawal of the asset enabled. */
		Boolean enableWithdraw,
		/** is it issued by a government. */
		Boolean isLegalMoney) {
}