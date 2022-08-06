package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A deposit history.
 * 
 * @param amount        Volume to deposit.
 * @param coin          Coin abbreviation.
 * @param network       Transfer network.
 * @param address       Deposit address.
 * @param addressTag    Deposit address tag.
 * @param txId          Transaction id.
 * @param unlockConfirm confirm times for unlocking.
 * @param confirmTimes  Confirm times
 * @param status        Withdraw status code.
 * @param insertTime    confirm times for insertion (?)
 * @param transferType  Transfer type. 1 for internal transfer, 0 for external transfer.
 */
@ApiModel("A deposit history.")
public record DepositHistory(@ApiModelProperty("A deposit history.") String amount, @ApiModelProperty("A deposit history.") String coin,
		@ApiModelProperty("A deposit history.") String network, @ApiModelProperty("A deposit history.") String address,
		@ApiModelProperty("A deposit history.") String addressTag, @ApiModelProperty("A deposit history.") String txId,
		@ApiModelProperty("A deposit history.") String unlockConfirm, @ApiModelProperty("A deposit history.") String confirmTimes,
		@ApiModelProperty("A deposit history.") String status, @ApiModelProperty("A deposit history.") long insertTime,
		@ApiModelProperty("A deposit history.") int transferType) {
	/** @return The withdraw status. */
	public DepositStatus getDepositStatus() {
		return DepositStatus.valueOf(status);
	}
}