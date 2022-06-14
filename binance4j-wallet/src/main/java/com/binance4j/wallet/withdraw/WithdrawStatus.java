package com.binance4j.wallet.withdraw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The status of a withdraw
 */
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public enum WithdrawStatus {
	EMAIL_SENT(0),
	CANCELLED(1),
	AWAITING_APPROVAL(2),
	REJECTED(3),
	PROCESSING(4),
	FAILURE(5),
	COMPLETED(6);

	@Getter
	private final int value;
}