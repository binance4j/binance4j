package com.binance4j.savings.dto;

/**
 * Fixed or activity project.
 * 
 * @param asset              Asset.
 * @param displayPriority    Display priority.
 * @param duration           Duration.
 * @param interestPerLot     Interest per lot.
 * @param interestRate       Interest rate.
 * @param lotSize            Lot size.
 * @param lotsLowLimit       Lots low limit.
 * @param lotsPurchased      Lots purchased.
 * @param lotsUpLimit        Lots up limit.
 * @param maxLotsPerUser     Max lots per user.
 * @param needKyc            Need kyc.
 * @param projectId          Project id.
 * @param projectName        Project name.
 * @param status             Status.
 * @param type               Type.
 * @param withAreaLimitation With area limitation.
 */
public record FixedProject(
		/** Asset. */
		String asset,
		/** Display priority. */
		long displayPriority,
		/** Duration. */
		long duration,
		/** Interest per lot. */
		String interestPerLot,
		/** Interest rate. */
		String interestRate,
		/** Lot size. */
		String lotSize,
		/** Lots low limit. */
		long lotsLowLimit,
		/** Lots purchased. */
		long lotsPurchased,
		/** Lots up limit. */
		long lotsUpLimit,
		/** Max lots per user. */
		long maxLotsPerUser,
		/** Need kyc. */
		boolean needKyc,
		/** Project id. */
		String projectId,
		/** Project name. */
		String projectName,
		/** Status. */
		String status,
		/** Type. */
		String type,
		/** With area limitation. */
		boolean withAreaLimitation) {
}