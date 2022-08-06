package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A deposit history.
 * 
 * @param amount        The volume to deposit.
 * @param coin          The coin abbreviation.
 * @param network       The transfer network.
 * @param address       The deposit address.
 * @param addressTag    The deposit address tag.
 * @param txId          The transaction id.
 * @param unlockConfirm confirm times for unlocking.
 * @param confirmTimes  Confirm times
 * @param status        The withdraw status code.
 * @param insertTime    confirm times for insertion (?)
 * @param transferType  The transfer type. 1 for internal transfer,@ApiModelProperty("") 0 for external transfer.
 */
@ApiModel("")
public record DepositHistory(@ApiModelProperty("") String amount, @ApiModelProperty("") String coin, @ApiModelProperty("") String network,
		@ApiModelProperty("") String address, @ApiModelProperty("") String addressTag, @ApiModelProperty("") String txId,
		@ApiModelProperty("") String unlockConfirm, @ApiModelProperty("") String confirmTimes, @ApiModelProperty("") String status,
		@ApiModelProperty("") long insertTime, @ApiModelProperty("") int transferType) {
	/** @return The withdraw status. */
	public DepositStatus getDepositStatus() {
		return DepositStatus.valueOf(status);
	}
}