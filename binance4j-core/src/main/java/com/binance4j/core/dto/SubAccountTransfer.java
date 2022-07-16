package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO transfer to sub account module when created
@JsonIgnoreProperties(ignoreUnknown = true)
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
		String qty,
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