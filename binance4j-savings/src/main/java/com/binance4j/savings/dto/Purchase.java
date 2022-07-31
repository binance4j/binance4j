package com.binance4j.savings.dto;

/**
 * Purchase infos.
 * 
 * @param amount      Amount.
 * @param asset       Asset.
 * @param createTime  Create time.
 * @param lendingType Lending type.
 * @param lot         Lot.
 * @param productName Product name.
 * @param purchaseId  Purchase id.
 * @param status      Status.
 */
public record Purchase(String amount, String asset, long createTime, String lendingType, long lot, String productName, long purchaseId, String status) {
}