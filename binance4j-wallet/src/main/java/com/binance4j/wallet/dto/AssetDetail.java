package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Details of a supported asset.
 * 
 * @param minWithdrawAmount The minimal withdraw amount.
 * @param depositStatus     The deposit status (false if ALL of networks' are false).
 * @param withdrawFee       The withdraw fee.
 * @param withdrawStatus    The withdraw status (false if ALL of networks' are false).
 * @param depositTip        The reason of the status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AssetDetail(
		/** The minimal withdraw amount. */
		String minWithdrawAmount,
		/** The deposit status (false if ALL of networks' are false). */
		boolean depositStatus,
		/** The withdraw fee. */
		Float withdrawFee,
		/** The withdraw status (false if ALL of networks' are false). */
		boolean withdrawStatus,
		/** Reason. */
		String depositTip) {
	/** @return Reason. */
	public String depositTip() {
		return depositTip == null ? "" : depositTip;
	}
}