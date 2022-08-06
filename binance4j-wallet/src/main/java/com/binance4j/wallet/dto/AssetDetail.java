package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Details of a supported asset.
 * 
 * @param minWithdrawAmount Minimal withdraw amount.
 * @param depositStatus     Deposit status (false if ALL of networks' are false).
 * @param withdrawFee       Withdraw fee.
 * @param withdrawStatus    Withdraw status (false if ALL of networks' are false).
 * @param depositTip        Reason of the status.
 */
@ApiModel("Details of a supported asset.")
public record AssetDetail(@ApiModelProperty("Minimal withdraw amount.") String minWithdrawAmount,
		@ApiModelProperty("Deposit status (false if ALL of networks' are false).") boolean depositStatus, @ApiModelProperty("Withdraw fee.") Float withdrawFee,
		@ApiModelProperty("Withdraw status (false if ALL of networks' are false).") boolean withdrawStatus,
		@ApiModelProperty("Reason of the status.") String depositTip) {
	/** @return Reason. */
	public String depositTip() {
		return depositTip == null ? "" : depositTip;
	}
}