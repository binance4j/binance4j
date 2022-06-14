package com.binance4j.wallet.deposit;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * The coin deposit status
 */
@AllArgsConstructor
public enum DepositStatus {
	PENDING(0), CANNOT_WITHDRAW(6), SUCCESS(1);

	/**
	 * The status number
	 */
	@Getter
	private final int value;

	/**
	 * the enum corresponding to the integer if present
	 */
	public static DepositStatus valueOf(int value) {
		return Arrays.stream(values()).filter(e -> e.getValue() == value).findFirst().orElse(null);
	}
}
