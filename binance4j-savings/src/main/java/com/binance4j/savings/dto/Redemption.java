package com.binance4j.savings.dto;

/**
 * Redemption infos.
 * 
 * @param amount      Amount.
 * @param asset       Asset.
 * @param createTime  Create time.
 * @param principal   Principal.
 * @param projectId   Project id.
 * @param projectName Project name.
 * @param status      Status.
 * @param type        Type.
 */
public record Redemption(
		/** Amount. */
		String amount,
		/** Asset. */
		String asset,
		/** Create time. */
		long createTime,
		/** Principal. */
		String principal,
		/** Project id. */
		String projectId,
		/** Project name. */
		String projectName,
		/** Status. */
		String status,
		/** Type. */
		String type) {
}