package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
		BigDecimal minWithdrawAmount,
		/** The deposit status (false if ALL of networks' are false). */
		boolean depositStatus,
		/** The withdraw fee. */
		Float withdrawFee,
		/** The withdraw status (false if ALL of networks' are false). */
		boolean withdrawStatus,
		/** The reason of the status. */
		@JsonProperty(defaultValue = "") String depositTip) {
}