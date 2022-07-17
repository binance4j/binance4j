package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * An asset on binance.
 * 
 * @param id                      The asset id.
 * @param assetCode               The asset abbreviation.
 * @param assetName               The asset full name.
 * @param unit                    Unit
 * @param transactionFee          The cost of a transaction.
 * @param commissionRate          The payment associated with a certain amount of sale.
 * @param freeAuditWithdrawAmount Free audit withdraw amount
 * @param freeUserChargeAmount    Free user charge amount
 * @param minProductWithdraw      The minimal amount you can withdraw.
 * @param withdrawIntegerMultiple The smallest withdraw multiple.
 * @param confirmTimes            Time elapsed between the moment a blockchain transaction is submitted and recorded
 *                                    into a confirmed block
 * @param enableWithdraw          s the withdrawal of the asset enabled.
 * @param isLegalMoney            s it issued by a government.
 */
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
		long confirmTimes,
		/** Is the withdrawal of the asset enabled. */
		boolean enableWithdraw,
		/** Is it issued by a government. */
		boolean isLegalMoney) {
}