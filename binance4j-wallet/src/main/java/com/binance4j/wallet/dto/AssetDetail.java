package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Details of a supported asset */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AssetDetail(
		/** The minimal withdraw amount. */
		BigDecimal minWithdrawAmount,
		/** The deposit status (false if ALL of networks' are false). */
		boolean depositStatus,
		/** The withdraw fee. */
		Float withdrawFee,
		/** The withdraw status (false if ALL of networks' are false). */
		boolean withdrawStatus, /** The reason of the status. */
		String depositTip) {
	public String getDepositTip() {
		return depositTip == null ? "" : depositTip;
	}
}