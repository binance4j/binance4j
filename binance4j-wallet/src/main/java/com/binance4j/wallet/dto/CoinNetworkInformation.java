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
public record CoinNetworkInformation(String addressRegex, String addressRule, String coin, String depositDesc, String withdrawDesc, String name,
		String memoRegex, String network, String specialTips, String specialWithdrawTips, String depositDust, String withdrawFee,
		String withdrawIntegerMultiple, String withdrawMax, String withdrawMin, int minConfirm, int unLockConfirm, boolean depositEnable, boolean isDefault,
		boolean resetAddressStatus, boolean withdrawEnable, boolean sameAddress) {
}