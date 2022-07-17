package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A deposit history */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DepositHistory(
		/** The volume to deposit. */
		BigDecimal amount,
		/** The coin abbreviation. */
		String coin,
		/** The transfer network. */
		String network,
		/** The deposit address. */
		String address,
		/** The deposit address tag. */
		String addressTag,
		/** The transaction id. */
		String txId,
		/** confirm times for unlocking. */
		String unlockConfirm,
		/** TODO JAVADOC */
		String confirmTimes,
		/** The withdraw status code. */
		int status,
		/** confirm times for insertion (?) */
		long insertTime,
		/** The transfer type. 1 for internal transfer, 0 for external transfer. */
		int transferType) {

	/** The withdraw status. */
	public DepositStatus getDepositStatus() {
		return DepositStatus.valueOf(status);
	}
}