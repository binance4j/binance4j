package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The coin network informations.
 * 
 * @param addressRegex            The address pattern.
 * @param addressRule             TODO JAVADOC
 * @param coin                    The coin abbreviation.
 * @param depositDesc             The deposit description.
 * @param withdrawDesc            The withdra description.
 * @param name                    The network name.
 * @param memoRegex               The memo pattern.
 * @param network                 TODO JAVADOC
 * @param specialTips             Tips about the network.
 * @param specialWithdrawTips     Tips about the withdraw.
 * @param depositDust             TODO JAVADOC
 * @param withdrawFee             The withdraw fee.
 * @param withdrawIntegerMultiple TODO JAVADOC
 * @param withdrawMax             The maximal amount authorized to be withdrawn.
 * @param withdrawMin             The minimal amount authorized to be withdrawn.
 * @param minConfirm              The min number for balance confirmation.
 * @param unLockConfirm           The confirmation number for balance unlock.
 * @param depositEnable           If deposit is enabled.
 * @param isDefault               if is the default network.
 * @param resetAddressStatus      TODO JAVADOC
 * @param withdrawEnable          If withdraw is enabled.
 * @param sameAddress             If the coin needs to provide memo to withdraw.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CoinNetworkInformation(
		/** The address pattern. */
		String addressRegex,
		/** TODO JAVADOC */
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
		/** TODO JAVADOC */
		String network,
		/** Tips about the network. */
		String specialTips,
		/** Tips about the withdraw. */
		String specialWithdrawTips,
		/** TODO JAVADOC */
		BigDecimal depositDust,
		/** The withdraw fee. */
		BigDecimal withdrawFee,
		/** TODO JAVADOC */
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
		/** TODO JAVADOC */
		boolean resetAddressStatus,
		/** If withdraw is enabled. */
		boolean withdrawEnable,
		/** If the coin needs to provide memo to withdraw. */
		boolean sameAddress) {
}