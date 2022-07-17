package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The coin network informations */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CoinNetworkInformation(
		/** The address pattern. */
		String addressRegex,
		/** ? */
		String addressRule,
		/** The coin abbreviation. */
		String coin,
		/** The deposit description. */
		String depositDesc,
		/** The withdra description. */
		String withdrawDesc,
		/** The network name. */
		String name,
		/** The memo pattern. */
		String memoRegex,
		/** ? */
		String network,
		/** Tips about the network. */
		String specialTips,
		/** Tips about the withdraw. */
		String specialWithdrawTips,
		/** ? */
		BigDecimal depositDust,
		/** The withdraw fee. */
		BigDecimal withdrawFee,
		/** ? */
		BigDecimal withdrawIntegerMultiple,
		/** The maximal amount authorized to be withdrawn. */
		BigDecimal withdrawMax,
		/** The minimal amount authorized to be withdrawn. */
		BigDecimal withdrawMin,
		/** The min number for balance confirmation. */
		int minConfirm,
		/** The confirmation number for balance unlock. */
		int unLockConfirm,
		/** If deposit is enabled. */
		boolean depositEnable,
		/** if is the default network. */
		boolean isDefault,
		/** ? */
		boolean resetAddressStatus,
		/** If withdraw is enabled. */
		boolean withdrawEnable,
		/** If the coin needs to provide memo to withdraw. */
		boolean sameAddress) {
}