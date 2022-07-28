package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO transfer to sub account module when created
/**
 * Sub account transfer
 * 
 * @param counterParty    Counter party name.
 * @param email           Counter party email.
 * @param type            Transfer in or transfer out.
 * @param asset           Transfer asset.
 * @param quantity        Quantity of transfer asset.
 * @param fromAccountType Type of from account.
 * @param toAccountType   Type of to account.
 * @param status          Transfer status.
 * @param tranId          Transfer ID.
 * @param time            Transfer time.
 */
public record SubAccountTransfer(
		/** Counter party name. */
		String counterParty,
		/** Counter party email. */
		String email,
		/** Transfer in or transfer out. */
		int type, // 1 for transfer in, 2 for transfer out
		/** Transfer asset. */
		String asset,
		/** Quantity of transfer asset. */
		@JsonProperty("qty") String quantity,
		/** Type of from account. */
		String fromAccountType,
		/** Type of to account. */
		String toAccountType,
		/** Transfer status. */
		String status,
		/** Transfer ID. */
		long tranId,
		/** Transfer time. */
		long time) {
}