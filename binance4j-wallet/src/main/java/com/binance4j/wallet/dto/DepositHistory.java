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
 * @param status        Deposit status code.
 * @param insertTime    confirm times for insertion (?)
 * @param transferType  Transfer type. 1 for internal transfer, 0 for external
 *                      transfer.
 * @param walletType    Wallet type. 0-spot wallet ，1-funding wallet.Default
 *                      spot wallet.
 */
@ApiModel("A deposit history.")
public record DepositHistory(@ApiModelProperty("Volume to deposit.") String amount,
		@ApiModelProperty("Coin abbreviation.") String coin,
		@ApiModelProperty("Transfer network.") String network, @ApiModelProperty("Deposit address.") String address,
		@ApiModelProperty("Deposit address tag.") String addressTag, @ApiModelProperty("Transaction id.") String txId,
		@ApiModelProperty("confirm times for unlocking.") String unlockConfirm,
		@ApiModelProperty("Confirm times") String confirmTimes,
		@ApiModelProperty("Deposit status code.") String status,
		@ApiModelProperty("confirm times for insertion (?)") long insertTime,
		@ApiModelProperty("Transfer type. 1 for internal transfer, 0 for external transfer.") int transferType,
		@ApiModelProperty("Wallet type. 0-spot wallet ，1-funding wallet.Default spot wallet.") int walletType) {
	/** @return String value of status. */
	public DepositStatus getDepositStatus() {
		return DepositStatus.fromValue(status);
	}
}