package com.binance4j.savings.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public record Purchase(
		/** Amount. */
		String amount,
		/** Asset. */
		String asset,
		/** Create time. */
		long createTime,
		/** Lending type. */
		String lendingType,
		/** Lot. */
		long lot,
		/** Product name. */
		String productName,
		/** Purchase id. */
		long purchaseId,
		/** Status. */
		String status) {
}