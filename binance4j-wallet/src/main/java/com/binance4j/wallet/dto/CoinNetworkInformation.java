package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel("")
public record CoinNetworkInformation(@ApiModelProperty("") String addressRegex, @ApiModelProperty("") String addressRule, @ApiModelProperty("") String coin,
		@ApiModelProperty("") String depositDesc, @ApiModelProperty("") String withdrawDesc, @ApiModelProperty("") String name,
		@ApiModelProperty("") String memoRegex, @ApiModelProperty("") String network, @ApiModelProperty("") String specialTips,
		@ApiModelProperty("") String specialWithdrawTips, @ApiModelProperty("") String depositDust, @ApiModelProperty("") String withdrawFee,
		@ApiModelProperty("") String withdrawIntegerMultiple, @ApiModelProperty("") String withdrawMax, @ApiModelProperty("") String withdrawMin,
		@ApiModelProperty("") int minConfirm, @ApiModelProperty("") int unLockConfirm, @ApiModelProperty("") boolean depositEnable,
		@ApiModelProperty("") boolean isDefault, @ApiModelProperty("") boolean resetAddressStatus, @ApiModelProperty("") boolean withdrawEnable,
		@ApiModelProperty("") boolean sameAddress) {
}