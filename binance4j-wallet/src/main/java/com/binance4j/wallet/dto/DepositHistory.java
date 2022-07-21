package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A deposit history.
 * 
 * @param amount        The volume to deposit.
 * @param coin          The coin abbreviation.
 * @param network       The transfer network.
 * @param address       The deposit address.
 * @param addressTag    The deposit address tag.
 * @param txId          The transaction id.
 * @param unlockConfirm confirm times for unlocking.
 * @param confirmTimes  Confirm times
 * @param status        The withdraw status code.
 * @param insertTime    confirm times for insertion (?)
 * @param transferType  The transfer type. 1 for internal transfer, 0 for external transfer.
 */
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
		/** Confirm times */
		String confirmTimes,
		/** The withdraw status code. */
		int status,
		/** confirm times for insertion (?) */
		long insertTime,
		/** The transfer type. 1 for internal transfer, 0 for external transfer. */
		int transferType) {

	/** @return The withdraw status. */
	public DepositStatus getDepositStatus() {
		return DepositStatus.valueOf(status);
	}
}