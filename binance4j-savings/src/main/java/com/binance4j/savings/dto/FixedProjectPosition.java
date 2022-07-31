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
public record FixedProjectPosition(String asset, boolean canTransfer, long createTimestamp, long duration, long endTime, String interest, String interestRate,
		long lot, long positionId, String principal, String projectId, String projectName, long purchaseTime, String redeemDate, long startTime, String status,
		String type) {
}
