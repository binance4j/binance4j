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
public record FixedProject(String asset, long displayPriority, long duration, String interestPerLot, String interestRate, String lotSize, long lotsLowLimit,
		long lotsPurchased, long lotsUpLimit, long maxLotsPerUser, boolean needKyc, String projectId, String projectName, String status, String type,
		boolean withAreaLimitation) {
}