package com.binance4j.savings.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public record Redemption(
		/** Amount. */
		BigDecimal amount,
		/** Asset. */
		String asset,
		/** Create time. */
		long createTime,
		/** Principal. */
		BigDecimal principal,
		/** Project id. */
		String projectId,
		/** Project name. */
		String projectName,
		/** Status. */
		String status,
		/** Type. */
		String type) {
}