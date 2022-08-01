package com.binance4j.wallet.dto;

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
 * @param transferType  The transfer type. 1 for internal transfer, 0 for external transfer.
 */
public record DepositHistory(String amount, String coin, String network, String address, String addressTag, String txId, String unlockConfirm,
		String confirmTimes, String status, long insertTime, int transferType) {
	/** @return The withdraw status. */
	public DepositStatus getDepositStatus() {
		return DepositStatus.valueOf(status);
	}
}