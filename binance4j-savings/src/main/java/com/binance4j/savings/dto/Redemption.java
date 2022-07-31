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
public record Redemption(String amount, String asset, long createTime, String principal, String projectId, String projectName, String status, String type) {
}