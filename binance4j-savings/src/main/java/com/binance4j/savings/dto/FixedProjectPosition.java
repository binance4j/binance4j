package com.binance4j.savings.dto;

/**
 * A fixed project.
 * 
 * @param asset           Asset.
 * @param canTransfer     Can transfer.
 * @param createTimestamp Create timestamp.
 * @param duration        Duration.
 * @param endTime         Endtime.
 * @param interest        Interest.
 * @param interestRate    Interest rate.
 * @param lot             Lot.
 * @param positionId      Position id.
 * @param principal       Principal.
 * @param projectId       Project id.
 * @param projectName     Project name.
 * @param purchaseTime    Purchase time.
 * @param redeemDate      Redeem date.
 * @param startTime       Start time.
 * @param status          Status.
 * @param type            Type.
 */
public record FixedProjectPosition(
		/** Asset. */
		String asset,
		/** Can transfer. */
		boolean canTransfer,
		/** Create timestamp. */
		long createTimestamp,
		/** Duration. */
		long duration,
		/** Endtime. */
		long endTime,
		/** Interest. */
		String interest,
		/** Interest rate. */
		String interestRate,
		/** Lot. */
		long lot,
		/** Position id. */
		long positionId,
		/** Principal. */
		String principal,
		/** Project id. */
		String projectId,
		/** Project name. */
		String projectName,
		/** Purchase time. */
		long purchaseTime,
		/** Redeem date. */
		String redeemDate,
		/** Start time. */
		long startTime,
		/** Status. */
		String status,
		/** Type. */
		String type

) {
}
