package com.binance4j.wallet.dto;

/**
 * The coin network informations.
 * 
 * @param addressRegex            The address pattern.
 * @param addressRule             Address rule
 * @param coin                    The coin abbreviation.
 * @param depositDesc             The deposit description.
 * @param withdrawDesc            The withdra description.
 * @param name                    The network name.
 * @param memoRegex               The memo pattern.
 * @param network                 The network
 * @param specialTips             Tips about the network.
 * @param specialWithdrawTips     Tips about the withdraw.
 * @param depositDust             Deposit dust.
 * @param withdrawFee             The withdraw fee.
 * @param withdrawIntegerMultiple Withdraw integer multiple
 * @param withdrawMax             The maximal amount authorized to be withdrawn.
 * @param withdrawMin             The minimal amount authorized to be withdrawn.
 * @param minConfirm              The min number for balance confirmation.
 * @param unLockConfirm           The confirmation number for balance unlock.
 * @param depositEnable           If deposit is enabled.
 * @param isDefault               if is the default network.
 * @param resetAddressStatus      Reset address status.
 * @param withdrawEnable          If withdraw is enabled.
 * @param sameAddress             If the coin needs to provide memo to withdraw.
 */
public record CoinNetworkInformation(
		/** The address pattern. */
		String addressRegex,
		/** Address rule */
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
		/** The network */
		String network,
		/** Tips about the network. */
		String specialTips,
		/** Tips about the withdraw. */
		String specialWithdrawTips,
		/** Deposit dust. */
		String depositDust,
		/** The withdraw fee. */
		String withdrawFee,
		/** Withdraw integer multiple */
		String withdrawIntegerMultiple,
		/** The maximal amount authorized to be withdrawn. */
		String withdrawMax,
		/** The minimal amount authorized to be withdrawn. */
		String withdrawMin,
		/** The min number for balance confirmation. */
		int minConfirm,
		/** The confirmation number for balance unlock. */
		int unLockConfirm,
		/** If deposit is enabled. */
		boolean depositEnable,
		/** if is the default network. */
		boolean isDefault,
		/** Reset address status. */
		boolean resetAddressStatus,
		/** If withdraw is enabled. */
		boolean withdrawEnable,
		/** If the coin needs to provide memo to withdraw. */
		boolean sameAddress) {
}