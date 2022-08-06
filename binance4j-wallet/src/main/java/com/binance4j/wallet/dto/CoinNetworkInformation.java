package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The coin network informations.
 * 
 * @param addressRegex            Address pattern.
 * @param addressRule             Address rule
 * @param coin                    Coin abbreviation.
 * @param depositDesc             Deposit description.
 * @param withdrawDesc            Withdra description.
 * @param name                    Network name.
 * @param memoRegex               Memo pattern.
 * @param network                 Network
 * @param specialTips             Tips about the network.
 * @param specialWithdrawTips     Tips about the withdraw.
 * @param depositDust             Deposit dust.
 * @param withdrawFee             Withdraw fee.
 * @param withdrawIntegerMultiple Withdraw integer multiple
 * @param withdrawMax             Maximal amount authorized to be withdrawn.
 * @param withdrawMin             Minimal amount authorized to be withdrawn.
 * @param minConfirm              Min number for balance confirmation.
 * @param unLockConfirm           Confirmation number for balance unlock.
 * @param depositEnable           If deposit is enabled.
 * @param isDefault               if is the default network.
 * @param resetAddressStatus      Reset address status.
 * @param withdrawEnable          If withdraw is enabled.
 * @param sameAddress             If the coin needs to provide memo to withdraw.
 */
@ApiModel("The coin network informations.")
public record CoinNetworkInformation(@ApiModelProperty("Address pattern.") String addressRegex, @ApiModelProperty("Address rule") String addressRule,
		@ApiModelProperty("Coin abbreviation.") String coin, @ApiModelProperty("Deposit description.") String depositDesc,
		@ApiModelProperty("Withdra description.") String withdrawDesc, @ApiModelProperty("Network name.") String name,
		@ApiModelProperty("Memo pattern.") String memoRegex, @ApiModelProperty("Network") String network,
		@ApiModelProperty("Tips about the network.") String specialTips, @ApiModelProperty("Tips about the withdraw.") String specialWithdrawTips,
		@ApiModelProperty("Deposit dust.") String depositDust, @ApiModelProperty("Withdraw fee.") String withdrawFee,
		@ApiModelProperty("Withdraw integer multiple") String withdrawIntegerMultiple,
		@ApiModelProperty("Maximal amount authorized to be withdrawn.") String withdrawMax,
		@ApiModelProperty("Minimal amount authorized to be withdrawn.") String withdrawMin,
		@ApiModelProperty("Min number for balance confirmation.") int minConfirm,
		@ApiModelProperty("Confirmation number for balance unlock.") int unLockConfirm, @ApiModelProperty("If deposit is enabled.") boolean depositEnable,
		@ApiModelProperty("if is the default network.") boolean isDefault, @ApiModelProperty("Reset address status.") boolean resetAddressStatus,
		@ApiModelProperty("If withdraw is enabled.") boolean withdrawEnable,
		@ApiModelProperty("If the coin needs to provide memo to withdraw.") boolean sameAddress) {
}